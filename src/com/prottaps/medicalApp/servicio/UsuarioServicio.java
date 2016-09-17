/**
 * UsuarioservicioImpl.java
 * 
* Thu Sep 26 17:17:42 ECT 2013
 */
package ec.gob.mrl.peti.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.saviasoft.persistence.util.dao.GenericDao;
import com.saviasoft.persistence.util.service.impl.GenericServiceImpl;

import ec.gob.mrl.peti.dao.UsuarioDao;
import ec.gob.mrl.peti.exception.RecuperaClaveExcepcion;
import ec.gob.mrl.peti.exception.UsuarioInactivoExcepcion;
import ec.gob.mrl.peti.model.Usuario;
import ec.gob.mrl.peti.util.MailMessage;
import ec.gob.mrl.peti.util.Md5;
import ec.gob.mrl.peti.util.PasswordGenerator;
import ec.gov.mrl.peti.constantes.EstadoEnum;
import ec.gov.mrl.peti.constantes.ParametroEnum;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;

@Stateless(name = "UsuarioServicio")
public class UsuarioServicioImpl extends GenericServiceImpl<Usuario, String>
        implements UsuarioServicio {

    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private ClienteQueueMailServicio clienteQueueMailServicio;
    @EJB
    private EmailServicio emailServicio;
    @EJB
    private ParametroServicio parametroServicio;

    @Override
    public GenericDao<Usuario, String> getDao() {
        return usuarioDao;
    }

    @Override
    public String recuperaXCedula(String cedula) throws RecuperaClaveExcepcion {
        String resp = null;

        Usuario usuario = usuarioDao.obtenerXNumeroDocumento(cedula);

        if (usuario != null) {
            enviaCredenciales(usuario);
            resp = usuario.getEmail();
        }

        //3. Si no se encuentra se lanza excpecion
        if (resp == null) {
            throw new RecuperaClaveExcepcion();
        }

        return resp;
    }

    @Override
    public String recuperaXPk(String pk) throws RecuperaClaveExcepcion, UsuarioInactivoExcepcion {
        String resp = null;

        Usuario usuario = findByPk(pk);

        if (usuario != null) {
            if (EstadoEnum.ACTIVO != usuario.getEstado()) {
                throw new UsuarioInactivoExcepcion();
            } else {
                enviaCredenciales(usuario);
                resp = usuario.getEmail();
            }
        }

        //3. Si no se encuentra se lanza excpecion
        if (resp == null) {
            throw new RecuperaClaveExcepcion();
        }

        return resp;
    }

    private void enviaCredenciales(Usuario usuario) throws RecuperaClaveExcepcion {
        try {
            String nuevaClave = PasswordGenerator.generatePassword();
            String nuevaClaveHash = Md5.hash(nuevaClave);

            //Se actualiza clave de usuario
            usuario.setPassword(nuevaClaveHash);

            //Envia mail con credenciales.
            //enviaMailRecuperaCredenciales(usuario.getSupDocIdentificacion(), nuevaClave, usuario.getEmail());
        } catch (NoSuchAlgorithmException ex) {
            throw new RecuperaClaveExcepcion();
        }
    }

    /*  private void enviaMailRecuperaCredenciales(String username, String clave, String mail) {
     StringBuffer txt = new StringBuffer(200);
     txt.append("Estimado(a) asesor(ra) de la Red Socio Empleo, tus credenciales de acceso son:<br/><br/>Usuario: ").append(username);
     txt.append("<br/>").append("Clave: ").append(clave);
     txt.append("<br/><br/>.");

     List<String> to = new ArrayList<String>();
     to.add(mail);

     MailMessage mailMessage = new MailMessage();
     //mailMessage.setFrom("juan.ochoa@saviasof.com");
     mailMessage.setSubject("Red Socio Empleo - Recupera credenciales de acceso");
     mailMessage.setText(txt.toString());
     mailMessage.setTo(to);

     //Se encola el mail
     mailServicio.encolarMail(mailMessage);
     }*/
    @Override
    public Usuario obtenerPorCedulaClave(String cedula, String clave) {
        return usuarioDao.obtenerPorCedulaClave(cedula, clave);
    }

    @Override
    public void enviaMailCambioClave(String cedula, String mail, String clave) {
        StringBuffer txt = new StringBuffer(200);
        txt.append("Estimado usuario/a, se ha generado una nueva clave, sus credenciales de acceso son:<br/><br/>Usuario: ").append(cedula);
        txt.append("<br/>").append("Clave: ").append(clave);
        txt.append("<br/>");
        txt.append("Ingrese con sus credenciales en el siguiente enlace: " + parametroServicio.obtenerTexto(ParametroEnum.URL_SURTI.toString()));

        List<String> to = new ArrayList<String>();
        to.add(mail);

        MailMessage mailMessage = new MailMessage();
        mailMessage.setSubject("SURTI ");
        mailMessage.setText(txt.toString());
        mailMessage.setTo(to);

        //Se encola el mail
        clienteQueueMailServicio.encolarMail(mailMessage);
    }

    @Override
    public Usuario obtieneUsuarioXCedula(String cedula) {
        return usuarioDao.obtieneUsuarioXCedula(cedula);
    }

    @Override
    public void generaCadenaAleatoriaYEnviaMail(String cedula, String mail) throws NoSuchAlgorithmException {
        System.out.println("entra generaCadenaAleatoria");
        String code = RandomStringUtils.randomAlphanumeric(6);
        System.out.println("code: " + code);
        String claveMd5 = Md5.hash(code);

        //Se actualiza clave de usuario
        usuarioDao.actualizaClave(cedula, claveMd5);

        enviaMailCambioClave(cedula, mail, code);
        System.out.println("sale generaCadenaAleatoria");
    }

    @Override
    public void creaYEnviaClaveUsuario(Usuario usuario) throws NoSuchAlgorithmException {
        create(usuario);
        generaCadenaAleatoriaYEnviaMail(usuario.getIdentificacion(), usuario.getEmail());
    }

    @Override
    public Usuario obtieneUsuarioXIdentificacion(String identificacion) {
        return findByPk(identificacion);
    }

    @Override
    public Long obtenerTotalListadoPaginado(String nombre, String apellido, String cedula, Long institucionId) {
        return usuarioDao.obtenerTotalListadoPaginado(nombre, apellido, cedula, institucionId);
    }

    @Override
    public List<Usuario> obtenerListadoPaginado(String nombre, String apellido, String cedula, Long institucionId,
            int filas, int posicionInicial) {
        return usuarioDao.obtenerListadoPaginado(nombre, apellido, cedula, institucionId, filas, posicionInicial);
    }
}

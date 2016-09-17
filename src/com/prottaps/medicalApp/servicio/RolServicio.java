///**
// * RolservicioImpl.java
// * 
//* Thu Sep 26 17:13:37 ECT 2013
// */
//package ec.gob.mrl.peti.service;
//
//import com.saviasoft.persistence.util.constant.CriteriaTypeEnum;
//import com.saviasoft.persistence.util.dao.GenericDao;
//import com.saviasoft.persistence.util.service.impl.GenericServiceImpl;
//import com.saviasoft.util.Criteria;
//import ec.gob.mrl.peti.dao.RolDao;
//import ec.gob.mrl.peti.model.Rol;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//
//@Stateless(name = "RolServicio")
//public class RolServicioImpl extends GenericServiceImpl<Rol, String>
//        implements RolServicio {
//
//    @EJB
//    private RolDao rolDao;
//
//    public GenericDao<Rol, String> getDao() {
//        return rolDao;
//    }
//
//    @Override
//    public List<Rol> devuelveRolesActivos() {
//        String[] criteriasAnd = {"estado"};
//        CriteriaTypeEnum[] typesAnd = {CriteriaTypeEnum.STRING_LIKE};
//        Object[] valuesCriteriaAnd = {ec.gov.mrl.peti.constantes.EstadoEnum.ACTIVO};
//        String[] criteriasOrderBy = {"estado"};
//        boolean[] asc = {true};
//        Criteria criteria = new Criteria(criteriasAnd, typesAnd,
//                valuesCriteriaAnd, criteriasOrderBy, asc);
//        return rolDao.findByCriterias(criteria);
//    }
//
//    @Override
//    public List<Rol> obtieneRolesActivos() {
//        return rolDao.obtieneRolesActivos();
//    }
//
//    @Override
//    public Rol obtieneRolNemonico(String nemonico) {
//        String[] criteriasAnd = {"nemonico"};
//        CriteriaTypeEnum[] typesAnd = {CriteriaTypeEnum.STRING_EQUALS};
//        Object[] valuesCriteriaAnd = {nemonico};
//        String[] criteriasOrderBy = {"nemonico"};
//        boolean[] asc = {true};
//        Criteria criteria = new Criteria(criteriasAnd, typesAnd,
//                valuesCriteriaAnd, criteriasOrderBy, asc);
//        List<Rol> lista = rolDao.findByCriterias(criteria);
//        if (lista != null && !lista.isEmpty()) {
//            return lista.get(0);
//        }
//        return null;
//    }
//}

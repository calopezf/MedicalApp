///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package ec.gob.mrl.peti.ctrl;
//
//import ec.gob.mrl.peti.model.ActividadEconomicaItem;
//import ec.gob.mrl.peti.model.Canton;
//import ec.gob.mrl.peti.model.Etnia;
//import ec.gob.mrl.peti.model.Institucion;
//import ec.gob.mrl.peti.model.LugarTrabajo;
//import ec.gob.mrl.peti.model.ModalidadTrabajo;
//import ec.gob.mrl.peti.model.NivelInstruccion;
//import ec.gob.mrl.peti.model.Pais;
//import ec.gob.mrl.peti.model.Parroquia;
//import ec.gob.mrl.peti.model.Provincia;
//import ec.gob.mrl.peti.model.RamaActividad;
//import ec.gob.mrl.peti.service.ActividadEconomicaItemServicio;
//import ec.gob.mrl.peti.service.CantonServicio;
//import ec.gob.mrl.peti.service.EtniaServicio;
//import ec.gob.mrl.peti.service.InstitucionServicio;
//import ec.gob.mrl.peti.service.LugarTrabajoServicio;
//import ec.gob.mrl.peti.service.ModalidadTrabajoServicio;
//import ec.gob.mrl.peti.service.NivelInstruccionServicio;
//import ec.gob.mrl.peti.service.PaisServicio;
//import ec.gob.mrl.peti.service.ParroquiaServicio;
//import ec.gob.mrl.peti.service.ProvinciaServicio;
//import ec.gob.mrl.peti.service.RamaActividadServicio;
//import ec.gov.mrl.peti.constantes.DiasSemanaEnum;
//import ec.gov.mrl.peti.constantes.EstadoCivilEnum;
//import ec.gov.mrl.peti.constantes.EstadoEnum;
//import ec.gov.mrl.peti.constantes.JornadaEnum;
//import ec.gov.mrl.peti.constantes.ModalidadEnum;
//import ec.gov.mrl.peti.constantes.OficioEnum;
//import ec.gov.mrl.peti.constantes.ParentescoEnum;
//import ec.gov.mrl.peti.constantes.RangoGananciaEnum;
//import ec.gov.mrl.peti.constantes.RazonesNoEstudiaEnum;
//import ec.gov.mrl.peti.constantes.RepresentanteLegalEnum;
//import ec.gov.mrl.peti.constantes.RolEnum;
//import ec.gov.mrl.peti.constantes.TipoAsistenciaMonetariaEnum;
//import ec.gov.mrl.peti.constantes.TipoDireccionEnum;
//import ec.gov.mrl.peti.constantes.TipoEstablecimientoEnum;
//import ec.gov.mrl.peti.constantes.TipoIdentificacionEnum;
//import ec.gov.mrl.peti.constantes.TipoNotificacionEnum;
//import ec.gov.mrl.peti.constantes.TipoPaginaHtmlEnum;
//import ec.gov.mrl.peti.constantes.TipoParametroEnum;
//import ec.gov.mrl.peti.constantes.TipoZonaEnum;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.model.SelectItem;
//
///**
// *
// * @author juan
// */
//@ManagedBean(name = "selectItemCtrl")
//public class SelectItemCtrl extends BaseCtrl {
//
//    private static final long serialVersionUID = 1L;
//    @EJB
//    private EtniaServicio etniaServicio;
//    @EJB
//    private ModalidadTrabajoServicio modalidadTrabajoServicio;
//    @EJB
//    private InstitucionServicio institucionServicio;
//    @EJB
//    private PaisServicio paisServicio;
//    @EJB
//    private ProvinciaServicio provinciaServicio;
//    @EJB
//    private CantonServicio cantonServicio;
//    @EJB
//    private ParroquiaServicio parroquiaServicio;
//    @EJB
//    private ActividadEconomicaItemServicio actividadEconomicaItemServicio;
//    @EJB
//    private LugarTrabajoServicio lugarTrabajoServicio;
//    @EJB
//    private RamaActividadServicio ramaActividadServicio;
//    @EJB
//    private NivelInstruccionServicio nivelInstruccionServicio;
//    
//    private List<SelectItem> tipoParametroEnumItems;
//    private List<SelectItem> instruccionFormalItems;
//    private List<SelectItem> estadoEnum;
//    private List<SelectItem> rolEnum;
//    private List<SelectItem> estadoCivil;
//    private List<SelectItem> pais;
//    private List<SelectItem> tipoIdentificacion;
//    private List<SelectItem> tipoZona;
//    private List<SelectItem> tipoDireccionItems;
//    private List<SelectItem> parentesco;
//    private List<SelectItem> tipoJornada;
//    private List<SelectItem> oficio;
//    private List<SelectItem> modalidad;
//    private List<SelectItem> modalidadEducacion;
//    private List<SelectItem> etnia;
//    private List<SelectItem> institucion;
//    private List<SelectItem> tipoNotificacion;
//    private List<SelectItem> provincia;
//    private List<SelectItem> canton;
//    private List<SelectItem> parroquia;
//    private List<SelectItem> actividadEconomica;
//    private List<SelectItem> accionesViolentas;
//    private List<SelectItem> tipoPagina;
//    private List<SelectItem> lugaresTrabajo;
//    private List<SelectItem> representanteLegalItems;
//    private List<SelectItem> tipoAsistenciaMonetariaItems;
//    private List<SelectItem> tipoEstablecimientoItems;
//    private List<SelectItem> nivelInstruccionItems;
//    private List<SelectItem> ramaActividadItems;
//    private List<SelectItem> diaSemanaItems;
//    private List<SelectItem> rangoGananciaItems;
//    private List<SelectItem> razonesNoEstudiaItems;
//
//    public List<SelectItem> getTipoNotificacion() {
//
//        if (tipoNotificacion == null) {
//            tipoNotificacion = new ArrayList<SelectItem>();
//
//            for (TipoNotificacionEnum tn : TipoNotificacionEnum.getTipoNotificacionEnumList()) {
//                tipoNotificacion.add(new SelectItem(tn, tn.toString()));
//            }
//        }
//
//        return tipoNotificacion;
//    }
//
//    public void setTipoNotificacion(List<SelectItem> tipoNotificacion) {
//        this.tipoNotificacion = tipoNotificacion;
//    }
//
//    public List<SelectItem> getInstitucion() {
//        if (institucion == null) {
//            institucion = new ArrayList<SelectItem>();
//
//            for (Institucion i : institucionServicio.findAll()) {
//                institucion.add(new SelectItem(i.getId(), i.getNombre()));
//            }
//        }
//        return institucion;
//    }
//
//    public void setInstitucion(List<SelectItem> institucion) {
//        this.institucion = institucion;
//    }
//
//    public List<SelectItem> getEtnia() {
//        if (etnia == null) {
//            etnia = new ArrayList<SelectItem>();
//
//            for (Etnia e : etniaServicio.findAll()) {
//                etnia.add(new SelectItem(e.getId(), e.getNombre()));
//            }
//        }
//        return etnia;
//    }
//
//    public void setEtnia(List<SelectItem> etnia) {
//        this.etnia = etnia;
//    }
//
//    public List<SelectItem> getTipoParametroEnumItems() {
//        if (tipoParametroEnumItems == null) {
//            tipoParametroEnumItems = new ArrayList<SelectItem>();
//
//            for (TipoParametroEnum p : TipoParametroEnum.getTipoParametroEnumList()) {
//                tipoParametroEnumItems.add(new SelectItem(p, p.toString()));
//            }
//        }
//        return tipoParametroEnumItems;
//    }
//
//    public void setTipoParametroEnumItems(List<SelectItem> tipoParametroEnumItems) {
//        this.tipoParametroEnumItems = tipoParametroEnumItems;
//    }
//
//    public List<SelectItem> getEstadoEnum() {
//        if (estadoEnum == null) {
//            estadoEnum = new ArrayList<SelectItem>();
//            for (EstadoEnum e : EstadoEnum.values()) {
//                estadoEnum.add(new SelectItem(e, e.toString()));
//            }
//        }
//        return estadoEnum;
//    }
//
//    public void setEstadoEnum(List<SelectItem> estadoEnum) {
//        this.estadoEnum = estadoEnum;
//    }
//
//    public List<SelectItem> getRolEnum() {
//        if (rolEnum == null) {
//            rolEnum = new ArrayList<SelectItem>();
//            for (RolEnum re : RolEnum.values()) {
//                rolEnum.add(new SelectItem(re, re.toString()));
//            }
//        }
//        return rolEnum;
//    }
//
//    public void setRolEnum(List<SelectItem> rolEnum) {
//        this.rolEnum = rolEnum;
//    }
//
//    public List<SelectItem> getInstruccionFormalItems() {
//        return instruccionFormalItems;
//    }
//
//    public void setInstruccionFormalItems(List<SelectItem> instruccionFormalItems) {
//        this.instruccionFormalItems = instruccionFormalItems;
//    }
//
//    public List<SelectItem> getEstadoCivil() {
//        if (estadoCivil == null) {
//            estadoCivil = new ArrayList<SelectItem>();
//            for (EstadoCivilEnum ec : EstadoCivilEnum.values()) {
//                estadoCivil.add(new SelectItem(ec, ec.getEtiqueta()));
//            }
//        }
//        return estadoCivil;
//    }
//
//    public void setEstadoCivil(List<SelectItem> estadoCivil) {
//        this.estadoCivil = estadoCivil;
//    }
//
//    public List<SelectItem> getPais() {
//        if (pais == null) {
//            pais = new ArrayList<SelectItem>();
//            for (Pais p : paisServicio.findAll()) {
//                pais.add(new SelectItem(p.getId(), p.getNombre()));
//            }
//        }
//        return pais;
//    }
//
//    public void setPais(List<SelectItem> pais) {
//        this.pais = pais;
//    }
//
//    public List<SelectItem> getProvincia() {
//        if (provincia == null) {
//            provincia = new ArrayList<SelectItem>();
//            for (Provincia p : provinciaServicio.findAll()) {
//                provincia.add(new SelectItem(p.getId(), p.getNombre()));
//            }
//        }
//        return provincia;
//    }
//
//    public void setProvincia(List<SelectItem> provincia) {
//        this.provincia = provincia;
//    }
//
//    public List<SelectItem> getCanton() {
//        if (canton == null) {
//            canton = new ArrayList<SelectItem>();
//            for (Canton c : cantonServicio.findAll()) {
//                canton.add(new SelectItem(c.getId(), c.getNombre()));
//            }
//        }
//        return canton;
//    }
//
//    public void setCanton(List<SelectItem> canton) {
//        this.canton = canton;
//    }
//
//    public List<SelectItem> getParroquia() {
//        if (parroquia == null) {
//            parroquia = new ArrayList<SelectItem>();
//            for (Parroquia p : parroquiaServicio.findAll()) {
//                parroquia.add(new SelectItem(p.getId(), p.getNombre()));
//            }
//        }
//        return parroquia;
//    }
//
//    public void setParroquia(List<SelectItem> parroquia) {
//        this.parroquia = parroquia;
//    }
//
//    public List<SelectItem> getTipoIdentificacion() {
//        if (tipoIdentificacion == null) {
//            tipoIdentificacion = new ArrayList<SelectItem>();
//            for (TipoIdentificacionEnum ti : TipoIdentificacionEnum.values()) {
//                tipoIdentificacion.add(new SelectItem(ti, ti.getEtiqueta()));
//            }
//        }
//        return tipoIdentificacion;
//    }
//
//    public void setTipoIdentificacion(List<SelectItem> tipoIdentificacion) {
//        this.tipoIdentificacion = tipoIdentificacion;
//    }
//
//    public List<SelectItem> getTipoZona() {
//        if (tipoZona == null) {
//            tipoZona = new ArrayList<SelectItem>();
//            for (TipoZonaEnum tz : TipoZonaEnum.values()) {
//                tipoZona.add(new SelectItem(tz, tz.toString()));
//            }
//        }
//        return tipoZona;
//    }
//
//    public void setTipoZona(List<SelectItem> tipoZona) {
//        this.tipoZona = tipoZona;
//    }
//
//    public List<SelectItem> getParentesco() {
//        if (parentesco == null) {
//            parentesco = new ArrayList<SelectItem>();
//            for (ParentescoEnum p : ParentescoEnum.values()) {
//                parentesco.add(new SelectItem(p, p.getEtiqueta()));
//            }
//        }
//        return parentesco;
//    }
//
//    public void setParentesco(List<SelectItem> parentesco) {
//        this.parentesco = parentesco;
//    }
//
//    public List<SelectItem> getTipoJornada() {
//        if (tipoJornada == null) {
//            tipoJornada = new ArrayList<SelectItem>();
//            for (JornadaEnum j : JornadaEnum.values()) {
//                tipoJornada.add(new SelectItem(j, j.getEtiqueta()));
//            }
//        }
//        return tipoJornada;
//    }
//
//    public void setTipoJornada(List<SelectItem> tipoJornada) {
//        this.tipoJornada = tipoJornada;
//    }
//
//    public List<SelectItem> getModalidad() {
//        if (modalidad == null) {
//            modalidad = new ArrayList<SelectItem>();
//            List<ModalidadTrabajo> lista = modalidadTrabajoServicio.findAll();
//            for (ModalidadTrabajo m : lista) {
//                modalidad.add(new SelectItem(m.getId(), m.getNombre()));
//            }
//        }
//        return modalidad;
//    }
//
//    public void setModalidad(List<SelectItem> modalidad) {
//        this.modalidad = modalidad;
//    }
//
//    /**
//     * @return the tipoDireccionItems
//     */
//    public List<SelectItem> getTipoDireccionItems() {
//        if (tipoDireccionItems == null) {
//            tipoDireccionItems = new ArrayList<SelectItem>();
//            for (TipoDireccionEnum td : TipoDireccionEnum.values()) {
//                tipoDireccionItems.add(new SelectItem(td, td.toString()));
//            }
//        }
//        return tipoDireccionItems;
//    }
//
//    /**
//     * @param tipoDireccionItems the tipoDireccionItems to set
//     */
//    public void setTipoDireccionItems(List<SelectItem> tipoDireccionItems) {
//        this.tipoDireccionItems = tipoDireccionItems;
//    }
//
//    public List<SelectItem> getActividadEconomica() {
//        if (actividadEconomica == null) {
//            actividadEconomica = new ArrayList<SelectItem>();
//            for (ActividadEconomicaItem actividadEconomicaItem : actividadEconomicaItemServicio.findAll()) {
//                actividadEconomica.add(new SelectItem(actividadEconomicaItem.getId(), actividadEconomicaItem.getNombre()));
//            }
//        }
//        return actividadEconomica;
//    }
//
//    public void setActividadEconomica(List<SelectItem> actividadEconomica) {
//        this.actividadEconomica = actividadEconomica;
//    }
//
//    public void setAccionesViolentas(List<SelectItem> accionesViolentas) {
//        this.accionesViolentas = accionesViolentas;
//    }
//
//    public List<SelectItem> getTipoPagina() {
//        if (tipoPagina == null) {
//            tipoPagina = new ArrayList<SelectItem>();
//            for (TipoPaginaHtmlEnum tp : TipoPaginaHtmlEnum.values()) {
//                tipoPagina.add(new SelectItem(tp, tp.toString()));
//            }
//        }
//        return tipoPagina;
//    }
//
//    public void setTipoPagina(List<SelectItem> tipoPagina) {
//        this.tipoPagina = tipoPagina;
//    }
//
//    public List<SelectItem> getModalidadEducacion() {
//        if (modalidadEducacion == null) {
//            modalidadEducacion = new ArrayList<SelectItem>();
//            for (ModalidadEnum e : ModalidadEnum.values()) {
//                modalidadEducacion.add(new SelectItem(e, e.getEtiqueta()));
//            }
//        }
//        return modalidadEducacion;
//    }
//
//    public void setModalidadEducacion(List<SelectItem> modalidadEducacion) {
//        this.modalidadEducacion = modalidadEducacion;
//    }
//
//    public List<SelectItem> getOficio() {
//        if (oficio == null) {
//            oficio = new ArrayList<SelectItem>();
//            for (OficioEnum e : OficioEnum.values()) {
//                oficio.add(new SelectItem(e, e.toString()));
//            }
//        }
//        return oficio;
//    }
//
//    public void setOficio(List<SelectItem> oficio) {
//        this.oficio = oficio;
//    }
//
//    public List<SelectItem> getLugaresTrabajo() {
//        if (lugaresTrabajo == null) {
//            lugaresTrabajo = new ArrayList<SelectItem>();
//            for (LugarTrabajo lt : lugarTrabajoServicio.findAll()) {
//                lugaresTrabajo.add(new SelectItem(lt.getId(), lt.getNombre()));
//            }
//        }
//        return lugaresTrabajo;
//    }
//
//    public void setLugaresTrabajo(List<SelectItem> lugaresTrabajo) {
//        this.lugaresTrabajo = lugaresTrabajo;
//    }
//
//    public List<SelectItem> getRepresentanteLegalItems() {
//        if (representanteLegalItems == null) {
//            representanteLegalItems = new ArrayList<SelectItem>();
//            for (RepresentanteLegalEnum rle : RepresentanteLegalEnum.values()) {
//                representanteLegalItems.add(new SelectItem(rle, rle.getEtiqueta()));
//            }
//        }
//        return representanteLegalItems;
//    }
//
//    public void setRepresentanteLegalItems(List<SelectItem> representanteLegalItems) {
//        this.representanteLegalItems = representanteLegalItems;
//    }
//
//    public List<SelectItem> getTipoAsistenciaMonetariaItems() {
//        if (tipoAsistenciaMonetariaItems == null) {
//            tipoAsistenciaMonetariaItems = new ArrayList<SelectItem>();
//            for (TipoAsistenciaMonetariaEnum tami : TipoAsistenciaMonetariaEnum.values()) {
//                tipoAsistenciaMonetariaItems.add(new SelectItem(tami, tami.getEtiqueta()));
//            }
//        }
//        return tipoAsistenciaMonetariaItems;
//    }
//
//    public void setTipoAsistenciaMonetariaItems(List<SelectItem> tipoAsistenciaMonetariaItems) {
//        this.tipoAsistenciaMonetariaItems = tipoAsistenciaMonetariaItems;
//    }
//
//    public List<SelectItem> getTipoEstablecimientoItems() {
//        if (tipoEstablecimientoItems == null) {
//            tipoEstablecimientoItems = new ArrayList<SelectItem>();
//            for (TipoEstablecimientoEnum tee : TipoEstablecimientoEnum.values()) {
//                tipoEstablecimientoItems.add(new SelectItem(tee, tee.getEtiqueta()));
//            }
//        }
//        return tipoEstablecimientoItems;
//    }
//
//    public void setTipoEstablecimientoItems(List<SelectItem> tipoEstablecimientoItems) {
//        this.tipoEstablecimientoItems = tipoEstablecimientoItems;
//    }
//
//    public List<SelectItem> getNivelInstruccionItems() {
//        if (nivelInstruccionItems == null) {
//            nivelInstruccionItems = new ArrayList<SelectItem>();
//            /*for (NivelInstruccionEnum nie : NivelInstruccionEnum.values()) {
//                nivelInstruccionItems.add(new SelectItem(nie, nie.getEtiqueta()));
//            }*/
//            List<NivelInstruccion> nivelesInstruccion = nivelInstruccionServicio.findAll();
//            for (NivelInstruccion ni : nivelesInstruccion) {
//                nivelInstruccionItems.add(new SelectItem(ni.getId(), ni.getNombre()));
//            }
//        }
//        return nivelInstruccionItems;
//    }
//
//    public void setNivelInstruccionItems(List<SelectItem> nivelInstruccionItems) {
//        this.nivelInstruccionItems = nivelInstruccionItems;
//    }
//
//    public List<SelectItem> getRamaActividadItems() {
//        if (ramaActividadItems == null) {
//            ramaActividadItems = new ArrayList<SelectItem>();
//            for (RamaActividad ra : ramaActividadServicio.findAll()) {
//                ramaActividadItems.add(new SelectItem(ra.getId(), ra.getNombre()));
//            }
//        }
//        return ramaActividadItems;
//    }
//
//    public void setRamaActividadItems(List<SelectItem> ramaActividadItems) {
//        this.ramaActividadItems = ramaActividadItems;
//    }
//
//    public List<SelectItem> getDiaSemanaItems() {
//        if (diaSemanaItems == null) {
//            diaSemanaItems = new ArrayList<SelectItem>();
//            for (DiasSemanaEnum dse : DiasSemanaEnum.values()) {
//                diaSemanaItems.add(new SelectItem(dse, dse.getEtiqueta()));
//            }
//        }
//        return diaSemanaItems;
//    }
//
//    public void setDiaSemanaItems(List<SelectItem> diaSemanaItems) {
//        this.diaSemanaItems = diaSemanaItems;
//    }
//
//    public List<SelectItem> getRangoGananciaItems() {
//        if (rangoGananciaItems == null) {
//            rangoGananciaItems = new ArrayList<SelectItem>();
//            for (RangoGananciaEnum rge : RangoGananciaEnum.values()) {
//                rangoGananciaItems.add(new SelectItem(rge, rge.getEtiqueta()));
//            }
//        }
//        return rangoGananciaItems;
//    }
//
//    public void setRangoGananciaItems(List<SelectItem> rangoGananciaItems) {
//        this.rangoGananciaItems = rangoGananciaItems;
//    }
//
//    public List<SelectItem> getRazonesNoEstudiaItems() {
//        if (razonesNoEstudiaItems == null) {
//            razonesNoEstudiaItems = new ArrayList<SelectItem>();
//            for (RazonesNoEstudiaEnum rne : RazonesNoEstudiaEnum.values()) {
//                razonesNoEstudiaItems.add(new SelectItem(rne, rne.getEtiqueta()));
//            }
//        }
//        return razonesNoEstudiaItems;
//    }
//
//    public void setRazonesNoEstudiaItems(List<SelectItem> razonesNoEstudiaItems) {
//        this.razonesNoEstudiaItems = razonesNoEstudiaItems;
//    }
//}

package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.lang.RuntimeException;

public class Empresa{

/*------------------Atributos------------------------*/

    private String CUIT;
    private String nombre;
    private int capacidadDepositos;                         //Capacidad expresada en volúmen (volumen del paquete a cargar en el depósito < capacidadDepositos)
    private Set<viaje> listaDeDestinos;                     //Para AGREGAR un destino a la lista de destinos
    private Map<transporte,String> camionesConDestino;      //Para ASIGNAR un destino a un transporte tomando la matricula de este
    private Set<transporte> flotaDeTransportes;             //Agregar un transporte(flete,trailer o megaTrailer) a la empresa. Al asignarles un destino ya no forman parte de esta lista.
    private List<paquetes> depositoComun;                   //Deposito de Paquetes comunes
    private List<paquetes> depositoFrio;                    //Deposito de Paquetes con refrigeración
    private Map<transporte, String> camionesListos;         // Los camiones con destino asignado y cargados listos para el viaje <Transporte, Destino>
    private Map<transporte,String> camionesEnViaje;         // Camiones con el viaje iniciado y su respectivo destino

/*----------------------------------------------------*/


/*-------------------Constructor----------------------*/

    public Empresa(String cUIT, String nombre, Integer capacidadDepositos){
        this.CUIT = cUIT;
        this.nombre = nombre;
        this.capacidadDepositos = capacidadDepositos;
        this.depositoComun= new ArrayList<paquetes>();
        this.depositoFrio= new ArrayList<paquetes>();
        this.flotaDeTransportes= new HashSet<transporte>();
        this.camionesConDestino= new HashMap<transporte,String>();
        this.listaDeDestinos= new HashSet<viaje>();
        this.camionesListos=new HashMap<transporte, String>();
        this.camionesEnViaje=new HashMap<transporte,String>();

    }

/*----------------------------------------------------*/


/*----Getters y Setters-------------------------------*/

    public String getCUIT(){
        return CUIT;
    }
    public void setCUIT(String cUIT){
        CUIT = cUIT;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getCapacidadDepositos(){
        return capacidadDepositos;
    }
    public void setCapacidadDepositos(int capacidadDepositos){
        this.capacidadDepositos = capacidadDepositos;
    }
    public List<paquetes> getDepositoComun(){
        return depositoComun;
    }
    public void setDepositoComun(List<paquetes> depositoComun){
        this.depositoComun = depositoComun;
    }
    public List<paquetes> getDepositoFrio(){
        return depositoFrio;
    }
    public void setDepositoFrio(List<paquetes> depositoFrio){
        this.depositoFrio = depositoFrio;
    }
    public Map<transporte, String> getCamionesConDestino(){
        return camionesConDestino;
    }
    public void setCamionesConDestino(Map<transporte, String> camionesConDestino){
        this.camionesConDestino = camionesConDestino;
    }
    public Set<transporte> getFlotaDeTransportes(){
        return flotaDeTransportes;
    }
    public void setFlotaDeTransportes(Set<transporte> flotaDeTransportes){
        this.flotaDeTransportes = flotaDeTransportes;
    }
    public Set<viaje> getListaDeDestinos(){
        return listaDeDestinos;
    }
    public void setListaDeDestinos(Set<viaje> listaDeDestinos){
        this.listaDeDestinos = listaDeDestinos;
    }
    public Map<transporte, String> getCamionesListos(){
        return camionesListos;
    }
    public void setCamionesListos(Map<transporte, String> camionesListos){
        this.camionesListos = camionesListos;
    }
    public Map<transporte,String> getCamionesEnViaje(){
        return camionesEnViaje;
    }
    public void setCamionesEnViaje(Map<transporte,String> camionesEnViaje){
        this.camionesEnViaje = camionesEnViaje;
    }

/*----------------------------------------------------crearEmpresa--------------------------------------------------------------------------------*/

    public Empresa crearEmpresa(String CUIT, String nombre, int capacidadDepositos){
        Empresa e =new Empresa(CUIT,nombre,capacidadDepositos); 
        return e;
    }

/*-----------------------------------------------------incorporarPaquete--------------------------------------------------------------------------*/

    public boolean incorporarPaquete(String destino, double peso,double volumen, boolean necesitaRefrigeracion){

        paquetes p= new paquetes(destino,peso,volumen,necesitaRefrigeracion);
        if(necesitaRefrigeracion==true && p.getVolumen() < getCapacidadDepositos()){
            getDepositoFrio().add(p);
            return true;
        }
        if(necesitaRefrigeracion==false && p.getVolumen() < getCapacidadDepositos()){
            getDepositoComun().add(p);
            return true;
        }
        return false;
    }

/*----------------------------------------------------agregarDestino-----------------------------------------------------------------------------*/

    public void agregarDestino(String destino, Integer km) throws RuntimeException{

        viaje v= new viaje(destino, km);

        Iterator<viaje> iterador= getListaDeDestinos().iterator();

        while(iterador.hasNext()){
            viaje t=iterador.next();

            if(v.getNombreDestino().equals(t.getNombreDestino()))
                throw new RuntimeException("Ya existe el destino");
        }

        if(!getListaDeDestinos().contains(v))
            getListaDeDestinos().add(v);
    }

/*-----------------------------------------------------asignarDestino----------------------------------------------------------------------------*/

    public void asignarDestino(String matricula,String destino) throws RuntimeException{

        for(viaje v: getListaDeDestinos()){

            if(!getListaDeDestinos().isEmpty()){

            Iterator<transporte> iterador= getFlotaDeTransportes().iterator();
            while(iterador.hasNext()){

                transporte t=iterador.next();
                    if(t.getMatricula().equals(matricula) && v.getDistanciaADestino()>500 && v.getNombreDestino().equals(destino) && (t.rangoKm()>500 || t.rangoKm()==0)){
                        getCamionesConDestino().put(t, destino);
                        iterador.remove();
                    }
                    if(t.getMatricula().equals(matricula) && v.getDistanciaADestino()<=500 && (t.rangoKm()<=500) && v.getNombreDestino().equals(destino)){
                        getCamionesConDestino().put(t, destino);
                        iterador.remove();
                    }
                }
            }
                else
                    throw new RuntimeException("No hay destinos cargados");
            }
        }

/*------------------------------------------------------agregarTransportes-----------------------------------------------------------------------*/

    public void agregarTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga){

        trailerComun trailer =new trailerComun(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga);
        getFlotaDeTransportes().add(trailer);
    }

    public void agregarMegaTrailer(String matricula, double cargaMax,double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo,double costoComida){

        megaTrailer mega= new megaTrailer(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga, costoFijo, costoComida);
        getFlotaDeTransportes().add(mega);
    }

    public void agregarFlete(String matricula, double cargaMax, double capacidad,double costoKm, int cantAcompaniantes, double costoPorAcompaniante){

        flete f= new flete(matricula, cargaMax, capacidad, costoKm, cantAcompaniantes, costoPorAcompaniante);
        getFlotaDeTransportes().add(f);
    }

/*-------------------------------------------------------cargarTransportes-------------------------------------------------------------------------*/

    public double cargarTransporte(String matricula){

        for(transporte t: getCamionesConDestino().keySet()){

            if(t.getMatricula().equals(matricula) && t.getRefrigeracion()==true)
                return cargarTransporteRefrigerado(matricula);

            else{

                if (t.getMatricula().equals(matricula) && t.getRefrigeracion()==false ){

                    return cargarTransporteComun(matricula);
                    }
                }
        }
        return 0;
    }

    private double cargarTransporteRefrigerado(String matricula){

        double paquetesFriosSubidos=0;
        for (transporte Camion : getCamionesConDestino().keySet()){

            if((Camion.getMatricula().equals(matricula) && (Camion.getRefrigeracion()==true))){

                    double capacidadCamion = Camion.getCapacidad();
                    double pesoCamion = Camion.getCargaMax();
                        Iterator<paquetes> iterador= getDepositoFrio().iterator();
                        while(iterador.hasNext()){

                            paquetes paquete=iterador.next();
                                if(paquete.getDestino().equals(getCamionesConDestino().get(Camion)) && paquete.getRefrigeraci�n()==true){

                                    if(capacidadCamion>=paquete.getVolumen() && pesoCamion>= paquete.getPeso()){

                                        capacidadCamion = capacidadCamion - paquete.getVolumen();
                                        pesoCamion = pesoCamion - paquete.getPeso();
                                        paquetesFriosSubidos = paquetesFriosSubidos + paquete.getVolumen();
                                        iterador.remove();
                                        getCamionesListos().put(Camion, getCamionesConDestino().get(Camion));
                                    }
                                }
                        }
            }
        }
        return paquetesFriosSubidos;
    }

        private double cargarTransporteComun(String matricula){
            double paquetesComunesSubidos=0;
            for (transporte Camion : getCamionesConDestino().keySet()){

                if(Camion.getMatricula().equals(matricula)){

                    if(Camion.getRefrigeracion()==false){

                        double capacidadCamion = Camion.getCapacidad();
                        double pesoCamion = Camion.getCargaMax();
                             Iterator<paquetes> iterador = getDepositoComun().iterator();
                             while(iterador.hasNext()){

                                 paquetes paquete=iterador.next();
                                     if(paquete.getDestino().equals(getCamionesConDestino().get(Camion)) && paquete.getRefrigeraci�n()==false){

                                         if(capacidadCamion>=paquete.getVolumen() && pesoCamion>= paquete.getPeso()){

                                             capacidadCamion = capacidadCamion - paquete.getVolumen();
                                             pesoCamion = pesoCamion - paquete.getPeso();
                                             paquetesComunesSubidos = paquetesComunesSubidos + paquete.getVolumen();
                                             iterador.remove();
                                             getCamionesListos().put(Camion, getCamionesConDestino().get(Camion));
                                         }
                                     }
                             }
                    }
                }
            }
            return paquetesComunesSubidos;
    }

/*-------------------------------------------------iniciarViaje-----------------------------------------------------------------*/

    public void iniciarViaje(String matricula){

        Iterator<transporte> iterador= getCamionesListos().keySet().iterator();
        boolean camionNoListo = false;
        while(iterador.hasNext()){

            transporte t=iterador.next();

            if(t.getMatricula().equals(matricula)){

                getCamionesEnViaje().put(t, getCamionesListos().get(t));
                iterador.remove();
                camionNoListo = camionNoListo || true;
            }
        }
        if(!camionNoListo)
            throw new RuntimeException("Camion no listo");
    }

/*------------------------------------------------finalizarViaje------------------------------------------------------------------*/

    public void finalizarViaje(String matricula){
        Iterator<transporte> iterador= getCamionesEnViaje().keySet().iterator();
        boolean estaEnViaje=false;
        while(iterador.hasNext()){

            transporte Camion=iterador.next();
            if(Camion.getMatricula().equals(matricula)){

                iterador.remove();
                removerDestino(matricula);
                getFlotaDeTransportes().add(Camion);
                estaEnViaje=estaEnViaje || true;
            }
        }
        if(!estaEnViaje)
            throw new RuntimeException("No se puede finalizar un viaje no iniciado");
    }

    private void removerDestino(String matricula){
        Iterator<transporte> iterador= getCamionesConDestino().keySet().iterator();
        while(iterador.hasNext()){

            transporte Camion=iterador.next();
            if(Camion.getMatricula().equals(matricula)){
                iterador.remove();
            }
        }
    }

/*------------------------------------------------obtenerCostoViaje------------------------------------------------------------------*/

    public double obtenerCostoViaje(String matricula){

        for (transporte t: getCamionesEnViaje().keySet()){

            for(viaje v: getListaDeDestinos()){

                if(t.getMatricula().equals(matricula)){

                    if(t.tipo().equals("trailer") && getCamionesEnViaje().get(t).equals(v.getNombreDestino()))
                            return v.getDistanciaADestino()*t.getCostoKm()+ t.costoViaje();

                    if(t.tipo().equals("megaTrailer") && getCamionesEnViaje().get(t).equals(v.getNombreDestino()))
                            return v.getDistanciaADestino()*t.getCostoKm()+ t.costoViaje() ;

                    if(t.tipo().equals("flete") && getCamionesEnViaje().get(t).equals(v.getNombreDestino()))
                            return v.getDistanciaADestino()*t.getCostoKm()+t.costoViaje();
                }
        }
    }
    throw new RuntimeException("No existe esa matricula o el camion no esta en viaje");
}

/*----------------------------------------------------------obtenerTransporteIgual--------------------------------------------------------*/

    public String obtenerTransporteIgual(String matricula){

        for(Entry<transporte, String> camionParametro: getCamionesListos().entrySet()){

            if(camionParametro.getKey().getMatricula() == matricula){

                for(Entry<transporte, String> otroCamion: getCamionesListos().entrySet()){

                    if(otroCamion.getKey().getMatricula() != matricula){

                        if(cargarTransporte(otroCamion.getKey().getMatricula()) == cargarTransporte(matricula)   //misma carga
                                       && otroCamion.getValue().equals(camionParametro.getValue())               //mismo destino
                                        && otroCamion.getKey().tipo().equals(camionParametro.getKey().tipo()))  //mismo tipo

                            return otroCamion.getKey().getMatricula();
                    }
                }
            }
        }
        return null;
    }

/*------------------------------------------------------------------------------------------------------------------*/

    public String toString(){

        StringBuilder st= new StringBuilder();
        st.append("CUIT: ");
        st.append(getCUIT());
        st.append(", ");
        st.append("Nombre: " );
        st.append(getNombre());
        st.append(", ");
        st.append("Capacidad: ");
        st.append(getCapacidadDepositos());
        st.append("\n");
        st.append("Paquetes en Deposito Comun: ");
        st.append(getDepositoComun().toString());
        st.append("\n");
        st.append("Paquetes en Deposito Frio: ");
        st.append( getDepositoFrio().toString());
        st.append("\n");
        st.append("Destinos Cargados: ");
        st.append(getListaDeDestinos().size());
        st.append("\n");
        st.append("Transportes disponibles: ");
        st.append(getFlotaDeTransportes().toString());
        st.append("\n");
        st.append("Transportes con viajes asignados: ");
        st.append(getCamionesConDestino().toString());
        st.append("\n");
        st.append("Camiones listos para salir (Viaje asignado + Carga) : ");
        st.append( getCamionesListos().toString());
        st.append("\n");
        st.append("Camiones en viaje: ");
        st.append(getCamionesEnViaje().toString());

        return st.toString();
    }

/*------------------------------------------------------*/
}

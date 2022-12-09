package clases;

public class paquetes{

    private double peso;
    private double volumen;
    private String destino;
    private boolean necesitaRefrigeracion;

/*-----------------------Constructor--------------------------------*/

    public paquetes(String destino, double peso, double volumen,  boolean necesitaRefrigeracion){
        this.peso = peso;
        this.volumen = volumen;
        this.destino = destino;
        this.necesitaRefrigeracion = necesitaRefrigeracion;
    }
/*-----------------------Getters and Setters--------------------------------*/
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public double getVolumen(){
        return volumen;
    }
    public void setVolumen(double volumen){
        this.volumen = volumen;
    }
    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public boolean getRefrigeracion(){
        return necesitaRefrigeracion;
    }
    public void setRefrigeracion(boolean necesitaRefrigeracion){
        this.necesitaRefrigeracion = necesitaRefrigeracion;
    }

/*-----------------------Methods--------------------------------*/

    public String toString(){
        StringBuilder st= new StringBuilder();
        st.append(this.getDestino());
        st.append(", ");
        st.append(this.getPeso());
        st.append(", ");
        st.append(this.getVolumen());
        st.append(", ");
        st.append(this.getRefrigeracion());
        return st.toString();
    }

/*-----------------------------------------------------------*/
}

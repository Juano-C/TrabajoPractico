package clases;

public class trailerComun extends transporte{
    private double segCarga;

/*-------------------------Constructor----------------------------*/

    public trailerComun(String matricula, double cargaMax, double capacidad,boolean tieneRefrigeracion, double costoKm,double segCarga){
        super(matricula, cargaMax, capacidad, costoKm,tieneRefrigeracion);
        this.segCarga=segCarga;
    }

/*-------------------Getters and Setters-------------------------*/

    public double getSegurodeCarga(){
        return segCarga;
    }
    public void setSegurodeCarga(double segCarga){
        this.segCarga = segCarga;
    }

/*-------------------------Methods------------------------------*/

    @Override
    public int hashCode(){

        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(segCarga);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (tieneRefrigeracion ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        trailerComun other = (trailerComun) obj;
        if (Double.doubleToLongBits(segCarga) != Double.doubleToLongBits(other.segCarga))
            return false;
        if (tieneRefrigeracion != other.tieneRefrigeracion)
            return false;
        return true;
    }

    @Override
    public Integer rangoKm(){
        return 500;
    }
    
    @Override
    public double costoViaje(){
        return getSegurodeCarga();
    }
    
    public String toString(){
        StringBuilder st= new StringBuilder();
        st.append(tipo());
        st.append("[");
        st.append(this.getMatricula());
        st.append("]");
        return st.toString();
    }

    @Override
    public String tipo(){

        return "trailer";
    }

/*-----------------------------------------------------------*/
}

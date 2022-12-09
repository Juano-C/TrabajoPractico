package clases;

public class megaTrailer extends transporte{

    private double segCarga;
    private double costoFijo;
    private double costoComida;

/*-----------------------Constructor--------------------------------*/

    public megaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo, double costoComida){
        super(matricula, cargaMax, capacidad, costoKm,tieneRefrigeracion);
        this.segCarga=segCarga;
        this.costoFijo=costoFijo;
        this.costoComida=costoComida;
    }

/*-------------------Getters and Setters-------------------------*/

    public double getSegCarga(){
        return segCarga;
    }
    public void setSegCarga(double segCarga){
        this.segCarga = segCarga;
    }
    public double getCostoFijo() {
        return costoFijo;
    }
    public void setCostoFijo(double costoFijo){
        this.costoFijo = costoFijo;
    }
    public double getCostoComida(){
        return costoComida;
    }
    public void setCostoComida(double costoComida){
        this.costoComida = costoComida;
    }

/*-----------------------Methods--------------------------------*/

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(costoComida);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costoFijo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        megaTrailer other = (megaTrailer) obj;
        if (Double.doubleToLongBits(costoComida) != Double.doubleToLongBits(other.costoComida))
            return false;
        if (Double.doubleToLongBits(costoFijo) != Double.doubleToLongBits(other.costoFijo))
            return false;
        if (Double.doubleToLongBits(segCarga) != Double.doubleToLongBits(other.segCarga))
            return false;
        if (tieneRefrigeracion != other.tieneRefrigeracion)
            return false;
        return true;
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
    public double costoViaje(){
        return getSegCarga()+getCostoFijo()+getCostoComida();
    }

    @Override
    public String tipo(){
        return "megaTrailer";
    }

    @Override
    public Integer rangoKm(){
        return 501;
    }

/*-----------------------------------------------------------------*/
}

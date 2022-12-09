package clases;

public abstract class transporte{

    protected String matricula;
    protected double cargaMax;
    protected double capacidad;
    protected double costoKm;
    protected boolean tieneRefrigeracion;

/*-----------------------Constructor--------------------------------*/

    public transporte(String matricula, double cargaMax, double capacidad, double costoKm,boolean tieneRefrigeracion){
        this.matricula = matricula;
        this.cargaMax = cargaMax;
        this.capacidad = capacidad;
        this.costoKm=costoKm;
        this.tieneRefrigeracion=tieneRefrigeracion;
    }

/*-----------------------Getters y Setters--------------------------*/

     public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public double getCargaMax(){
        return cargaMax;
    }
    public void setCargaMax(double cargaMax){
        this.cargaMax = cargaMax;
    }
    public double getCapacidad(){
        return capacidad;
    }
    public void setCapacidad(double capacidad){
        this.capacidad = capacidad;
    }
    public double getCostoKm(){
        return costoKm;
    }
    public void setCostoKm(double costoKm){
        this.costoKm = costoKm;
    }
    public boolean getRefrigeracion(){
        return tieneRefrigeracion;
    }
    public void setRefrigeracion(boolean tieneRefrigeracion) {
        this.tieneRefrigeracion = tieneRefrigeracion;
    }

/*------------------------Methods---------------------------------*/

    public abstract double costoViaje();
    public abstract Integer rangoKm();
    public abstract String tipo();

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(capacidad);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cargaMax);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costoKm);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        transporte other = (transporte) obj;
        if (Double.doubleToLongBits(capacidad) != Double.doubleToLongBits(other.capacidad))
            return false;
        if (Double.doubleToLongBits(cargaMax) != Double.doubleToLongBits(other.cargaMax))
            return false;
        if (Double.doubleToLongBits(costoKm) != Double.doubleToLongBits(other.costoKm))
            return false;
        if (matricula == null){
            if (other.matricula != null)
                return false;
        }
        else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

/*----------------------------------------------------------------*/
}

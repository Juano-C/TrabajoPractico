package clases;

public class flete extends transporte{

    private static final boolean tieneRefrigeracion = false;
    private int cantAcompaniantes;
    private double costoPorAcompaniante;

/*-----------------------Constructor--------------------------------*/

    public flete(String matricula, double cargaMax, double capacidad, double costoKm, int cantAcompaniantes, double costoPorAcompaniante){

        super(matricula, cargaMax, capacidad, costoKm,tieneRefrigeracion);
        this.cantAcompaniantes=cantAcompaniantes;
        this.costoPorAcompaniante=costoPorAcompaniante;
    }

/*------------------------Methods-----------------------------------*/

    public int getcantAcompaniantes(){
        return cantAcompaniantes;
    }

    public void setCantAcompaniantes(int cantAcompaniantes){
        this.cantAcompaniantes = cantAcompaniantes;
    }


    public double getCostoPorAcompaniante(){
        return costoPorAcompaniante;
    }

    public void setCostoPorAcompaniante(double costoPorAcompaniante){
        this.costoPorAcompaniante = costoPorAcompaniante;
    }

    public boolean getRefrigeracion(){
        return flete.tieneRefrigeracion;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + cantAcompaniantes;
        long temp;
        temp = Double.doubleToLongBits(costoPorAcompaniante);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        flete other = (flete) obj;
        if (cantAcompaniantes != other.cantAcompaniantes)
            return false;
        if (Double.doubleToLongBits(costoPorAcompaniante) != Double.doubleToLongBits(other.costoPorAcompaniante))
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
        return getcantAcompaniantes()*getCostoPorAcompaniante();
    }

    @Override
    public String tipo(){
        return "flete";
    }

    @Override
    public Integer rangoKm(){
        return 0;
    }
}

/*------------------------------------------------------------------*/

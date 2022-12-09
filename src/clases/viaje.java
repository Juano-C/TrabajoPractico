package clases;

public class viaje{

    private String destino;
    private Integer distanciaADestino;

/*-----------------------Constructor--------------------------------*/

    public viaje(String destino, Integer distanciaADestino){
        this.destino = destino;
        this.distanciaADestino = distanciaADestino;
    }

/*-----------------------Getters y Setters--------------------------------*/

    public String getNombreDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public Integer getDistanciaADestino(){
        return distanciaADestino;
    }
    public void setDistanciaADestino(Integer distanciaADestino){
        this.distanciaADestino = distanciaADestino;
    }

/*-----------------------Methods--------------------------------*/

    public String toString(){
        return "Destinos : " + "[" + this.getNombreDestino() + ", " + "Distancia: " + getDistanciaADestino() + "]";
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((distanciaADestino == null) ? 0 : distanciaADestino.hashCode());
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
        viaje other = (viaje) obj;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (distanciaADestino == null) {
            if (other.distanciaADestino != null)
                return false;
        } else if (!distanciaADestino.equals(other.distanciaADestino))
            return false;
        return true;
    }

/*-------------------------------------------------------*/
}

package clases;

public class paquetes{
	
	private double peso;
	private double volumen;
	private String destino;
	private boolean necesitaRefrigeración;
	
/*-----------------------Constructor--------------------------------*/	
	
	public paquetes(String destino, double peso, double volumen,  boolean necesitaRefrigeración){
		
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
		this.necesitaRefrigeración = necesitaRefrigeración;
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
	public boolean getRefrigeración(){
		return necesitaRefrigeración;
	}
	public void setRefrigeración(boolean necesitaRefrigeración){
		this.necesitaRefrigeración = necesitaRefrigeración;
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
		st.append(this.getRefrigeración());
		
		return st.toString();
	}

/*-----------------------------------------------------------*/
}
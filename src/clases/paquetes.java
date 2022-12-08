package clases;

public class paquetes{
	
	private double peso;
	private double volumen;
	private String destino;
	private boolean necesitaRefrigeraci�n;
	
/*-----------------------Constructor--------------------------------*/	
	
	public paquetes(String destino, double peso, double volumen,  boolean necesitaRefrigeraci�n){
		
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
		this.necesitaRefrigeraci�n = necesitaRefrigeraci�n;
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
	public boolean getRefrigeraci�n(){
		return necesitaRefrigeraci�n;
	}
	public void setRefrigeraci�n(boolean necesitaRefrigeraci�n){
		this.necesitaRefrigeraci�n = necesitaRefrigeraci�n;
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
		st.append(this.getRefrigeraci�n());
		
		return st.toString();
	}

/*-----------------------------------------------------------*/
}
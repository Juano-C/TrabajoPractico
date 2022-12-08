package clases;

public class pruebas {

	
/*----------------Ejemplo aparte del Test Junit----------------------*/

	public static void main(String[] args){

	Empresa emp = new Empresa("20404267354","ExpresoLibre",30000);
	emp.agregarDestino("Cordoba", 350);
	emp.agregarDestino("Santa Fe", 450);
	emp.agregarDestino("Lima", 1700);

	// matricula,cargaMax,capacidad,costoKm,cantAcompaniantes,costoPorAcompaniante,tieneRefrigeracion
	emp.agregarTrailer("AGT777FE", 4000, 120, true, 10, 32);
	emp.agregarFlete("AAA675GT", 2000, 4000, 10, 1, 100);
	emp.agregarMegaTrailer("ABB975BT", 2000, 1000, true, 100, 50, 30, 20);
	emp.agregarTrailer("AKT756UO", 4000, 120, true, 10, 32);

	emp.asignarDestino("AGT777FE","Cordoba");				//capacidad>volumen para agregar todos
	emp.asignarDestino("AAA675GT","Santa Fe");				//cargaMax>peso para agregar todos
	emp.asignarDestino("ABB975BT","Lima");

	//destino,peso,volumen,necesitaRefrigeracion
	emp.incorporarPaquete("Cordoba", 3, 5, false);
	emp.incorporarPaquete("Cordoba", 250, 10, true);
	emp.incorporarPaquete("Santa Fe", 50, 2.5, false);						
	emp.incorporarPaquete("Santa Fe", 125, 5, false);
	emp.incorporarPaquete("Lima", 400, 12, true);
	emp.incorporarPaquete("Lima", 400, 12, true);

	emp.iniciarViaje("AGT777FE");
	emp.iniciarViaje("ABB975BT");

	System.out.println(emp.toString());
	System.out.println(emp.obtenerCostoViaje("ABB975BT"));
	System.out.println(emp.obtenerCostoViaje("AGT777FE"));

	}
}
	

	
	
	


	



package main;

import servicio.ArchivoServicioImp;

public class Main {

	public static void main(String[] args) {

		ArchivoServicioImp asi = new ArchivoServicioImp();
		
		System.out.println(asi.cargarDatos("notas.csv"));
	}

}

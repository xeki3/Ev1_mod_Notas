package main;


import servicio.ArchivoServicioImp;

import vistas.Menu;

public class Main {

	public static void main(String[] args) {
		ArchivoServicioImp asi = new ArchivoServicioImp();
		asi.cargarDatos("notas.csv");
		Menu menu = new Menu();
		menu.iniciarMenu();

	}

}

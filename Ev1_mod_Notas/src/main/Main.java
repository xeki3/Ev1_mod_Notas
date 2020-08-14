package main;

import java.util.HashMap;
import java.util.Map;

import modelo.Alumno;
import servicio.ArchivoServicioImp;
import servicio.PromedioServicioImp;

public class Main {

	public static void main(String[] args) {
		Map<String, Alumno> datos = new HashMap<String, Alumno>();

		ArchivoServicioImp asi = new ArchivoServicioImp();

		// System.out.println(asi.cargarDatos("notas.csv"));
		datos = asi.cargarDatos("notas.csv");
		PromedioServicioImp promedio = new PromedioServicioImp();
		promedio.calcularPromedio(datos.get("17.423.112-4").getMaterias().get(0).getNotas());

		// System.out.println(datos.get("17.423.112-4").getMaterias().get(0).getNotas());
		System.out.println(promedio.calcularPromedio(datos.get("17.423.112-4").getMaterias().get(0).getNotas()));
	}

}

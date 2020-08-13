package modelo;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class ArchivoServicioImp implements IArchivoServicio{
	private Scanner lector;

	@Override
	public Map<String, Alumno> cargarDatos(String rutaArchivoNotas) {
		try {
			File archivo = new File("datos.txt");
			String linea;
			String[] datosPersona;
			Alumno alumno;
			Materia materia;
			lector = new Scanner(archivo);

			while (lector.hasNext()) {
				linea = lector.nextLine();
				datosPersona = linea.split(",");
				alumno = new Alumno();
				materia = new Materia();
				alumno.setRut(datosPersona[0]);
				alumno.setNombre(datosPersona[1]);
				materia.setNombre(datosPersona[2]);
//				materia.setNotas(Integer.parseInt(datosPersona[3]));
				
			}
			lector.close();
			//System.out.println("Se leyeron " + alumnos.size() + " Clientes");

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		
		return null;
	}

	@Override
	public void ExportarDatos(Map<String, Alumno> alumnos, String rutaArchivoNotas) {
		
	}

}

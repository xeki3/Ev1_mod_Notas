package servicio;

import java.util.Map;

import modelo.Alumno;

public interface IArchivoServicio {

	public Map<String,Alumno> cargarDatos(String rutaArchivoNotas);
	public void ExportarDatos(Map<String, Alumno> alumnos,String rutaArchivoNotas);

}

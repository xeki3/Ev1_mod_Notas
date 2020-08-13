package modelo;

import java.util.Map;

public interface IArchivoServicio {

	public Map<String,Alumno> cargarDatos(String rutaArchivoNotas);
	public void ExportarDatos(Map<String, Alumno> alumnos,String rutaArchivoNotas);

}

package servicio;


import java.util.Map;

import modelo.*;

public interface IAlumnoServicio {

	public void crearAlumno(Alumno alumno);

	public void agregarMateria(String rutAlumno, Materia nuevaMateria);

	public void listarAlumnos(Map listaAlumnos);

}

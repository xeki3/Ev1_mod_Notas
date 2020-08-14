package servicio;

import java.util.ArrayList;
import java.util.Map;

import modelo.*;

public interface IAlumnoServicio {

	public void crearAlumno(Alumno alumno);

	public void agregarMateria(String rutAlumno, Materia nuevaMateria);

	public ArrayList<Materia> materiasPorAlumno(String rutAlumno);

	public Map<String, Alumno> listarAlumnos();

}
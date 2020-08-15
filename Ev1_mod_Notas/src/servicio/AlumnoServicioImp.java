package servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;

public class AlumnoServicioImp implements IAlumnoServicio {

	private Map<String, Alumno> listaAlumnos = new HashMap<String, Alumno>();

	@Override
	public void crearAlumno(Alumno alumno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarMateria(String rutAlumno, Materia nuevaMateria) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Materia> materiasPorAlumno(String rutAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarAlumnos(Map listaAlumnos) {
		listaAlumnos = listaAlumnos;
		Collection<Alumno> alumno = listaAlumnos.values();

		System.out.println("----------------Listar Alumnos-----------------------");
		for (Alumno alumno2 : alumno) {
			System.out.println("Datos Alumno");
			System.out.println("           Rut: " + alumno2.getRut());
			System.out.println("           Nombre: " + alumno2.getNombre());
			System.out.println("Materias");
			for (Materia materia : alumno2.getMaterias()) {
				System.out.println(materia.getNombre());
				System.out.println(materia.getNotas());
			}

		}
		System.out.println("------------------------------------------------------");
	}

}

package servicio;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;
import vistas.Menu;
import vistas.MenuTemplate;

public class AlumnoServicioImp implements IAlumnoServicio{
	MenuTemplate menu = new Menu();


	private Map<String,Alumno>listaAlumno(){
		return null;
	}


	public void crearAlumno(Alumno alumno) {

		ArchivoServicioImp.getAlumnosACargar().add(alumno);
		ArchivoServicioImp.getAlumnos().put(alumno.getRut(), alumno);
		menu.iniciarMenu();
	}


	public void agregarMateria(String rutAlumno, Materia nuevaMateria) {
		List<Double> notas = new ArrayList<Double>();
		ArchivoServicioImp.getAlumnos().get(rutAlumno).getMaterias().add(nuevaMateria);
		ArchivoServicioImp.getAlumnos().get(rutAlumno).getMaterias().get(0).setNotas(notas);
		ArchivoServicioImp.setAlumnosACargar(Collections.list(Collections.enumeration(ArchivoServicioImp.getAlumnos().values())));
		menu.iniciarMenu();
	}

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

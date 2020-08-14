package servicio;


import java.util.ArrayList;
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


	public Map<String, Alumno> listarAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

}

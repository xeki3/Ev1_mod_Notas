package vistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.Alumno;
import modelo.Materia;
import servicio.AlumnoServicioImp;
import servicio.ArchivoServicioImp;

public class Menu extends MenuTemplate{
	private AlumnoServicioImp alumnoServicioImp;
	private ArchivoServicioImp archivoServicioImp;
	private Scanner tec = new Scanner(System.in);

	@Override
	public void cargarDatos() {

	}

	@Override
	public void exportarDatos() {

	}

	@Override
	public void crearAlumno() {
		Alumno al =  new Alumno();

		System.out.println("RUT");
		al.setRut(tec.nextLine());
		System.out.println("Nombre");
		al.setNombre(tec.nextLine());
		List<Materia> materias = new ArrayList<Materia>();
		al.setMaterias(materias);
		alumnoServicioImp  = new AlumnoServicioImp();
		alumnoServicioImp.crearAlumno(al);	

	}

	@Override
	public void agregarMateria() {
		int cont=0;
		int opcionAl=0;
		int opcionMateria=0;
		System.out.println("Seleccione Alumno");
		for(Alumno al:ArchivoServicioImp.getAlumnosACargar()) {
			cont+=1;
			System.out.println(cont+".- "+al.getNombre());
		}
		opcionAl = tec.nextInt();
		tec.nextLine();
		System.out.println("1. MATEMATICA  \r\n" + 
				"2. LENGUAJE  \r\n" + 
				"3. CIENCIA \r\n" + 
				" 4. HISTORIA  \r\n" + 
				"");
		opcionMateria= tec.nextInt();
		tec.nextLine();
		Materia materia = new Materia();
		switch (opcionMateria) {
		case 1:
			materia.setNombre("MATEMATICA");
			break;
		case 2:
			materia.setNombre("LENGUAJE");
			break;
		case 3:
			materia.setNombre("CIENCIA");
			break;
		case 4:
			materia.setNombre("HISTORIA");
			break;
		default:
			System.out.println("Error");
			break;
		}
		long conta =ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getMaterias().stream().filter(x->x.getNombre().equals(materia.getNombre())).count();
		if(conta==0) {
			String rut = ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getRut();
			alumnoServicioImp  = new AlumnoServicioImp();
			alumnoServicioImp.agregarMateria(rut, materia);
		}
	}

	@Override
	public void agregarNota() {
		int cont=0;
		int opcionAl=0;
		int opcionMateria=0;
		double nota=0;
		System.out.println("Seleccione Alumno");
		for(Alumno al:ArchivoServicioImp.getAlumnosACargar()) {
			cont+=1;
			System.out.println(cont+".- "+al.getNombre());
		}
		opcionAl = tec.nextInt();
		tec.nextLine();
		String rut = ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getRut();
		System.out.println("Seleccione Materia");
		cont=0;
		for(Materia mt :ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getMaterias()) {
			cont+=1;
			System.out.println(cont+".- "+mt.getNombre());
		}
		opcionMateria= tec.nextInt();
		tec.nextLine();
		//Materia materia = ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getMaterias().get(opcionMateria-1);
		//System.out.println("ESTA LA MATERIA "+ArchivoServicioImp.getAlumnos().get(rut).getMaterias().contains(materia));
		//System.out.println("la materia que elegi "+ArchivoServicioImp.getAlumnos().get(rut).getMaterias().get(opcionMateria-1));
		System.out.println("Ingrese nota");
		nota = tec.nextDouble();
		tec.nextLine();
		ArchivoServicioImp.getAlumnos().get(rut).getMaterias().get(opcionMateria-1).getNotas().add(nota);
		ArchivoServicioImp.setAlumnosACargar(Collections.list(Collections.enumeration(ArchivoServicioImp.getAlumnos().values())));
		System.out.println(ArchivoServicioImp.getAlumnosACargar());
		this.iniciarMenu();
	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub

	}

	public AlumnoServicioImp getAlumnoServicioImp() {
		return alumnoServicioImp;
	}

	public void setAlumnoServicioImp(AlumnoServicioImp alumnoServicioImp) {
		this.alumnoServicioImp = alumnoServicioImp;
	}

	public ArchivoServicioImp getArchivoServicioImp() {
		return archivoServicioImp;
	}

	public void setArchivoServicioImp(ArchivoServicioImp archivoServicioImp) {
		this.archivoServicioImp = archivoServicioImp;
	}

}

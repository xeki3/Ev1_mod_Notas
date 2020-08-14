package vistas;

import java.util.ArrayList;
import java.util.List;
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
		alumnoServicioImp  = new AlumnoServicioImp();
		alumnoServicioImp.crearAlumno(al);	
		
	}

	@Override
	public void agregarMateria() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarNota() {
		// TODO Auto-generated method stub
		
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

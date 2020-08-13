package modelo;

import java.util.List;

public class Alumno {
	
	private int rut;
	private String nombre;
	private List<Materia> materias;

	public Alumno() {	
	}

	public Alumno(int rut, String nombre, List<Materia> materias) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.materias = materias;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Alumno [rut=" + rut + ", nombre=" + nombre + ", materias=" + materias + "]";
	}

}

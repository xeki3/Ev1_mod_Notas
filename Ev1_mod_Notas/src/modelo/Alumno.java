package modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String rut;
	private String nombre;
	private List<Materia> materias;

	public Alumno() {
	}

	public Alumno(String rut, String nombre, ArrayList<Materia> materias) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.materias = materias;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
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

	public void setMaterias(List<Materia> materias2) {
		this.materias = materias2;
	}

	@Override
	public String toString() {
		return "Alumno [rut=" + rut + ", nombre=" + nombre + ", materias=" + materias + "]";
	}

}

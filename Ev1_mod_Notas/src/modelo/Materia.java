package modelo;

import java.util.List;

public class Materia {
	private String nombre;
	private List<Double> notas;

	public Materia() {	
	}

	public Materia(String nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}

}

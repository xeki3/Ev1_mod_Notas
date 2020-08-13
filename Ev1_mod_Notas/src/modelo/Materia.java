package modelo;

import java.util.List;

public class Materia {
	private String nombres;
	private List<Double> notas;

	public Materia() {	
	}

	public Materia(String nombre, List<Double> notas) {
		super();
		this.nombres = nombre;
		this.notas = notas;
	}

	public String getNombre() {
		return nombres;
	}

	public void setNombre(String nombre) {
		this.nombres = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombres + ", notas=" + notas + "]";
	}

}

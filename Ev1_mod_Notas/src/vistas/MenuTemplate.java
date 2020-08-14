package vistas;

import java.util.Scanner;

public abstract class  MenuTemplate {
	protected Scanner scanner;
	
	public abstract void cargarDatos();
	public abstract void exportarDatos();
	public abstract void crearAlumno();
	public abstract void agregarMateria();
	public abstract void agregarNota();
	public abstract void terminarPrograma();
	
	public void iniciarMenu() {
		
	}
	
	

}

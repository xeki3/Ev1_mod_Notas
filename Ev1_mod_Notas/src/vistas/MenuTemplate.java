package vistas;

import java.util.Scanner;

public abstract class  MenuTemplate {
	private Scanner scanner;

	public abstract void cargarDatos();
	public abstract void exportarDatos();
	public abstract void crearAlumno();
	public abstract void agregarMateria();
	public abstract void agregarNota();
	public abstract void terminarPrograma();

	public void iniciarMenu() {
		scanner = new Scanner(System.in);
		int opcion ;

		System.out.println("1.- Crear Alumno");
		System.out.println("2.- Lista Alumnos");
		System.out.println("3.- Agregar Materias");
		System.out.println("4.- Agregar Notas");
		//System.out.println("5.- Null cargar datos");
		System.out.println("5.- Exportar Datos");
		System.out.println("6.- Salir");
		opcion = scanner.nextInt();
		scanner.nextLine();
		switch (opcion) {
		case 1:
			crearAlumno();
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;

		default:
			break;
		}

	}



}

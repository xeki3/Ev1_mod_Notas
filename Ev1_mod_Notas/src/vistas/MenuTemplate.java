package vistas;

import java.util.Scanner;

public abstract class  MenuTemplate {
	private Scanner scanner;

	public abstract void exportarDatos();
	public abstract void crearAlumno();
	public abstract void agregarMateria();
	public abstract void agregarNota();
	public abstract void terminarPrograma();
	public abstract void listarAlumnos();

	public void iniciarMenu() {
		scanner = new Scanner(System.in);
		int opcion ;
		boolean ok = false;

		do {
			ok= false;
			try {
				System.out.println("**********MENU****************");
				System.out.println("1.- Crear Alumno");
				System.out.println("2.- Lista Alumnos");
				System.out.println("3.- Agregar Materias");
				System.out.println("4.- Agregar Notas");
				System.out.println("5.- Exportar Datos");
				System.out.println("6.- Salir");
				System.out.println("**********FIN MENU************");
				opcion = scanner.nextInt();
				scanner.nextLine();
				switch (opcion) {
				case 1:
					crearAlumno();
					break;
				case 2:
					listarAlumnos();
					break;
				case 3:
					agregarMateria();
					break;
				case 4:
					agregarNota();
					break;
				case 5:
					exportarDatos();
					break;

				case 6:
					terminarPrograma();
					break;
				default:
					System.out.println("Opcion ingresada Invalida");
					ok= true;
					break;
				}

			}catch(Exception e) {
				System.out.println("Opcion ingresada Invalida");
				ok = true;
				scanner.nextLine();
			}

		}while(ok);

	}

}

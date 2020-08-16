package vistas;

import java.util.ArrayList;
import java.util.Collections;
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
	public void exportarDatos() {
		int opcion ;
		boolean ok = false;
		
		String nombreArchivo;
		ArchivoServicioImp asi = new ArchivoServicioImp();
		System.out.println("Escriba el nombre del archivo");
		nombreArchivo = tec.nextLine();
		do {
			ok= false;
			try {
				System.out.println("1. TXT  \r\n" + 
						"2. CSV  \r\n");
				opcion = tec.nextInt();
				tec.nextLine();
				if(opcion==1) {
					nombreArchivo+=".txt";
				}else if (opcion ==2){
					nombreArchivo+=".csv";
				}else {
					System.out.println("Opcion Invalida");
					ok = true;
				}
				if(nombreArchivo.equals("notas.csv")) {
					ok=true;
					System.out.println("No puedes Ingresar ese nombre, estarias borrando un archivo clave");
				}
				
			}catch(Exception e) {
				System.out.println("Opcion Invalida");
				ok = true;
				tec.nextLine();
			}
			
		}while(ok);
		
		asi.ExportarDatos(ArchivoServicioImp.getAlumnos(), nombreArchivo);
	}

	@Override
	public void crearAlumno() {
		Alumno al =  new Alumno();

		System.out.println("Ingresa RUT");
		al.setRut(tec.nextLine());
		System.out.println("Ingresa Nombre");
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
		boolean ok = false;
		do {
			ok= false;
			try {
				cont=0;
				System.out.println("Seleccione Alumno");
				for(Alumno al:ArchivoServicioImp.getAlumnosACargar()) {
					cont+=1;
					System.out.println(cont+".- "+al.getNombre());
				}
				opcionAl = tec.nextInt();
				tec.nextLine();
				System.out.println("Seleccione una materia");
				System.out.println("1. MATEMATICAS  \r\n" + 
						"2. LENGUAJE  \r\n" + 
						"3. CIENCIA \r\n" + 
						"4. HISTORIA  \r\n" + 
						"");
				opcionMateria= tec.nextInt();
				tec.nextLine();
				Materia materia = new Materia();
				switch (opcionMateria) {
				case 1:
					materia.setNombre("MATEMATICAS");
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
					System.out.println("Error: Opcion Invalida");
					ok=true;
					break;
				}
				long conta =ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getMaterias().stream().filter(x->x.getNombre().equals(materia.getNombre())).count();
				if(conta==0) {
					String rut = ArchivoServicioImp.getAlumnosACargar().get(opcionAl-1).getRut();
					alumnoServicioImp  = new AlumnoServicioImp();
					alumnoServicioImp.agregarMateria(rut, materia);
				}else {
					System.out.println("Esa materia ya Existe para ese alumno");
				this.iniciarMenu();
				}
			}catch(Exception e) {
				System.out.println("Opcion Invalida");
				ok= true;
				//tec.nextLine();
			}
			
		}while(ok);
		
	}

	@Override
	public void agregarNota() {
		int cont=0;
		int opcionAl=0;
		int opcionMateria=0;
		double nota=0;
		boolean ok = false;
		
		do {
			ok= false;
			try {
				cont=0;
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
				System.out.println("Ingrese nota");
				nota = tec.nextDouble();
				tec.nextLine();
				ArchivoServicioImp.getAlumnos().get(rut).getMaterias().get(opcionMateria-1).getNotas().add(nota);
				ArchivoServicioImp.setAlumnosACargar(Collections.list(Collections.enumeration(ArchivoServicioImp.getAlumnos().values())));
				System.out.println("Nota ingresada correctamente");
				this.iniciarMenu();
			}catch(Exception e) {
				System.out.println("Opcion Invalida");
				ok = true;
				tec.nextLine();
			}
		}while(ok);
		
		
	}
	
	@Override
	public void listarAlumnos() {
		alumnoServicioImp=new AlumnoServicioImp();
		archivoServicioImp=new ArchivoServicioImp();
		alumnoServicioImp.listarAlumnos(ArchivoServicioImp.getAlumnos());
		this.iniciarMenu();
	}

	@Override
	public void terminarPrograma() {
		System.out.println("Hasta Pronto...");

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

package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.Alumno;
import modelo.Materia;
import vistas.Menu;

public class ArchivoServicioImp implements IArchivoServicio{
	
	private static List<Alumno> alumnosACargar;
	
	
	private Scanner lector;
	private List<Alumno> al = new ArrayList<Alumno>();
	private List<Double> notas;
	private List<Materia> materias2;
	private static Map<String, Alumno> alumnos = new HashMap<String, Alumno>();
	int cont = 0;
	
	
	@Override
	public Map<String, Alumno> cargarDatos(String rutaArchivoNotas){
		try {
			File archivo = new File(rutaArchivoNotas);
			String linea;
			String[] datosPersona;
			Alumno alumno;
			Materia materia;
			lector = new Scanner(archivo);

			while (lector.hasNext()) {
				cont+=1;
				linea = lector.nextLine();
				datosPersona = linea.split(",");
				String rut=datosPersona[0];
				String materia1 = datosPersona[2];
				alumno =new Alumno();
				alumno.setRut(datosPersona[0]);
				alumno.setNombre(datosPersona[1]);

				materia = new Materia();
				materia.setNombre(datosPersona[2]);
				//System.out.println("Materia "+materia);

				if(cont==1||al.stream().filter(x->x.getRut().equals(rut)).count()<1) {
					al.add(alumno);
				}
				//System.out.println("AL1"+al);
				for(Alumno al2:al) {
					if(al2.getRut().equals(datosPersona[0])) {
						if(al2.getMaterias()==null) {
							materias2= new ArrayList<Materia>();
							al2.setMaterias(materias2);
							al2.getMaterias().add(materia);
							notas= new ArrayList<Double>();
							al2.getMaterias().get(0).setNotas(notas);
							al2.getMaterias().get(0).getNotas().add(Double.parseDouble(datosPersona[3]));
						}else {
							if(al2.getMaterias().stream().filter(x->x.getNombre().equals(materia1)).count()<1) {
								al2.getMaterias().add(materia);
							}
							for(Materia mt: al2.getMaterias()) {
								if(mt.getNombre().equals(datosPersona[2])) {
									if(mt.getNotas()==null) {
										notas= new ArrayList<Double>();
										mt.setNotas(notas);
										mt.getNotas().add(Double.parseDouble(datosPersona[3]));
									}else {
										mt.getNotas().add(Double.parseDouble(datosPersona[3]));
									}		
								}
							}
						}
						//System.out.println("ALFinal "+al);
					}
				}
			}
			lector.close();
			//System.out.println("Se leyeron " + alumnos.size() + " Clientes");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		for(Alumno al3: al) {
			alumnos.put(al3.getRut(), al3);
		}
		ArchivoServicioImp.alumnosACargar = al;
		return alumnos;
	}
	@Override
	public void ExportarDatos(Map<String, Alumno> alumnos, String rutaArchivoNotas) {
		PromedioServicioImp psi = new PromedioServicioImp();
		Menu menu = new Menu();
		
		try {
            String ruta = rutaArchivoNotas;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Alumno al: alumnos.values()) {
            	bw.write("Alumno: "+al.getRut()+"-"+al.getNombre());
            	bw.newLine();
            	for(Materia mt: al.getMaterias()) {
            		bw.write("Materia: "+mt.getNombre()+"-Promedio: "+psi.calcularPromedio(mt.getNotas()));
            		bw.newLine();
            	}
            	
            }
            
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("Archivo creado en la carpeta fuente del proyecto");
		
		menu.iniciarMenu();
	}
	
	public static List<Alumno> getAlumnosACargar() {
		return alumnosACargar;
	}
	public static void setAlumnosACargar(List<Alumno> alumnosACargar) {
		ArchivoServicioImp.alumnosACargar = alumnosACargar;
	}
	public static Map<String, Alumno> getAlumnos() {
		return alumnos;
	}
	public static void setAlumnos(Map<String, Alumno> alumnos) {
		ArchivoServicioImp.alumnos = alumnos;
	}
	@Override
	public String toString() {
		return "ArchivoServicioImp [alumnosACargar=" + alumnosACargar + "]";
	}
	

}

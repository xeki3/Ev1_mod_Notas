package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArchivoServicioImp implements IArchivoServicio{
	private Scanner lector;
	//private List<String> gen= new ArrayList<String>();
	private List<Alumno> al = new ArrayList<Alumno>();
	private List<Double> notas ;
	private List<Materia> materias2 ;
	private Map<String, Alumno> alumnos = new HashMap<String, Alumno>(); 
	int cont = 0;
	@Override
	public Map<String, Alumno> cargarDatos(String rutaArchivoNotas) {
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

		return alumnos;
	}

	@Override
	public void ExportarDatos(Map<String, Alumno> alumnos, String rutaArchivoNotas) {
		
	}

}

package servicio;

import java.util.List;

public class PromedioServicioImp implements IPromedioServicio {

	@Override
	public Double calcularPromedio(List<Double> notas) {
		// TODO Auto-generated method stub
		double promedio=notas.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		return promedio;
	}


		
		
	

}

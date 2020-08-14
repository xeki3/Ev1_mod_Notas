package servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class PromedioServicioImpTest extends TestCase {
private PromedioServicioImp promedio=new PromedioServicioImp()	;

	public void testCalcularPromedio() {
		//notas 4.0,6.0.
		List<Double> notas=new ArrayList<Double>();
		notas.add(4.0);
		notas.add(6.0);	
		double esperado=5;
		double actual=promedio.calcularPromedio(notas);
	}

}

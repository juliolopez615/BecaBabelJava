package entidades;

import java.util.ArrayList;
import java.util.List;

public class Directivos extends Empleado{
	private List<Empleado> listaempleado = new ArrayList<Empleado>();
	
	public int getEmpleados() {
		return this.listaempleado.size();
	}
	
	public void aniadirEmpleado(Empleado empleado) {
		this.listaempleado.add(empleado);
	}
	
	public List<Empleado> getListaempleado() {
		return listaempleado;
	}


	@Override
	public double sueldoFinal() {
		if(listaempleado.size() < 3) {
			System.out.println("El directivo tiene que tener más de 3 empleados a su cargo.");
			System.out.println("Introduzca más empleados.");
			System.out.println("Numero actual de empleados: " + this.getEmpleados());
			return -1;
		}else {
			double tempBase = this.getSueldoBase();
			double tempEmpleados = this.getEmpleados() * 100;
			return tempBase + tempEmpleados;			
		}
	}
}

package main;

import java.util.ArrayList;
import java.util.List;

import entidades.Directivos;
import entidades.Empleado;
import entidades.Jefes;
import entidades.Trabajadores;

public class Main {
	
	public static void main(String[] args) {
		List<Empleado> listaempleadotest = new ArrayList<Empleado>();
		
		//Creando jefe y añadiendolo a la lista
		Jefes jefe = new Jefes();
		jefe.setSueldoBase(1500);
		jefe.setNombre("Jefe Pablo");
		jefe.setIncentivos(200);
		listaempleadotest.add(jefe);
		
		//Creando 2 jefe
		jefe = new Jefes();
		jefe.setSueldoBase(1000);
		jefe.setNombre("Jefe Pedro");
		jefe.setIncentivos(600);
		listaempleadotest.add(jefe);
		
		//Creando directivo
		Directivos directivo = new Directivos();
		directivo.setNombre("Directivo Roberto");
		directivo.setSueldoBase(2000);
		
		//Creando 2 trabajadore y 1 jefe que van dentro de la lista de empleados directivo
		Trabajadores trabajador = new Trabajadores();
		trabajador.setSueldoBase(500);
		trabajador.setNombre("Trabajador Julio");
		trabajador.setValoracion(7);
		directivo.aniadirEmpleado(trabajador);
		
		trabajador = new Trabajadores();
		trabajador.setSueldoBase(400);
		trabajador.setNombre("Trabajador Ana");
		trabajador.setValoracion(9);
		directivo.aniadirEmpleado(trabajador);
		
		jefe = new Jefes();
		jefe.setSueldoBase(1200);
		jefe.setNombre("Jefe Clara");
		jefe.setIncentivos(400);
		directivo.aniadirEmpleado(jefe);
		
		//Añadiendo directivo a la lista del main
		listaempleadotest.add(directivo);
		
		//Creando un trabajador y añadiendolo a la lista
		trabajador = new Trabajadores();
		trabajador.setSueldoBase(700);
		trabajador.setNombre("Trabajador Javier");
		trabajador.setValoracion(9);
		listaempleadotest.add(trabajador);
		
		//Recorriendo la lista creada de empleados n el main
		for(Empleado empleado: listaempleadotest) {
			System.out.println("Hola soy " + empleado.getNombre() + " y mi sueldo es de " +
					+ empleado.sueldoFinal() + " Euros");
		}
		
		System.out.println("--------------------------------------------------------------------------\n");
		
		//Recorriendo la lista de empleados dentro de directivo (Directivo Roberto)
		for(Empleado empleado: directivo.getListaempleado()) {
			System.out.println("Hola soy " + empleado.getNombre() + " y mi sueldo es de " +
					+ empleado.sueldoFinal() + " Euros");
		}
		

	}

}

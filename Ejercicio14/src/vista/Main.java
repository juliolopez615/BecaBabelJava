package vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;


public class Main {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int op = 0;
	while(true) {
		System.out.println(" -- INTRODUZCA UNA OPCION A REALIZAR -- ");
		
		System.out.println("1. Alta de coche");
		System.out.println("2. Eliminar coche por id");
		System.out.println("3. Modificar coche por id");
		System.out.println("4. buscar coche por id");
		System.out.println("5. buscar coche por matricula");
		System.out.println("6. buscar coches por marca");
		System.out.println("7. buscar coches por modelo");
		System.out.println("8. listar todos los coches");
		System.out.println("9. Salir de la aplicación");
		
		op = sc.nextInt();
		
		switch(op) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
		}
		
		
		
		break;		
	}
	
	
	
	

	}

}

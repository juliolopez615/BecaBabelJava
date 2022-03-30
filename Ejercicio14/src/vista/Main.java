package vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sca = new Scanner(System.in);
		GestorCoche gestor = new GestorCoche();
		
		int op = 0;
		while(op != 9) {
			System.out.println(" \n\n-- INTRODUZCA UNA OPCION A REALIZAR -- \n");
			
			System.out.println("1. Alta de coche");
			System.out.println("2. Eliminar coche por id");
			System.out.println("3. Modificar coche por id");
			System.out.println("4. buscar coche por id");
			System.out.println("5. buscar coche por matricula");
			System.out.println("6. buscar coches por marca");
			System.out.println("7. buscar coches por modelo");
			System.out.println("8. listar todos los coches");
			System.out.println("9. Salir de la aplicación\n");
			
			if(gestor.listar().size() > 0) {
				System.out.println("\nLista actual de coches...\n ");
				for(Coche coches : gestor.listar()) {
					System.out.println("\n" + coches);
				}
			}else {
				System.out.println("Ahora mismo no hay ningun coche en nuestra lista de coches :( ");
			}
			
			System.out.println("\n -- INTRODUZCA OPCION --  ");
			op = sc.nextInt();
			
			switch(op) {
				case 1:
					System.out.println("Introduzca la matricula: \n");
					int matricula = sca.nextInt();
					sca.nextLine();//Limpiar buffer
					
					System.out.println("Introduzca la marca: \n");
					String marca = sca.nextLine();
					
					System.out.println("Introduzca el modelo: \n");
					String modelo = sca.nextLine();
					
					System.out.println("Introduzca los kilometros: \n");
					int kilometros = sca.nextInt();
					
					Coche c = new Coche(matricula,marca,modelo,kilometros);
					gestor.alta(c);
					break;
				case 2:
					System.out.println("Introduzca el id del coche que quiere eliminar: \n");
					int id = sca.nextInt();
					gestor.baja(id);
					break;
				case 3:
					System.out.println("Introduzca el id del coche que quiere modificar: \n");
					id = sca.nextInt();
					
					System.out.println("Introduzca la nueva matricula: \n");
					matricula = sca.nextInt();
					sca.nextLine();//Limpiar buffer
					
					System.out.println("Introduzca la nueva marca: \n");
					marca = sca.nextLine();
					
					System.out.println("Introduzca el nuevo modelo: \n");
					modelo = sca.nextLine();
					
					System.out.println("Introduzca los nuevos kilometros: \n");
					kilometros = sca.nextInt();
					
					c = new Coche(matricula,marca,modelo,kilometros);
					c.setId(id);
					gestor.modificar(c);
					break;
				case 4:
					System.out.println("Introduzca el id del coche que quiere buscar: \n");
					id = sca.nextInt();
					System.out.println("\nEste es el coche que busca: " + gestor.buscarid(id));
					break;
				case 5:
					System.out.println("Introduzca la matricula que quiere buscar: \n");
					matricula = sca.nextInt();
					System.out.println("\nEste es el coche que busca: " + gestor.buscarmatricula(matricula));
					break;
				case 6:
					System.out.println("Introduzca la marca que quiere buscar: \n");
					marca = sca.nextLine();
					
					System.out.println("Mostrando coches ... ");
					for(Coche coches : gestor.buscarmarca(marca)) {
						System.out.println("\n" + coches);
					}
					System.out.println("... Cerrando ... ");
					
					break;
				case 7:
					System.out.println("Introduzca el modelo que quiere buscar: \n");
					modelo = sca.nextLine();
					
					System.out.println("... Mostrando coches ... ");
					for(Coche coches : gestor.buscarmodelo(modelo)) {
						System.out.println("\n" + coches);
					}
					System.out.println("\n... Cerrando ... ");
					break;
				case 8:
					System.out.println("\nListado de coches: \n ");
					for(Coche coches : gestor.listar()) {
						System.out.println("\n" + coches);
					}
					break;
				case 9:
					op = 9;
					break;
			}
		}
		sc.close();
		sca.close();
		System.out.println("HA SALIDO DE LA APLICACION \n");
	}
}
	
package vista;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;
import validador.Validador;


public class Main {
	/**
	 * Este metodo es el mismo que el ejercicio 14 pero se han añadido el caso 9 y 10 en el menú.
	 * 
	 * El método 9 ha sido hecho con la librería Gson
	 * El método 10 con iText.
	 * @param args
	 */
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		Scanner sca = new Scanner(System.in);
		GestorCoche gestor = new GestorCoche();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		boolean flag = true;
		int contador = 0;
		String usuario = "";
		String password = "";
		int op = 0;
		
		while(flag) {
			System.out.println("Introduzca un usuario: ");
			usuario = sca.nextLine();
			
			System.out.println("Introduzca una contraseña: ");
			password = sca.nextLine();
			
			if(gestor.validar(usuario, password)) {
				flag = false;
			}
			
			if(contador > 2) {
				System.out.println("Se agotaron los intentos");
				op = 11;
			}
		}
		
		
		while(op != 11) {
			System.out.println(" \n\n-- INTRODUZCA UNA OPCION A REALIZAR -- \n");
			
			System.out.println("1. Alta de coche");
			System.out.println("2. Eliminar coche por id");
			System.out.println("3. Modificar coche por id");
			System.out.println("4. buscar coche por id");
			System.out.println("5. buscar coche por matricula");
			System.out.println("6. buscar coches por marca");
			System.out.println("7. buscar coches por modelo");
			System.out.println("8. listar todos los coches");
			System.out.println("9. Exportar la lista de los coches a fichero JSON");
			System.out.println("10. Exportar la lista de coches a PDF");
			System.out.println("11. Salir de la aplicación\n");
			
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
					try (FileWriter writer = new FileWriter("coches.json")) {
			            writer.write(gson.toJson(gestor.listar()));
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
					break;
				case 10:					
					Document document = new Document();
					var phrase = new Phrase();
					try {
						PdfWriter.getInstance(document, new FileOutputStream("coches.pdf"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					document.open();
				
					for(Coche coche : gestor.listar()) {
						Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
						Chunk chunk = new Chunk("* " + coche.toString() + "\n\n", font);
					
					phrase.add(chunk);
				}
				
				try {
					document.add(phrase);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				document.close();
					break;
				case 11:
					op = 11;
					break;
			}
		}
		System.out.println("HA SALIDO DE LA APLICACION \n");
		sc.close();
		sca.close();
	}
}
	
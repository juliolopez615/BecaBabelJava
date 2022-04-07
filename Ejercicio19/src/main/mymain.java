package main;

import java.util.Scanner;

interface InterfazOperaciones{
	public Double operacion(Double a, Double b);
}

public class mymain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int op = 0;
		double num1 = 0;
		double num2 = 0;
		InterfazOperaciones operacion = null;
		
		
		do {
			
			System.out.println("\n\n¿Qué operación quieres realizar? Elige un número");
			System.out.println("1) Sumar");
			System.out.println("2) Restar");
			System.out.println("3) Multiplicar");
			System.out.println("4) Dividir");
			System.out.println("5) Potencia");
			System.out.println("6) Salir");
			
			System.out.println("Introduzca una opcion:");
			op = sc.nextInt();
			
			if(op != 6) {
				System.out.println("Introduce el primer numero:");
				num1 = sc.nextDouble();
				
				System.out.println("Introduce el segundo numero:");
				num2 = sc.nextDouble();
			}
			
			switch(op) {
				case 1:
					operacion = (n1, n2) -> n1 + n2;
					System.out.println("El resultado es: " + operacion.operacion(num1,num2));
					break;
				case 2:
					operacion = (n1, n2) -> n1 - n2;
					System.out.println("El resultado es: " + operacion.operacion(num1,num2));
					break;
				case 3:
					operacion = (n1, n2) -> n1 * n2;
					System.out.println("El resultado es: " + operacion.operacion(num1,num2));
					break;
				case 4:
					operacion = (n1, n2) -> n1 / n2;
					System.out.println("El resultado es: " + operacion.operacion(num1,num2));
					break;
				case 5:
					operacion = (n1, n2) -> Math.pow(n1, n2);;
					System.out.println("El resultado es: " + operacion.operacion(num1,num2));
					break;
				case 6:
					flag = false;
					break;
				default:
					System.out.println("algo fue mal");
					break;
			}					
			
		}while(flag);
		
		System.out.println("Fin del Programa.");
		sc.close();		
	}

}

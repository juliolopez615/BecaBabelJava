package Main;

import java.util.Scanner;

public class Mymain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero: ");
		
		Runnable primo = () -> {	
			int numero = sc.nextInt();
			int flag = 1;
			
			if (numero == 0 || numero == 1 || numero == 4) {
			    System.out.println("El numero " + numero +" No es primo");
			    sc.close();
			    return;
			}
			  for (int x = 2; x < numero / 2; x++) {
			    if (numero % x == 0) {
			    	flag = 0;
			    }
			  }
			  
			  if(flag == 0) {
			    	System.out.println("El numero " + numero +" No es primo");
			    }else {
			    	System.out.println("El numero " + numero +" Es Primo !!!");
			    }			  
		};
		
		Thread t1 = new Thread(primo);
		t1.setName("Hilo 1");
		
		Thread t2 = new Thread(primo);
		t1.setName("Hilo 2");
		
		Thread t3 = new Thread(primo);
		t1.setName("Hilo 3");
		
		t1.run();
		t2.run();
		t3.run();
		
		System.out.println("Fin del programa");
		sc.close();
		
	}
}

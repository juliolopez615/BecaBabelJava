package main;

import java.util.Scanner;

import primo.Primo;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido a nuestra calculadora de numeros primos !!");
		System.out.println("Introduza tres numeros primos, por favor :)");
		
		System.out.println("Primer numero: ");
		int num1 = sc.nextInt();
		
		System.out.println("Segundo numero");
		int num2 = sc.nextInt();
		
		System.out.println("Tercer numero");
		int num3 = sc.nextInt();
		
		System.out.println("Calculando.....");
		
		Runnable esprimo1 = new Primo(num1);
		Thread t1 = new Thread(esprimo1);
		t1.setName("HiloNum1");
		
		Runnable esprimo2 = new Primo(num2);
		Thread t2 = new Thread(esprimo2);
		t2.setName("HiloNum2");
		
		Runnable esprimo3 = new Primo(num3);
		Thread t3 = new Thread(esprimo3);
		t3.setName("HiloNum3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

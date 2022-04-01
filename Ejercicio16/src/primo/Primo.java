package primo;

public class Primo implements Runnable {
	private int numero;
	
	public Primo(int numero) {
		this.numero = numero;
	}
	/*
	 * numero que queremos comprobar si es primo o no es primo
	 * Devuelve falso si son los numeros 0,1 y 4. Devuelve falso si se puede dividir por
	 * los numeros que hay hasta su mitad( De ahí la excepcion con 0,1 y 4), en caso de que no 
	 * se pueda dividir devuelve verdadero
	 */ 
	@Override
	public void run() {
		int flag = 1;
		
		if (numero == 0 || numero == 1 || numero == 4) {
		    System.out.println("El numero " + this.numero +" No es primo");
		    return;
		}
		  for (int x = 2; x < numero / 2; x++) {
		    if (numero % x == 0) {
		    	flag = 0;
		    }
		  }
		  
		  if(flag == 0) {
		    	System.out.println("El numero " + this.numero +" No es primo");
		    }else {
		    	System.out.println("El numero " + this.numero +" Es Primo !!!");
		    }
	}
}

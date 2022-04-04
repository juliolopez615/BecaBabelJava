package entidades.armas;

import java.util.Random;

public class Arco extends Arma{

	public Arco() {
		this.setNombre("Arco");
	}
	
	@Override
	public int usar() {
		Random rand = new Random();
		System.out.println("FVII ~El sonido de la flecha cortó el aire ~ FVII");
		this.setDanio(rand.nextInt(21));
		return this.getDanio();
	}

	@Override
	public String toString() {
		return "["+ getNombre() + "]";
	}
	
	
	
}

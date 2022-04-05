package entidades.armas;

import java.util.Random;

public class Espada extends Arma{
	
	public Espada() {
		this.setNombre("Espada");
	}

	@Override
	public int usar() {
		Random rand = new Random();
		System.out.println("FVII ~El sonido cortó el aire ~ FVII");
		this.setDanio(rand.nextInt(24));
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "["+ getNombre() + "]";
	}
	
}

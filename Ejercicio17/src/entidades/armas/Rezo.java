package entidades.armas;

import java.util.Random;

public class Rezo extends Arma{

	public Rezo() {
		this.setNombre("Rezo");
	}
	
	
	@Override
	public int usar() {
		Random rand = new Random();
		System.out.println("AAAaaAAA ~Sonido canticos sagrados~ AAAaaaAAA");
		this.setDanio(rand.nextInt(20));
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "["+ getNombre() + "]";
	}
	

}

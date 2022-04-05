package entidades.armas;

import java.util.Random;

public class Hechizo extends Arma{

	
	public Hechizo() {
		this.setNombre("Hechizo");
	}
	
	@Override
	public int usar() {
		Random rand = new Random();
		System.out.println("chisp ~Sonido de pequeñas chispas ~ chisp");
		this.setDanio(rand.nextInt(22));
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "["+ getNombre() + "]";
	}
	

}

package entidades.armas;

public class Hechizo extends Arma{

	
	public Hechizo() {
		this.setNombre("Hechizo");
	}
	
	@Override
	public int usar() {
		System.out.println("chisp ~Sonido de pequeñas chispas ~ chisp");
		this.setDanio(10);
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "Arco [getNombre()=" + getNombre() + "]";
	}
	

}

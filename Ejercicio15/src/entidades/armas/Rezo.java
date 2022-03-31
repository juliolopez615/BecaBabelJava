package entidades.armas;

public class Rezo extends Arma{

	public Rezo() {
		this.setNombre("Rezo");
	}
	
	
	@Override
	public int usar() {
		System.out.println("AAAaaAAA ~Sonido canticos sagrados~ AAAaaaAAA");
		this.setDanio(11);
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "Arco [getNombre()=" + getNombre() + "]";
	}
	

}

package entidades.armas;

public class Arco extends Arma{

	public Arco() {
		this.setNombre("Arco");
	}
	
	@Override
	public int usar() {
		System.out.println("FVII ~El sonido cortó el aire ~ FVII");
		this.setDanio(9);
		return this.getDanio();
	}

	@Override
	public String toString() {
		return "Arco [getNombre()=" + getNombre() + "]";
	}
	
	
	
}

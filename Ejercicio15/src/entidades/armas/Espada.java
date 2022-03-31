package entidades.armas;


public class Espada extends Arma{
	
	public Espada() {
		this.setNombre("Espada");
	}

	@Override
	public int usar() {
		System.out.println("FVII ~El sonido cortó el aire ~ FVII");
		this.setDanio(10);
		return this.getDanio();
	}
	
	@Override
	public String toString() {
		return "Arco [getNombre()=" + getNombre() + "]";
	}
	
}

package entidades.armas;

public abstract class Arma {
	private int danio;
	private String nombre;
	
	public abstract int usar();

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

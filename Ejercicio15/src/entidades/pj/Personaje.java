package entidades.pj;

import entidades.armas.Arma;

public abstract class Personaje {
	private int vida;
	private int danioBase;
	private String nombre;
	private Arma arma;
	
	public abstract int atacar();
	
	public abstract void restarVida(int danio);
	
	public abstract boolean escapar();
	
	public abstract void cambiarArma(Arma arma);
	
	public abstract void taunt();

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getDanioBase() {
		return danioBase;
	}

	public void setDanioBase(int danioBase) {
		this.danioBase = danioBase;
	}

}

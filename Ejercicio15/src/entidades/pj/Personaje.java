package entidades.pj;

import java.util.Random;

import entidades.armas.Arma;

public abstract class Personaje {
	private int vida;
	private int danioBase;
	private String nombre;
	private Arma arma;
	
	public abstract int atacar();
	
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
	
	
	public void restarVida(int danio) {
		this.setVida(this.getVida() - danio);
	}
	
	public void cambiarArma(Arma arma) {
		this.setArma(arma);		
	}
	
	public boolean escapar() {
		Random rand = new Random();
		int numero = rand.nextInt(101);
		int escapar = 0;
		
		for(int i = 0; i < 10; i++) {
			escapar = rand.nextInt(101);
			if(escapar == numero) {
				return true;
			}
		}
		
		return false;
		
	}

}

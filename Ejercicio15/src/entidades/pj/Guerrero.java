package entidades.pj;

import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;

public class Guerrero extends Personaje{
	private int fuerza = 0;
	
	public Guerrero() {
		Random rand = new Random(); 
	    int topefuerza = 16;
	    int topedaniobase = 7;
	    int randomfuerza = rand.nextInt(topefuerza);
	    int randomdaniobase = rand.nextInt(topedaniobase);
	    
		this.setDanioBase(randomdaniobase);
		this.setFuerza(randomfuerza);
		this.setVida(100);
		this.setNombre("Guerrero");
		
	}
	
	
	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	@Override
	public int atacar() {
		Arma arma = this.getArma();
		int fuerzas = 0;
		Random rand = new Random(); 
		
		if(this.getArma() instanceof Espada) {
			fuerzas = this.getFuerza() + rand.nextInt(15);
			System.out.println("AAARHH ~Por Aicamed ~ AAARHH");
			return fuerzas + arma.usar();
			
		}else if(this.getArma() instanceof Arco) {
			fuerzas = this.getFuerza() + rand.nextInt(12);
			System.out.println("8) ~Aicamed es eterna ~ 8)");
			return fuerzas + arma.usar();
			
		}else if(this.getArma() instanceof Hechizo) {
			System.out.println("A ver como se usa esto...");
			return arma.usar();
			
		}else if(this.getArma() instanceof Rezo) {
			System.out.println("No he rezado en mi vida hulio pero all� va");
			return arma.usar();
		}else {
			return -1;
		}
		
	}

	@Override
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

	@Override
	public void cambiarArma(Arma arma) {
		this.setArma(arma);		
	}

	@Override
	public void taunt() {
		System.out.println("Por el poder del fuego y la tierra YO te dar� caza!");
		
	}

	@Override
	public void restarVida(int danio) {
		this.setVida(this.getVida() - danio);
	}


	@Override
	public String toString() {
		return "Guerrero [fuerza=" + fuerza + ", getVida()=" + getVida() + ", getNombre()=" + getNombre()
				+ ", getArma()=" + getArma() + ", getDanioBase()=" + getDanioBase() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}

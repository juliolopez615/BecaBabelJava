package entidades.pj;

import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;

public class Mago extends Personaje{
	private int inteligencia;	
	
	public Mago() {
		Random rand = new Random(); 
	    int topeinteligencia = 16;
	    int topedaniobase = 7;
	    int randominteligencia = rand.nextInt(topeinteligencia);
	    int randomdaniobase = rand.nextInt(topedaniobase);
	    
		this.setDanioBase(randomdaniobase);
		this.setInteligencia(randominteligencia);
		this.setVida(100);
		this.setNombre("Mago");
	}
	
	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public int atacar() {
		Arma arma = this.getArma();
		int inteligencias = 0;
		Random rand = new Random();
		
		if(this.getArma() instanceof Espada) {
			System.out.println("Las espadas son para los debiles, pero, que remedio...");
			return arma.usar();
			
		}else if(this.getArma() instanceof Arco) {
			System.out.println("En mi ojo, tu vida");
			return arma.usar();
			
		}else if(this.getArma() instanceof Hechizo) {
			inteligencias = this.getInteligencia() + rand.nextInt(15);
			System.out.println("TORMENTA !!");
			return arma.usar() + inteligencias;
			
		}else if(this.getArma() instanceof Rezo) {
			System.out.println("Los Rezos son para los debiles de corazon...");
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
		System.out.println("Por el poder del fuego y la tierra YO te daré caza!");
		
	}

	@Override
	public void restarVida(int danio) {
		this.setVida(this.getVida() - danio);
	}

	@Override
	public String toString() {
		return "Mago [inteligencia=" + inteligencia + ", getVida()=" + getVida() + ", getNombre()=" + getNombre()
				+ ", getArma()=" + getArma() + ", getDanioBase()=" + getDanioBase() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}

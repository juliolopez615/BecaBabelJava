package entidades.pj;

import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;

public class Guerrero extends Personaje{
	private int fuerza = 0;
	
	/**
	 * Se setea el atributo fuerza y el daño base con un random. La fuerza luego será aumentada si se usa
	 * una espada en el ataque. Se añade tambien la vida y el nombre, que serán constantes.
	 */
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
			System.out.println("No he rezado en mi vida hulio pero allá va");
			return arma.usar();
		}else {
			return -1;
		}
		
	}
	
	/**
	 * Opcion para que el personaje escape en caso de que vaya perdiendo o esté a punto de morir
	 * Aun no se si lo voy a implementar pero de momento ahi queda
	 */
	

	@Override
	public void taunt() {
		System.out.println("Por el poder del fuego y la tierra YO te daré caza!");
		
	}


	@Override
	public String toString() {
		return "Guerrero [fuerza=" + fuerza + ", getVida()=" + getVida() + ", getNombre()=" + getNombre()
				+ ", getArma()=" + getArma() + ", getDanioBase()=" + getDanioBase() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}	
	

}

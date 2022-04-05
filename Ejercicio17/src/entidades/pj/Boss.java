package entidades.pj;

import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;

public class Boss extends Personaje {
	private int maldad;
	
	public Boss() {
		Random rand = new Random(); 
	    int topemaldad = 12;
	    int topedaniobase = 11;
	    int randommaldad = rand.nextInt(topemaldad);
	    int randomdaniobase = rand.nextInt(topedaniobase);
	    
		this.setDanioBase(randomdaniobase);
		this.setMaldad(randommaldad);
		this.setVida(150);
		this.setNombre("Final Boss");
		
	}
	
	//El Boss maneja todas las armas y tiene bonificacion por todas.
	@Override
	public int atacar() {
		Arma arma = this.getArma();
		Random rand = new Random(); 
		
		if(this.getArma() instanceof Espada) {
			maldad = this.getMaldad() + rand.nextInt(8);
			System.out.println("Espada de sombras!!");
			return maldad + arma.usar();
			
		}else if(this.getArma() instanceof Arco) {
			maldad = this.getMaldad() + rand.nextInt(8);
			System.out.println("Arco Maldito!!");
			return maldad + arma.usar();
			
		}else if(this.getArma() instanceof Hechizo) {
			maldad = this.getMaldad() + rand.nextInt(12);
			System.out.println("Por el poder de las tinieblas!!");
			return maldad + arma.usar();
			
		}else if(this.getArma() instanceof Rezo) {
			maldad = this.getMaldad() + rand.nextInt(11);
			System.out.println("Oración Maligna!");
			return maldad + arma.usar();
		}else {
			return -1;
		}
		
	}

	@Override
	public void taunt() {
		System.out.println("Soy... Eterno Muajjaja !!");		
	}

	public int getMaldad() {
		return maldad;
	}

	public void setMaldad(int maldad) {
		this.maldad = maldad;
	}

}

package entidades.pj;

import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;

public class Priest extends Personaje{
	private int sabiduria;
	
	public Priest() {
		Random rand = new Random(); 
	    int topesabiduria = 16;
	    int topedaniobase = 7;
	    int randomsabiduria = rand.nextInt(topesabiduria);
	    int randomdaniobase = rand.nextInt(topedaniobase);
	    
		this.setDanioBase(randomdaniobase);
		this.setSabiduria(randomsabiduria);
		this.setVida(100);
		this.setNombre("Priest");
	}
	
	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}
	
	@Override
	public int atacar() {
		Arma arma = this.getArma();
		int sabidurias = 0;
		Random rand = new Random();
		
		if(this.getArma() instanceof Espada) {
			System.out.println("Las espadas las carga el diablo... AAAAAHHH (ataca)");
			return arma.usar() + this.getDanioBase();
			
		}else if(this.getArma() instanceof Arco) {
			System.out.println("Que la flecha purifique tu alma");
			return arma.usar() + this.getDanioBase();
			
		}else if(this.getArma() instanceof Hechizo) {
			System.out.println("Tengo mis experiencias con la magia");
			return arma.usar() + this.getDanioBase();
		}else if(this.getArma() instanceof Rezo) {
			sabidurias = this.getSabiduria() + rand.nextInt(15);
			System.out.println("Por el poder Sagrado, yo te purifico!!");
			return arma.usar() + sabidurias + this.getDanioBase();
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
		return "Priest [sabiduria=" + sabiduria + ", getVida()=" + getVida() + ", getNombre()=" + getNombre()
				+ ", getArma()=" + getArma() + ", getDanioBase()=" + getDanioBase() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}

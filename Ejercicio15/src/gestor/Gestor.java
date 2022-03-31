package gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;
import entidades.pj.Guerrero;
import entidades.pj.Mago;
import entidades.pj.Personaje;
import entidades.pj.Priest;

public class Gestor {
	
	public Personaje combatir(Personaje pj1, Personaje pj2) {
		pj2.restarVida(pj1.atacar());
		return pj2;
	}
	public List<Arma> creararma(){
		Arma ar1 = null;
		Arma ar2 = null;
		int clase = 0;
		List<Arma> arlist = new ArrayList<Arma>();
		Random rand = new Random();
		
		for(int i=0; i<2; i++) {
			
			clase = rand.nextInt(13);
			if(clase > 0 && clase <= 3) {
				if(i == 0) {
					ar1 = new Arco();
				}else {
					ar2 = new Arco();
				}
			}else if(clase > 3 && clase <= 6) {
				if(i == 0) {
					ar1 = new Espada();
				}else {
					ar2 = new Espada();
				}
				
			}else if(clase > 6 && clase <=9) {
				if(i == 0) {
					ar1 = new Hechizo();
				}else {
					ar2 = new Hechizo();
				}
				
			}else if(clase > 9 && clase <=12) {
				if(i == 0) {
					ar1 = new Rezo();
				}else {
					ar2 = new Rezo();
				}
				
			}else {
				i--;
				continue;
			}
		}
		arlist.add(ar1);
		arlist.add(ar2);
		return arlist;
	}
	
	public List<Personaje> crearPj(){
		Personaje pj1 = null;
		Personaje pj2 = null;
		int clase = 0;
		List<Personaje> pjlist = new ArrayList<Personaje>();
		Random rand = new Random();
		
		for(int i=0; i<2; i++) {
			
			clase = rand.nextInt(10);
			System.out.println(clase);
			if(clase > 0 && clase <= 3) {
				if(i == 0) {
					pj1 = new Guerrero();
				}else {
					pj2 = new Guerrero();
				}
			}else if(clase > 3 && clase <= 6) {
				if(i == 0) {
					pj1 = new Mago();
				}else {
					pj2 = new Mago();
				}
				
			}else if(clase > 6 && clase <=9) {
				if(i == 0) {
					pj1 = new Priest();
				}else {
					pj2 = new Priest();
				}
				
			}else {
				System.out.println("Wtf");
				i--;
				continue;
			}
		}
		pjlist.add(pj1);
		pjlist.add(pj2);
		return pjlist;
	}
}

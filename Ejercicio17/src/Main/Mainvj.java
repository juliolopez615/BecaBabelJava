package Main;

import java.util.List;
import entidades.armas.Arma;
import entidades.pj.Guerrero;
import entidades.pj.Mago;
import entidades.pj.Personaje;
import entidades.pj.Priest;
import gestor.Gestor;

public class Mainvj {

	public static void main(String[] args){

		Gestor combate = new Gestor();
		List<Personaje> pjlist = combate.crearPj();
		List<Arma> arlist = combate.creararma();
		
		Personaje pj1 = pjlist.get(0);
		pj1.setArma(arlist.get(0));
		pj1.setMazmorra(combate);
		
		Personaje pj2 = pjlist.get(1);
		pj2.setArma(arlist.get(1));
		pj2.setMazmorra(combate);
		
		Personaje pj3 = new Priest();
		pj3.setArma(arlist.get(0));
		pj3.setMazmorra(combate);
		pjlist.add(pj3);
		
		Personaje pj4 = new Guerrero();
		pj4.setArma(arlist.get(1));
		pj4.setMazmorra(combate);
		pjlist.add(pj4);
		
		Personaje pj5 = new Mago();
		pj5.setArma(arlist.get(0));
		pj5.setMazmorra(combate);
		pjlist.add(pj5);
		
		Personaje pj6 = new Mago();
		pj6.setArma(arlist.get(0));
		pj6.setMazmorra(combate);
		pjlist.add(pj6);
		
		for(Personaje pj : pjlist) {
			pj.run();
		}
		
		System.out.println("\n\nFIN DEL JUEGO");

	}
}

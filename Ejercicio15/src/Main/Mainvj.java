package Main;

import java.util.List;
import entidades.armas.Arma;
import entidades.pj.Personaje;
import gestor.Gestor;

public class Mainvj {

	public static void main(String[] args) throws InterruptedException {

		Gestor combate = new Gestor();
		List<Personaje> pjlist = combate.crearPj();
		List<Arma> arlist = combate.creararma();
		
		Personaje pj1 = pjlist.get(0);
		pj1.setArma(arlist.get(0));
		Personaje pj2 = pjlist.get(1);
		pj2.setArma(arlist.get(1));
		
		combate.combatir(pj1, pj2);
		
		
		
		System.out.println("\n\nFIN DEL JUEGO");

	}
}

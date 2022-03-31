package Main;

import java.util.List;
import java.util.Random;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.pj.Personaje;
import gestor.Gestor;

public class Mainvj {

	public static void main(String[] args) throws InterruptedException {
		boolean turno = true;
		boolean flag = true;
		int contador = 1;
		Gestor combate = new Gestor();
		Random rand = new Random();
		List<Personaje> pjlist = combate.crearPj();
		List<Arma> arlist = combate.creararma();
		
		Personaje pj1 = pjlist.get(0);
		pj1.setArma(arlist.get(0));
		Personaje pj2 = pjlist.get(1);
		pj2.setArma(arlist.get(1));
		
		turno = rand.nextBoolean();
		
		System.out.println("BATALLA ENTRE JUGADOR 1: " + pj1.getNombre() + " Y JUGADOR 2: " + pj2.getNombre() + " !!!!");
		
		if(turno) {
			System.out.println("COMIENZA EL JUGADOR 1: " + pj1.getNombre());
		}else {
			System.out.println("COMIENZA EL JUGADOR 2: " + pj2.getNombre());
		}
		
		while(flag) {
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\nTurno " + contador + "\n");
			
			System.out.println("Vida del JUGADOR 1: " + pj1.getNombre() + ": " + pj1.getVida() + "  Arma: " + pj1.getArma());
			System.out.println("Vida del JUGADOR 2: " + pj2.getNombre() + ": " + pj2.getVida() + "  Arma: " + pj2.getArma());
			System.out.println("\n");
			if(turno) {
				pj2 = combate.combatir(pj1, pj2);
			}else {
				pj1 = combate.combatir(pj2, pj1);
			}
			
			if(pj1.getVida() <=0 || pj2.getVida() <= 0) {
				if(pj1.getVida() <=0) {
					System.out.println("\nGANADOR JUGADOR 2: " + pj2.getNombre());
					flag = false;
				}else {
					System.out.println("\nGANADOR JUGADOR 1: " + pj1.getNombre());
					flag = false;
				}
			}
			
			//Todos los turnos arma nueva a partir del 6!
			if(contador > 4) {
				arlist = combate.creararma();
				
				pj1 = pjlist.get(0);
				pj1.setArma(arlist.get(0));
				
				pj2 = pjlist.get(1);
				pj2.setArma(arlist.get(1));
			}
			
			
			System.out.println("-------------------------------------------------------------------");
			
			turno = !turno;
			contador++;
			Thread.sleep(4000);
			
		}
		
		System.out.println("Vida del JUGADOR 1: " + pj1.getNombre() + ": " + pj1.getVida() + "  Arma: " + pj1.getArma());
		System.out.println("Vida del JUGADOR 2: " + pj2.getNombre() + ": " + pj2.getVida() + "  Arma: " + pj2.getArma());
		
		System.out.println("\n\nFIN DEL JUEGO");

	}
}

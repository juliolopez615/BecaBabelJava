package gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entidades.armas.Arco;
import entidades.armas.Arma;
import entidades.armas.Espada;
import entidades.armas.Hechizo;
import entidades.armas.Rezo;
import entidades.pj.Boss;
import entidades.pj.Guerrero;
import entidades.pj.Mago;
import entidades.pj.Personaje;
import entidades.pj.Priest;

public class Gestor {
	private Personaje pj1;
	private Boss pj2;
	
	public Gestor() {
		this.pj2 = new Boss();
		List<Arma> arlist = this.creararma();
		pj2.setArma(arlist.get(0));
	}
	public Personaje getPj1() {
		return pj1;
	}

	public void setPj1(Personaje pj1) {
		this.pj1 = pj1;
	}

	public Boss getPj2() {
		return pj2;
	}

	public void setPj2(Boss pj2) {
		this.pj2 = pj2;
	}

	/**
	 * Los ataques van por turnos, uno cada turno.
	 * 
	 * @param pj1 primer pj
	 * @param pj2 segundo pj
	 * @return devuelve el ganador de la batalla aunque en este caso no se ha implementado luego en el main 
	 * se implementará en el ejercicio 17.
	 * 
	 */
	public synchronized int combatir(Personaje pj1) {
		//Parecido al caso base.
		if(this.pj2.getVida() <= 0) {
			System.out.println("Oiba, algún genio ya se ha cargado al jefe. Me quedo sin Cobrar :(");
			return -1;
		}
		
		this.pj1 = pj1;
		List<Arma> arlist;
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		boolean turno = true;
		boolean flag = true;
		int contador = 1;
		int contarma = 2;
		
		turno = rand.nextBoolean();
		
		System.out.println("BATALLA ENTRE JUGADOR 1: " + pj1.getNombre() + " Y JUGADOR 2: " + pj2.getNombre() + " !!!!");
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
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
				pj2.restarVida(pj1.atacar());
			}else {
				pj1.restarVida(pj2.atacar());
			}
			
			if(pj1.getVida() <=0 || pj2.getVida() <= 0) {
				if(pj1.getVida() <=0) {
					System.out.println("\nGANADOR JUGADOR 2: " + pj2.getNombre());
					
					System.out.println("Vida del JUGADOR 1: " + pj1.getNombre() + ": " + pj1.getVida() + "  Arma: " + pj1.getArma());
					System.out.println("Vida del JUGADOR 2: " + pj2.getNombre() + ": " + pj2.getVida() + "  Arma: " + pj2.getArma());
					sc.close();
					return 0;
		
				}else {
					System.out.println("\nGANADOR JUGADOR 1: " + pj1.getNombre());
					
					System.out.println("Vida del JUGADOR 1: " + pj1.getNombre() + ": " + pj1.getVida() + "  Arma: " + pj1.getArma());
					System.out.println("Vida del JUGADOR 2: " + pj2.getNombre() + ": " + pj2.getVida() + "  Arma: " + pj2.getArma());
					sc.close();
					return 1;
				}
			}
			
			//Todos los turnos arma nueva a partir del 6!
			if(contador > 4) {
				if(contarma == 0) {
					contarma = 2;
				}
				if(contarma == 2) {
					arlist = this.creararma();
					
					pj1.setArma(arlist.get(0));
					pj2.setArma(arlist.get(1));
				}
			
				contarma--;
				
			}
			
			
			System.out.println("-------------------------------------------------------------------");
			
			turno = !turno;
			contador++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Vida del JUGADOR 1: " + pj1.getNombre() + ": " + pj1.getVida() + "  Arma: " + pj1.getArma());
		System.out.println("Vida del JUGADOR 2: " + pj2.getNombre() + ": " + pj2.getVida() + "  Arma: " + pj2.getArma());
		sc.close();
		return 0;
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
				i--;
				continue;
			}
		}
		pjlist.add(pj1);
		pjlist.add(pj2);
		return pjlist;
	}
}

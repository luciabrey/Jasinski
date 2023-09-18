
import personajes.RobotPlatino;
import personajes.Personaje;
import personajes.RobotTitanio;
import personajes.Usuario;
import tipos.Tipo;
import utiles.Utiles;

import java.util.InputMismatchException;
import java.util.Scanner;

import ataques.Ataque;


public class Principal {
	static Usuario u;
	static Personaje p;
	static Personaje maquina;
	static Personaje enemigo;
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("---- Bienvenido al juego de Pelea de Robots! ----\n");
		System.out.println("Ingrese su Nombre: ");
		u = new Usuario();
		u.setNombre(s.nextLine());
		
		System.out.println("\nComenzemos " + u.getNombre() + "!");
		System.out.println("\nElija a su robot: "
				+ "\n" + "1. Robot de Titanio"
				+ "\n" + "2. Robot de Platino");
		int res = Utiles.validarEntero(1, 2);
		crearJugadores(res);
		mostrarEstadisticas();
		batallar();

	}

	private static void batallar() {
		 int turno = Utiles.generarRandom(0, 1), j = 0;
		 int tiempoInhabilitadoP = 0;
		 int tiempoInhabilitadoE = 0;
		 boolean fin = false;
		 
		 do {
			 System.out.println("Presione ENTER para seguir peleando!");
			 s.nextLine();
			 System.out.println("--------------------");
			 System.out.println("RONDA N°" + (j+1));
			 System.out.println("--------------------");
		
			 //En caso de que cualquiera de los dos jugadores tenga el efecto PROTECTOR, el turno pasa a ser del otro.
			 if(p.getEstado().getTipoEfecto() == Tipo.PROTECTOR) {
				 turno = 1;
				 tiempoInhabilitadoP++;
				 verificoRondas(tiempoInhabilitadoP, p);
			 }
			 if(enemigo.getEstado().getTipoEfecto() == Tipo.PROTECTOR) {
				 turno = 0;
				 tiempoInhabilitadoE++;
				 verificoRondas(tiempoInhabilitadoE, enemigo);
			 }
			 //TURNO DEL USUARIO
			 if(turno == 0) {
				 if(p.getEstado().getEstado() == Tipo.HABILITADO 
						 || p.getEstado().getEstado() == Tipo.INHABILITADO && p.getEstado().getTipoEfecto() == Tipo.DEBILITA) {
					 System.out.println("Turno de " + u.getNombre() + "!");
					 System.out.println("Seleccione el Ataque: ");
					 for(int i = 0; i < p.getAtaques().length; i++) {
						 System.out.println("--------------------");
						 System.out.println("ATAQUE N°" + (i + 1));
						 System.out.println("- Nombre: " + p.getAtaques()[i].getNombre());
						 System.out.println("- Daño: " +  p.getAtaques()[i].getDaño());
						 System.out.println("- Energia Requerida: " +  p.getAtaques()[i].getEnergiaRequerida());
						 System.out.println("- Probabilidad: " +  p.getAtaques()[i].getProbabilidad());		
						 System.out.println("--------------------");
						 Utiles.esperar(800); 
					 }
					 System.out.println("Ingrese el numero del ataque que desea: ");
					 
					 int res = Utiles.validarEntero(1, p.getAtaques().length) - 1;
					 
					 if(p.getAtaques()[res].getEnergiaRequerida() > p.getEnergia()) {
						 //Corroboramos si todavia tiene energia para un ataque mas
						 if(noPuedeRealizarAtaques(p)) {
							 System.out.println("Energia Insuficiente!");
							 continue;
						 } else {
							 System.out.println("No tiene mas energia!");
							 fin = true;
						 }
					 }
					 if (!fin) p.atacar(res, enemigo, p.getEstado().getEstado());
				 	}
				 
				 turno = 1;
			 } else if(turno == 1){
				 //TURNO DE LA MAQUINA
				 if(enemigo.getEstado().getEstado() == Tipo.HABILITADO 
						 || enemigo.getEstado().getEstado() == Tipo.INHABILITADO && enemigo.getEstado().getTipoEfecto() == Tipo.DEBILITA) {
					 System.out.println("Turno de la Maquina");
					 
					 int res = validarEnergia(enemigo);
					 
					 if(enemigo.getAtaques()[res].getEnergiaRequerida() > enemigo.getEnergia()) {
						 System.out.println("Energia Insuficiente");
						 if(noPuedeRealizarAtaques(enemigo)) {
							 res = validarEnergia(enemigo);
						 } else {
							 System.out.println("No tiene mas energia");
							 fin = true;
						 }
					 } 
					 
					 System.out.println("La maquina elijio el ataque: " + enemigo.getAtaques()[res].getNombre());
					 enemigo.atacar(res, p, enemigo.getEstado().getEstado());
				 }
				 turno = 0;
			 }

			if(p.getVida()<=0 || enemigo.getVida() <=0) {
				fin = true;
			}
			mostrarEstadisticas();
			j++;
		 }while(!fin);
		 
		 if(p.getVida() > enemigo.getVida()) {
			 System.out.println("Felicidades has ganado!");
		 } else if(p.getVida() < enemigo.getVida()) {
			 System.out.println("Has ganado la MAQUINA!");
		 } else if(p.getVida() == enemigo.getVida()) {
			 if(p.getEnergia() > enemigo.getEnergia()) {
				 System.out.println("Felicidades has ganado!");
			 } else if(p.getEnergia() < enemigo.getEnergia()) {
				 System.out.println("Ha ganado la MAQUINA!");
			 } else if(p.getEnergia() == enemigo.getEnergia()) {
				 System.out.println("TENEMOS UN EMPATE");
			 }
		 }
		
	}

	public static boolean noPuedeRealizarAtaques(Personaje personaje) {
	    for (int i = 0; i < personaje.getAtaques().length; i++) {
	        if (personaje.getEnergia() >= personaje.getAtaques()[i].getEnergiaRequerida()) {
	            // El personaje tiene suficiente energía para al menos un ataque
	            return true;
	        }
	    }
	    // El personaje no tiene suficiente energía para ningún ataque
	    return false;
	}
	private static int validarEnergia(Personaje enemigo) {
		int opc=0;
		boolean error;
		
		do {
		     opc = Utiles.generarRandom(1, enemigo.getAtaques().length) - 1; // Genera un índice válido
		     error = (enemigo.getEnergia() < enemigo.getAtaques()[opc].getEnergiaRequerida());
		}while(error);
		
		return opc;		
		
	}

	private static void verificoRondas(int contInhabilitado, Personaje p) {
		if(contInhabilitado >= p.getEstado().getTiempo()) {
			p.getEstado().setEstado(Tipo.HABILITADO);
			p.getEstado().setTipoEfecto(Tipo.SINEFECTO);
			p.getEstado().setTiempo(0);
		}
		
	}

	private static void mostrarEstadisticas() {
		System.out.println("\n----- Estadisticas de " + u.getNombre() + " -----");
		System.out.println("-----------------------------------");
		System.out.println("Nombre: " + p.getNombre());
		System.out.println("Vida: " + p.getVida() + "/" + p.getVidaMax());
		System.out.println("Energia: " + p.getEnergia() + "/" + p.getEnergiaMax());
		System.out.println("-----------------------------------");
		
		System.out.println("\n----- Estadisticas del ENEMIGO -----");
		System.out.println("Nombre: " + enemigo.getNombre());
		System.out.println("Vida: " + enemigo.getVida() + "/" + enemigo.getVidaMax());
		System.out.println("-----------------------------------");
		
		
	}

	private static void crearJugadores(int res) {
		switch(res) {
		case 1:
			p = new RobotTitanio();
			break;
		case 2:
			p = new RobotPlatino();
			break;
		}
		
		res = 0;
		res = Utiles.generarRandom(1, 2);
		
		switch(res) {
		case 1:
			enemigo = new RobotTitanio();
			break;
		case 2:
			enemigo = new RobotPlatino();
			break;
		}
		System.out.println("La maquina esta eligiendo su robot");
		for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Utiles.esperar(800); 
        }
		System.out.println("\nListo ha pelear!");

		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("El usuario jugara con " + p.getNombre());
		System.out.println("La maquina jugara con " + enemigo.getNombre());
		System.out.println("-----------------------------------");
		System.out.println();
		
	}
}

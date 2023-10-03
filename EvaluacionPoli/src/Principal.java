import java.util.Scanner;

import personajes.Koi;
import personajes.Mecca;
import personajes.Nimmo;
import personajes.Personaje;
import utiles.CaraSeca;
import utiles.Utiles;

public class Principal {
	static Personaje personaje; 
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al juego de mascotas virtuales! ");
		System.out.println("\n Elija la mascota que desea: ");
		System.out.println("\n1. Nimmo Tipo: Fuego"
				+ "\n2. Mecca Tipo: Aire"
				+ "\n3. Koi Tipo: Agua"
				+ "\nRespuesta: ");
		int opc = Utiles.validarEntero(1, 3);
		creacionMascota(opc);
		mostrarEstadisticas();
		mostrarMenu();

	}

	private static void mostrarEstadisticas() {
		System.out.println("--------------------");
		System.out.println("ESTADISTICAS DE " + personaje.getMascota().getNombre());
		System.out.println("\t \n- Suciedad: " + personaje.getMascota().getSuciedad() + "/100");
		System.out.println("\t \n- Hambre: " + personaje.getMascota().getHambre() + "/100");
		System.out.println("\t \n- Sueño: " + personaje.getMascota().getSueño() + "/100");
		System.out.println("\t \n- Felicidad: " + personaje.getMascota().getFelicidad() + "/100");
		System.out.println("\t \n- Monedas: " + personaje.getMonedas());
		System.out.println("--------------------");
		
	}

	private static void mostrarMenu() {
		boolean fin = false;
		
		do {
			System.out.println("Toca para ver las opciones");
			s.nextLine();
			System.out.println("\n------------ MENU DE JUEGO ------------");
			System.out.println("Opciones: "
					+ "\n1. Bañar"
					+ "\n2. Comer"
					+ "\n3. Dormir"
					+ "\n4. Jugar"
					+ "\n5. Comprar"
					+ "\n6. Salir"
					+ "\nRespuesta: ");
			int opc = Utiles.validarEntero(1, 5);
			actividades(opc);
			
			mostrarEstadisticas();
		}while(!fin);
		
	}

	private static void actividades(int opc) {
		switch(opc) {
		case 1: 
			personaje.getMascota().bañarMascota(personaje.getMascota());
			break;
		case 2: 
			personaje.getMascota().comer(personaje);
			break;
		case 3: 
			personaje.getMascota().dormir(personaje);
			break;
		case 4:
			jugarCaraSeca(personaje);
			break;
		case 5: 
			mostrarTienda(personaje);
			break;
		}
		
	}

	private static void jugarCaraSeca(Personaje personaje2) {
		boolean fin = false;
		
		do {
			System.out.println("------------ CARA O SECA ------------");
			System.out.println("\nElija:"
					+ "\n1. Cara"
					+ "\n2. Seca"
					+ "\nRespuesta: ");
			int opc = Utiles.validarEntero(1, 2);
			CaraSeca maq = CaraSeca.tirarMoneda();
			if(maq == CaraSeca.CARA && opc == 1) {
				System.out.println("Felicidades gano 3 monedas!");
				personaje.aumentarMonedas(3);
			} else if(maq == CaraSeca.SECA && opc == 2) {
				System.out.println("Felicides gano 3 monedas!");
				personaje.aumentarMonedas(3);
			} else {
				System.out.println("Perdio! La maquina saco: " + maq);
			}
			
			System.out.println("¿Desea seguir jugando?"
					+ "\n1. Si"
					+ "\n2. No"
					+ "\nRespuesta: ");
			int res = Utiles.validarEntero(1, 2);
			if(res == 2) {
				fin = true;
			} else fin = false;
			
			personaje.getMascota().aumentarFelicidad(15);
			personaje.getMascota().aumentarSuciedad(5);
			personaje.getMascota().aumentarSueño(5);
			personaje.getMascota().aumentarHambre(7);	
		}while(!fin);
		
		
		
	}

	private static void mostrarTienda(Personaje personaje) {
		boolean fin = false;
		
		do {
			if(personaje.getMonedas() > 0) {
				System.out.println("------------ TIENDA ------------");
				System.out.println("\n1. Manzana: 1 moneda"
						+ "\n2. Fideos: 5 monedas"
						+ "\n3. Sushi: 10 monedas"
						+ "\nRespuesta: ");
				int opc = Utiles.validarEntero(1, 3);
				
				if(opc == 1) {
					//MANZANA
					personaje.reducirMonedas(1);
					personaje.getComidas()[0].aumentarCantidad();
				} else if(opc == 2) {
					//FIDEOS
					personaje.reducirMonedas(5);
					personaje.getComidas()[1].aumentarCantidad();
				} else if(opc == 3) {
					//SUSHI
					personaje.reducirMonedas(10);
					personaje.getComidas()[2].aumentarCantidad();
				}
				
				System.out.println(personaje.getMonedas() + "CANTIDAD E COMIDA" + personaje.getComidas()[1].getCantidad());
				fin = true;
			} else {
				System.out.println("No tiene fondos");
				fin = true;
			}
			
		}while(!fin);
	}

	private static void creacionMascota(int opc) {
		 switch(opc) {
		 case 1: 
			 personaje = new Personaje(new Nimmo());
			 break;
		 case 2: 
			 personaje = new Personaje(new Mecca());
			 break;
		 case 3: 
			 personaje = new Personaje(new Koi());
			 break;
	
		 }
		 
		 System.out.println("Felicidades su mascota es: " + personaje.getMascota().getNombre());
		
	}

}

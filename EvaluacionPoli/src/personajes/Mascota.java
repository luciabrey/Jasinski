package personajes;

import utiles.TipoComida;
import utiles.TipoMascota;
import utiles.Utiles;

public abstract class Mascota {
	protected String nombre;
	protected TipoMascota tipo;
	protected int suciedad, hambre, sueño, felicidad;
	
	public String getNombre() {
		return nombre;
	}
	public TipoMascota getTipo() {
		return tipo;
	}
	public int getSuciedad() {
		return suciedad;
	}
	public int getHambre() {
		return hambre;
	}
	public int getSueño() {
		return sueño;
	}
	public int getFelicidad() {
		return felicidad;
	}
	
	//SECTOR REDUCIR
	public void reducirSuciedad(int cantidad) {
		this.suciedad -= cantidad;
		if(this.suciedad < 0) {
			this.suciedad = 0;
		}
	}
	public void reducirFelicidad(int cantidad) {
		this.felicidad -= cantidad;
		if(this.felicidad < 0) {
			this.felicidad = 0;
		}
	}
	public void reducirHambre(int cantidad) {
		this.hambre -= cantidad;
		if(this.hambre < 0) {
			this.hambre = 0;
		}
	}
	public void reducirSueño(int cantidad) {
		this.sueño -= cantidad;
		if(this.sueño < 0) {
			this.sueño = 0;
		}
	}
	
	//SECTOR AUMENTAR
	public void aumentarSuciedad(int cantidad) {
		this.suciedad += cantidad;
		if(this.suciedad > 100) {
			this.suciedad = 100;
		}
	}
	public void aumentarSueño(int cantidad){
		this.sueño += cantidad;
		if(this.sueño > 100) {
			this.sueño = 100;
		}
	}
	public void aumentarHambre(int cantidad) {
		this.hambre += cantidad;
		if(this.hambre > 100) {
			this.hambre = 100;
		}
	}
	public void aumentarFelicidad(int cantidad) {
		this.felicidad += cantidad;
		if(this.felicidad > 100) {
			this.felicidad = 100;
		}
	}
	
	
	//BAÑAR
	public void bañarMascota(Mascota mascota) {
		if(mascota.getTipo() == TipoMascota.FUEGO) {
			//REDUCE 50%
			reducirSuciedad(50);
		} else if(mascota.getTipo() == TipoMascota.AIRE) {
			//REDUCE 70%
			reducirSuciedad(70);
		} else if(mascota.getTipo() == TipoMascota.AGUA) {
			//REDUCE 90%
			reducirSuciedad(90);
		}
		
		aumentarHambre(5);
		reducirFelicidad(7);
		System.out.println("Se ha bañado con exito! ");
	}
	
	//COMER
	public void comer(Personaje personaje) {
		boolean fin = false;
		int cont = 0;
		
		for(int i = 0; i < personaje.comidas.length; i ++) {
			if(personaje.comidas[i].getCantidad() < 0) {
				fin = true;
			} else fin = false;
		}
		
		if(!fin) {
			System.out.println("Las opciones de comida que tiene son: ");
			for(int i = 0; i < personaje.comidas.length; i++) {
				if(personaje.comidas[i].getCantidad() > 0) {
					
					System.out.println((i + 1)+ ". " + personaje.comidas[i].getNombreComida());
					System.out.println("\n");
				} 
			}
			int opc = Utiles.validarEntero(1, personaje.comidas.length);
			//reducimos la cantidad que tenemos de esa comida
			personaje.comidas[opc].reducirCantidad();
			
			if(personaje.comidas[opc].getTipo() == TipoComida.MANZANA) {
				//REDUCE 15
				reducirHambre(15);
			} else if(personaje.comidas[opc].getTipo() == TipoComida.FIDEOS) {
				//REDUCE 25
				reducirHambre(25);
			} else if(personaje.comidas[opc].getTipo() == TipoComida.SUSHI) {
				//REDUCE 40
				reducirHambre(40);
			}
			
			aumentarSueño(7);
			aumentarSuciedad(5);
			
			System.out.println("Se realizo con exito la comida!");
		} else System.out.println("No tiene comidas!");
	}
	
	//DORMIR
	public void dormir(Personaje personaje) {
		reducirSueño(100);
		System.out.println("Ya durmio");
	}
	
	
	
}

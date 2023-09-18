package Personajes;

public class Personaje {
	private int vida, energia;
	private String nombre;
	
	public Personaje(int vida, int energia, String nombre) {
		this.vida = vida;
		this.energia = energia;
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	
	public int getEnergia() {
		return energia;
	}
	public String getNombre() {
		return nombre;
	}
	

}


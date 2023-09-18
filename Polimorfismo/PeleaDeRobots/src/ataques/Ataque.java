package ataques;

import tipos.Tipo;

public abstract class Ataque {
	protected int energiaRequerida = 0, daño = 0, probabilidad = 0; 
	protected String nombre;
	protected Tipo tipoAtaque;
	protected Tipo tipo;
	
	public String getNombre() {
		return nombre;
	}
	public int getEnergiaRequerida() {
		return energiaRequerida;
	}
	public int getDaño() {
		return daño;
	}
	public int getProbabilidad() {
		return probabilidad;
	}
	public Tipo getTipoAtaque() {
		return tipoAtaque;
	}
	public Tipo getTipo() {
		return tipo;
	}
}

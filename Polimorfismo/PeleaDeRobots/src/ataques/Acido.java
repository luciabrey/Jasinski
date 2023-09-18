package ataques;

import tipos.Tipo;

public class Acido extends Ataque{
	
	public Acido() {
		super.nombre = "Acido";
		super.energiaRequerida = 100;
		super.daño = 75;
		super.probabilidad = 85;
		super.tipoAtaque = Tipo.CORROCION;
	}
}

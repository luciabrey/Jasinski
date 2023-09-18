package ataques;

import tipos.Tipo;

public class Fuego extends Ataque{
	public Fuego() {
		super.nombre = "Fuego";
		super.energiaRequerida = 150;
		super.daño = 100;
		super.probabilidad = 65;
		super.tipoAtaque = Tipo.FUEGO;
	}
}

package ataques;

import tipos.Tipo;

public class Metralleta extends Ataque{
	
	public Metralleta() {
		super.nombre = "Metralleta";
		super.energiaRequerida = 50;
		super.daño = 50;
		super.probabilidad = 70;
		super.tipoAtaque = Tipo.IMPACTO;
	}
}

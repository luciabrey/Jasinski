package ataques;

import tipos.Tipo;

public class Electro extends Ataque{
	public Electro() {
		super.nombre = "Interferencia electromagnética";
		super.energiaRequerida = 75;
		super.probabilidad = 50;
		super.tipoAtaque = Tipo.EFECTO;
		super.tipo = Tipo.PROTECTOR;
	}
}

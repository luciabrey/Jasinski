package ataques;

import tipos.Tipo;

public class EscudoProtector extends Ataque{
	public EscudoProtector() {
		super.nombre = "Escudo Protector";
		super.energiaRequerida = 50;
		super.probabilidad = 40;
		super.tipoAtaque = Tipo.EFECTO;
		super.tipo = Tipo.DEBILITA;
	}
}

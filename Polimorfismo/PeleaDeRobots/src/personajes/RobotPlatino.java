package personajes;

import ataques.Acido;
import ataques.Ataque;
import ataques.EscudoProtector;
import ataques.Fuego;
import ataques.Metralleta;
import tipos.Tipo;

public class RobotPlatino extends Personaje {
	public RobotPlatino() {
		super.ataques = new Ataque[]{ new Metralleta(), new Acido(), new Fuego(), new EscudoProtector()};
		super.nombre = "Robot Platino";
		super.vida = 1200;
		super.energia = 1000;
		super.vidaMax = super.vida;
		super.energiaMax = super.energia;
		super.tipoRobot = Tipo.PLATINO;
	}
}

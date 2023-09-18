package personajes;

import ataques.Ataque;
import ataques.Metralleta;
import tipos.Tipo;
import ataques.Acido;
import ataques.Fuego;
import ataques.Electro;


public class RobotTitanio extends Personaje{
	public RobotTitanio() {
		super.ataques = new Ataque[]{ new Metralleta(), new Acido(), new Fuego(), new Electro()};
		super.nombre = "Robot Titanio";
		super.vida = 1000;
		super.energia = 1500;
		super.vidaMax = super.vida;
		super.energiaMax = super.energia;
		super.tipoRobot = Tipo.TITANIO;
		
	}
}

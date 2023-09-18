package ataques.efectos;

import ataques.Ataque;
import personajes.Personaje;
import tipos.Tipo;
import utiles.Utiles;

public class Efectos {
	public static int calcularDaño(Ataque datosAtaque, Personaje enemigo, Tipo p) {
		int dañoAtaque = datosAtaque.getDaño();
		int daño = 0;
		if(datosAtaque.getTipoAtaque() == Tipo.EFECTO) { 
			if(enemigo.getEstado().getEstado() == Tipo.HABILITADO) {
				//Es igual al de Electromagnetica
				if(datosAtaque.getTipo() == Tipo.PROTECTOR) {
					// INHABILITADO TANTOS TURNOS
					int cantTurnos = Utiles.generarRandom(1, 4);
					enemigo.getEstado().setTiempo(cantTurnos);
					enemigo.getEstado().setEstado(Tipo.INHABILITADO);
					enemigo.getEstado().setTipoEfecto(Tipo.PROTECTOR);
					daño = 0;
				} else if(datosAtaque.getTipo() == Tipo.DEBILITA) {
					int cantTurnos = Utiles.generarRandom(1, 3);
					enemigo.getEstado().setTiempo(cantTurnos);
					enemigo.getEstado().setEstado(Tipo.INHABILITADO);
					enemigo.getEstado().setTipoEfecto(Tipo.DEBILITA);
					daño = 0;
				}
			} else {
				System.out.println("El jugador ya se encuentra con un efecto!");
				if(p == Tipo.DEBILITA) {
					daño = dañoAtaque / 2;
				} else {
					daño = dañoAtaque;
				}
			} 
			 
		} else if (datosAtaque.getTipoAtaque() == Tipo.CORROCION) {
			if(enemigo.getTipoRobot() == Tipo.PLATINO) {
				daño = dañoAtaque / 2;
			} else daño = dañoAtaque; 
		} else if(datosAtaque.getTipoAtaque() == Tipo.IMPACTO) {
			if(enemigo.getTipoRobot() == Tipo.PLATINO) {
				daño = dañoAtaque * 2;
			} else {
				daño = dañoAtaque / 2;
			}
		} else if(datosAtaque.getTipoAtaque() == Tipo.FUEGO) {
			if (enemigo.getTipoRobot() == Tipo.TITANIO) {
				daño = dañoAtaque * 2;
			}
		} else daño = dañoAtaque;
		
		return daño;
	}
}

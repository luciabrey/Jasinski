package personajes;

import tipos.Tipo;

public class Jugador {
	protected Personaje p;
	protected Tipo estadoJugador = Tipo.HABILITADO;

	

	public void setEstado(Tipo estadoJugador) {
		this.estadoJugador = estadoJugador;
	}
	
	
	
	public Tipo getEstadoJugador() {
		return estadoJugador;
	}
}

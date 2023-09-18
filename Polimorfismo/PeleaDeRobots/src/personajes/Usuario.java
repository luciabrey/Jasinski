package personajes;

import tipos.Tipo;

public class Usuario {
	protected String nombre;
	protected Tipo estadoJugador = Tipo.HABILITADO;
	protected Jugador jugador;

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEstado(Tipo estadoJugador) {
		this.estadoJugador = estadoJugador;
	}
	public String getNombre() {
		return nombre;
	}
	public Tipo getEstadoJugador() {
		return estadoJugador;
	}
	
}

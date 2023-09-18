package ataques.efectos;

import tipos.Tipo;

public class Estado {
	protected Tipo estado = Tipo.HABILITADO;
	protected Tipo tipoEfecto;
	protected int tiempo = 0;
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public void setEstado(Tipo estado) {
		this.estado = estado;
	}
	public void setTipoEfecto(Tipo tipoEfecto) {
		this.tipoEfecto = tipoEfecto;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	public Tipo getEstado() {
		return estado;
	}
	public Tipo getTipoEfecto() {
		return tipoEfecto;
	}
}

package personajes;


import ataques.Ataque;
import ataques.efectos.Efectos;
import ataques.efectos.Estado;
import tipos.Tipo;
import utiles.Utiles;

public class Personaje {
	protected Ataque[] ataques;
	protected int vida, energia, vidaMax, energiaMax;
	protected String nombre;
	protected Tipo tipoRobot;
	protected Estado estado;
	
	public Tipo getTipoRobot() {
		return tipoRobot;
	}
	public Personaje() {
		this.estado = new Estado();
	}
	
	public Estado getEstado() {
		return estado;
	}

	public int getVida() {
		return vida;
	}
	public void setEnergia(int energia) {
		this.energia += energia ;
	}
	public int getEnergia() {
		return energia;
	}
	public int getVidaMax() {
		return vidaMax;
	}
	public int getEnergiaMax() {
		return energiaMax;
	}
	public String getNombre() {
		return nombre;
	}
	public Ataque[] getAtaques() {
		return ataques;
	}
	
	
	private void reducirVida(int daño) {
		this.vida -= daño;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
	private void reducirEnergia(int energiaRequerida) {
		this.energia -= energiaRequerida;
		if(this.energia < 0) {
			this.energia = 0;
		}
	}

	public void atacar(int res, Personaje enemigo, Tipo p) {
		reducirEnergia(ataques[res].getEnergiaRequerida());
		calcularAcierto(res, enemigo, p);

	}

	public void calcularAcierto(int res, Personaje enemigo, Tipo p) {
		int probabilidadAcierto = Utiles.generarRandom(1, 100);
		
		if(probabilidadAcierto <= ataques[res].getProbabilidad()) {
			int daño = Efectos.calcularDaño(ataques[res], enemigo, p);
			enemigo.reducirVida(daño);	
			if (ataques[res].getTipoAtaque() != Tipo.EFECTO) {
				System.out.println("El ataque ha causado " + daño + " de daño a su oponente");
			}
			else if(p == Tipo.HABILITADO) {
				System.out.println("Se ha aplicado el efecto! Durara: " + enemigo.getEstado().getTiempo() + " rondas");
			}
		} else {
			System.out.println("Ha fallado el ataque!");
		}
	}

}

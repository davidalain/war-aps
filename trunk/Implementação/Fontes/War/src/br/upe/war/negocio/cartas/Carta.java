package br.upe.war.negocio.cartas;

import br.upe.war.negocio.territorios.Territorio;


public class Carta {
	private Territorio territorio;
	 
	private String forma;

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	 
}
 

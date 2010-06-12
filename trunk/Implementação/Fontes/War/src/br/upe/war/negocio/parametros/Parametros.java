package br.upe.war.negocio.parametros;

import java.io.Serializable;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.SalaJogo;


public abstract class Parametros implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SalaJogo salaJogo;
	private Jogador jogador;
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Parametros(SalaJogo salaJogo, Jogador jogador){
		this.salaJogo = salaJogo;
		this.jogador = jogador;
	}
	
	public SalaJogo getSalaJogo() {
		return salaJogo;
	}

	public void setSalaJogo(SalaJogo salaJogo) {
		this.salaJogo = salaJogo;
	}
}

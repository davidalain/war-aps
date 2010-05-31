package br.upe.war.negocio.parametros;

import br.upe.war.negocio.jogadores.Jogador;

import br.upe.war.negocio.jogos.Jogo;


public abstract class Parametros {
	private Jogo jogo;
	private Jogador jogador;
	
	


	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Parametros(Jogo jogo, Jogador jogador){
		this.jogo = jogo;
		this.jogador = jogador;
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}

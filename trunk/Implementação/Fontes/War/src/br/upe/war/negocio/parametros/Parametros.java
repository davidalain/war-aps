package br.upe.war.negocio.parametros;

import br.upe.war.negocio.jogos.Jogo;

public abstract class Parametros {
	private Jogo jogo;

	public Parametros(Jogo jogo){
		this.jogo = jogo;
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}

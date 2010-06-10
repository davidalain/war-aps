package br.upe.war.negocio.objetivos;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.Jogo;

public abstract class Objetivo {

	public abstract boolean atingido(Jogador jogador, Jogo jogo);
	
}

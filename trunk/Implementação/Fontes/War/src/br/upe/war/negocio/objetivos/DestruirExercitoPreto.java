package br.upe.war.negocio.objetivos;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.Jogo;

public class DestruirExercitoPreto extends Objetivo {

	@Override
	public boolean atingido(Jogador jogador, Jogo jogo) {
		return false;
	}

}

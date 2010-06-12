package br.upe.war.negocio.ataques;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.parametros.Parametros;
import br.upe.war.negocio.salajogos.SalaJogo;


public class ParametrosPovoarTerritorioConquistado extends Parametros {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantidadeExercito;
	
	public ParametrosPovoarTerritorioConquistado(SalaJogo salaJogo, Jogador jogador, int quantidadeExercito){
		super(salaJogo, jogador);
		this.quantidadeExercito = quantidadeExercito;
	}
	
	public int getQuantidadeExercito() {
		return quantidadeExercito;
	}

	public void setQuantidadeExercito(int quantidadeExercito) {
		this.quantidadeExercito = quantidadeExercito;
	}
}

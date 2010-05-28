package br.upe.war.negocio.ataques;

import br.upe.war.negocio.jogos.Jogo;
import br.upe.war.negocio.parametros.Parametros;


public class ParametrosPovoarTerritorioConquistado extends Parametros {
	private int quantidadeExercito;
	
	public ParametrosPovoarTerritorioConquistado(Jogo jogo, int quantidadeExercito){
		super(jogo);
		this.quantidadeExercito = quantidadeExercito;
	}
	
	public int getQuantidadeExercito() {
		return quantidadeExercito;
	}

	public void setQuantidadeExercito(int quantidadeExercito) {
		this.quantidadeExercito = quantidadeExercito;
	}
}

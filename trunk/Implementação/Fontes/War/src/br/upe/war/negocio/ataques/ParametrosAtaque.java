package br.upe.war.negocio.ataques;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.parametros.Parametros;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.territorios.Territorio;

public class ParametrosAtaque extends Parametros{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Territorio atacante;
	private Territorio defensor;
	private int quantidadeExercito;
	
	public ParametrosAtaque(SalaJogo jogo, Jogador jogador, Territorio atacante, Territorio defensor) {
		super(jogo, jogador);
		this.atacante = atacante;
		this.defensor = defensor;
	}
	
	public Territorio getAtacante() {
		return atacante;
	}
	public void setAtacante(Territorio atacante) {
		this.atacante = atacante;
	}
	public Territorio getDefensor() {
		return defensor;
	}
	public void setDefensor(Territorio defensor) {
		this.defensor = defensor;
	}
	public int getQuantidadeExercito() {
		return quantidadeExercito;
	}
	public void setQuantidadeExercito(int quantidadeExercito) {
		this.quantidadeExercito = quantidadeExercito;
	}
	
	
}

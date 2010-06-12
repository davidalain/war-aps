package br.upe.war.negocio.jogadas;

import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.fases.Fase;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class Jogada {
	private Fase faseAtual;
	private Jogador jogador;
	
	public Jogada(Fase faseAtual, Jogador jogador) {
		super();
		this.faseAtual = faseAtual;
		this.jogador = jogador;
	}

	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		if(!jogadorEstaNaJogadaAtual(parametros.getJogador()))
		{
			throw new WarException(MensagemErro.JOGADOR_NAO_ESTA_NA_JOGADA_ATUAL);
		}
		
		this.faseAtual.povoarTerritorioConquistado(parametros);
	}
	
	public  boolean jogadorEstaNaJogadaAtual(Jogador jogador)
	{
		boolean resultado = false;
		
		if(this.jogador.equals(jogador))
		{
			resultado = true;
		}
		
		return resultado;
	}

	public Territorio[] atacarTerritorio(ParametrosAtaque parametros) throws WarException {
		return this.faseAtual.atacar(parametros);
		
	}
}

package br.upe.war.negocio.jogos;

import java.util.ArrayList;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.cartas.Carta;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadas.Jogada;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.mapas.Mapa;
import br.upe.war.negocio.objetivos.Objetivo;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.util.Mensagens;

public class Jogo {
	private int id;
	private ArrayList<Objetivo> possiveisObjetivos;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Carta> cartas;
	private Jogada jogadaAtual;
	private Mapa mapa;
	private SalaJogo salaJogo;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		if(!jogadorEstaNoJogo(parametros.getJogador()))
		{
			throw new WarException(Mensagens.JOGADOR_NAO_ESTA_NO_JOGO);
		}
		
		this.jogadaAtual.povoarTerritorioConquistado(parametros);
	}
	
	private boolean jogadorEstaNoJogo(Jogador jogador)
	{
		boolean encontrou = false;
		
		for (int i = 0; i < this.jogadores.size(); i++) 
		{
			if(this.jogadores.get(i).getLogin().equals(jogador.getLogin()))
			{	
				encontrou = true;
				break;
			}
		}
		
		return encontrou;
	}
	
}

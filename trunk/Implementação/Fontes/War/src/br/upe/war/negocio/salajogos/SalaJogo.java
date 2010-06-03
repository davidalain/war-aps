package br.upe.war.negocio.salajogos;

import java.util.ArrayList;

import br.upe.war.negocio.jogadores.Jogador;

public class SalaJogo 
{
	private ArrayList<Jogador> jogadores;
	
	public SalaJogo(Jogador jogadorCriador)
	{
		this.jogadores = new ArrayList<Jogador>();
		this.jogadores.add(jogadorCriador);
	}
}

package br.upe.war.negocio.salajogos;

import java.util.ArrayList;
import java.util.HashMap;

import br.upe.war.negocio.jogadores.Jogador;

public class ControladorSalaJogo 
{
	private static ControladorSalaJogo instance;
	
	private ArrayList<SalaJogo> salasJogo;
	
	private ControladorSalaJogo()
	{
		this.salasJogo = new ArrayList<SalaJogo>();
	}
	
	public synchronized static ControladorSalaJogo getInstance()
	{
		if(instance == null)
		{
			instance = new ControladorSalaJogo();
		}
		return instance;
	}

	public int obterCount()
	{
		return this.salasJogo.size();
	}

	public void criar(Jogador jogador) 
	{
		SalaJogo novaSalaJogo = new SalaJogo(jogador);
		
		this.salasJogo.add(novaSalaJogo);
	}
}

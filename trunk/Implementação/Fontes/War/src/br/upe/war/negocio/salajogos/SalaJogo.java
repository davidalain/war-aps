package br.upe.war.negocio.salajogos;

import java.util.ArrayList;

import br.upe.war.negocio.jogadores.Jogador;

public class SalaJogo 
{
	private ArrayList<Jogador> jogadores;
	
	private String senha;
	
	public SalaJogo(ParametrosCriarSalaJogo parametros)
	{
		this.jogadores = new ArrayList<Jogador>();
		this.jogadores.add(parametros.getJogador());
		if(parametros.getSenha() != null)
		{
			this.senha = parametros.getSenha();
		}
	}
	
	public boolean possuiSenha()
	{
		return this.senha != null;
	}
}

package br.upe.war.negocio.salajogos;

import br.upe.war.negocio.jogadores.Jogador;


public class ParametrosCriarSalaJogo 
{
	private Jogador jogador;
	
	private String senha;
	
	private String endereco;

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

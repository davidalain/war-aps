package br.upe.war.comunicacao.mensagens;

import java.io.IOException;
import java.io.Serializable;

import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;

public abstract class Mensagem implements Serializable
{
	private String endereco;
	private Jogador jogador;

	

	public Mensagem(Jogador jogador, String endereco) {
		super();
		this.endereco = endereco;
		this.jogador = jogador;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void tratarMensagem() throws WarException, IOException;
	
	public abstract String resposta();

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoJogador) 
	{
		this.endereco = enderecoJogador;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}


}

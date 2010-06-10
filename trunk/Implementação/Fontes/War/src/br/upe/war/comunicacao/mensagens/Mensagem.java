package br.upe.war.comunicacao.mensagens;

import java.io.IOException;
import java.io.Serializable;

import br.upe.war.negocio.excecoes.WarException;

public abstract class Mensagem implements Serializable
{
	private String endereco;

	public Mensagem(String endereco) {
		super();
		this.endereco = endereco;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void tratarMensagem() throws WarException, IOException;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoJogador) 
	{
		this.endereco = enderecoJogador;
	}

	


}

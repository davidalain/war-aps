package br.upe.war.comunicacao.mensagens;

import java.io.Serializable;

import br.upe.war.negocio.excecoes.WarException;

public abstract class Mensagem implements Serializable
{
	private String enderecoJogador;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void tratarMensagem() throws WarException;


}

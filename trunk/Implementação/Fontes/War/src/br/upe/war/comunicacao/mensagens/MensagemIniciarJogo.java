package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.salajogos.SalaJogo;

public class MensagemIniciarJogo extends Mensagem 
{
	public MensagemIniciarJogo(String endereco) {
		super(endereco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SalaJogo salaJogo;
	
	@Override
	public void tratarMensagem() throws WarException, IOException 
	{
	
	}

}

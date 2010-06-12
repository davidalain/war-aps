package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;

public class MensagemDefesa extends Mensagem {

	public MensagemDefesa(Jogador jogador, String endereco) {
		super(jogador, endereco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String resposta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {
		// TODO Auto-generated method stub

	}

}

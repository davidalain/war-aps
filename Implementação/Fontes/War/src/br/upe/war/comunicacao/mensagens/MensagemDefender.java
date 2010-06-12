package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;

public class MensagemDefender extends Mensagem {

	private Territorio atacante;
	private int quantidadeExe;
	
	public MensagemDefender(Jogador jogador, Territorio atacante, int quantidadeExe, String endereco) {
		super(jogador, endereco);
		this.atacante = atacante;
		this.quantidadeExe = quantidadeExe;
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
		System.out.println("");

	}

}

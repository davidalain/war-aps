package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;

public class MensagemChat extends Mensagem {

	private String mensagem;
		
	
	public MensagemChat(Jogador jogador, String mensagem, String endereco) {
		super(jogador, endereco);
		this.mensagem = mensagem;
		}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void tratarMensagem() throws WarException, IOException {
		ControladorComunicacao com = ControladorComunicacao.getInstance();
		com.enviarMensagemResposta(this);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String resposta() {
		// TODO Auto-generated method stub
		return super.getJogador().getLogin() + " : " + this.mensagem;
	}

}

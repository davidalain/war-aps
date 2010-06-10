package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.negocio.excecoes.WarException;

public class MensagemChat extends Mensagem {

	private String mensagem;
	
	private String apelido;
		
	
	public MensagemChat(String apelido, String mensagem, String endereco) {
		super(endereco);
		this.mensagem = mensagem;
		this.apelido = apelido;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void tratarMensagem() throws WarException, IOException {
		// TODO Auto-generated method stub

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}

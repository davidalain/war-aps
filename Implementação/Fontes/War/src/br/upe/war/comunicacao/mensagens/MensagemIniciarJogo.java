package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;

public class MensagemIniciarJogo extends Mensagem 
{
	private String nomeSala;
	private String loginJogador;
	
	public MensagemIniciarJogo(String nomeSala, String loginJogador, String endereco) {
		super(endereco);
		this.loginJogador = loginJogador;
		this.nomeSala = nomeSala;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void tratarMensagem() throws WarException, IOException 
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		fachada.iniciarJogo(this.nomeSala, this.loginJogador);
		

		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);
		
	}
	
	public String resposta(){
		return "O jogo da sala : " + this.nomeSala + " foi iniciado. ";
	}

}

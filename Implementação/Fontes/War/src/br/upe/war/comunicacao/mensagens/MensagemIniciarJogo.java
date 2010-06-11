package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;

public class MensagemIniciarJogo extends Mensagem 
{
	private String nomeSala;
	
	public MensagemIniciarJogo(String nomeSala, Jogador jogador, String endereco) {
		super(jogador, endereco);
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
		
		fachada.iniciarJogo(this.nomeSala, super.getJogador().getLogin());
		

		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);
		
	}
	
	public String resposta(){
		return "O jogo da sala : " + this.nomeSala + " foi iniciado. ";
	}

}

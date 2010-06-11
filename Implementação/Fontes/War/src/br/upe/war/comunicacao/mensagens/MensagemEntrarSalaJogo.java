package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;


public class MensagemEntrarSalaJogo extends Mensagem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeSalaJogo;
	
	public MensagemEntrarSalaJogo(Jogador jogador, String nomeSalaJogo, String ipDestino) throws WarValidationException {
		super(jogador, ipDestino);
		this.nomeSalaJogo = nomeSalaJogo;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {
		FachadaWar fachada = FachadaWar.getInstance();
	
		fachada.entrarSalaJogo(super.getJogador(), nomeSalaJogo);
		
		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);
	}
	
	public String resposta(){
		return super.getJogador().getLogin() + " entrou na sala : " + this.nomeSalaJogo;
	}

}

package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;


public class MensagemEntrarSalaJogo extends Mensagem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String apelido;
	
	private int cor;
	
	private String nomeSalaJogo;
	
	public MensagemEntrarSalaJogo(String apelido, int cor, String nomeSalaJogo, String ipDestino) {
		super(ipDestino);
		this.apelido = apelido;
		this.cor = cor;
		this.nomeSalaJogo = nomeSalaJogo;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {
		FachadaWar fachada = FachadaWar.getInstance();
		Jogador jogador = new Jogador(this.apelido, this.cor);
		
		fachada.entrarSalaJogo(jogador, nomeSalaJogo);
		
		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);
	}
	
	public String resposta(){
		return this.apelido + " entrou na sala : " + this.nomeSalaJogo;
	}

}

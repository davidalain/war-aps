package br.upe.war.comunicacao.mensagens;

import java.io.IOException;
import java.util.Iterator;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;

public class MensagemObjetivos extends Mensagem {

	private String salaJogo;
	private String retorno;
	
	public MensagemObjetivos(Jogador jogador, String salaJogo, String endereco) {
		super(jogador, endereco);
		this.salaJogo = salaJogo;
		this.retorno = "";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String resposta() {
		return this.retorno;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {
		FachadaWar fachada = FachadaWar.getInstance();
		Iterator<Jogador> jogador = fachada.obterJogadores(this.salaJogo);
		Jogador atual;
		while(jogador.hasNext())
		{
			atual = jogador.next();
			String objetivo = atual.getObjetivo().getClass().toString();
			
			this.retorno += "O objetivo de " + atual.getLogin() ;
			this.retorno += " é " + objetivo.substring(35);
			this.retorno += "\n";
			
		}

		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);

	}

}

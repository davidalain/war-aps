package br.upe.war.comunicacao.mensagens;

import java.io.IOException;
import java.util.Iterator;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;

public class MensagemEstadoTerritorios extends Mensagem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeSalaJogo;
	private String retorno;

	public MensagemEstadoTerritorios(Jogador jogador, String nomeSalaJogo, String endereco) {
		super(jogador, endereco);
		this.nomeSalaJogo = nomeSalaJogo;
		this.retorno = "";
	}

	@Override
	public String resposta() {
		return this.retorno;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {

		FachadaWar fachada = FachadaWar.getInstance();
		Iterator<Territorio> territorios = fachada.obterTerritorios(this.nomeSalaJogo);
		Territorio atual;
		int i = 1;
		while(territorios.hasNext())
		{
			atual = territorios.next();
			
			this.retorno += i + " " + atual.getNome() + " ";
			this.retorno += "é dominado por: " + atual.getDominante().getLogin();
			this.retorno += "\n";
			
			i++;
		}

		ControladorComunicacao com = ControladorComunicacao.getInstance();
		
		com.enviarMensagemResposta(this);

	}

}

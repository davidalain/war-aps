package br.upe.war.comunicacao.mensagens;

import java.io.IOException;
import java.util.Iterator;

import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.territorios.Territorio;

public class MensagemEstadoTerritorios extends Mensagem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SalaJogo salaJogo;
	private Iterator<Territorio> territorios;

	public MensagemEstadoTerritorios(Jogador jogador, String endereco, SalaJogo salaJogo) {
		super(jogador, endereco);
		this.salaJogo = salaJogo;
	}

	@Override
	public String resposta() {
		String retorno = "";
		Territorio atual;
		while(this.territorios.hasNext())
		{
			atual = this.territorios.next();
			
			retorno += atual.getNome() + " ";
			retorno += "é dominado por: " + atual.getDominante().getLogin();
			retorno += "/n";
		}
		
		return retorno;
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {

		FachadaWar fachada = FachadaWar.getInstance();
		this.territorios = fachada.obterTerritorios(salaJogo);

	}

}

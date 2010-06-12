package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.territorios.Territorio;

public class MensagemAtacar extends Mensagem {

	private ParametrosAtaque parametros;
	
	public MensagemAtacar(Jogador jogador, String nomeSala, Territorio atacante, Territorio defensor, int quantidadeExercito, String endereco) throws WarValidationException {
		super(jogador, endereco);
		ParametrosCriarSalaJogo p = new ParametrosCriarSalaJogo(jogador.getLogin(), 0, nomeSala, 3);
		SalaJogo s = new SalaJogo(p);
		this.parametros = new ParametrosAtaque(s, jogador, atacante, defensor);
		this.parametros.setQuantidadeExercito(quantidadeExercito);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String resposta() {
		
		return this.parametros.getAtacante().getNome() + " atacou " + this.parametros.getDefensor().getNome();
	}

	@Override
	public void tratarMensagem() throws WarException, IOException {
		FachadaWar fachada = FachadaWar.getInstance();
		fachada.atacarTerritorio(parametros);
		
		//MensagemDefesa m = new MensagemDefesa();
		
		ControladorComunicacao com = ControladorComunicacao.getInstance();
		com.enviarMensagemResposta(this);

	}

}

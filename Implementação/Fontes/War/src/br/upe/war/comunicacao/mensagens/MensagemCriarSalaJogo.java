package br.upe.war.comunicacao.mensagens;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;

public class MensagemCriarSalaJogo extends Mensagem 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084415134256323493L;

	private String nomeSala;
	
	private String senha;
	
	private boolean protegida;
	
	private int numeroJogadores;
	
	public MensagemCriarSalaJogo(Jogador jogador, String nomeSala,
			boolean protegida, String senha,  int numeroJogadores, String enderecoDestino) throws WarValidationException {
		
		super(jogador, enderecoDestino);
		this.nomeSala = nomeSala;
		this.senha = senha;
		this.protegida = protegida;
		this.numeroJogadores = numeroJogadores;
	}
	
	public MensagemCriarSalaJogo(Jogador jogador, String nomeSala,
			boolean protegida, int numeroJogadores, String enderecoDestino) throws WarValidationException {
		
		super(jogador, enderecoDestino);
		this.nomeSala = nomeSala;
		this.protegida = protegida;
		this.numeroJogadores = numeroJogadores;
	}

	@Override
	public void tratarMensagem() throws WarValidationException, IOException 
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		ParametrosCriarSalaJogo parametros = null;
		
		if(!protegida)
			parametros = new ParametrosCriarSalaJogo(super.getJogador().getLogin(), super.getJogador().getCor(), nomeSala,  numeroJogadores);
		else
			parametros = new ParametrosCriarSalaJogo(super.getJogador().getLogin(), super.getJogador().getCor(), nomeSala, senha, numeroJogadores);
		
		fachada.criarSalaJogo(parametros);
		
		ControladorComunicacao com = ControladorComunicacao.getInstance();
		com.enviarMensagemResposta(this);
	}
	
	public String resposta(){
		return super.getJogador().getLogin() + " criou a sala : " + this.nomeSala;
	}
}

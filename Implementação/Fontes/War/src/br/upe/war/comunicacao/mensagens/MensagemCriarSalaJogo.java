package br.upe.war.comunicacao.mensagens;

import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;

public class MensagemCriarSalaJogo extends Mensagem 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084415134256323493L;

	private String apelido;
	
	private int cor;
	
	private String nomeSala;
	
	private String senha;
	
	private boolean protegida;
	
	private int numeroJogadores;
	
	public MensagemCriarSalaJogo(String apelido, int cor, String nomeSala,
			boolean protegida, String senha,  int numeroJogadores) {
		super();
		this.apelido = apelido;
		this.cor = cor;
		this.nomeSala = nomeSala;
		this.senha = senha;
		this.protegida = protegida;
		this.numeroJogadores = numeroJogadores;
	}
	
	public MensagemCriarSalaJogo(String apelido, int cor, String nomeSala,
			boolean protegida, int numeroJogadores) {
		super();
		this.apelido = apelido;
		this.cor = cor;
		this.nomeSala = nomeSala;
		this.protegida = protegida;
		this.numeroJogadores = numeroJogadores;
	}

	@Override
	public void tratarMensagem() 
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		ParametrosCriarSalaJogo parametros = null;
		
		if(!protegida)
			parametros = new ParametrosCriarSalaJogo(apelido, cor, nomeSala, protegida, numeroJogadores);
		else
			parametros = new ParametrosCriarSalaJogo(apelido, cor, nomeSala, protegida, senha, numeroJogadores);
		
		fachada.criarSalaJogo(parametros);
	}

}

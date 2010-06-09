package br.upe.war.negocio.salajogos;

import java.util.ArrayList;
import java.util.Iterator;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.Jogo;
import br.upe.war.negocio.util.MensagemErro;

public class SalaJogo 
{
	private Jogo jogo;
	
	private ArrayList<Jogador> jogadores;
	
	private String senha;
	
	public SalaJogo(ParametrosCriarSalaJogo parametros)
	{
		this.jogadores = new ArrayList<Jogador>();
		this.jogadores.add(parametros.getJogador());
		if(parametros.getSenha() != null)
		{
			this.senha = parametros.getSenha();
		}
		
	}
	
	public boolean possuiSenha()
	{
		return this.senha != null;
	}

	public void povoarTerritorioConquistado(
			ParametrosPovoarTerritorioConquistado parametros) throws WarException 
	{
		this.jogo.povoarTerritorioConquistado(parametros);
	}

	public void iniciarJogo() throws WarException 
	{
		
		validarNumeroJogares();
		
		criarJogo();
		
		

	}

	private void criarJogo() 
	{
		this.jogo = new Jogo();
		
		for(Jogador j : this.jogadores)
		{
			this.jogo.addJogador(j);
		}
		
		this.jogo.distribuirTerritorios();
	}

	/**
	 * (RN01) – Quantidade de jogadores em um jogo
	 * @throws WarException
	 */
	private void validarNumeroJogares() throws WarException 
	{
		if(this.jogadores.size() < 3)
		{
			throw new WarException(MensagemErro.NUMERO_JOGADORES_INSUFICIENTES);
		}
		
		if(this.jogadores.size() > 6)
		{
			throw new WarException(MensagemErro.NUMERO_JOGADORES_SUPERIOR_LIMITE);
		}
		
	}
	
	public Iterator<Jogador> obterJogadores()
	{
		return this.jogadores.iterator();
	}
	
	
}

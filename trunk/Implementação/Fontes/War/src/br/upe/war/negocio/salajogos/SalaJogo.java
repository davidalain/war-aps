package br.upe.war.negocio.salajogos;

import java.util.ArrayList;
import java.util.Iterator;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.Jogo;
import br.upe.war.negocio.util.MensagemErro;

public class SalaJogo 
{
	private Jogo jogo;
	
	private ArrayList<Jogador> jogadores;
	
	private String senha;
	
	private String nomeSala;
	
	private int numeroJogadores;
	
	public SalaJogo(ParametrosCriarSalaJogo parametros) throws WarValidationException
	{
		
		WarValidationException wve = new WarValidationException();
		
		wve.comparar(false, parametros.getJogador() == null, MensagemErro.JOGADOR_VAZIO);
		wve.<String>compararDiferentes("", parametros.getNomeSala(), MensagemErro.SALA_JOGO_NOME_VAZIO);
		wve.comparar(true, parametros.getNumeroJogadores() <= 6 && parametros.getNumeroJogadores() >= 3, MensagemErro.NUMERO_JOGADORES_INVALIDO);
		wve.comparar(false, parametros.getNomeSala() == null, MensagemErro.SALA_JOGO_NULL);
		wve.validar();
		
		this.jogadores = new ArrayList<Jogador>();
		this.jogadores.add(parametros.getJogador());
		this.nomeSala = parametros.getNomeSala();
		this.numeroJogadores = parametros.getNumeroJogadores();
		
		
		
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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public int getNumeroJogadores() {
		return numeroJogadores;
	}

	public void setNumeroJogadores(int numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}

	public void addJogador(Jogador jogador) {
		this.jogadores.add(jogador);
		
	}
	
	
}

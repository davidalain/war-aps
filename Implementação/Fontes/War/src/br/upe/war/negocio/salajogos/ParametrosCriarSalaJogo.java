package br.upe.war.negocio.salajogos;

import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;


public class ParametrosCriarSalaJogo 
{
	private Jogador jogador;
		
	private String senha;
	
	private String nomeSala;
	
	private int numeroJogadores;
	
	public ParametrosCriarSalaJogo(String apelido, int cor,  String nomeSala, String senha, int numeroJogadores) throws WarValidationException {
		this.jogador = new Jogador(apelido, cor);
		this.senha = senha;
		this.nomeSala = nomeSala;
		this.numeroJogadores = numeroJogadores;
	}
	
	public ParametrosCriarSalaJogo(String apelido, int cor,  String nomeSala,
			int numeroJogadores) throws WarValidationException {
		this.jogador = new Jogador(apelido, cor);	
		this.nomeSala = nomeSala;
		this.numeroJogadores = numeroJogadores;
		this.senha = null;
	}

	

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
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

	
}

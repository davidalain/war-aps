package br.upe.war.negocio.salajogos;

import br.upe.war.negocio.jogadores.Jogador;


public class ParametrosCriarSalaJogo 
{
	private Jogador jogador;
	
	private boolean restrita;
	
	private String senha;
	
	public ParametrosCriarSalaJogo(String apelido, int cor,  String nomeSala, boolean restrita,
			String senha, int numeroJogadores) {
		this.jogador = new Jogador(apelido, cor);
		this.restrita = restrita;
		this.senha = senha;
		this.nomeSala = nomeSala;
		this.numeroJogadores = numeroJogadores;
	}
	
	public ParametrosCriarSalaJogo(String apelido, int cor,  String nomeSala, boolean restrita,
			int numeroJogadores) {
		this.jogador = new Jogador(apelido, cor);
		this.restrita = restrita;
		this.nomeSala = nomeSala;
		this.numeroJogadores = numeroJogadores;
	}

	private String nomeSala;
	
	private int numeroJogadores;

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

	public boolean isRestrita() {
		return restrita;
	}

	public void setRestrita(boolean restrita) {
		this.restrita = restrita;
	}
	
	
}

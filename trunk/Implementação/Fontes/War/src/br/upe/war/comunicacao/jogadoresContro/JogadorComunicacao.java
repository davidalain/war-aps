package br.upe.war.comunicacao.jogadoresContro;

import br.upe.war.negocio.jogadores.Jogador;

public class JogadorComunicacao 
{

	private Jogador jogador;
	private String ip;
	
	
	public JogadorComunicacao(Jogador jogador, String ip) {
		super();
		this.jogador = jogador;
		this.ip = ip;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}

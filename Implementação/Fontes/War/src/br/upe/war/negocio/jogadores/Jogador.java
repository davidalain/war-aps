package br.upe.war.negocio.jogadores;

import br.upe.war.negocio.cartas.Carta;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogos.Jogo;
import br.upe.war.negocio.objetivos.Objetivo;
import br.upe.war.negocio.util.MensagemErro;


public class Jogador 
{
	public static int AZUL = 1;
	public static int VERDE = 2;
	public static int VERMELHO = 3;
	public static int BRANCO = 4;
	public static int PRETO = 5;
	public static int AMARELO = 6;
 
	private String login;
	 
	private int cor;
	 	 
	private Carta[] carta;
	
	private Objetivo objetivo;
	
	public Jogador(String login, int cor) throws WarValidationException {
		WarValidationException wve = new WarValidationException();
		
		wve.<String>compararDiferentes("", login, MensagemErro.JOGADOR_VAZIO);
		wve.comparar(true, cor > 0 && cor < 7, MensagemErro.COR_NAO_EXISTENTE);
		
		wve.validar();
		
		this.login = login;
		this.cor = cor;
	}

	public boolean atingiuObjetivo(Jogo jogo){
		return 	this.objetivo.atingido(this, jogo);
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	public Carta[] getCarta() {
		return carta;
	}

	public void setCarta(Carta[] carta) {
		this.carta = carta;
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if(o instanceof Jogador)
		{
			Jogador j = (Jogador)o;
			return this.login.equals(j.login);
		}
		return false;
	}
	
}
 

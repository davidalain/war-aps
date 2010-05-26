package br.upe.war;


public class Jogador {
	public static int AZUL = 1;
	public static int VERDE = 2;
	public static int VERMELHO = 3;
	public static int BRANCO = 4;
	public static int PRETO = 5;
	public static int AMARELO = 1;
 
	private String login;
	 
	private int cor;
	 
	private Territorio[] territorio;
	 
	private Carta[] carta;

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

	public Territorio[] getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio[] territorio) {
		this.territorio = territorio;
	}

	public Carta[] getCarta() {
		return carta;
	}

	public void setCarta(Carta[] carta) {
		this.carta = carta;
	}
	 
	public boolean equals(Jogador jogador){
		if(this.cor == jogador.getCor())
			return true;
		else
			return false;
	}
}
 

package br.upe.war.negocio;

import br.upe.war.negocio.grafo.Vertice;
import br.upe.war.negocio.jogadores.Jogador;



public class Territorio extends Vertice {	
	private int quantidadeExercito;
	private String nome;
	private Jogador dominante;
	
	public Territorio(int id, String nome)
	{
		super(id);
		this.nome = nome;
		this.quantidadeExercito = 0;
	}
	
	public Territorio(int id, String nome, Jogador dominante)
	{
		super(id);
		this.nome = nome;
		this.quantidadeExercito = 0;
		this.dominante = dominante;
	}
	 
	public void addExercito(int quantidade) {
		this.quantidadeExercito += quantidade;
	}
	 
	public void removeExercito(int quantidade) {
		this.quantidadeExercito -= quantidade;
	}

	public int getQuantidadeExercito() {
		return quantidadeExercito;
	}

	public void setQuantidadeExercito(int quantidadeExercito) {
		this.quantidadeExercito = quantidadeExercito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(Territorio territorio){
		if(this.nome.equals(territorio.getNome()))
			return true;
		
		return false;
	}

	public Jogador getDominante() {
		return dominante;
	}
	
	public boolean ehDominante(Jogador jogador){
		return this.dominante.equals(jogador);			
	}

	public void setDominante(Jogador dominante) {
		this.dominante = dominante;
	}	  
}
 

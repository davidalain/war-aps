package br.upe.war.negocio.continentes;

import java.util.ArrayList;

import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;

public class Continente {
 
	private String nome;
	private ArrayList<Territorio> territorios;
	 
	public Continente(String nome){
		this.nome = nome;
		this.territorios = null;
	}
	
	public Continente(String nome, ArrayList<Territorio> territorios){
		this.nome = nome;
		this.territorios = territorios;
	}
	
	public boolean contem(Territorio territorio) {
		for(Territorio t : this.territorios){
			if(t.equals(territorio))
				return true;
		}
		
		return false;
	}
	
	private boolean ehCompletamenteDominado(){
		Jogador dominante = null;
		for(Territorio t: this.territorios)
		{
			if(dominante == null)
				dominante = t.getDominante();
			else
			{
				if(!dominante.equals(t))
					return false;
			}
		}
		
		return true;
	}
	
	public Jogador getDominante(){
		if(this.ehCompletamenteDominado())
			return this.territorios.get(0).getDominante();
		else
			return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(Continente c){
		return this.nome.equalsIgnoreCase(c.getNome());
			
	}
	 
}
 

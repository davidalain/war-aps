package br.upe.war.negocio.grafo;

import br.upe.war.negocio.territorios.Territorio;

public class ArestaTerritorio implements Aresta{
	
	private Territorio fim;
	private Territorio inicio;

	public ArestaTerritorio(Territorio inicio,Territorio fim){
		this.inicio = inicio;
		this.fim = fim;
	}	

	public Vertice fim() {
		return this.fim;
	}

	public Vertice inicio() {
		return this.inicio;
	}
	
	public String toString(){
		return new String("inicio: "+inicio.getNome()+" -- fim: "+fim.getNome());
	}

	public boolean equals(Aresta a)
	{
		return (this.inicio.equals(a.inicio()) && this.fim.equals(a.fim()));
	}
	
	
	
	
}

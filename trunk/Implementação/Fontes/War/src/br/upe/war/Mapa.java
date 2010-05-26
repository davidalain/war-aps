package br.upe.war;

import java.util.ArrayList;
import java.util.List;

import br.upe.war.grafo.Aresta;
import br.upe.war.grafo.ArestaTerritorio;
import br.upe.war.grafo.Grafo;
import br.upe.war.grafo.Vertice;

public class Mapa implements Grafo {
 
	private int vertices[][] ;
	private ArrayList<Continente> continentes;
	private boolean orientado = false;
	private int numTerritorios;
	
	public boolean ehOrientado()
	{
		return this.orientado;
	}
	
	public Mapa() {
		this.numTerritorios = 42;
		vertices = new int[numTerritorios][numTerritorios];
		this.preencherMapa();		
	}
	
	public boolean ehVizinho(Vertice origem, Vertice dest) {
		return vertices[origem.getId()][dest.getId()] != 0;
	}
	
	public Jogador dominante(Territorio t){
		return t.getDominante();
	}
	
	public Jogador dominante(Continente continente){
		for(Continente c : this.continentes){
			if(c.equals(continente))
				return c.getDominante();
		}
		
		return null;
	}

	public void insert(ArestaTerritorio aresta) {
		vertices[aresta.inicio().getId()][aresta.fim().getId()] = 1;
		if (!ehOrientado()) {
			vertices[aresta.inicio().getId()][aresta.fim().getId()] = 1;
		}
	}
	
	private void preencherMapa(){
		ArrayList<Territorio> territorios = new ArrayList<Territorio>();
		territorios.add(new Territorio(1, "BRASIL"));
		territorios.add(new Territorio(2, "CHILE"));
		territorios.add(new Territorio(3, "ARGENTINA"));
		territorios.add(new Territorio(4, "COLÔMBIA"));
		this.continentes.add(new Continente("AMÉRICA DO SUL", territorios));
		
		territorios =  new ArrayList<Territorio>();
		territorios.add(new Territorio(5, "MÉXICO"));
		territorios.add(new Territorio(6, "NOVA YORK"));
		territorios.add(new Territorio(7, "CALIFORNIA"));
		territorios.add(new Territorio(8, "VANCOUVER"));
		territorios.add(new Territorio(9, "OTTAWA"));
		territorios.add(new Territorio(10, "LABRADOR"));
		territorios.add(new Territorio(11, "MACKENZIE"));
		territorios.add(new Territorio(12, "ALASKA"));
		territorios.add(new Territorio(13, "GROENLÂNDIA"));
		this.continentes.add(new Continente("AMÉRICA DO NORTE", territorios));
				
		territorios =  new ArrayList<Territorio>();
		territorios.add(new Territorio(14, "ÁFRICA DO SUL"));
		territorios.add(new Territorio(15, "MADAGASCAR"));
		territorios.add(new Territorio(16, "CONGO"));
		territorios.add(new Territorio(17, "SUDÃO"));
		territorios.add(new Territorio(18, "ARGÉLIA"));
		territorios.add(new Territorio(19, "EGITO"));
		this.continentes.add(new Continente("ÁFRICA", territorios));
		
		territorios =  new ArrayList<Territorio>();
		territorios.add(new Territorio(20, "PORTUGAL"));
		territorios.add(new Territorio(21, "POLÔNIA"));
		territorios.add(new Territorio(22, "ALEMANHA"));
		territorios.add(new Territorio(23, "INGLATERRA"));
		territorios.add(new Territorio(24, "ISLÂNDIA"));
		territorios.add(new Territorio(25, "SUÉCIA"));
		territorios.add(new Territorio(26, "MOSCOU"));
		this.continentes.add(new Continente("EUROPA", territorios));
		
		territorios =  new ArrayList<Territorio>();
		territorios.add(new Territorio(27, "ORIENTE"));
		territorios.add(new Territorio(28, "ARAL"));
		territorios.add(new Territorio(29, "OMSK"));
		territorios.add(new Territorio(30, "DUDINKA"));
		territorios.add(new Territorio(31, "SIBÉRIA"));
		territorios.add(new Territorio(32, "TCHITA"));
		territorios.add(new Territorio(33, "MONGÓLIA"));
		territorios.add(new Territorio(34, "CHINA"));
		territorios.add(new Territorio(35, "ÍNDIA"));
		territorios.add(new Territorio(36, "VIETNÃ"));
		territorios.add(new Territorio(37, "VLADIVOSTOK"));
		territorios.add(new Territorio(38, "JAPÃO"));
		this.continentes.add(new Continente("ÁSIA", territorios));
		
		territorios =  new ArrayList<Territorio>();
		territorios.add(new Territorio(39, "SUMATRA"));
		territorios.add(new Territorio(40, "BORNEO"));
		territorios.add(new Territorio(41, "OULNÉ"));
		territorios.add(new Territorio(42, "AUSTRÁLIA"));
		this.continentes.add(new Continente("OCEANIA", territorios));
	}
	
	
	@Override
	public int numeroV() {
		return this.numTerritorios;
	}

	@Override
	public List<Aresta> linkedFrom(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aresta> linkedTo(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}	
	 
}
 

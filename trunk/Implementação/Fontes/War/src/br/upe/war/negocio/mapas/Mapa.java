package br.upe.war.negocio.mapas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.upe.war.negocio.continentes.Continente;
import br.upe.war.negocio.grafo.Aresta;
import br.upe.war.negocio.grafo.ArestaTerritorio;
import br.upe.war.negocio.grafo.Grafo;
import br.upe.war.negocio.grafo.Vertice;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;

public class Mapa implements Grafo {
 
	private int vertices[][] ;
	private ArrayList<Continente> continentes;
	private boolean orientado = false;
	
	
	public boolean ehOrientado()
	{
		return this.orientado;
	}
	
	private int obterNumeroTerritorios()
	{
		return 42;
	}
	
	public Mapa() 
	{
	
		int numTerritorios = obterNumeroTerritorios();		
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
	
	private void preencherMapa()
	{
		
		Continente americaSul = new Continente("AM�RICA DO SUL");
		
		americaSul.addTerritorio(new Territorio(1, "BRASIL"));
		americaSul.addTerritorio(new Territorio(2, "CHILE"));
		americaSul.addTerritorio(new Territorio(3, "ARGENTINA"));
		americaSul.addTerritorio(new Territorio(4, "COL�MBIA"));
		this.continentes.add(americaSul);
		
		Continente americaNorte = new Continente("AM�RICA DO NORTE");
		americaNorte.addTerritorio(new Territorio(5, "M�XICO"));
		americaNorte.addTerritorio(new Territorio(6, "NOVA YORK"));
		americaNorte.addTerritorio(new Territorio(7, "CALIFORNIA"));
		americaNorte.addTerritorio(new Territorio(8, "VANCOUVER"));
		americaNorte.addTerritorio(new Territorio(9, "OTTAWA"));
		americaNorte.addTerritorio(new Territorio(10, "LABRADOR"));
		americaNorte.addTerritorio(new Territorio(11, "MACKENZIE"));
		americaNorte.addTerritorio(new Territorio(12, "ALASKA"));
		americaNorte.addTerritorio(new Territorio(13, "GROENL�NDIA"));
		this.continentes.add(americaNorte);
				
		Continente africa = new Continente("�FRICA");
		africa.addTerritorio(new Territorio(14, "�FRICA DO SUL"));
		africa.addTerritorio(new Territorio(15, "MADAGASCAR"));
		africa.addTerritorio(new Territorio(16, "CONGO"));
		africa.addTerritorio(new Territorio(17, "SUD�O"));
		africa.addTerritorio(new Territorio(18, "ARG�LIA"));
		africa.addTerritorio(new Territorio(19, "EGITO"));
		this.continentes.add(africa);
		
		Continente europa = new Continente("EUROPA");
		europa.addTerritorio(new Territorio(20, "PORTUGAL"));
		europa.addTerritorio(new Territorio(21, "POL�NIA"));
		europa.addTerritorio(new Territorio(22, "ALEMANHA"));
		europa.addTerritorio(new Territorio(23, "INGLATERRA"));
		europa.addTerritorio(new Territorio(24, "ISL�NDIA"));
		europa.addTerritorio(new Territorio(25, "SU�CIA"));
		europa.addTerritorio(new Territorio(26, "MOSCOU"));
		this.continentes.add(europa);
		
		Continente asia = new Continente("�SIA");
		asia.addTerritorio(new Territorio(27, "ORIENTE"));
		asia.addTerritorio(new Territorio(28, "ARAL"));
		asia.addTerritorio(new Territorio(29, "OMSK"));
		asia.addTerritorio(new Territorio(30, "DUDINKA"));
		asia.addTerritorio(new Territorio(31, "SIB�RIA"));
		asia.addTerritorio(new Territorio(32, "TCHITA"));
		asia.addTerritorio(new Territorio(34, "CHINA"));
		asia.addTerritorio(new Territorio(33, "MONG�LIA"));
		asia.addTerritorio(new Territorio(35, "�NDIA"));
		asia.addTerritorio(new Territorio(36, "VIETN�"));
		asia.addTerritorio(new Territorio(37, "VLADIVOSTOK"));
		asia.addTerritorio(new Territorio(38, "JAP�O"));
		this.continentes.add(asia);
		
		Continente oceania = new Continente("OCEANIA");
		oceania.addTerritorio(new Territorio(39, "SUMATRA"));
		oceania.addTerritorio(new Territorio(40, "BORNEO"));
		oceania.addTerritorio(new Territorio(41, "OULN�"));
		oceania.addTerritorio(new Territorio(42, "AUSTR�LIA"));
		this.continentes.add(oceania);
	}
	
	
	@Override
	public int numeroV() {
		return obterNumeroTerritorios();
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

	public Iterator<Territorio> obterTerritorios() 
	{
		ArrayList<Territorio> retorno  = new ArrayList<Territorio>();
		
		for (Continente c : this.continentes) 
		{
			Iterator<Territorio> territoriosContinente = c.obterTerritorios();
			
			while(territoriosContinente.hasNext())
			{
				retorno.add(territoriosContinente.next());
			}
		}
		
		return retorno.iterator();
		
	}	
	 
}
 

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
		this.continentes = new ArrayList<Continente>(6);
		this.preencherMapa();		
		this.ligarTerritorios();
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
		
		Continente americaSul = new Continente("AMÉRICA DO SUL");
		
		americaSul.addTerritorio(new Territorio(1, "BRASIL"));
		americaSul.addTerritorio(new Territorio(2, "CHILE"));
		americaSul.addTerritorio(new Territorio(3, "ARGENTINA"));
		americaSul.addTerritorio(new Territorio(4, "COLÔMBIA"));
		this.continentes.add(americaSul);
		
		Continente americaNorte = new Continente("AMÉRICA DO NORTE");
		americaNorte.addTerritorio(new Territorio(5, "MÉXICO"));
		americaNorte.addTerritorio(new Territorio(6, "NOVA YORK"));
		americaNorte.addTerritorio(new Territorio(7, "CALIFORNIA"));
		americaNorte.addTerritorio(new Territorio(8, "VANCOUVER"));
		americaNorte.addTerritorio(new Territorio(9, "OTTAWA"));
		americaNorte.addTerritorio(new Territorio(10, "LABRADOR"));
		americaNorte.addTerritorio(new Territorio(11, "MACKENZIE"));
		americaNorte.addTerritorio(new Territorio(12, "ALASKA"));
		americaNorte.addTerritorio(new Territorio(13, "GROENLÂNDIA"));
		this.continentes.add(americaNorte);
				
		Continente africa = new Continente("ÁFRICA");
		africa.addTerritorio(new Territorio(14, "ÁFRICA DO SUL"));
		africa.addTerritorio(new Territorio(15, "MADAGASCAR"));
		africa.addTerritorio(new Territorio(16, "CONGO"));
		africa.addTerritorio(new Territorio(17, "SUDÃO"));
		africa.addTerritorio(new Territorio(18, "ARGÉLIA"));
		africa.addTerritorio(new Territorio(19, "EGITO"));
		this.continentes.add(africa);
		
		Continente europa = new Continente("EUROPA");
		europa.addTerritorio(new Territorio(20, "PORTUGAL"));
		europa.addTerritorio(new Territorio(21, "POLÔNIA"));
		europa.addTerritorio(new Territorio(22, "ALEMANHA"));
		europa.addTerritorio(new Territorio(23, "INGLATERRA"));
		europa.addTerritorio(new Territorio(24, "ISLÂNDIA"));
		europa.addTerritorio(new Territorio(25, "SUÉCIA"));
		europa.addTerritorio(new Territorio(26, "MOSCOU"));
		this.continentes.add(europa);
		
		Continente asia = new Continente("ÁSIA");
		asia.addTerritorio(new Territorio(27, "ORIENTE"));
		asia.addTerritorio(new Territorio(28, "ARAL"));
		asia.addTerritorio(new Territorio(29, "OMSK"));
		asia.addTerritorio(new Territorio(30, "DUDINKA"));
		asia.addTerritorio(new Territorio(31, "SIBÉRIA"));
		asia.addTerritorio(new Territorio(32, "TCHITA"));
		asia.addTerritorio(new Territorio(34, "CHINA"));
		asia.addTerritorio(new Territorio(33, "MONGÓLIA"));
		asia.addTerritorio(new Territorio(35, "ÍNDIA"));
		asia.addTerritorio(new Territorio(36, "VIETNÃ"));
		asia.addTerritorio(new Territorio(37, "VLADIVOSTOK"));
		asia.addTerritorio(new Territorio(38, "JAPÃO"));
		this.continentes.add(asia);
		
		Continente oceania = new Continente("OCEANIA");
		oceania.addTerritorio(new Territorio(39, "SUMATRA"));
		oceania.addTerritorio(new Territorio(40, "BORNEO"));
		oceania.addTerritorio(new Territorio(41, "OULNÉ"));
		oceania.addTerritorio(new Territorio(42, "AUSTRÁLIA"));
		this.continentes.add(oceania);
	}
	
	private void ligarTerritorios(){
		//america do sul
		Territorio brasil = this.obterTerritorio(1);
		Territorio argentina = this.obterTerritorio(3);
		Territorio colombia = this.obterTerritorio(4);
		Territorio chile = this.obterTerritorio(2);
		
		//africa
		Territorio argelia = this.obterTerritorio(18);
		Territorio sudao = this.obterTerritorio(17);
		Territorio egito = this.obterTerritorio(19);
		Territorio africaSul = this.obterTerritorio(14);
		Territorio congo = this.obterTerritorio(16);
		Territorio madagascar = this.obterTerritorio(15);
		
		//america do norte
		Territorio mexico = this.obterTerritorio(5);
		Territorio novaYork = this.obterTerritorio(6);
		Territorio california = this.obterTerritorio(7);
		Territorio ottawa = this.obterTerritorio(9);
		Territorio vancouver = this.obterTerritorio(8);
		Territorio labrador = this.obterTerritorio(10);
		Territorio mackenzie = this.obterTerritorio(11);
		Territorio alaska = this.obterTerritorio(12);
		Territorio groenlandia = this.obterTerritorio(13);
		
		
		//europa
		Territorio portugal = this.obterTerritorio(20);
		Territorio polonia = this.obterTerritorio(21);
		Territorio alemanha = this.obterTerritorio(22);
		Territorio inglaterra = this.obterTerritorio(23);
		Territorio islandia = this.obterTerritorio(24);
		Territorio suecia = this.obterTerritorio(25);
		Territorio moscou = this.obterTerritorio(26);
		
		//asia
		Territorio oriente = this.obterTerritorio(27);
		Territorio aral = this.obterTerritorio(28);
		Territorio omsk = this.obterTerritorio(29);
		Territorio dudinka = this.obterTerritorio(30);
		Territorio siberia = this.obterTerritorio(31);
		Territorio tchita = this.obterTerritorio(32);
		Territorio china = this.obterTerritorio(34);
		Territorio mogolia = this.obterTerritorio(33);
		Territorio india = this.obterTerritorio(35);
		Territorio vietna = this.obterTerritorio(36);
		Territorio vladivostok = this.obterTerritorio(37);
		Territorio japao = this.obterTerritorio(38);
		
		ArestaTerritorio aresta = new ArestaTerritorio(brasil, argentina);
		this.insert(aresta);
		
		//america sul
		aresta = new ArestaTerritorio(brasil, colombia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(brasil, chile);
		this.insert(aresta);
		
		//america -> africa	
		aresta = new ArestaTerritorio(brasil, argelia);
		this.insert(aresta);
		
		//america sul -> america norte
		aresta = new ArestaTerritorio(colombia, mexico);
		this.insert(aresta);
		
		//america norte
		aresta = new ArestaTerritorio(mexico, novaYork);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(mexico, california);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(california, novaYork);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(california, vancouver);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(ottawa, novaYork);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(ottawa, labrador);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(labrador, groenlandia);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(labrador, novaYork);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(groenlandia, mackenzie);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(alaska, mackenzie);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(vancouver, mackenzie);
		this.insert(aresta);	
		
		aresta = new ArestaTerritorio(vancouver, ottawa);
		this.insert(aresta);
		
		//america norte -> europa
		aresta = new ArestaTerritorio(groenlandia, islandia);
		this.insert(aresta);
		
		//europa
		aresta = new ArestaTerritorio(inglaterra, islandia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(islandia, suecia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(moscou, suecia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(moscou, polonia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(alemanha, polonia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(portugal, polonia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(portugal, inglaterra);
		this.insert(aresta);
		
		//europa ->  africa
		aresta = new ArestaTerritorio(portugal, argelia);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(portugal, egito);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(polonia, egito);
		this.insert(aresta);
		
		//africa
		aresta = new ArestaTerritorio(argelia, egito);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(argelia, sudao);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(argelia, congo);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(sudao, egito);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(sudao, congo);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(sudao, africaSul);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(sudao, madagascar);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(congo, africaSul);
		this.insert(aresta);
		
		aresta = new ArestaTerritorio(madagascar, africaSul);
		this.insert(aresta);
		
		//TODO: o resto!!
	
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
	
	public Territorio obterTerritorio(int idTerritorio) 
	{
		Territorio territorioComp  = new Territorio(idTerritorio, "");
		Territorio atual = null;
		for (Continente c : this.continentes) 
		{
			Iterator<Territorio> territoriosContinente = c.obterTerritorios();
			
			while(territoriosContinente.hasNext())
			{
				atual = territoriosContinente.next();
				if(atual.equals(territorioComp))
					return atual;
			}
		}
		
		return null;
		
	}	
	 
}
 

package br.upe.war.negocio.jogos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.cartas.Carta;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadas.Jogada;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.mapas.Mapa;
import br.upe.war.negocio.objetivos.FabricaObjetivos;
import br.upe.war.negocio.objetivos.Objetivo;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class Jogo {
	private String nomeJogo;
	private ArrayList<Objetivo> possiveisObjetivos;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Carta> cartas;
	private Jogada jogadaAtual;
	private Mapa mapa;
	
	public Jogo()
	{
		this.jogadores = new ArrayList<Jogador>();
		this.mapa = new Mapa();
		
		this.possiveisObjetivos = FabricaObjetivos.getPossiveisObjetivos(this.jogadores);
	}
	
	public void addJogador(Jogador jogador)
	{
		this.jogadores.add(jogador);
	}
	
	

	public String getNomeJogo() 
	{
		return nomeJogo;
	}



	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}



	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		if(!jogadorEstaNoJogo(parametros.getJogador()))
		{
			throw new WarException(MensagemErro.JOGADOR_NAO_ESTA_NO_JOGO);
		}
		
		this.jogadaAtual.povoarTerritorioConquistado(parametros);
	}
	
	private boolean jogadorEstaNoJogo(Jogador jogador)
	{
		boolean encontrou = false;
		
		for (int i = 0; i < this.jogadores.size(); i++) 
		{
			if(this.jogadores.get(i).getLogin().equals(jogador.getLogin()))
			{	
				encontrou = true;
				break;
			}
		}
		
		return encontrou;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Jogo)
		{
			Jogo jogo = (Jogo)obj;
			return this.nomeJogo.equals(jogo.nomeJogo);
		}
		return false;
	}

	public void distribuirTerritorios() 
	{
		Iterator<Territorio> territorios = this.mapa.obterTerritorios();
		
		int i = 0;
		while(territorios.hasNext())
		{
			Territorio territorio = territorios.next();
			
			Jogador jogador = this.jogadores.get(i);
			
			territorio.setDominante(jogador);
			
			if(i == this.jogadores.size() - 1)
			{
				i = 0;
			}
			else
			{
				i++;
			}		
		}
	}

	public void distribuirObjetivos() {
		Objetivo o = null;
		ArrayList<Objetivo> usados = new ArrayList<Objetivo>();
		int i = new Random().nextInt(14);
		for(Jogador j : jogadores){
			o = this.possiveisObjetivos.get(i);
			
			if(!usados.contains(o)){
				usados.add(o);
				j.setObjetivo(o);
			}
			
			if(i == 14)
				i = 0;
			else
				i++;
		}
		
	}
	
}

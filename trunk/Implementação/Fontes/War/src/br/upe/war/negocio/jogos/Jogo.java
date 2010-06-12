package br.upe.war.negocio.jogos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.fases.FaseAtaque;
import br.upe.war.negocio.jogadas.Jogada;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.mapas.Mapa;
import br.upe.war.negocio.objetivos.FabricaObjetivos;
import br.upe.war.negocio.objetivos.Objetivo;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class Jogo {
	private ArrayList<Jogador> jogadores;
	//private ArrayList<Carta> cartas;
	private Jogada jogadaAtual;
	private Mapa mapa;
	
	public Jogo()
	{
		this.jogadores = new ArrayList<Jogador>();
		this.mapa = new Mapa();
		
	}
	
	public void addJogador(Jogador jogador)
	{
		this.jogadores.add(jogador);
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
	
	public void distribuirTerritorios() 
	{
		Iterator<Territorio> territorios = this.mapa.obterTerritorios();
		
		int i = 0;
		while(territorios.hasNext())
		{
			Territorio territorio = territorios.next();
			
			Jogador jogador = this.jogadores.get(i);
			
			territorio.setDominante(jogador);
			territorio.addExercito(1);
			
			if(territorio.getNome().equals("BRASIL") || territorio.getNome().equals("ARGENTINA") )
				territorio.addExercito(4);
			
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
		FabricaObjetivos fabrica = FabricaObjetivos.getInstance();
		ArrayList<Objetivo> possiveisObjetivos = fabrica.getPossiveisObjetivos(this.jogadores);
		Objetivo o = null;
		ArrayList<Objetivo> usados = new ArrayList<Objetivo>();
		int i = new Random().nextInt(this.jogadores.size()+8);
		for(Jogador j : jogadores){
			o = possiveisObjetivos.get(i);
			
			if(!usados.contains(o)){
				usados.add(o);
				j.setObjetivo(o);
			}
			
			i = new Random().nextInt(this.jogadores.size()+8);
		}
		
	}

	public Iterator<Territorio> obterTerritorios() {
		return this.mapa.obterTerritorios();
	}

	public void atacarTerritorio(ParametrosAtaque parametros) throws WarException {
		String atacante = parametros.getAtacante().getNome();
		parametros.setAtacante(this.mapa.obterTerritorio(atacante));
		
		String defensor = parametros.getDefensor().getNome();
		parametros.setDefensor(this.mapa.obterTerritorio(defensor));
		
		if(!this.mapa.ehVizinho(parametros.getAtacante(), parametros.getDefensor())){
			throw new WarException(MensagemErro.TERRITORIOS_NAO_CONTIGUOS);
		}
		
		Territorio[] retorno = this.jogadaAtual.atacarTerritorio(parametros);
			
		this.mapa.atualizatTerritorio(retorno[0]);
		this.mapa.atualizatTerritorio(retorno[1]);

	}

	public void comecarJogadas(Jogador jogador) {
		FaseAtaque fase = new FaseAtaque();
		this.jogadaAtual = new Jogada(fase, jogador);
		
	}
	
}

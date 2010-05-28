package br.upe.war.negocio.jogos;

import java.util.ArrayList;

import br.upe.war.negocio.cartas.Carta;
import br.upe.war.negocio.jogadas.Jogada;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.mapas.Mapa;
import br.upe.war.negocio.objetivos.Objetivo;

public class Jogo {
	private int id;
	private ArrayList<Objetivo> possiveisObjetivos;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Carta> cartas;
	private Jogada jogadaAtual;
	private Mapa mapa;
	
	
}

package br.upe.war.negocio.comum;

import java.util.ArrayList;
import java.util.Iterator;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.ControladorJogo;
import br.upe.war.negocio.salajogos.ControladorSalaJogo;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;
import br.upe.war.negocio.salajogos.SalaJogo;


public class FachadaWar 
{
	private static FachadaWar instance;
	private ControladorJogo jogos;
	private ControladorSalaJogo salasJogos;
	
	private FachadaWar()
	{
		this.jogos = ControladorJogo.getInstance();
		this.salasJogos = ControladorSalaJogo.getInstance();
	}
	
	public synchronized static FachadaWar getInstance()
	{
		if(instance == null)
		{
			instance = new FachadaWar();
		}
		return instance;
	}
	
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		this.jogos.povoarTerritorioConquistado(parametros);
	}
	
	public void criarSalaJogo(ParametrosCriarSalaJogo parametros)
	{
		this.salasJogos.criar(parametros);
	}

	public void iniciarJogo(SalaJogo salaJogo)
	{
		this.jogos.iniciar(salaJogo);
	}

	public int obterSalasJogoCount() {
		return this.salasJogos.obterCount();
	}

	public Iterator<SalaJogo> obterSalasJogo() 
	{
		return this.salasJogos.obter();
	}
	
	public synchronized void reiniciar()
	{
		this.jogos.removerTodos();
		this.salasJogos.removerTodas();
	}
}

	package br.upe.war.negocio.comum;

import java.util.Iterator;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.ControladorSalaJogo;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;
import br.upe.war.negocio.salajogos.SalaJogo;


public class FachadaWar 
{
	private static FachadaWar instance;
	private ControladorSalaJogo salasJogos;
	
	private FachadaWar()
	{
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
		this.salasJogos.povoarTerritorioConquistado(parametros);
	}
	
	public void criarSalaJogo(ParametrosCriarSalaJogo parametros) throws WarValidationException
	{
		this.salasJogos.criarSalaJogo(parametros);
		
	}
	
	public void entrarSalaJogo(Jogador jogador, String nomeSalaJogo){
		this.salasJogos.entrarSalaJogo(jogador, nomeSalaJogo);
	}

	public void iniciarJogo(String nomeSalaJogo, String loginJogador) throws WarException
	{
		this.salasJogos.iniciarJogo(nomeSalaJogo, loginJogador);
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
		this.salasJogos.removerTodas();
	}
}

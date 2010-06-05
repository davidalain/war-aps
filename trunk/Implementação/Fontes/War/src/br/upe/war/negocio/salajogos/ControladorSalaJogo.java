package br.upe.war.negocio.salajogos;

import java.util.ArrayList;
import java.util.Iterator;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.util.MensagemErro;

public class ControladorSalaJogo 
{
	private static ControladorSalaJogo instance;
	
	private ArrayList<SalaJogo> salasJogo;
	
	private ControladorComunicacao comunicacao;
	
	private ControladorSalaJogo()
	{
		this.salasJogo = new ArrayList<SalaJogo>();
		this.comunicacao = ControladorComunicacao.getInstance();
	}
	
	public synchronized static ControladorSalaJogo getInstance()
	{
		if(instance == null)
		{
			instance = new ControladorSalaJogo();
		}
		return instance;
	}

	public int obterCount()
	{
		return this.salasJogo.size();
	}

	public void criar(ParametrosCriarSalaJogo parametros) 
	{

		
		SalaJogo novaSalaJogo = new SalaJogo(parametros);
		
		this.salasJogo.add(novaSalaJogo);
		
	}

	public Iterator<SalaJogo> obter() 
	{
	
		return this.salasJogo.iterator();
		
		
	}
	
	public void validarNaoExisteSalaJogo(SalaJogo jogo) throws WarException
	{
		if(this.salasJogo.contains(jogo))
		{
			throw new WarException(MensagemErro.SALA_JOGO_EXISTENTE);
		}
	}

	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		
		SalaJogo salaJogo = this.salasJogo.get(this.salasJogo.indexOf(parametros.getSalaJogo()));
		
		salaJogo.povoarTerritorioConquistado(parametros);		
		
	}
	
	public void iniciarJogo(SalaJogo salaJogo) throws WarException
	{
		
		
		salaJogo.iniciarJogo();	
		
	}
	
	public void removerTodas() 
	{
		this.salasJogo.clear();
	}

}

package br.upe.war.negocio.jogos;

import java.util.HashMap;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.util.Mensagens;

public class ControladorJogo {
	private HashMap<Integer, Jogo> jogos;
	private static ControladorJogo instance;

	public synchronized static ControladorJogo getInstance(){
		if(instance == null)
			instance = new ControladorJogo();

		return instance;
	}
	
	private ControladorJogo()
	{
		this.jogos = new HashMap<Integer, Jogo>();
	}

	
	
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		if(!this.jogos.containsKey(new Integer(parametros.getJogo().getId())))
		{
			throw new WarException(Mensagens.JOGO_NAO_CADASTRADO);
		}
		
		Jogo jogo = this.jogos.get(new Integer(parametros.getJogo().getId()));
		
		jogo.povoarTerritorioConquistado(parametros);		
		
	}

	public void iniciar(SalaJogo salaJogo)
	{
		
	}
}

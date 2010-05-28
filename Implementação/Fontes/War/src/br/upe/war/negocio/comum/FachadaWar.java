package br.upe.war.negocio.comum;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.jogos.ControladorJogo;


public class FachadaWar 
{
	private static FachadaWar instance;
	private ControladorJogo jogos;
	
	private FachadaWar()
	{
		this.jogos = ControladorJogo.getInstance();
	}
	
	public synchronized static FachadaWar getInstance()
	{
		if(instance == null)
		{
			instance = new FachadaWar();
		}
		return instance;
	}
	
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros)
	{
		this.jogos.povoarTerritorioConquistado(parametros);
	}
}

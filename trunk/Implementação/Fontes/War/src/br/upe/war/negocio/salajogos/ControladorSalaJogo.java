package br.upe.war.negocio.salajogos;

public class ControladorSalaJogo 
{
	private static ControladorSalaJogo instance;
	
	private ControladorSalaJogo()
	{
		
	}
	
	public synchronized static ControladorSalaJogo getInstance()
	{
		if(instance == null)
		{
			instance = new ControladorSalaJogo();
		}
		return instance;
	}
}

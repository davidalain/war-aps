package br.upe.war.comunicacao.comum;



import br.upe.war.comunicacao.envio.EnvioPacote;
import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.negocio.comum.FachadaWar;

import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;


public class ControladorComunicacao 
{
	private static ControladorComunicacao instance;
	
	private ControladorComunicacao()
	{
		
	}
	
	public synchronized static ControladorComunicacao getInstance()
	{
		if(instance == null)
		{
			instance = new ControladorComunicacao();
		}
		return instance;
	}
	
	public void enviarMensagem(Mensagem m)
	{
		EnvioPacote.enviarMensagem(m);
	}
	
	
}

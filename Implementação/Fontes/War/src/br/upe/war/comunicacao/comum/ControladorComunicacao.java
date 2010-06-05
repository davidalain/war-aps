package br.upe.war.comunicacao.comum;



import java.io.IOException;

import br.upe.war.comunicacao.envio.EnvioPacote;
import br.upe.war.comunicacao.mensagens.Mensagem;


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
	
	public void enviarMensagem(Mensagem m) throws IOException
	{
		EnvioPacote.enviarMensagem(m);
	}
	
	
}

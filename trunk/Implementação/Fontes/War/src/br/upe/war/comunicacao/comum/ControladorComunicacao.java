package br.upe.war.comunicacao.comum;



import java.io.IOException;
import java.util.ArrayList;

import br.upe.war.comunicacao.envio.EnvioPacote;
import br.upe.war.comunicacao.jogadoresContro.JogadorComunicacao;
import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.negocio.jogadores.Jogador;


public class ControladorComunicacao 
{
	private static ControladorComunicacao instance;
	
	private static ArrayList<JogadorComunicacao> jogadores;
	
	private ControladorComunicacao()
	{
		jogadores = new ArrayList<JogadorComunicacao>(6);
	}
	
	public void addJogadorComunicacao(Jogador jogador, String ip){
		JogadorComunicacao j = new JogadorComunicacao(jogador, ip);
		jogadores.add(j);
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
		EnvioPacote.enviarMensagem(m, 6789);
	}
	
	public void enviarMensagemResposta(Mensagem m) throws IOException
	{
		for(JogadorComunicacao j : jogadores){
			m.setEndereco(j.getIp());
			EnvioPacote.enviarMensagem(m, 1234);
		}		
	}
	
	
}

package br.upe.war.comunicacao.envio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;

public class EnvioPacote 
{
	public static void enviarMensagem(Mensagem m, int porta) throws IOException
	{
		Socket socket = new Socket(m.getEndereco(), porta);
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		 
		output.writeObject(m);
		socket.close();
	}
	
}

package br.upe.war.apresentacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacote;


public class ProgramaServidor 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		ServerSocket socket = new ServerSocket(6789);
		
		while(true)
		{			
			Socket connectionSocket = socket.accept();
			
			ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
			Mensagem mensagem = (Mensagem) input.readObject();
			
			ThreadRecebimentoPacote r = new ThreadRecebimentoPacote(mensagem);
			
			Thread nova = new Thread(r);
					
			nova.start();
		}
		
	}

}

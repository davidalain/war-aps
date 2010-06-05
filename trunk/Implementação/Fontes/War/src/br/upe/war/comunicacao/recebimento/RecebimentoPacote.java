package br.upe.war.comunicacao.recebimento;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;

public class RecebimentoPacote implements Runnable{
	
	private ServerSocket socket;
	
	public RecebimentoPacote() throws IOException{
		this.socket = new ServerSocket(6789);
	}
	
	/*public void receberMensagem() throws IOException, ClassNotFoundException{
		ServerSocket socket = new ServerSocket(6789);
		
		while(true){
			Socket connectionSocket = socket.accept();
			
			ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
			Mensagem mensagem = (Mensagem) input.readObject();
			
			System.out.println(mensagem.getEnderecoJogador());
		}
		
	}*/

	@Override
	public void run() 
	{
		while(true)
		{
			try {
				Socket connectionSocket = socket.accept();
				
				ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
				
				Mensagem mensagem = (Mensagem) input.readObject();
				
				System.out.println(mensagem.getEnderecoJogador());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		
}

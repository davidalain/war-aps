package br.upe.war.comunicacao.recebimento;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.negocio.excecoes.WarException;

public class ThreadRecebimentoPacote implements Runnable{
	
	private Mensagem mensagem;
	private ServerSocket socket;
	
	public ThreadRecebimentoPacote(Mensagem mensagem) throws IOException{
		this.mensagem = mensagem;
		this.socket = new ServerSocket(6789);
	}
	
	@Override
	public void run() 
	{
		try {
			while(true){
			Socket connectionSocket = socket.accept();
			
			ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
			this.mensagem = (Mensagem) input.readObject();
			
			this.mensagem.tratarMensagem();
			}
		} catch (WarException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}

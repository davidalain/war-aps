package br.upe.war.comunicacao.recebimento;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;

public class ThreadRecebimentoPacoteCliente extends ThreadRecebimentoPacote {	
	public ThreadRecebimentoPacoteCliente(int porta) throws IOException{
		super(porta);
	}
	
	@Override
	public void run() 
	{
		try {
			while(true){
				Socket connectionSocket = super.getSocket().accept();
							
				ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
				Mensagem mensagem = (Mensagem) input.readObject();
				
				System.out.println(mensagem.resposta());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

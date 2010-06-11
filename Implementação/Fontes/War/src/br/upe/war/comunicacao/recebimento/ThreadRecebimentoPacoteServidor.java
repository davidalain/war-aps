package br.upe.war.comunicacao.recebimento;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.negocio.excecoes.WarException;

public class ThreadRecebimentoPacoteServidor extends ThreadRecebimentoPacote {

	public ThreadRecebimentoPacoteServidor(int porta) throws IOException {
		super(porta);
	}

	public void run() 
	{
		try {
			while(true){
				Socket connectionSocket = super.getSocket().accept();
			
				ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
				Mensagem mensagem = (Mensagem) input.readObject();
			
				mensagem.tratarMensagem();
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

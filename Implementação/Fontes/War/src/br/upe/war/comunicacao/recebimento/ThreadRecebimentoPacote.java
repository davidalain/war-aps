package br.upe.war.comunicacao.recebimento;

import java.io.IOException;

import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.negocio.excecoes.WarException;

public class ThreadRecebimentoPacote implements Runnable{
	
	private Mensagem mensagem;
	
	public ThreadRecebimentoPacote(Mensagem mensagem) throws IOException{
		this.mensagem = mensagem;
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
		try {
			this.mensagem.tratarMensagem();
		} catch (WarException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}

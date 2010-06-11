package br.upe.war.comunicacao.recebimento;

import java.io.IOException;
import java.net.ServerSocket;

public abstract class ThreadRecebimentoPacote implements Runnable{
	
	private ServerSocket socket;
	
	public ThreadRecebimentoPacote(int porta) throws IOException{
		this.socket = new ServerSocket(porta);
	}
	
	@Override
	public abstract void  run();

	public ServerSocket getSocket() {
		return socket;
	}

	public void setSocket(ServerSocket socket) {
		this.socket = socket;
	} 
	
		
}

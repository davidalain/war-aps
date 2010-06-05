package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;


public class ProgramCliente {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		ControladorComunicacao comunicao = ControladorComunicacao.getInstance();
		
		
			MensagemCriarSalaJogo m = new MensagemCriarSalaJogo();
			m.setEndereco("127.0.0.1");
			
			while(true)
				comunicao.enviarMensagem(m);
		
	}

}

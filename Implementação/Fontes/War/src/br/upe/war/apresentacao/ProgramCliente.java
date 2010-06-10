package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemEntrarSalaJogo;


public class ProgramCliente {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		ControladorComunicacao comunicacao = ControladorComunicacao.getInstance();
		
		MensagemCriarSalaJogo m = new MensagemCriarSalaJogo("Erick", 1, "sala1", false, 3, "127.0.0.1");	
		comunicacao.enviarMensagem(m);
		
		MensagemEntrarSalaJogo m2 = new MensagemEntrarSalaJogo("Diego", 2, "sala1", "127.0.0.1");
		comunicacao.enviarMensagem(m2);
		
		
	}

}

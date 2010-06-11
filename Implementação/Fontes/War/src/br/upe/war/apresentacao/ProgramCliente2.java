package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemEntrarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemIniciarJogo;


public class ProgramCliente2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		ControladorComunicacao comunicacao = ControladorComunicacao.getInstance();
		String servidor = "127.0.0.1";
		
		MensagemCriarSalaJogo m = new MensagemCriarSalaJogo("Erick", 1, "sala1", false, 3, servidor);	
		comunicacao.enviarMensagem(m);
		
		MensagemEntrarSalaJogo m2 = new MensagemEntrarSalaJogo("Diego", 2, "sala1", servidor);
		comunicacao.enviarMensagem(m2);
		
		MensagemEntrarSalaJogo m3 = new MensagemEntrarSalaJogo("David", 3, "sala1", servidor);
		comunicacao.enviarMensagem(m3);
		
		MensagemIniciarJogo m4 = new MensagemIniciarJogo("sala1", "Erick", servidor);
		comunicacao.enviarMensagem(m4);
		
		
	}

	
}

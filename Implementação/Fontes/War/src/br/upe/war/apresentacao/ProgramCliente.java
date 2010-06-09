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
		
		MensagemCriarSalaJogo m = new MensagemCriarSalaJogo("Erick", 1, "sala1", false, 3);
		m.setEndereco("127.0.0.1");
			
		comunicao.enviarMensagem(m);
		
	}

}

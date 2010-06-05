package br.upe.war.apresentacao;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;


public class ProgramCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ControladorComunicacao comunicao = ControladorComunicacao.getInstance();
		
		while(true)
		{
			MensagemCriarSalaJogo m = new MensagemCriarSalaJogo();
			
			comunicao.enviarMensagem(m);
		}
	}

}

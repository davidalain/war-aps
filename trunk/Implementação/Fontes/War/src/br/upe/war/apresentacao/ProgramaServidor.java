package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacote;


public class ProgramaServidor 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		ThreadRecebimentoPacote r = new ThreadRecebimentoPacote();
		
		Thread nova = new Thread(r);
				
		nova.start();
	}

}

package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.recebimento.RecebimentoPacote;


public class ProgramaServidor 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		RecebimentoPacote r = new RecebimentoPacote();
		
		Thread nova = new Thread(r);
				
		nova.start();
	}

}

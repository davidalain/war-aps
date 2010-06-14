package br.upe.war.apresentacao;

import java.io.IOException;

import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacote;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacoteServidor;


public class ProgramaServidor 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		
			
			ThreadRecebimentoPacote r = new ThreadRecebimentoPacoteServidor(6789);
			
			Thread nova = new Thread(r);
					
			nova.start();
	
		
	}

}

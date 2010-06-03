package br.upe.war.testes;

import br.upe.war.testes.testeUC02.TesteUC02;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TesteTodos 
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Todos casos de uso");
		
		suite.addTest(TesteUC02.suite());
		
		return suite;
	}

}

package br.upe.war.testes.testeUC02;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TesteUC02
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("UC02");
		suite.addTestSuite(TesteUC02_R001.class);
		
		return suite;
	}

}

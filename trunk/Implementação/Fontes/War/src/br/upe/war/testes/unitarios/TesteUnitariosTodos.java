package br.upe.war.testes.unitarios;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TesteUnitariosTodos 
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Todos testes unitarios");
		
		suite.addTestSuite(TesteAtaque.class);
	
		return suite;
	}
}

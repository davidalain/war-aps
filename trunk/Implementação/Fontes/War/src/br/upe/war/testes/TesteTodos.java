package br.upe.war.testes;

import junit.framework.Test;
import junit.framework.TestSuite;
import br.upe.war.testes.unitarios.TesteUnitariosTodos;

public class TesteTodos 
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Todos casos de uso e testes unit�rios");
		
		suite.addTest(TesteUnitariosTodos.suite());
		
		return suite;
	}

}

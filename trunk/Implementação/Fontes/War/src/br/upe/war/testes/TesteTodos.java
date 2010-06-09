package br.upe.war.testes;

import junit.framework.Test;
import junit.framework.TestSuite;
import br.upe.war.testes.testeUC02.TesteUC02;
import br.upe.war.testes.unitarios.TesteUnitariosTodos;

public class TesteTodos 
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Todos casos de uso e testes unitários");
		
		suite.addTest(TesteUC02.suite());
		suite.addTest(TesteUnitariosTodos.suite());
		
		return suite;
	}

}

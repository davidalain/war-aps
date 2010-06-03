package br.upe.war.testes.testeUC02;



import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.jogadores.Jogador;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TesteUC02_R001 extends TestCase
{
	public void testeUC02_R001_C001()
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador();
		
		fachada.criarSalaJogo(jogador);
		
		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 1;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
	}
}

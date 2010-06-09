package br.upe.war.testes.testeUC02;

import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;
import br.upe.war.negocio.salajogos.SalaJogo;

public class TesteUC02_R002 extends TestCase
{
	
	@Override
	protected void setUp() throws Exception
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		fachada.reiniciar();
		
		super.setUp();
	}

	/***
	 * Criação da primeira sala de jogo sem senha
	 */
	public void testeUC02_R002_C001()
	{		
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador("Jogador 1");
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		parametros.setJogador(jogador);
		
		parametros.setSenha("Senha");
		
		fachada.criarSalaJogo(parametros);
		
		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 1;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
		
		Iterator<SalaJogo> salasJogo = fachada.obterSalasJogo();
		
		SalaJogo salaJogo = salasJogo.next();
		
		assertTrue(salaJogo.possuiSenha());
	}
	
	/***
	 * Criação de uma sala de jogo sem senha senha
	 */
	public void testeUC02_R002_C002()
	{
		
		//Estado inicial
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador("Jogador 2");
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		parametros.setJogador(jogador);
		
		fachada.criarSalaJogo(parametros);
		
		//Estado inicial
		
		

		parametros.setSenha("Senha");
		
		fachada.criarSalaJogo(parametros);

		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 2;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
		
		
		Iterator<SalaJogo> salasJogo = fachada.obterSalasJogo();
		
		SalaJogo salaJogo1 = salasJogo.next();
		
		SalaJogo salaJogo2 = salasJogo.next();
		
		assertTrue(salaJogo2.possuiSenha());
		
		
		
	}
}

package br.upe.war.testes.testeUC02;




import java.util.Iterator;

import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;
import br.upe.war.negocio.salajogos.SalaJogo;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TesteUC02_R001 extends TestCase
{
	
	@Override
	protected void setUp() throws Exception
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		fachada.reiniciar();
		
		super.setUp();
	}



	public void testeUC02_R001_C001()
	{		
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador();
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		parametros.setJogador(jogador);
		
		fachada.criarSalaJogo(parametros);
		
		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 1;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
		
		Iterator<SalaJogo> salasJogo = fachada.obterSalasJogo();
		
		SalaJogo salaJogo = salasJogo.next();
		
		assertFalse(salaJogo.possuiSenha());
	}
	
	public void testeUC02_R001_C002()
	{
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador();
		
		String senha = "Senha_UC02_R001_C002";
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		parametros.setJogador(jogador);
		
		parametros.setSenha(senha);
		
		fachada.criarSalaJogo(parametros);

		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 1;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
		
		Iterator<SalaJogo> salasJogo = fachada.obterSalasJogo();
		
		SalaJogo salaJogo = salasJogo.next();
		
		assertTrue(salaJogo.possuiSenha());
		
	}
	
	public void testeUC02_R001_C003()
	{
		
		//Estado inicial
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		Jogador jogador = new Jogador();
		
		String senha = "Senha_UC02_R001_C002";
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		parametros.setJogador(jogador);
		
		parametros.setSenha(senha);
		
		fachada.criarSalaJogo(parametros);
		
		//Estado inicial
		
		

		fachada.criarSalaJogo(parametros);

		int quantidadeSalas = fachada.obterSalasJogoCount();
		int quantidadeSalasEsperada = 2;
		
		Assert.assertEquals(quantidadeSalasEsperada, quantidadeSalas);
		
		
		
		
	}
}

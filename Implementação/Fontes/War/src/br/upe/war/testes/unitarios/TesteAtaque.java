package br.upe.war.testes.unitarios;

import junit.framework.TestCase;
import br.upe.war.negocio.ataques.Ataque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class TesteAtaque extends TestCase
{
	private Territorio territorioAtacante;
	
	private Territorio territorioDefensor;

	private Ataque ataque;
	
	private Jogador jogadorAtacante;
	
	@Override
	protected void setUp() throws Exception 
	{
		this.jogadorAtacante = new Jogador("Jogador 1");		
		this.territorioAtacante = new Territorio(1, "Territorio 1");
		this.territorioAtacante.setQuantidadeExercito(3);
		this.territorioAtacante.setDominante(this.jogadorAtacante);
		
		Jogador jogadorDefensor = new Jogador("Jogador 2");
		this.territorioDefensor = new Territorio(2, "Territorio 2");
		this.territorioDefensor.setDominante(jogadorDefensor);
		this.territorioDefensor.setQuantidadeExercito(3);
		
		this.ataque = new Ataque(this.territorioAtacante, territorioDefensor);
		
		
		this.ataque.setQuantidadeExercitos(2);
		
		super.setUp();
	}
	
	public void testeAtaqueTerritoriosIguais() throws WarException
	{		
		try 
		{
			
			Ataque novoAtaque = new Ataque(this.territorioAtacante, this.territorioAtacante);
			
			fail("Não deve ser possível um ataque ao mesmo território");
		} 
		catch (WarValidationException e)
		{
			e.existe(MensagemErro.ATAQUE_TERRITORIOS_IGUAIS);
		}
	
	}
	
	public void testePovoamentoUtilizandoTodosExercitos()
	{		
		try 
		{			
			
			ParametrosPovoarTerritorioConquistado parametros = new ParametrosPovoarTerritorioConquistado(null, this.jogadorAtacante, 3);
			
			this.ataque.povoarTerritorioConquistado(parametros);
			
			fail("Não deve ser possível utilizar TODOS os exércitos no povoamento");
		} 
		catch(WarValidationException e)
		{
			assertTrue(e.existe(MensagemErro.POVOAMENTO_UTILIZOU_TODOS_EXERCITOS));
		}
	}
	
	public void testePovoamentoSemTerritorioOcupacaoDestino()
	{		
		try 
		{			
			ParametrosPovoarTerritorioConquistado parametros = new ParametrosPovoarTerritorioConquistado(null, this.jogadorAtacante, 0);
			
			this.ataque.povoarTerritorioConquistado(parametros);
			
			fail("Deve ser deslocado ao menos UM exércitos no povoamento");
		} 
		catch(WarValidationException e)
		{
			assertEquals(1, e.quantidade());
			assertTrue(e.existe(MensagemErro.EXERCITO_OCUPACAO_NAO_DESLOCADO));
			
		}
	}
	
	public void testePovoamentoAlterarTerritorioDominante()
	{		
		try 
		{			
			ParametrosPovoarTerritorioConquistado parametros = new ParametrosPovoarTerritorioConquistado(null, this.jogadorAtacante, 2);
			
			this.ataque.povoarTerritorioConquistado(parametros);
		
			assertEquals(this.territorioAtacante.getDominante(), this.territorioDefensor.getDominante());
		
		} catch (WarException e)
		{
			fail("Povoamento deve ser permitido");
		}
	}
}

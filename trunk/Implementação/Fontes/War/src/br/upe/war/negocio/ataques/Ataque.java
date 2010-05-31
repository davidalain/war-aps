package br.upe.war.negocio.ataques;

import java.util.ArrayList;

import br.upe.war.negocio.dados.Dado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.Mensagens;

public class Ataque 
{
	private ArrayList<Dado> dadosAtaque;
	
	private ArrayList<Dado> dadosDefesa;
	
	private Territorio territorioAtacante;
	
	private Territorio territorioDefensor;
	
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		int quantidadeExercitoDeslocada = parametros.getQuantidadeExercito();
		
		//RNG03
		if(!aoMenosUmTerritorioUtilizado(quantidadeExercitoDeslocada))
		{
			throw new WarException(Mensagens.EXERCITO_OCUPACAO_NAO_DESLOCADO);
		}
		
		//RNG03
		if(!permaneceraTerritorioOcupacao(quantidadeExercitoDeslocada))
		{
			throw new WarException(Mensagens.EXERCITO_OCUPACAO_INEXISTENTE);
		}
		
		//RN07 do UC11
		if(!exercitosDeslocadosIgualNoMaximoDadosAtaque(quantidadeExercitoDeslocada))
		{
			throw new WarException(Mensagens.POVOAMETO_SUPERIOR_DADOS_ATAQUE);
		}
		
		this.territorioDefensor.setDominante(this.territorioAtacante.getDominante());
		
		this.territorioAtacante.removeExercito(quantidadeExercitoDeslocada);
		
		this.territorioDefensor.addExercito(quantidadeExercitoDeslocada);
	
	}
	
	public boolean exercitosDeslocadosIgualNoMaximoDadosAtaque(int quantidade)
	{
		return this.dadosAtaque.size() >= quantidade;
	}
	
	public boolean permaneceraTerritorioOcupacao(int quantidade)
	{
		int quantidadeExercitosTerritorioAtaque = this.territorioAtacante.getQuantidadeExercito();
		
		return (quantidadeExercitosTerritorioAtaque - quantidade) > 0;
	}
	
	public boolean aoMenosUmTerritorioUtilizado(int quantidade)
	{
		return quantidade > 0;
	}
}

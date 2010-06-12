package br.upe.war.negocio.ataques;

import java.util.ArrayList;

import br.upe.war.negocio.dados.Dado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class Ataque 
{
	private ArrayList<Dado> dadosAtaque;
	
	private ArrayList<Dado> dadosDefesa;
	
	private Territorio territorioAtacante;
	
	private Territorio territorioDefensor;
	
	public Ataque(Territorio territorioAtacante, Territorio territorioDefensor) throws WarException
	{
		WarValidationException wve = new WarValidationException();
		
		wve.<Territorio>compararDiferentes(territorioAtacante, territorioDefensor, MensagemErro.ATAQUE_TERRITORIOS_IGUAIS);

		wve.validar();
		
		this.territorioAtacante = territorioAtacante;
		this.territorioDefensor = territorioDefensor;
		
	}
	
	public void setQuantidadeExercitos(int quantidadeExercitos) throws WarValidationException
	{
		WarValidationException wve = new WarValidationException();
		
		//RNG03
		wve.comparar(true, permaneceraTerritorioOcupacao(quantidadeExercitos), MensagemErro.ATAQUE_UTILIZOU_TODOS_EXERCITOS);
		
		wve.comparar(true, validarQuantidadeExercitosAtaque(quantidadeExercitos), MensagemErro.ATAQUE_EXERCITOS_INCORRETOS);
		
		wve.validar();
	
		this.dadosAtaque = new ArrayList<Dado>();
		for (int i = 0; i < quantidadeExercitos ; i++) 
		{
			this.dadosAtaque.add(new Dado());
		}
	}
	private boolean validarQuantidadeExercitosAtaque(int numeroExercitos) 
	{
		return numeroExercitos <= 3 && numeroExercitos > 0;
	}
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarValidationException
	{
		int quantidadeExercitoDeslocada = parametros.getQuantidadeExercito();
		
		WarValidationException wve = new WarValidationException();
		
		//RNG03
		wve.comparar(true, aoMenosUmTerritorioUtilizado(quantidadeExercitoDeslocada), MensagemErro.EXERCITO_OCUPACAO_NAO_DESLOCADO);
		
		
		//RNG03
		wve.comparar(true, permaneceraTerritorioOcupacao(quantidadeExercitoDeslocada), MensagemErro.POVOAMENTO_UTILIZOU_TODOS_EXERCITOS);
		
		
		//RN07 do UC11
		wve.comparar(true, exercitosDeslocadosIgualNoMaximoDadosAtaque(quantidadeExercitoDeslocada), MensagemErro.POVOAMETO_SUPERIOR_DADOS_ATAQUE);
		
		wve.<Jogador>compararIguais(this.territorioAtacante.getDominante(), parametros.getJogador(), MensagemErro.JOGADOR_DEVE_SER_ATACANTE);
		
		wve.validar();
		
		this.territorioDefensor.setDominante(this.territorioAtacante.getDominante());
		
		this.territorioAtacante.removeExercito(quantidadeExercitoDeslocada);
		
		this.territorioDefensor.addExercito(quantidadeExercitoDeslocada);
	
	}
	
	private boolean exercitosDeslocadosIgualNoMaximoDadosAtaque(int quantidade)
	{
		return (this.dadosAtaque != null && this.dadosAtaque.size() >= quantidade);
	}
	
	
	private boolean permaneceraTerritorioOcupacao(int quantidade)
	{
		int quantidadeExercitosTerritorioAtaque = this.territorioAtacante.getQuantidadeExercito();
		
		return (quantidadeExercitosTerritorioAtaque - quantidade) > 0;
	}
	
	private boolean aoMenosUmTerritorioUtilizado(int quantidade)
	{
		return quantidade > 0;
	}

	public Territorio[] atacar() {
		Territorio[] retorno = new Territorio[2];
		
		int[] resultadosAtaque = new int[3];
		int i = 0;
		for(Dado d : this.dadosAtaque){
			resultadosAtaque[i] = d.rolar();
			i++;
		}
		
		int[] resultadosDefesa = {0, 0, 0};
		/*int j = 0;
		for(Dado d : this.dadosDefesa){
			resultadosDefesa[j] = d.rolar();
			j++;
		}*/
		
		int countAtaque = 0;
		int countDefesa = 0;
		for(i=0; i<3; i++){
			if(resultadosAtaque[i] > resultadosDefesa[i])
				countAtaque++;
			else
				countDefesa++;
		}
	
		this.territorioDefensor.setQuantidadeExercito(this.territorioDefensor.getQuantidadeExercito()-countAtaque);
		this.territorioAtacante.setQuantidadeExercito(this.territorioAtacante.getQuantidadeExercito()-countDefesa);
		
		retorno[0] = this.territorioAtacante;
		retorno[1] = this.territorioDefensor;
		
		return retorno;
	}
}

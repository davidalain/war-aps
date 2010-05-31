package br.upe.war.apresentacao;


import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.fases.FaseAtaque;
import br.upe.war.negocio.fases.FaseRecebimentoExercitos;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.jogos.Jogo;


public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		FaseRecebimentoExercitos faseRecebimento = new FaseRecebimentoExercitos();
		
		int quantidadeExercitos = 1;
		
		ParametrosPovoarTerritorioConquistado parametros = new ParametrosPovoarTerritorioConquistado(new Jogo(), new Jogador(),quantidadeExercitos);
		
		try 
		{
			fachada.povoarTerritorioConquistado(parametros);
			
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		


	}

}

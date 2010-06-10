package br.upe.war.negocio.objetivos;

import java.util.ArrayList;

import br.upe.war.negocio.jogadores.Jogador;

public class FabricaObjetivos {

	private static ArrayList<Objetivo> listaCompleta = new ArrayList<Objetivo>(14);
	
	private static FabricaObjetivos instance = null;
	
	private FabricaObjetivos(){
		listaCompleta.add(new DestruirExercitoPreto());
		listaCompleta.add(new DestruirExercitoAzul());
		listaCompleta.add(new DestruirExercitoVerde());
		listaCompleta.add(new DestruirExercitoAmarelo());
		listaCompleta.add(new DestruirExercitoVermelho());
		listaCompleta.add(new DestruirExercitoBranco());
		listaCompleta.add(new Conquistar24Territorios());
		listaCompleta.add(new ConquistarAmericaNorteEOceania());
		listaCompleta.add(new ConquistarAmericaNorteEAfrica());
		listaCompleta.add(new ConquistarAsiaEAfrica());
		listaCompleta.add(new Conquistar18TerritoriosCom2());
		listaCompleta.add(new ConquistarAmericaSulEuropaMaisUm());
		listaCompleta.add(new ConquistarAmericaSulEAsia());
		listaCompleta.add(new ConquistarEuropaOceaniaMaisUm());
	}
	
	public static FabricaObjetivos getInstance(){
		if(instance == null)
		{
			instance = new FabricaObjetivos();
		}
		return instance;
		
	}
	
	public  ArrayList<Objetivo> getPossiveisObjetivos( ArrayList<Jogador> jogadores) {	
		if(jogadores.size() == 6)
			return listaCompleta;
		else{
			ArrayList<Objetivo> retorno = new ArrayList<Objetivo>();
			boolean[] corExiste = {false, false, false, false, false, false};
			
			for(Jogador j : jogadores)
			{
				corExiste[j.getCor()-1] = true;
			}
			
			for(Objetivo o : listaCompleta){
				if(o instanceof DestruirExercitoAzul && !corExiste[0])
					continue;
				if(o instanceof DestruirExercitoVerde && !corExiste[1])
					continue;
				if(o instanceof DestruirExercitoVermelho && !corExiste[2])
					continue;
				if(o instanceof DestruirExercitoBranco && !corExiste[3])
					continue;
				if(o instanceof DestruirExercitoPreto && !corExiste[4])
					continue;
				if(o instanceof DestruirExercitoAmarelo && !corExiste[5])
					continue;
				
				retorno.add(o);
			}
			return retorno;
			
		}
		
		
		
	}
	
	
	
}

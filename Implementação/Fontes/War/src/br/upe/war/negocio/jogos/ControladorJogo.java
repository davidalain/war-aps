package br.upe.war.negocio.jogos;

import java.util.ArrayList;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;

public class ControladorJogo {
	private ArrayList<Jogo> jogos;
	private static ControladorJogo instance;
	
	public synchronized static ControladorJogo getInstance(){
		if(instance == null)
			instance = new ControladorJogo();
		
		return instance;
	}

	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado paramentros){
		
	}
}

package br.upe.war.negocio.jogos;

import java.util.ArrayList;
import java.util.HashMap;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.util.MensagemErro;

public class ControladorJogo {
	private ArrayList<SalaJogo> jogos;
	private static ControladorJogo instance;

	public synchronized static ControladorJogo getInstance(){
		if(instance == null)
			instance = new ControladorJogo();

		return instance;
	}
	
	private ControladorJogo()
	{
		this.jogos = new ArrayList<SalaJogo>();
	}

	
	
	
	
	

	

	public void removerTodos() {
		this.jogos.clear();
	}
}

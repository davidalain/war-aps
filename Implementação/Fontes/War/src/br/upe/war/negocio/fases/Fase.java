package br.upe.war.negocio.fases;

import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.territorios.Territorio;

public abstract class Fase {
	
	public abstract void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException;
	
	public abstract Territorio[] atacar(ParametrosAtaque parametros) throws WarException;
	
}

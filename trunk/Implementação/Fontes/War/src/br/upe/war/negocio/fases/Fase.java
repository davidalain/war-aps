package br.upe.war.negocio.fases;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;

public abstract class Fase {
	
	public abstract void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException;
	
}

package br.upe.war.negocio.fases;

import br.upe.war.negocio.ataques.Ataque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.util.Mensagens;

public class FaseAtaque extends Fase 
{
	
	private Ataque ataque;

	@Override
	public void povoarTerritorioConquistado(
			ParametrosPovoarTerritorioConquistado parametros)
			throws WarException {

		if(this.ataque == null)
		{
			throw new WarException(Mensagens.ATAQUE_INEXISTENTE);
		}
		this.ataque.povoarTerritorioConquistado(parametros);
		
	}

}

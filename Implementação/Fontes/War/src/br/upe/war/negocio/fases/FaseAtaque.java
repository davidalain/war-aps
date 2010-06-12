package br.upe.war.negocio.fases;

import br.upe.war.negocio.ataques.Ataque;
import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class FaseAtaque extends Fase 
{
	
	private Ataque ataque;

	@Override
	public void povoarTerritorioConquistado(
			ParametrosPovoarTerritorioConquistado parametros)
			throws WarException {

		if(this.ataque == null)
		{
			throw new WarException(MensagemErro.ATAQUE_INEXISTENTE);
		}
		this.ataque.povoarTerritorioConquistado(parametros);
		
	}

	@Override
	public Territorio[] atacar(ParametrosAtaque parametros) throws WarException {
		this.ataque = new Ataque(parametros.getAtacante(), parametros.getDefensor());
		this.ataque.setQuantidadeExercitos(parametros.getQuantidadeExercito());
		return this.ataque.atacar();
	}

}

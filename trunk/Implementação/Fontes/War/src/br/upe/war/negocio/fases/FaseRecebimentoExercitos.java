package br.upe.war.negocio.fases;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.util.MensagemErro;

public class FaseRecebimentoExercitos extends Fase {

	@Override
	public void povoarTerritorioConquistado(
			ParametrosPovoarTerritorioConquistado parametros) throws WarException {
		throw new WarException(MensagemErro.POVOAR_FASE_RECEBIMENTO);
		
	}

}

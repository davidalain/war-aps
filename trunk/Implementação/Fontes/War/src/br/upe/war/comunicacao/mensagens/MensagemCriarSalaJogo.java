package br.upe.war.comunicacao.mensagens;

import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.salajogos.ParametrosCriarSalaJogo;

public class MensagemCriarSalaJogo extends Mensagem 
{
	private String enderecoServidor;
	
	
	
	@Override
	public void tratarMensagem() 
	{
		FachadaWar fachada = FachadaWar.getInstance();
		
		ParametrosCriarSalaJogo parametros = new ParametrosCriarSalaJogo();
		
		fachada.criarSalaJogo(parametros);
	}

}

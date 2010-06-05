package br.upe.war.comunicacao.mensagens;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.negocio.comum.FachadaWar;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.salajogos.SalaJogo;

public class MensagemIniciarJogo extends Mensagem 
{
	private SalaJogo salaJogo;
	
	@Override
	public void tratarMensagem() throws WarException 
	{
		
		FachadaWar fachada = FachadaWar.getInstance();
		
		fachada.iniciarJogo(salaJogo);
		
		
		ControladorComunicacao comunicacao = ControladorComunicacao.getInstance();
		
		MensagemEscolherCorTerritorio m = new MensagemEscolherCorTerritorio();
		
		comunicacao.enviarMensagem(m);

	}

}

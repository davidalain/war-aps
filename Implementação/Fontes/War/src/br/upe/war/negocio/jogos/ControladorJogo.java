package br.upe.war.negocio.jogos;

import java.util.ArrayList;
import java.util.HashMap;

import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.salajogos.SalaJogo;
import br.upe.war.negocio.util.Mensagens;

public class ControladorJogo {
	private ArrayList<Jogo> jogos;
	private static ControladorJogo instance;

	public synchronized static ControladorJogo getInstance(){
		if(instance == null)
			instance = new ControladorJogo();

		return instance;
	}
	
	private ControladorJogo()
	{
		this.jogos = new ArrayList<Jogo>();
	}

	
	
	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		if(!existeJogo(parametros.getJogo()))
		{
			throw new WarException(Mensagens.JOGO_NAO_CADASTRADO);
		}
		
		Jogo jogo = this.jogos.get(this.jogos.indexOf(parametros.getJogo()));
		
		jogo.povoarTerritorioConquistado(parametros);		
		
	}
	
	public boolean existeJogo(Jogo jogo)
	{
		return this.jogos.contains(jogo);
	}

	public void iniciar(SalaJogo salaJogo)
	{
		int proximoJogoId = this.jogos.size();
		
		Jogo novoJogo = new Jogo(salaJogo);
	}

	public void removerTodos() {
		this.jogos.clear();
	}
}

package br.upe.war.negocio.salajogos;

import java.util.ArrayList;
import java.util.Iterator;

import br.upe.war.negocio.ataques.ParametrosAtaque;
import br.upe.war.negocio.ataques.ParametrosPovoarTerritorioConquistado;
import br.upe.war.negocio.excecoes.WarException;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;
import br.upe.war.negocio.objetivos.Objetivo;
import br.upe.war.negocio.territorios.Territorio;
import br.upe.war.negocio.util.MensagemErro;

public class ControladorSalaJogo 
{
	private static ControladorSalaJogo instance;
	
	private ArrayList<SalaJogo> salasJogo;
		
	private ControladorSalaJogo()
	{
		this.salasJogo = new ArrayList<SalaJogo>();
	}
	
	public synchronized static ControladorSalaJogo getInstance()
	{
		if(instance == null)
		{
			instance = new ControladorSalaJogo();
		}
		return instance;
	}

	public int obterCount()
	{
		return this.salasJogo.size();
	}

	public void criarSalaJogo(ParametrosCriarSalaJogo parametros) throws WarValidationException 
	{
		
		SalaJogo novaSalaJogo = new SalaJogo(parametros);
		
		this.salasJogo.add(novaSalaJogo);
		
	}

	public Iterator<SalaJogo> obter() 
	{
	
		return this.salasJogo.iterator();
		
		
	}
	
	public void validarNaoExisteSalaJogo(SalaJogo jogo) throws WarException
	{
		if(this.salasJogo.contains(jogo))
		{
			throw new WarException(MensagemErro.SALA_JOGO_EXISTENTE);
		}
	}

	public void povoarTerritorioConquistado(ParametrosPovoarTerritorioConquistado parametros) throws WarException
	{
		
		SalaJogo salaJogo = this.salasJogo.get(this.salasJogo.indexOf(parametros.getSalaJogo()));
		
		salaJogo.povoarTerritorioConquistado(parametros);		
		
	}
	
	public void iniciarJogo(String nomeSalaJogo, String loginJogador) throws WarException
	{
		SalaJogo s = this.getSala(nomeSalaJogo);
		Jogador criador = s.getCriador();
		
		if(criador.getLogin().equals(loginJogador))
			s.iniciarJogo();
		else
			new WarException(MensagemErro.JOGADOR_NAO_CRIADOR);
			
	}
	
	public void removerTodas() 
	{
		this.salasJogo.clear();
	}

	public void entrarSalaJogo(Jogador jogador, String nomeSalaJogo) {
		SalaJogo sala = this.getSala(nomeSalaJogo);
		sala.addJogador(jogador);
		
	}

	public SalaJogo getSala(String nomeSalaJogo) {

		for(SalaJogo s : this.salasJogo){
			if(s.getNomeSala().equals(nomeSalaJogo))
				return s;
		}
		return null;
	}

	public Iterator<Territorio> obterTerritorios(String nomeSalaJogo) {
		SalaJogo s = this.getSala(nomeSalaJogo);
		return s.obterTerritorios();
	}

	public void atacarTerritorio(ParametrosAtaque parametros) throws WarException {
		SalaJogo s = this.getSala(parametros.getSalaJogo().getNomeSala());
		s.atacarTerritorio(parametros);
		
	}

	public Iterator<Objetivo> obterObjetivos(String nomeSalaJogo) {
		SalaJogo s = this.getSala(nomeSalaJogo);
		return s.obterObjetivos();
	}

	public Iterator<Jogador> obterJogadores(String nomeSalaJogo) {
		SalaJogo s = this.getSala(nomeSalaJogo);
		return s.obterJogadores();
	}

}

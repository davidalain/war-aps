package br.upe.war.negocio.excecoes;

public class WarException extends Exception 
{
	public WarException(String mensagem)
	{
		super(mensagem);
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if(o instanceof WarException)
		{
			WarException e = (WarException)o;
			
			return this.getMessage().equals(e.getMessage());
		}
		return false;
	}
}

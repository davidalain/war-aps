package br.upe.war.negocio.excecoes;

import java.util.ArrayList;
import java.util.Iterator;

public class WarValidationException extends WarException
{
	private ArrayList<WarException> errors;
	
	public WarValidationException()
	{
		super(WarException.class.getName());
		this.errors = new ArrayList<WarException>();
	}
	
	public int quantidade()
	{
		return this.errors.size();
	}
	
	public void comparar(boolean esperado, boolean atual, String mensagem)
	{
		if(esperado != atual)
		{
			this.errors.add(new WarException(mensagem));
		}
	}
	
	public <T> void compararIguais (T a, T b, String mensagem)
	{
		if(!a.equals(b))
		{
			this.errors.add(new WarException(mensagem));
		}
	}
	
	public <T> void compararDiferentes (T a, T b, String mensagem)
	{
		if(a.equals(b))
		{
			this.errors.add(new WarException(mensagem));
		}
	}
	
	public void validar() throws WarValidationException
	{
		if(this.quantidade() > 0)
		{
			throw this;
		}
	}
	
	public Iterator<WarException> mostrarErros()
	{
		return this.errors.iterator();
	}
	
	public boolean existe(WarException erro)
	{
		return this.errors.contains(erro);
	}
	
	public boolean existe(String erro)
	{
		return existe(new WarException(erro));
	}
}

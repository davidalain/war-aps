package br.upe.war.negocio.dados;

import java.util.Random;

public class Dado 
{
	public int rolar()
	{
		return new Random().nextInt(5) + 1;
	}
}

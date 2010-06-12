package br.upe.war.negocio.grafo;

import java.io.Serializable;

public abstract class Vertice implements Serializable{
		
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id;
	
		public Vertice(int id)
		{
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
		
		boolean equals(Vertice v)
		{
			if(this.id == v.getId())
				return true;
			else
				return false;
		}
		
		@Override
		public boolean equals(Object o)
		{
			if(o instanceof Vertice)
			{
				Vertice v = (Vertice)o;
				return this.id == v.id;
			}
			return false;
		}
}

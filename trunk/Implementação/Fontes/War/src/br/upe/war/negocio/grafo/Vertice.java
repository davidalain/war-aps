package br.upe.war.negocio.grafo;

public abstract class Vertice {
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

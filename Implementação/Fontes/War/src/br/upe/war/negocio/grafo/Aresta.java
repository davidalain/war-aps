package br.upe.war.negocio.grafo;

public interface Aresta {
	 Vertice inicio();
	 Vertice fim();
	 boolean equals(Aresta a);
}

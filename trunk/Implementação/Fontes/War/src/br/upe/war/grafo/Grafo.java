package br.upe.war.grafo;

import java.util.List;

public interface Grafo {
	int numeroV();
	boolean ehOrientado();
	List<Aresta> linkedTo(Vertice v);
	List<Aresta> linkedFrom(Vertice v);
}

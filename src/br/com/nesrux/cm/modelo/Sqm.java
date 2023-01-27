package br.com.nesrux.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sqm {
	private final int linha;
	private final int coluna;

	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	// Auto relacionamento, um relacionamento de 1 para n
	// Com sigo mesmo
	private List<Sqm> vizinhos = new ArrayList<>();

	Sqm(int linha, int coluna) {
		this.coluna = coluna;
		this.linha = linha;
	}
	
	boolean addVizinho(Sqm vizinho) {
		return true;
	}

}

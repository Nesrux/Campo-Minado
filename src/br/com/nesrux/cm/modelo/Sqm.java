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

	public Sqm(int linha, int coluna) {
		this.coluna = coluna;
		this.linha = linha;
	}

	public boolean addVizinho(Sqm vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
	}

}

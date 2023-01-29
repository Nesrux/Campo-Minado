package br.com.nesrux.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private int minas;

	private final List<Sqm> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		gerarCampo();
		associarVizinhos();
		sortearMinas();
	}

	private void gerarCampo() {
		for (int li = 0; li < linhas; li++) {
			for (int co = 0; co < colunas; co++) {
				campos.add(new Sqm(li, co));
			}

		}
	}

	private void associarVizinhos() {
		for (Sqm c1 : campos) {
			for (Sqm c2 : campos) {
				c1.addVizinho(c2);
			}
		}
	}

	private void sortearMinas() {
	}

}

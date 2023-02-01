package br.com.nesrux.cm.modelo;

public class ResultadoDoEvento {
	private final boolean ganhou;

	public ResultadoDoEvento(boolean ganhou) {
		this.ganhou = ganhou;
	}

	public boolean isGanhou() {
		return ganhou;
	}

}

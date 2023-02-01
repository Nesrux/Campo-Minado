package br.com.nesrux.cm.visao;

import br.com.nesrux.cm.modelo.Tabuleiro;

public class Temp {
	public static void main(String[] args) {

		Tabuleiro t = new Tabuleiro(3, 3, 0);
		t.registrarObservador(e -> {
			if (e.isGanhou()) {
				System.out.println("ganhou!");
			} else {
				System.out.println("Perdeu!");
			}
		});
		
		t.abrir(0, 0);

	}
}
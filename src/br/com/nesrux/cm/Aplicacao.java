package br.com.nesrux.cm;

import br.com.nesrux.cm.modelo.Tabuleiro;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro jogon = new Tabuleiro(6, 6, 3);
		jogon.abrir(3, 3);
		jogon.marcar(2, 2);
		jogon.marcar(2, 3);
		System.out.println(jogon);
	}

}

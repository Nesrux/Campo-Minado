package br.com.nesrux.cm;

import br.com.nesrux.cm.modelo.Tabuleiro;
import br.com.nesrux.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro jogon = new Tabuleiro(10, 10, 20);
		new TabuleiroConsole(jogon);
	}

}

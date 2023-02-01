package br.com.nesrux.cm.visao;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.nesrux.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		int total = tabuleiro.getLinhas() * tabuleiro.getColunas();
		for (int i = 0; i < total; i++) {
			add(new JButton());

		}
	}
}

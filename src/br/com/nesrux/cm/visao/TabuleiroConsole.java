package br.com.nesrux.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.nesrux.cm.excecao.ExplosaoException;
import br.com.nesrux.cm.excecao.SairExeception;
import br.com.nesrux.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;

			while (continuar) {
				cicloDoJogo();
				System.out.println("Outra partida? (S/n) ");
				String resposta = entrada.nextLine();

				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}

		} catch (SairExeception e) {
			System.out.println("Obrigado Por jogar");
		} finally {
			entrada.close();
		}

	}

	private void cicloDoJogo() {
		try {
			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);

				String digitado = capturarValorDigitado("Digite (X, Y): ");
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim()))
						.iterator();
				System.out.println(xy.next());
				System.out.println(xy.next());
			}
			System.out.println("voce ganhou !");
		} catch (ExplosaoException e) {
			System.out.println("Voce Perdeu!");
		}

	}

	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();

		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairExeception();
		}
		return digitado;
	}
}

package br.com.nesrux.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoObservador {
	private int linhas;
	private int colunas;
	private int minas;

	private final List<Sqm> campos = new ArrayList<>();
	private final List<Consumer<ResultadoDoEvento>> observadores = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		gerarCampo();
		associarVizinhos();
		sortearMinas();
	}

	public void registrarObservador(Consumer<ResultadoDoEvento> observador) {
		observadores.add(observador);
	}

	public void notificarObservadores(boolean resultado) {
		observadores.stream().forEach(o -> o.accept(new ResultadoDoEvento(resultado)));
	}

	public void abrir(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(c -> c.abrir());
	}

	private void mostrarMinas() {
		campos.stream().filter(c -> c.isMinado()).forEach(c -> c.setAberto(true));
	}

	public void marcar(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(c -> c.alternarMarcacao());
	}

	private void gerarCampo() {
		for (int li = 0; li < linhas; li++) {
			for (int co = 0; co < colunas; co++) {
				Sqm campo = new Sqm(li, co);
				campo.registrarObservador(this);
				campos.add(campo);
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
		long minasArmadas = 0;
		Predicate<Sqm> minado = c -> c.isMinado();
		do {

			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();

		} while (minasArmadas < minas);
	}

	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

	@Override
	public void eventoOcorreu(Sqm campo, CampoEvento evento) {
		if (evento == CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);
		} else if (objetivoAlcancado()) {
			notificarObservadores(true);
		}

	}
}

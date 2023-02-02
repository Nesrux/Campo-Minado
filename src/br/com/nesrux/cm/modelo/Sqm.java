package br.com.nesrux.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sqm {
	private final int linha;
	private final int coluna;

	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	private List<Sqm> vizinhos = new ArrayList<>();
	private List<CampoObservador> observadores = new ArrayList<>();

	// Construtor
	public Sqm(int linha, int coluna) {
		this.coluna = coluna;
		this.linha = linha;
	}

	// Getters and setters
	public boolean isMarcado() {
		return marcado;
	}

	public boolean isAberto() {
		return aberto;
	}

	public boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public boolean isMinado() {
		return minado;
	}

	// Método que adiciona vizinhos dentro do jogo
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
		} else {
			return false;
		}
	}

	// Método que abre um SQM dentro do jogo
	public boolean abrir() {
		if (!aberto && !marcado) {

			if (minado) {
				notificarObservadores(CampoEvento.EXPLODIR);
				return true;
			}
			setAberto(true);

			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
			return false;
		}

	}

	void setAberto(boolean aberto) {
		this.aberto = aberto;

		if (aberto) {
			notificarObservadores(CampoEvento.ABRIR);
		}
	}

	// Método que abre os Sqm's próximos até encontrar lugares possiveis e minados
	public boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}

	 public int minasNaVizinhanca() {
		return (int) vizinhos.stream().filter(v -> v.minado).count();
	}

	public void registrarObservador(CampoObservador observador) {
		observadores.add(observador);
	}

	// Método que troca a marcação dos lugares que nao foram abertos
	public void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;

			if (marcado) {
				notificarObservadores(CampoEvento.MARCAR);
			} else {
				notificarObservadores(CampoEvento.DESMACAR);
			}
		}
	}

	// Método que coloca minas dentro dos SQM
	public void minar() {
		if (!minado) {
			minado = true;
		}
	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
		notificarObservadores(CampoEvento.REINICIAR);
	}

	private void notificarObservadores(CampoEvento evento) {
		observadores.forEach(obs -> obs.eventoOcorreu(this, evento));

	};

}

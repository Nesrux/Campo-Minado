package br.com.nesrux.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.nesrux.cm.modelo.Sqm;

class TesteCampo {
	private Sqm campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Sqm(3, 3);
	}

	@Test
	void testeVizinhoDistanciaEsquerda() {
		Sqm vizinho = new Sqm(3, 2);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistanciaDireita() {
		Sqm vizinho = new Sqm(3, 4);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistanciaEmCima() {
		Sqm vizinho = new Sqm(2, 3);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistanciaEmBaixo() {
		Sqm vizinho = new Sqm(4, 2);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistanciaDiagonal() {
		Sqm vizinho = new Sqm(2, 2);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinho() {
		Sqm vizinho = new Sqm(9, 5);
		boolean resultado = campo.addVizinho(vizinho);
		assertFalse(resultado);
	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeValorPadraoAtributoMarcadoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}



	@Test
	void testeAbrirComVizinho() {
		Sqm vizinho1 = new Sqm(2, 2);
		Sqm vizinhoDoVizinho2 = new Sqm(1, 1);
		vizinho1.addVizinho(vizinhoDoVizinho2);

		campo.addVizinho(vizinho1);

		campo.abrir();
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho2.isAberto());
	}

	void testeAbrirComVizinho2() {
		Sqm campo11 = new Sqm(1,1);
		Sqm campo12 = new Sqm(1,1);
		campo12.minar();
		
		Sqm campo22 = new Sqm(2,2);
		campo22.addVizinho(campo12);
		campo22.addVizinho(campo11);
		
		campo.addVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
		
	}

}

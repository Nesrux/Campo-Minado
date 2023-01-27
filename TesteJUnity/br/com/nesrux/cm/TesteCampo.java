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
}

package br.com.nesrux.cm.modelo;

@FunctionalInterface
public interface CampoObservador {

	public void eventoOcorreu(Sqm campo, CampoEvento evento);
}

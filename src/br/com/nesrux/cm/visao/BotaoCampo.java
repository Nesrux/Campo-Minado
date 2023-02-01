package br.com.nesrux.cm.visao;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.nesrux.cm.modelo.CampoEvento;
import br.com.nesrux.cm.modelo.CampoObservador;
import br.com.nesrux.cm.modelo.Sqm;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador {
	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCAR = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);

	private Sqm campo;

	public BotaoCampo(Sqm campo) {
		this.campo = campo;

		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		
		campo.registrarObservador(this);
	}

	@Override
	public void eventoOcorreu(Sqm campo, CampoEvento evento) {
		switch (evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCAR:
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
		default:
			aplicarEstiloPadreao();
		}
	}

	private void aplicarEstiloExplodir() {
		// TODO Auto-generated method stub

	}

	private void aplicarEstiloPadreao() {
		// TODO Auto-generated method stub

	}

	private void aplicarEstiloAbrir() {
		// TODO Auto-generated method stub

	}

	private void aplicarEstiloMarcar() {
		// TODO Auto-generated method stub

	}

}

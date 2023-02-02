package br.com.nesrux.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.nesrux.cm.modelo.CampoEvento;
import br.com.nesrux.cm.modelo.CampoObservador;
import br.com.nesrux.cm.modelo.Sqm;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCAR = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);

	private Sqm campo;

	public BotaoCampo(Sqm campo) {
		this.campo = campo;

		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));

		addMouseListener(this);
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
		setBackground(BG_EXPLODIR);
		setText("X");
	}

	private void aplicarEstiloPadreao() {
		setBackground(BG_PADRAO);
		setText("");

	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setText("M");
	}

	private void aplicarEstiloAbrir() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		switch (campo.minasNaVizinhanca()) {
		case 1:
			setForeground(TEXTO_VERDE);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
		case 4:
		case 5:
		case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
		}
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
		setText(valor);
	}

	// Interface dos enventos do maouse
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			campo.abrir();
		} else {
			campo.alternarMarcacao();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

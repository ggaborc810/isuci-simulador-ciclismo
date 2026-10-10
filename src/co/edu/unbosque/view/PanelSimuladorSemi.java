package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.sort.CiclistaTiempoAcumuladoComparator;

public class PanelSimuladorSemi extends JPanel {

	private Properties propertiesInfoV;

	private JProgressBar[] progresoBarra;
	private Thread[] ciclistaHilos;
	private int numCiclistas = 6;
	private int carreraDistancia = 100;

	private JLabel lblTitulo;
	private JLabel lblVolver;
	private JLabel lblIniciar;
	private JLabel lblImagenLogo1;
	private JLabel lblImagenLogo2;

	private JLabel lblC1;
	private JLabel lblC2;
	private JLabel lblC3;
	private JLabel lblC4;
	private JLabel lblC5;
	private JLabel lblC6;

	private JButton btnVolver;
	private JButton btnIniciar;
	private JButton btnOrdenarTiempos;

	private long[] tiempos;
	private JTextArea txtAreaTiempos;
	private JLabel[] lblCiclistas;

	private CiclistaDTO[] ciclistasDTO;

	public PanelSimuladorSemi() {

		propertiesInfoV = FileHandler.cargarPropiedades("datos/ventana.properties");
		int posX = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.horizontal"));
		int posY = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.vertical"));

		setSize(posX, posY);
		setLayout(null);
		setBounds(getVisibleRect());

		lblTitulo = generarMensajeTitulo("CARRERA SEMI LLANO", 220, 20, 600, 100);

		btnVolver = generarBoton("VOLVER", 50, 595, 40, 40, "imagenes/Volver.png");
		lblVolver = generarMensaje("VOLVER", 100, 590, 200, 50);

		btnIniciar = generarBoton("INICIAR", 750, 595, 40, 40, "imagenes/botonAvanzar.png");
		lblIniciar = generarMensaje("INICIAR", 790, 590, 200, 50);

		btnOrdenarTiempos = new JButton("Ordenar Tiempos");
		btnOrdenarTiempos.setBounds(575, 550, 140, 40);
		btnOrdenarTiempos.addActionListener(e -> ordenarYMostrarTiempos());

		lblC1 = generarMensajePequeño("Clasicomano", 50, 115, 200, 50);
		lblC2 = generarMensajePequeño("Contrarrelojista", 50, 180, 200, 50);
		lblC3 = generarMensajePequeño("Embalador", 50, 250, 200, 50);
		lblC4 = generarMensajePequeño("Escalador", 50, 325, 200, 50);
		lblC5 = generarMensajePequeño("Gregario", 50, 395, 200, 50);
		lblC6 = generarMensajePequeño("Rodador", 50, 460, 200, 50);

		lblCiclistas = new JLabel[] { lblC1, lblC2, lblC3, lblC4, lblC5, lblC6 };

//		lblImagenLogo1 = new JLabel();
//		lblImagenLogo1.setBounds(425, 125, 500, 400);
//		Image img = new ImageIcon("imagenes/mapaSemi.png").getImage();
//		ImageIcon img1 = new ImageIcon(img.getScaledInstance(500, 400, Image.SCALE_SMOOTH));
//		lblImagenLogo1.setIcon(img1);
		
		lblImagenLogo2 = new JLabel();
		lblImagenLogo2.setBounds(0, 0, 1000, 700);
		Image imge = new ImageIcon("imagenes/fondoSemi.png").getImage();
		ImageIcon img2 = new ImageIcon(imge.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));
		lblImagenLogo2.setIcon(img2);

		txtAreaTiempos = new JTextArea();
		txtAreaTiempos.setEditable(false);
		txtAreaTiempos.setBounds(375, 550, 200, 100);
		add(txtAreaTiempos);

		progresoBarra = new JProgressBar[numCiclistas];
		ciclistaHilos = new Thread[numCiclistas];

		for (int i = 0; i < progresoBarra.length; i++) {
			progresoBarra[i] = new JProgressBar();
			progresoBarra[i].setBounds(50, 150 + i * 70, 300, 30);
			progresoBarra[i].setValue(0);
			add(progresoBarra[i]);
		}

		add(btnVolver);
		add(btnIniciar);
		add(btnOrdenarTiempos);

		add(lblTitulo);
		add(lblVolver);
		add(lblIniciar);
		add(lblImagenLogo1);

		add(lblC1);
		add(lblC2);
		add(lblC3);
		add(lblC4);
		add(lblC5);
		add(lblC6);
		
		add(lblImagenLogo2);

		tiempos = new long[numCiclistas];
		ciclistasDTO = new CiclistaDTO[numCiclistas];
	}

	public void inicioCarrera() {
        tiempos = new long[numCiclistas];
        for (int i = 0; i < numCiclistas; i++) {
            final int cyclistIndex = i;
            ciclistasDTO[cyclistIndex] = new CiclistaDTO();
            ciclistaHilos[i] = new Thread(() -> {
                long startTime = System.currentTimeMillis();
                while (progresoBarra[cyclistIndex].getValue() < carreraDistancia) {
                    try {
                        Thread.sleep((int) (Math.random() * 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progresoBarra[cyclistIndex].setValue(progresoBarra[cyclistIndex].getValue() + 1);
                }
                long endTime = System.currentTimeMillis();
                tiempos[cyclistIndex] = endTime - startTime;
                ciclistasDTO[cyclistIndex].setTiempoAcumulado(tiempos[cyclistIndex] / 1000.0);
                if (todosLosCiclistasHanTerminado()) {
                    mostrarTiempos();
                }
            });
            ciclistaHilos[i].start();
        }
    }

    private boolean todosLosCiclistasHanTerminado() {
        for (int i = 0; i < numCiclistas; i++) {
            if (progresoBarra[i].getValue() < carreraDistancia) {
                return false;
            }
        }
        return true;
    }

    private void mostrarTiempos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCiclistas; i++) {
            double tiempoEnSegundos = tiempos[i] / 1000.0;
            sb.append(lblCiclistas[i].getText()).append(": ").append(tiempoEnSegundos).append(" s\n");
        }
        txtAreaTiempos.setText(sb.toString());
    }

    private void ordenarYMostrarTiempos() {
        Arrays.sort(ciclistasDTO, new CiclistaTiempoAcumuladoComparator());
        StringBuilder sb = new StringBuilder();
        for (CiclistaDTO ciclista : ciclistasDTO) {
            sb.append(ciclista.getIdentificador()).append(": ").append(ciclista.getTiempoAcumulado()).append(" s\n");
        }
        txtAreaTiempos.setText(sb.toString());
    }

    public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
        JButton btn = new JButton();
        btn.setBackground(Color.decode("#FFF8DC"));
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(true);
        btn.setFocusPainted(false);
        btn.setOpaque(false);
        btn.setToolTipText("BOTON " + texto + ".");
        ImageIcon icono = new ImageIcon(url);
        btn.setIcon(icono);
        btn.setBounds(x, y, ancho, alto);
        return btn;
    }

    public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("ARIAL", Font.BOLD, 30));
        lbl.setForeground(Color.WHITE);
        lbl.setBounds(x, y, ancho, alto);
        return lbl;
    }

    public JLabel generarMensajePequeño(String texto, int x, int y, int ancho, int alto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("ARIAL", Font.BOLD, 15));
        lbl.setForeground(Color.WHITE);
        lbl.setBounds(x, y, ancho, alto);
        return lbl;
    }

    public JLabel generarMensajeTitulo(String texto, int x, int y, int ancho, int alto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Arial", Font.BOLD, 40));
        lbl.setForeground(Color.BLACK);
        lbl.setBounds(x, y, ancho, alto);
        return lbl;
    }

	public JLabel getLblImagenLogo2() {
		return lblImagenLogo2;
	}

	public void setLblImagenLogo2(JLabel lblImagenLogo2) {
		this.lblImagenLogo2 = lblImagenLogo2;
	}

	public Properties getPropertiesInfoV() {
		return propertiesInfoV;
	}

	public void setPropertiesInfoV(Properties propertiesInfoV) {
		this.propertiesInfoV = propertiesInfoV;
	}

	public JProgressBar[] getProgresoBarra() {
		return progresoBarra;
	}

	public void setProgresoBarra(JProgressBar[] progresoBarra) {
		this.progresoBarra = progresoBarra;
	}

	public Thread[] getCiclistaHilos() {
		return ciclistaHilos;
	}

	public void setCiclistaHilos(Thread[] ciclistaHilos) {
		this.ciclistaHilos = ciclistaHilos;
	}

	public int getNumCiclistas() {
		return numCiclistas;
	}

	public void setNumCiclistas(int numCiclistas) {
		this.numCiclistas = numCiclistas;
	}

	public int getCarreraDistancia() {
		return carreraDistancia;
	}

	public void setCarreraDistancia(int carreraDistancia) {
		this.carreraDistancia = carreraDistancia;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblVolver() {
		return lblVolver;
	}

	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}

	public JLabel getLblIniciar() {
		return lblIniciar;
	}

	public void setLblIniciar(JLabel lblIniciar) {
		this.lblIniciar = lblIniciar;
	}

	public JLabel getLblImagenLogo1() {
		return lblImagenLogo1;
	}

	public void setLblImagenLogo1(JLabel lblImagenLogo1) {
		this.lblImagenLogo1 = lblImagenLogo1;
	}

	public JLabel getLblC1() {
		return lblC1;
	}

	public void setLblC1(JLabel lblC1) {
		this.lblC1 = lblC1;
	}

	public JLabel getLblC2() {
		return lblC2;
	}

	public void setLblC2(JLabel lblC2) {
		this.lblC2 = lblC2;
	}

	public JLabel getLblC3() {
		return lblC3;
	}

	public void setLblC3(JLabel lblC3) {
		this.lblC3 = lblC3;
	}

	public JLabel getLblC4() {
		return lblC4;
	}

	public void setLblC4(JLabel lblC4) {
		this.lblC4 = lblC4;
	}

	public JLabel getLblC5() {
		return lblC5;
	}

	public void setLblC5(JLabel lblC5) {
		this.lblC5 = lblC5;
	}

	public JLabel getLblC6() {
		return lblC6;
	}

	public void setLblC6(JLabel lblC6) {
		this.lblC6 = lblC6;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}

	public JButton getBtnOrdenarTiempos() {
		return btnOrdenarTiempos;
	}

	public void setBtnOrdenarTiempos(JButton btnOrdenarTiempos) {
		this.btnOrdenarTiempos = btnOrdenarTiempos;
	}

	public long[] getTiempos() {
		return tiempos;
	}

	public void setTiempos(long[] tiempos) {
		this.tiempos = tiempos;
	}

	public JTextArea getTxtAreaTiempos() {
		return txtAreaTiempos;
	}

	public void setTxtAreaTiempos(JTextArea txtAreaTiempos) {
		this.txtAreaTiempos = txtAreaTiempos;
	}

	public JLabel[] getLblCiclistas() {
		return lblCiclistas;
	}

	public void setLblCiclistas(JLabel[] lblCiclistas) {
		this.lblCiclistas = lblCiclistas;
	}

	public CiclistaDTO[] getCiclistasDTO() {
		return ciclistasDTO;
	}

	public void setCiclistasDTO(CiclistaDTO[] ciclistasDTO) {
		this.ciclistasDTO = ciclistasDTO;
	}
}
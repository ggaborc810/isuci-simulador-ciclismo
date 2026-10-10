package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.sort.CiclistaTiempoAcumuladoComparator;

public class PanelSimuladorPlano extends JPanel {

	private Properties propertiesInfoV;

	private JProgressBar[] progresoBarra;
	private Thread[] threadCiclista;
	private int nCiclista = 6;
	private int distanciaSimulacion = 100;

	private JLabel lblTitulo;
	private JLabel lblVolver;
	private JLabel lblIniciar;
	private JLabel lblImagenLogo2;

	private JLabel lblCiclista1;
	private JLabel lblCiclista2;
	private JLabel lblCiclista3;
	private JLabel lblCiclista4;
	private JLabel lblCiclista5;
	private JLabel lblCiclista6;

	private JButton btnVolver;
	private JButton btnIniciar;
	private JButton btnOrdenartiempo;

	private long[] tiempo;
	private JTextArea txtAreatiempo;
	private JLabel[] lblCiclistas;

	private CiclistaDTO[] ciclistas;
	private JLabel lblOrdenartiempo;

	public PanelSimuladorPlano() {

		propertiesInfoV = FileHandler.cargarPropiedades("datos/ventana.properties");
		int posX = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.horizontal"));
		int posY = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.vertical"));

		setSize(posX, posY);
		setLayout(null);
		setBounds(getVisibleRect());

		btnVolver = generarBoton("VOLVER", 23, 510, 40, 40, "fotos/botonVolver.png");
		lblVolver = generarMensaje("VOLVER", 80, 520, 130, 30);

		btnIniciar = generarBoton("INICIAR", 470, 235, 40, 40, "fotos/rueda.png");
		lblIniciar = generarMensaje("INICIAR", 520, 235, 130, 40);

		lblOrdenartiempo = generarMensaje("ORDENAR TIEMPOS", 760, 240, 250, 40);
		btnOrdenartiempo = generarBoton("Ordenartiempo", 720, 240, 40, 40, "fotos/rueda.png");


		lblCiclista1 = generarMensajePequeno("Clasicomano", 60, 52, 200, 50);
		lblCiclista2 = generarMensajePequeno("Contrarrelojista", 60, 120, 200, 50);
		lblCiclista3 = generarMensajePequeno("Embalador", 60, 185, 200, 50);
		lblCiclista4 = generarMensajePequeno("Escalador", 60, 260, 200, 50);
		lblCiclista5 = generarMensajePequeno("Gregario", 60, 325, 200, 50);
		lblCiclista6 = generarMensajePequeno("Rodador", 60, 400, 200, 50);

		lblCiclistas = new JLabel[] { lblCiclista1, lblCiclista2, lblCiclista3, lblCiclista4, lblCiclista5, lblCiclista6 };

		lblImagenLogo2 = new JLabel();
		lblImagenLogo2.setBounds(0, 0, 1000, 600);
		Image imge = new ImageIcon("fotos/plano.png").getImage();
		ImageIcon img2 = new ImageIcon(imge.getScaledInstance(1000, 600, Image.SCALE_SMOOTH));
		lblImagenLogo2.setIcon(img2);

		

		txtAreatiempo = new JTextArea();
		txtAreatiempo.setEditable(true);
		txtAreatiempo.setBounds(740, 280, 200, 250);
		JScrollPane scrollPane = new JScrollPane(txtAreatiempo);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		scrollPane.setVisible(true);

		;

		add(txtAreatiempo);
		add(scrollPane);
		progresoBarra = new JProgressBar[nCiclista];
		threadCiclista = new Thread[nCiclista];

		for (int i = 0; i < progresoBarra.length; i++) {
			progresoBarra[i] = new JProgressBar();
			progresoBarra[i].setBounds(60, 90 + i * 70, 300, 30);
			progresoBarra[i].setValue(0);
			add(progresoBarra[i]);
		}

		add(btnVolver);
		add(btnIniciar);
		add(btnOrdenartiempo);

		add(lblVolver);
		add(lblIniciar);

		add(lblCiclista1);
		add(lblCiclista2);
		add(lblCiclista3);
		add(lblCiclista4);
		add(lblCiclista5);
		add(lblCiclista6);
		add(lblOrdenartiempo);
		add(lblImagenLogo2);

		tiempo = new long[nCiclista];
		ciclistas = new CiclistaDTO[nCiclista];
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
		lbl.setFont(new Font("ARIAL", Font.BOLD, 20));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	public JLabel generarMensajePequeno(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("ARIAL", Font.BOLD, 13));
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

	public Thread[] getthreadCiclista() {
		return threadCiclista;
	}

	public void setthreadCiclista(Thread[] threadCiclista) {
		this.threadCiclista = threadCiclista;
	}

	public int getnCiclista() {
		return nCiclista;
	}

	public void setnCiclista(int nCiclista) {
		this.nCiclista = nCiclista;
	}

	public int getdistanciaSimulacion() {
		return distanciaSimulacion;
	}

	public void setdistanciaSimulacion(int distanciaSimulacion) {
		this.distanciaSimulacion = distanciaSimulacion;
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



	public JLabel getlblCiclista1() {
		return lblCiclista1;
	}

	public void setlblCiclista1(JLabel lblCiclista1) {
		this.lblCiclista1 = lblCiclista1;
	}

	public JLabel getlblCiclista2() {
		return lblCiclista2;
	}

	public void setlblCiclista2(JLabel lblCiclista2) {
		this.lblCiclista2 = lblCiclista2;
	}

	public JLabel getlblCiclista3() {
		return lblCiclista3;
	}

	public void setlblCiclista3(JLabel lblCiclista3) {
		this.lblCiclista3 = lblCiclista3;
	}

	public JLabel getlblCiclista4() {
		return lblCiclista4;
	}

	public void setlblCiclista4(JLabel lblCiclista4) {
		this.lblCiclista4 = lblCiclista4;
	}

	public JLabel getlblCiclista5() {
		return lblCiclista5;
	}

	public void setlblCiclista5(JLabel lblCiclista5) {
		this.lblCiclista5 = lblCiclista5;
	}

	public JLabel getlblCiclista6() {
		return lblCiclista6;
	}

	public void setlblCiclista6(JLabel lblCiclista6) {
		this.lblCiclista6 = lblCiclista6;
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

	public JButton getBtnOrdenartiempo() {
		return btnOrdenartiempo;
	}

	public void setBtnOrdenartiempo(JButton btnOrdenartiempo) {
		this.btnOrdenartiempo = btnOrdenartiempo;
	}

	public long[] gettiempo() {
		return tiempo;
	}

	public void settiempo(long[] tiempo) {
		this.tiempo = tiempo;
	}

	public JTextArea getTxtAreatiempo() {
		return txtAreatiempo;
	}

	public void setTxtAreatiempo(JTextArea txtAreatiempo) {
		this.txtAreatiempo = txtAreatiempo;
	}

	public JLabel[] getLblCiclistas() {
		return lblCiclistas;
	}

	public void setLblCiclistas(JLabel[] lblCiclistas) {
		this.lblCiclistas = lblCiclistas;
	}

	public CiclistaDTO[] getciclistas() {
		return ciclistas;
	}

	public void setciclistas(CiclistaDTO[] ciclistas) {
		this.ciclistas = ciclistas;
	}
}
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {
//	1) REGISTRO DE ESCUADRAS O EQUIPOS
//	2) REGISTRO DE USUARIOS
//	3) ASIGNACIÓN DE PERSONAS A EQUIPOS
//	4) PERFIL DE CICLISTA
//	5) PERFIL DE MASAJISTA
//	6) PERFIL DE DIRECTOR DEPORTIVO
//	7) SIMULACION DE CARRERA
//	8) REPORTES ANALÍTICOS
	// JLabels
	/** The title label. */
	private JLabel lblTitulo;

	/** The user label. */
	private JLabel lblUsuario;

	// Buttons
	/** The option 1 button. */
	private JButton btnOpcion1;

	/** The option 2 button. */
	private JButton btnOpcion2;

	/** The option 3 button. */
	private JButton btnOpcion3;

	/** The option 4 button. */
	private JButton btnOpcion4;

	/** The option 5 button. */
	private JButton btnOpcion5;

	/** The option 6 button. */
	private JButton btnOpcion6;

	/** The option 7 button. */
	private JButton btnOpcion7;

	/** The option 8 button. */
	private JButton btnOpcion8;

	/** The novelty option 1 button. */
	private JButton btnOpcionNov1;

	/** The novelty option 2 button. */
	private JButton btnOpcionNov2;

	/** The novelty option 3 button. */
	private JButton btnOpcionNov3;

	/** The novelty option 4 button. */
	private JButton btnOpcionNov4;

	/** The novelty option 5 button. */
	private JButton btnOpcionNov5;

	/** The novelty option 6 button. */
	private JButton btnOpcionNov6;

	/** The novelty option 7 button. */
	private JButton btnOpcionNov7;

	/** The novelty option 8 button. */
	private JButton btnOpcionNov8;

	// Option labels
	/** The option 1 label. */
	private JLabel lblOpcion1;

	/** The option 2 label. */
	private JLabel lblOpcion2;

	/** The option 3 label. */
	private JLabel lblOpcion3;

	/** The option 4 label. */
	private JLabel lblOpcion4;

	/** The option 5 label. */
	private JLabel lblOpcion5;

	/** The option 6 label. */
	private JLabel lblOpcion6;

	/** The option 7 label. */
	private JLabel lblOpcion7;

	/** The option 8 label. */
	private JLabel lblOpcion8;

	// Images
	/** The image icon. */
	private ImageIcon imagen;

	/** The masquerade image icon. */
	private ImageIcon imagenMas;

	/** The background image icon. */
	private ImageIcon fondo;

	// Image labels
	/** The masquerade image label. */
	private JLabel imageLabelMasajista;

	/** The cyclist image label. */
	private JLabel imageLabelCiclista;

	/** The director image label. */
	private JLabel imageLabelDirector;

	/** The administrative image label. */
	private JLabel imageLabelAdministrativo;

	/**
	 * Button used for navigating back to a previous screen or menu.
	 */
	private JButton btnVolver;

	/**
	 * Label associated with the "Back" button, indicating the action of returning.
	 */
	private JLabel lblVolver;

	/**
	 * constructor of the panelOptions class
	 */

	public PanelOpciones() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.decode("#19374F"));

		JLabel lblTitulo = new JLabel("MENU OPCIONES");
		lblUsuario = new JLabel();
		lblUsuario.setBounds(650, -70, 500, 200);
		lblUsuario.setFont(new Font("Coolvetica Rg", Font.BOLD, 26));
		lblUsuario.setForeground(Color.decode("#80D6D4"));

		imageLabelMasajista = new JLabel(new ImageIcon("fotos/masajista.gif"));
		imageLabelCiclista = new JLabel(new ImageIcon("fotos/opcionesGif2.gif"));
		imageLabelDirector = new JLabel(new ImageIcon("fotos/director.gif"));
		imageLabelAdministrativo = new JLabel(new ImageIcon("fotos/administrativo.gif"));

		imagenMas = new ImageIcon("fotos/masajista.gif");

		lblTitulo.setBounds(100, -20, 500, 200);
		lblTitulo.setFont(new Font("Coolvetica Rg", Font.BOLD, 42));
		lblTitulo.setForeground(Color.decode("#80D6D4"));

		btnOpcion1 = generarBotonI("Registro de escuadras o equipos", 100, 135, 32, 32, "fotos/rueda.png");
		btnOpcionNov1 = generarBotonI("Registro de escuadras o equipos", 100, 135, 32, 32, "fotos/botonNoValido.png");
		lblOpcion1 = generarMensaje("Registro de escuadras o equipos", 150, 0, 900, 300);

		btnOpcion2 = generarBotonI("Eliminar usuarios", 100, 185, 32, 32, "fotos/rueda.png");
		btnOpcionNov2 = generarBotonI("Eliminar usuarios", 100, 185, 32, 32, "fotos/botonNoValido.png");
		lblOpcion2 = generarMensaje("Eliminar usuarios", 150, 50, 900, 300);

		btnOpcion3 = generarBotonI("Asignación de personas a equipos", 100, 235, 32, 32, "fotos/rueda.png");
		btnOpcionNov3 = generarBotonI("Asignación de personas a equipos", 100, 235, 32, 32, "fotos/botonNoValido.png");
		lblOpcion3 = generarMensaje("Asignación de personas a equipos", 150, 100, 900, 300);

		btnOpcion4 = generarBotonI("Perfil de ciclista", 100, 285, 32, 32, "fotos/rueda.png");
		btnOpcionNov4 = generarBotonI("Perfil de ciclista", 100, 285, 32, 32, "fotos/botonNoValido.png");
		lblOpcion4 = generarMensaje("Perfil de ciclista", 150, 150, 900, 300);

		btnOpcion5 = generarBotonI("Perfil de director masajista", 100, 335, 32, 32, "fotos/rueda.png");
		btnOpcionNov5 = generarBotonI("Perfil de director masajista", 100, 335, 32, 32, "fotos/botonNoValido.png");
		lblOpcion5 = generarMensaje("Perfil de masajista", 150, 200, 900, 300);

		btnOpcion6 = generarBotonI("Perfil de director deportivo", 100, 385, 32, 32, "fotos/rueda.png");
		btnOpcionNov6 = generarBotonI("Perfil de director deportivo", 100, 385, 32, 32, "fotos/botonNoValido.png");
		lblOpcion6 = generarMensaje("Perfil de director deportivo", 150, 250, 900, 300);

		btnOpcion7 = generarBotonI("Simulacion de carreras", 100, 435, 32, 32, "fotos/rueda.png");
		btnOpcionNov7 = generarBotonI("Simulacion de carreras", 100, 435, 32, 32, "fotos/botonNoValido.png");
		lblOpcion7 = generarMensaje("Simulacion de carreras", 150, 300, 900, 300);

		btnOpcion8 = generarBotonI("Reportes analíticos", 100, 485, 32, 32, "fotos/rueda.png");
		btnOpcionNov8 = generarBotonI("Reportes analíticos", 100, 485, 32, 32, "fotos/botonNoValido.png");
		lblOpcion8 = generarMensaje("Reportes analíticos", 150, 350, 900, 300);

		btnVolver = generarBotonI("VOLVER", 30, 520, 30, 30, "fotos/rueda.png");
		lblVolver = generarMensaje("Volver", 65, 520, 200, 30);
		lblVolver.setFont(new Font("Banschrift", Font.BOLD, 25));

		// imagen = generarImagen("fotos/ciclista.gif", 550, -200);

		add(lblTitulo);
		add(lblUsuario);
		add(btnOpcion1);
		add(lblOpcion1);
		add(btnOpcion2);
		add(lblOpcion2);
		add(btnOpcion3);
		add(lblOpcion3);
		add(btnOpcion4);
		add(lblOpcion4);
		add(btnOpcion5);
		add(lblOpcion5);
		add(btnOpcion6);
		add(lblOpcion6);
		add(btnOpcion7);
		add(lblOpcion7);
		add(btnOpcion8);
		add(lblOpcion8);
		add(lblVolver);
		add(btnVolver);
		add(btnOpcionNov1);
		add(btnOpcionNov2);
		add(btnOpcionNov3);
		add(btnOpcionNov4);
		add(btnOpcionNov5);
		add(btnOpcionNov6);
		add(btnOpcionNov7);
		add(btnOpcionNov8);

		btnOpcionNov1.setVisible(true);
		btnOpcionNov2.setVisible(true);
		btnOpcionNov3.setVisible(true);
		btnOpcionNov4.setVisible(true);
		btnOpcionNov5.setVisible(true);
		btnOpcionNov6.setVisible(true);
		btnOpcionNov7.setVisible(true);
		btnOpcionNov8.setVisible(true);

		imageLabelMasajista.setVisible(false);
		imageLabelMasajista.setBounds(475, 90, 450, 450);
		add(imageLabelMasajista);

		imageLabelCiclista.setVisible(false);
		imageLabelCiclista.setBounds(440, 110, 450, 450);
		add(imageLabelCiclista);

		imageLabelDirector.setVisible(false);
		imageLabelDirector.setBounds(470, 70, 450, 450);
		add(imageLabelDirector);

		imageLabelAdministrativo.setVisible(false);
		imageLabelAdministrativo.setBounds(490, 100, 450, 450);
		add(imageLabelAdministrativo);

	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getLblVolver() {
		return lblVolver;
	}

	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}

	public void limpiarPanelO() {
		imageLabelAdministrativo.setVisible(false);
		imageLabelDirector.setVisible(false);
		imageLabelCiclista.setVisible(false);
		imageLabelMasajista.setVisible(false);

	}

	/**
	 * Generates a JButton with specified properties.
	 *
	 * @param toolTip The tooltip text for the button.
	 * @param x       The x-coordinate of the button.
	 * @param y       The y-coordinate of the button.
	 * @param ancho   The width of the button.
	 * @param alto    The height of the button.
	 * @param url     The URL of the image icon for the button.
	 * @return The generated JButton.
	 */
	public JButton generarBotonI(String toolTip, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#FFF8DC"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(true);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("BOTON " + toolTip + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}

	/**
	 * Generates a JLabel with specified properties.
	 *
	 * @param texto The text to display on the label.
	 * @param x     The x-coordinate of the label.
	 * @param y     The y-coordinate of the label.
	 * @param ancho The width of the label.
	 * @param alto  The height of the label.
	 * @return The generated JLabel.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Coolvetica Rg", Font.BOLD, 22));
		lbl.setForeground(Color.white);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * @return the lblTitulo
	 */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/**
	 * @param lblTitulo the lblTitulo to set
	 */
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	/**
	 * @return the lblUsuario
	 */
	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	/**
	 * @param lblUsuario the lblUsuario to set
	 */
	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	/**
	 * @return the btnOpcion1
	 */
	public JButton getBtnOpcion1() {
		return btnOpcion1;
	}

	/**
	 * @param btnOpcion1 the btnOpcion1 to set
	 */
	public void setBtnOpcion1(JButton btnOpcion1) {
		this.btnOpcion1 = btnOpcion1;
	}

	/**
	 * @return the btnOpcion2
	 */
	public JButton getBtnOpcion2() {
		return btnOpcion2;
	}

	/**
	 * @param btnOpcion2 the btnOpcion2 to set
	 */
	public void setBtnOpcion2(JButton btnOpcion2) {
		this.btnOpcion2 = btnOpcion2;
	}

	/**
	 * @return the btnOpcion3
	 */
	public JButton getBtnOpcion3() {
		return btnOpcion3;
	}

	/**
	 * @param btnOpcion3 the btnOpcion3 to set
	 */
	public void setBtnOpcion3(JButton btnOpcion3) {
		this.btnOpcion3 = btnOpcion3;
	}

	/**
	 * @return the btnOpcion4
	 */
	public JButton getBtnOpcion4() {
		return btnOpcion4;
	}

	/**
	 * @param btnOpcion4 the btnOpcion4 to set
	 */
	public void setBtnOpcion4(JButton btnOpcion4) {
		this.btnOpcion4 = btnOpcion4;
	}

	/**
	 * @return the btnOpcion5
	 */
	public JButton getBtnOpcion5() {
		return btnOpcion5;
	}

	/**
	 * @param btnOpcion5 the btnOpcion5 to set
	 */
	public void setBtnOpcion5(JButton btnOpcion5) {
		this.btnOpcion5 = btnOpcion5;
	}

	/**
	 * @return the btnOpcion6
	 */
	public JButton getBtnOpcion6() {
		return btnOpcion6;
	}

	/**
	 * @param btnOpcion6 the btnOpcion6 to set
	 */
	public void setBtnOpcion6(JButton btnOpcion6) {
		this.btnOpcion6 = btnOpcion6;
	}

	/**
	 * @return the btnOpcion7
	 */
	public JButton getBtnOpcion7() {
		return btnOpcion7;
	}

	/**
	 * @param btnOpcion7 the btnOpcion7 to set
	 */
	public void setBtnOpcion7(JButton btnOpcion7) {
		this.btnOpcion7 = btnOpcion7;
	}

	/**
	 * @return the btnOpcion8
	 */
	public JButton getBtnOpcion8() {
		return btnOpcion8;
	}

	/**
	 * @param btnOpcion8 the btnOpcion8 to set
	 */
	public void setBtnOpcion8(JButton btnOpcion8) {
		this.btnOpcion8 = btnOpcion8;
	}

	/**
	 * @return the btnOpcionNov1
	 */
	public JButton getBtnOpcionNov1() {
		return btnOpcionNov1;
	}

	/**
	 * @param btnOpcionNov1 the btnOpcionNov1 to set
	 */
	public void setBtnOpcionNov1(JButton btnOpcionNov1) {
		this.btnOpcionNov1 = btnOpcionNov1;
	}

	/**
	 * @return the btnOpcionNov2
	 */
	public JButton getBtnOpcionNov2() {
		return btnOpcionNov2;
	}

	/**
	 * @param btnOpcionNov2 the btnOpcionNov2 to set
	 */
	public void setBtnOpcionNov2(JButton btnOpcionNov2) {
		this.btnOpcionNov2 = btnOpcionNov2;
	}

	/**
	 * @return the btnOpcionNov3
	 */
	public JButton getBtnOpcionNov3() {
		return btnOpcionNov3;
	}

	/**
	 * @param btnOpcionNov3 the btnOpcionNov3 to set
	 */
	public void setBtnOpcionNov3(JButton btnOpcionNov3) {
		this.btnOpcionNov3 = btnOpcionNov3;
	}

	/**
	 * @return the btnOpcionNov4
	 */
	public JButton getBtnOpcionNov4() {
		return btnOpcionNov4;
	}

	/**
	 * @param btnOpcionNov4 the btnOpcionNov4 to set
	 */
	public void setBtnOpcionNov4(JButton btnOpcionNov4) {
		this.btnOpcionNov4 = btnOpcionNov4;
	}

	/**
	 * @return the btnOpcionNov5
	 */
	public JButton getBtnOpcionNov5() {
		return btnOpcionNov5;
	}

	/**
	 * @param btnOpcionNov5 the btnOpcionNov5 to set
	 */
	public void setBtnOpcionNov5(JButton btnOpcionNov5) {
		this.btnOpcionNov5 = btnOpcionNov5;
	}

	/**
	 * @return the btnOpcionNov6
	 */
	public JButton getBtnOpcionNov6() {
		return btnOpcionNov6;
	}

	/**
	 * @param btnOpcionNov6 the btnOpcionNov6 to set
	 */
	public void setBtnOpcionNov6(JButton btnOpcionNov6) {
		this.btnOpcionNov6 = btnOpcionNov6;
	}

	/**
	 * @return the btnOpcionNov7
	 */
	public JButton getBtnOpcionNov7() {
		return btnOpcionNov7;
	}

	/**
	 * @param btnOpcionNov7 the btnOpcionNov7 to set
	 */
	public void setBtnOpcionNov7(JButton btnOpcionNov7) {
		this.btnOpcionNov7 = btnOpcionNov7;
	}

	/**
	 * @return the btnOpcionNov8
	 */
	public JButton getBtnOpcionNov8() {
		return btnOpcionNov8;
	}

	/**
	 * @param btnOpcionNov8 the btnOpcionNov8 to set
	 */
	public void setBtnOpcionNov8(JButton btnOpcionNov8) {
		this.btnOpcionNov8 = btnOpcionNov8;
	}

	/**
	 * @return the lblOpcion1
	 */
	public JLabel getLblOpcion1() {
		return lblOpcion1;
	}

	/**
	 * @param lblOpcion1 the lblOpcion1 to set
	 */
	public void setLblOpcion1(JLabel lblOpcion1) {
		this.lblOpcion1 = lblOpcion1;
	}

	/**
	 * @return the lblOpcion2
	 */
	public JLabel getLblOpcion2() {
		return lblOpcion2;
	}

	/**
	 * @param lblOpcion2 the lblOpcion2 to set
	 */
	public void setLblOpcion2(JLabel lblOpcion2) {
		this.lblOpcion2 = lblOpcion2;
	}

	/**
	 * @return the lblOpcion3
	 */
	public JLabel getLblOpcion3() {
		return lblOpcion3;
	}

	/**
	 * @param lblOpcion3 the lblOpcion3 to set
	 */
	public void setLblOpcion3(JLabel lblOpcion3) {
		this.lblOpcion3 = lblOpcion3;
	}

	/**
	 * @return the lblOpcion4
	 */
	public JLabel getLblOpcion4() {
		return lblOpcion4;
	}

	/**
	 * @param lblOpcion4 the lblOpcion4 to set
	 */
	public void setLblOpcion4(JLabel lblOpcion4) {
		this.lblOpcion4 = lblOpcion4;
	}

	/**
	 * @return the lblOpcion5
	 */
	public JLabel getLblOpcion5() {
		return lblOpcion5;
	}

	/**
	 * @param lblOpcion5 the lblOpcion5 to set
	 */
	public void setLblOpcion5(JLabel lblOpcion5) {
		this.lblOpcion5 = lblOpcion5;
	}

	/**
	 * @return the lblOpcion6
	 */
	public JLabel getLblOpcion6() {
		return lblOpcion6;
	}

	/**
	 * @param lblOpcion6 the lblOpcion6 to set
	 */
	public void setLblOpcion6(JLabel lblOpcion6) {
		this.lblOpcion6 = lblOpcion6;
	}

	/**
	 * @return the lblOpcion7
	 */
	public JLabel getLblOpcion7() {
		return lblOpcion7;
	}

	/**
	 * @param lblOpcion7 the lblOpcion7 to set
	 */
	public void setLblOpcion7(JLabel lblOpcion7) {
		this.lblOpcion7 = lblOpcion7;
	}

	/**
	 * @return the lblOpcion8
	 */
	public JLabel getLblOpcion8() {
		return lblOpcion8;
	}

	/**
	 * @param lblOpcion8 the lblOpcion8 to set
	 */
	public void setLblOpcion8(JLabel lblOpcion8) {
		this.lblOpcion8 = lblOpcion8;
	}

	/**
	 * @return the imagen
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the imagenMas
	 */
	public ImageIcon getImagenMas() {
		return imagenMas;
	}

	/**
	 * @param imagenMas the imagenMas to set
	 */
	public void setImagenMas(ImageIcon imagenMas) {
		this.imagenMas = imagenMas;
	}

	/**
	 * @return the fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * @param fondo the fondo to set
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * @return the imageLabelMasajista
	 */
	public JLabel getImageLabelMasajista() {
		return imageLabelMasajista;
	}

	/**
	 * @param imageLabelMasajista the imageLabelMasajista to set
	 */
	public void setImageLabelMasajista(JLabel imageLabelMasajista) {
		this.imageLabelMasajista = imageLabelMasajista;
	}

	/**
	 * @return the imageLabelCiclista
	 */
	public JLabel getImageLabelCiclista() {
		return imageLabelCiclista;
	}

	/**
	 * @param imageLabelCiclista the imageLabelCiclista to set
	 */
	public void setImageLabelCiclista(JLabel imageLabelCiclista) {
		this.imageLabelCiclista = imageLabelCiclista;
	}

	/**
	 * @return the imageLabelDirector
	 */
	public JLabel getImageLabelDirector() {
		return imageLabelDirector;
	}

	/**
	 * @param imageLabelDirector the imageLabelDirector to set
	 */
	public void setImageLabelDirector(JLabel imageLabelDirector) {
		this.imageLabelDirector = imageLabelDirector;
	}

	/**
	 * @return the imageLabelAdministrativo
	 */
	public JLabel getImageLabelAdministrativo() {
		return imageLabelAdministrativo;
	}

	/**
	 * @param imageLabelAdministrativo the imageLabelAdministrativo to set
	 */
	public void setImageLabelAdministrativo(JLabel imageLabelAdministrativo) {
		this.imageLabelAdministrativo = imageLabelAdministrativo;
	}

}

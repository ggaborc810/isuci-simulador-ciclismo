package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * PPanel for displaying cyclist information.
 * 
 * @autor Juan Diego Triana Mejía
 * 
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMostrarCiclista extends JPanel {

	/**
	 * Button to send information.
	 */
	private JButton btnEnviar;

	/**
	 * Label for sending information.
	 */
	private JLabel lblEnviar;

	/**
	 * Button to return.
	 */
	private JButton btnVolver;

	/**
	 * Label for returning.
	 */
	private JLabel lblVolver;

	/**
	 * Label for name.
	 */
	private JLabel lblNombre;

	/**
	 * Text field for name.
	 */
	private JTextField txtNombre;

	/**
	 * Label for ID number.
	 */
	private JLabel lblCedula;

	/**
	 * Text field for ID number.
	 */
	private JTextField txtCedula;

	/**
	 * Label for gender.
	 */
	private JLabel lblGenero;

	/**
	 * Drop-down box for selecting gender.
	 */
	private JComboBox boxGenero;

	/**
	 * Label for email.
	 */
	private JLabel lblcorreoElectronico;

	/**
	 * Text field for email.
	 */
	private JTextField txtcorreoElectronico;

	/**
	 * Label for username.
	 */
	private JLabel lblNombreUsuario;

	/**
	 * Text field for username.
	 */
	private JTextField txtNombreUsuario;

	/**
	 * Label for password.
	 */
	private JLabel lblContrasenia;

	/**
	 * Text field for password.
	 */
	private JTextField txtContrasenia;

	/**
	 * Label for ID.
	 */
	private JLabel lblId;

	/**
	 * Text field for ID.
	 */
	private JTextField txtId;

	/**
	 * Label for accumulated time.
	 */
	private JLabel lblTiempoAcumulado;

	/**
	 * Text field for accumulated time.
	 */
	private JTextField txtTiempoAcumulado;

	/**
	 * Label for body build.
	 */
	private JLabel lblContextura;

	/**
	 * Text field for body build.
	 */
	private JTextField txtContextura;

	/**
	 * Label for pedaling cadence.
	 */
	private JLabel lblCadenciaPedaleo;

	/**
	 * Text field for pedaling cadence.
	 */
	private JTextField txtCadenciaPedaleo;

	/**
	 * Label for years of experience.
	 */
	private JLabel lblAniosExperiencia;

	/**
	 * Text field for years of experience.
	 */
	private JTextField txtAniosExperiencia;

	/**
	 * Label for number of classic wins.
	 */
	private JLabel lblNumClasicoGanado;

	/**
	 * Text field for number of classic wins.
	 */
	private JTextField txtNumClasicoGanado;

	/**
	 * Label for maximum speed (for time trials).
	 */
	private JLabel lblVelocidadMaxima;

	/**
	 * Text field for maximum speed (for time trials).
	 */
	private JTextField txtVelocidadMaxima;

	/**
	 * Label for average power (for sprinters).
	 */
	private JLabel lblPotenciaPromedio;

	/**
	 * Text field for average power (for sprinters).
	 */
	private JTextField txtPotenciaPromedio;

	/**
	 * Label for average speed (for sprinters).
	 */
	private JLabel lblVelocidadPromedio;

	/**
	 * Text field for average speed (for sprinters).
	 */
	private JTextField txtVelocidadPromedio;

	/**
	 * Label for average acceleration (for climbers).
	 */
	private JLabel lblAceleracionPromedio;

	/**
	 * Text field for average acceleration (for climbers).
	 */
	private JTextField txtAceleracionPromedio;

	/**
	 * Label for supported ramp grade (for climbers).
	 */
	private JLabel lblGradoRampaSoportada;

	/**
	 * Text field for supported ramp grade (for climbers).
	 */
	private JTextField txtGradoRampaSoportada;

	/**
	 * Radio button for feed provider (for support riders).
	 */
	private JRadioButton rbtnAbastecedor;

	/**
	 * Radio button for maintaining pace (for support riders).
	 */
	private JRadioButton rbtnMantenerRitmo;

	/**
	 * Radio button for capturing breakaways (for support riders).
	 */
	private JRadioButton rbtnCapturasFuga;

	/**
	 * Radio button for positioning leader (for support riders).
	 */
	private JRadioButton rbtnPosicionarLider;

	/**
	 * Radio button for protecting leader (for support riders).
	 */
	private JRadioButton rbtnProtegerLider;

	/**
	 * Label for average pedaling speed (for rollers).
	 */
	private JLabel lblVelocidadPromedioPedaleo;

	/**
	 * Text field for average pedaling speed (for rollers).
	 */
	private JTextField txtVelocidadPromedioPedaleo;

	/**
	 * Image associated with the form.
	 */
	private ImageIcon imagen;

	/**
	 * Title label.
	 */
	private JLabel lblTitulo;

	/**
	 * Radio button for hand-classics.
	 */
	private JRadioButton rbtnClasicoMano;

	/**
	 * Radio button for time trials.
	 */
	private JRadioButton rbtnContrarreloj;

	/**
	 * Radio button for sprinters.
	 */
	private JRadioButton rbtnEmbalador;

	/**
	 * Radio button for climbers.
	 */
	private JRadioButton rbtnEscalador;

	/**
	 * Radio button for support riders.
	 */
	private JRadioButton rbtnGregario;

	/**
	 * Radio button for rollers.
	 */
	private JRadioButton rbtnRodador;

	/**
	 * Radio button for empty selection.
	 */
	private JRadioButton rbtnVacio;

	/**
	 * Radio button for time trial tasks (visualization).
	 */
	private JRadioButton rbtnTareaCVisualizar;

	/**
	 * Radio button for time trial tasks (concentration).
	 */
	private JRadioButton rbtnTareaCConcentrarse;

	/**
	 * Radio button for time trial tasks (regular).
	 */
	private JRadioButton rbtnTareaCRegular;

	/**
	 * Radio button for sprinter tasks (increase pace).
	 */
	private JRadioButton rbtnTareaEmAumentarRitmo;

	/**
	 * Radio button for sprinter tasks (reduce pace).
	 */
	private JRadioButton rbtnTareaEmBajarRitmo;

	/**
	 * Radio button for climber tasks (seated pedaling).
	 */
	private JRadioButton rbtnTareaEsPedalearS;

	/**
	 * Radio button for climber tasks (standing pedaling).
	 */
	private JRadioButton rbtnTareaEsPedalearP;

	/**
	 * Label for pedaling cadence (for rollers).
	 */
	private JLabel lblCadenciaPedaleo2;

	/**
	 * Label for average power (for rollers).
	 */
	private JLabel lblPotenciaPromedio1;

	/**
	 * Label for average acceleration (for rollers).
	 */
	private JLabel lblAceleracionPromedio1;

	/**
	 * Label for average pedaling speed (for rollers).
	 */
	private JLabel lblVelocidadPromedioPedaleo1;

	/**
	 * Constructor for the PanelMostrarCiclista class. Initializes and sets up the
	 * components of the panel.
	 */
	public PanelMostrarCiclista() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		lblTitulo = generarMensaje("MOSTRAR CICLISTA", 420, 20, 320, 30);

		ButtonGroup grupoBotones = new ButtonGroup();
		rbtnClasicoMano = generarRadioBoton("Clasicómano", 20, 70, 130, 30);
		rbtnContrarreloj = generarRadioBoton("Contrarreloj", 160, 70, 120, 30);
		rbtnEmbalador = generarRadioBoton("Embalador", 300, 70, 120, 30);
		rbtnEscalador = generarRadioBoton("Escalador", 440, 70, 120, 30);
		rbtnGregario = generarRadioBoton("Gregario", 580, 70, 100, 30);
		rbtnRodador = generarRadioBoton("Rodador", 720, 70, 90, 30);
		rbtnVacio = generarRadioBoton("Sin Atributos", 860, 70, 200, 30);

		lblNombre = generarMensaje("Nombre:", 20, 115, 100, 50);
		txtNombre = generarEscritura(20, 155, 110, 30);

		lblGenero = generarMensaje("Genero:", 240, 115, 100, 50);
		boxGenero = generarGenero(240, 155, 110, 30);

		lblId = generarMensaje("Identificador:", 430, 115, 160, 50);
		txtId = generarEscritura(430, 155, 110, 30);

		lblCedula = generarMensaje("Cedula: ", 640, 115, 300, 50);
		txtCedula = generarEscritura(640, 155, 110, 30);

		lblcorreoElectronico = generarMensaje("Correo Electronico:", 795, 115, 200, 50);
		txtcorreoElectronico = generarEscritura(815, 155, 110, 30);

		lblNombreUsuario = generarMensaje("Nombre de usuario:", 20, 220, 200, 30);
		txtNombreUsuario = generarEscritura(20, 255, 110, 30);

		lblContrasenia = generarMensaje("Contraseña:", 240, 220, 200, 30);
		txtContrasenia = generarEscritura(240, 255, 110, 30);

		lblTiempoAcumulado = generarMensaje("Tiempo Acumulado:", 410, 220, 200, 30);
		txtTiempoAcumulado = generarEscritura(430, 255, 110, 30);

		lblContextura = generarMensaje("Contextura:", 810, 220, 200, 30);
		txtContextura = generarEscritura(810, 255, 110, 30);

		lblCadenciaPedaleo = generarMensaje("Cadenacia", 640, 190, 220, 50);
		lblCadenciaPedaleo2 = generarMensaje("pedaleo:", 640, 210, 220, 50);
		txtCadenciaPedaleo = generarEscritura(640, 255, 110, 30);
		lblCadenciaPedaleo.setFont(new Font("Banschrift", Font.BOLD, 18));

		lblAniosExperiencia = generarMensaje("Años Experiencia:", 20, 305, 300, 30);
		txtAniosExperiencia = generarEscritura(20, 340, 110, 30);

		lblNumClasicoGanado = generarMensaje("Clasicos Ganados:", 220, 305, 300, 30);
		txtNumClasicoGanado = generarEscritura(240, 340, 110, 30);

		lblVelocidadMaxima = generarMensaje("Velocidad Maxima:", 220, 305, 300, 30);
		txtVelocidadMaxima = generarEscritura(240, 340, 110, 30);

		ButtonGroup grupoBotones1 = new ButtonGroup();

		rbtnTareaCVisualizar = generarRadioBoton("visualizar", 430, 320, 200, 30);
		rbtnTareaCConcentrarse = generarRadioBoton("concentrarse", 620, 320, 200, 30);
		rbtnTareaCRegular = generarRadioBoton("regular", 810, 320, 200, 30);

		// tareas escalador
		rbtnTareaEsPedalearS = generarRadioBoton("Pedalear sentado", 620, 310, 200, 30);
		rbtnTareaEsPedalearP = generarRadioBoton("Pedalear parado", 620, 370, 200, 30);

		// tareas embalador
		rbtnTareaEmAumentarRitmo = generarRadioBoton("Aumentar ritmo", 620, 340, 150, 30);
		rbtnTareaEmBajarRitmo = generarRadioBoton("Bajar ritmo", 790, 340, 110, 30);
		lblPotenciaPromedio = generarMensaje("Potencia", 240, 295, 300, 30);
		lblPotenciaPromedio1 = generarMensaje("Promedio:", 240, 315, 300, 30);
		txtPotenciaPromedio = generarEscritura(240, 340, 110, 30);
		lblVelocidadPromedio = generarMensaje("Velocidad Promedio:", 410, 305, 200, 30);
		txtVelocidadPromedio = generarEscritura(430, 340, 110, 30);

		lblAceleracionPromedio = generarMensaje("Aceleración", 240, 290, 300, 30);
		lblAceleracionPromedio1 = generarMensaje("Promedio:", 240, 305, 300, 30);
		txtAceleracionPromedio = generarEscritura(240, 340, 110, 30);
		lblGradoRampaSoportada = generarMensaje("Grado de la rampa:", 410, 305, 200, 30);
		txtGradoRampaSoportada = generarEscritura(430, 340, 110, 30);

		rbtnAbastecedor = generarRadioBoton("Abastecedor", 240, 350, 200, 30);
		rbtnMantenerRitmo = generarRadioBoton("Mantener el Ritmo", 410, 350, 200, 30);
		rbtnCapturasFuga = generarRadioBoton("Capturar Fuga", 640, 350, 200, 30);
		rbtnPosicionarLider = generarRadioBoton("Posicionar Lider", 240, 400, 150, 30);
		rbtnProtegerLider = generarRadioBoton("Protege al lider", 410, 400, 200, 30);

		lblVelocidadPromedioPedaleo = generarMensaje("Velocidad Promedio", 240, 300, 300, 30);
		lblVelocidadPromedioPedaleo1 = generarMensaje("Pedaleo:", 240, 315, 300, 30);
		txtVelocidadPromedioPedaleo = generarEscritura(240, 345, 110, 30);

		btnEnviar = generarBoton("ENVIAR", 930, 500, 30, 30, "fotos/rueda.png");
		lblEnviar = generarMensaje("Enviar", 850, 500, 200, 30);
		lblEnviar.setFont(new Font("Banschrift", Font.BOLD, 25));

		btnVolver = generarBoton("VOLVER", 30, 520, 30, 30, "fotos/rueda.png");
		lblVolver = generarMensaje("Volver", 65, 520, 200, 30);
		lblVolver.setFont(new Font("Banschrift", Font.BOLD, 25));

		imagen = new ImageIcon("fotos/PanelMostrarCiclista.png");

//		add(lblTitulo);
		add(rbtnClasicoMano);
		add(rbtnContrarreloj);
		add(rbtnEmbalador);
		add(rbtnEscalador);
		add(rbtnGregario);
		add(rbtnRodador);
		add(rbtnVacio);
//		add(imagen);

		add(lblCedula);
		add(txtCedula);
		add(lblGenero);
		add(boxGenero);
		add(lblcorreoElectronico);
		add(txtcorreoElectronico);
		add(lblNombreUsuario);
		add(txtNombreUsuario);
		add(lblContrasenia);
		add(txtContrasenia);
		add(lblId);
		add(txtId);
		add(lblTiempoAcumulado);
		add(txtTiempoAcumulado);
		add(lblContextura);
		add(txtContextura);
		add(lblCadenciaPedaleo);
		add(lblCadenciaPedaleo2);
		add(txtCadenciaPedaleo);
		add(lblAniosExperiencia);
		add(txtAniosExperiencia);

		add(lblNumClasicoGanado).setVisible(false);
		add(txtNumClasicoGanado).setVisible(false);
		add(lblVelocidadMaxima).setVisible(false);
		;
		add(txtVelocidadMaxima).setVisible(false);
		;
		add(lblPotenciaPromedio).setVisible(false);
		add(lblPotenciaPromedio1).setVisible(false);
		add(txtPotenciaPromedio).setVisible(false);
		add(lblVelocidadPromedio).setVisible(false);
		add(txtVelocidadPromedio).setVisible(false);

		add(lblAceleracionPromedio).setVisible(false);
		add(lblAceleracionPromedio1).setVisible(false);
		add(txtAceleracionPromedio).setVisible(false);
		add(lblGradoRampaSoportada).setVisible(false);
		add(txtGradoRampaSoportada).setVisible(false);

		add(rbtnAbastecedor).setVisible(false);
		add(rbtnMantenerRitmo).setVisible(false);
		add(rbtnCapturasFuga).setVisible(false);
		add(rbtnPosicionarLider).setVisible(false);
		add(rbtnProtegerLider).setVisible(false);

		add(rbtnTareaCConcentrarse).setVisible(false);
		add(rbtnTareaCRegular).setVisible(false);
		add(rbtnTareaCVisualizar).setVisible(false);

		add(rbtnTareaEmAumentarRitmo).setVisible(false);
		add(rbtnTareaEmBajarRitmo).setVisible(false);

		add(rbtnTareaEsPedalearS).setVisible(false);
		add(rbtnTareaEsPedalearP).setVisible(false);

		add(lblVelocidadPromedioPedaleo).setVisible(false);
		add(txtVelocidadPromedioPedaleo).setVisible(false);

		add(lblEnviar);
		add(btnEnviar);
		add(btnVolver);
		add(lblVolver);
		add(lblNombre);
		add(txtNombre);
		grupoBotones.add(rbtnClasicoMano);
		grupoBotones.add(rbtnContrarreloj);
		grupoBotones.add(rbtnEmbalador);
		grupoBotones.add(rbtnEscalador);
		grupoBotones.add(rbtnGregario);
		grupoBotones.add(rbtnRodador);
		grupoBotones.add(rbtnVacio);

		grupoBotones.add(rbtnTareaEmAumentarRitmo);
		grupoBotones.add(rbtnTareaEmBajarRitmo);

		grupoBotones.add(rbtnTareaEsPedalearS);
		grupoBotones.add(rbtnTareaEsPedalearP);

		grupoBotones.add(rbtnTareaCVisualizar);
		grupoBotones.add(rbtnTareaCConcentrarse);
		grupoBotones.add(rbtnTareaCRegular);

		grupoBotones1.add(rbtnTareaEmAumentarRitmo);
		grupoBotones1.add(rbtnTareaEmBajarRitmo);

		grupoBotones1.add(rbtnTareaEsPedalearS);
		grupoBotones1.add(rbtnTareaEsPedalearP);

		grupoBotones1.add(rbtnTareaCVisualizar);
		grupoBotones1.add(rbtnTareaCConcentrarse);
		grupoBotones1.add(rbtnTareaCRegular);

		repaint();

	}

	/**
	 * Generates a JButton with specified parameters.
	 * 
	 * @param texto The text to display on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the image for the button icon.
	 * @return The generated JButton.
	 */
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

	/**
	 * Generates a JRadioButton with specified parameters.
	 * 
	 * @param texto The text to display on the radio button.
	 * @param x     The x-coordinate of the radio button.
	 * @param y     The y-coordinate of the radio button.
	 * @param ancho The width of the radio button.
	 * @param alto  The height of the radio button.
	 * @return The generated JRadioButton.
	 */
	public JRadioButton generarRadioBoton(String texto, int x, int y, int ancho, int alto) {
		JRadioButton rbtn = new JRadioButton(texto);
		rbtn.setBounds(x, y, ancho, alto);
		rbtn.setBorderPainted(false);
		rbtn.setContentAreaFilled(true);
		rbtn.setFocusPainted(false);
		rbtn.setOpaque(false);
		rbtn.setFont(new Font("Banschrift", Font.BOLD, 15));
		rbtn.setForeground(Color.WHITE);
		return rbtn;
	}

	/**
	 * Generates a JLabel with specified parameters.
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
		lbl.setFont(new Font("Banschrift", Font.BOLD, 18));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Generates a JTextField with specified parameters.
	 * 
	 * @param x     The x-coordinate of the text field.
	 * @param y     The y-coordinate of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return The generated JTextField.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox for selecting gender with specified parameters.
	 * 
	 * @param x     The x-coordinate of the combo box.
	 * @param y     The y-coordinate of the combo box.
	 * @param ancho The width of the combo box.
	 * @param alto  The height of the combo box.
	 * @return The generated JComboBox.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Hides specific components related to cyclist attributes.
	 */
	public void limpiarPanelCrearCiclista() {
		add(lblNumClasicoGanado).setVisible(false);
		add(txtNumClasicoGanado).setVisible(false);
		add(lblVelocidadMaxima).setVisible(false);
		;
		add(txtVelocidadMaxima).setVisible(false);
		;
		add(lblPotenciaPromedio).setVisible(false);
		add(lblPotenciaPromedio1).setVisible(false);
		add(txtPotenciaPromedio).setVisible(false);
		add(lblVelocidadPromedio).setVisible(false);
		add(txtVelocidadPromedio).setVisible(false);

		add(lblAceleracionPromedio).setVisible(false);
		add(lblAceleracionPromedio1).setVisible(false);
		add(txtAceleracionPromedio).setVisible(false);
		add(lblGradoRampaSoportada).setVisible(false);
		add(txtGradoRampaSoportada).setVisible(false);

		add(rbtnAbastecedor).setVisible(false);
		add(rbtnMantenerRitmo).setVisible(false);
		add(rbtnCapturasFuga).setVisible(false);
		add(rbtnPosicionarLider).setVisible(false);
		add(rbtnProtegerLider).setVisible(false);

		add(lblVelocidadPromedioPedaleo).setVisible(false);
		add(lblVelocidadPromedioPedaleo1).setVisible(false);
		add(txtVelocidadPromedioPedaleo).setVisible(false);

		add(rbtnTareaCConcentrarse).setVisible(false);
		add(rbtnTareaCRegular).setVisible(false);
		add(rbtnTareaCVisualizar).setVisible(false);

		add(rbtnTareaEmAumentarRitmo).setVisible(false);
		add(rbtnTareaEmBajarRitmo).setVisible(false);

		add(rbtnTareaEsPedalearS).setVisible(false);
		add(rbtnTareaEsPedalearP).setVisible(false);

	}

	/**
	 * Clears all input fields in the panel.
	 */
	public void limpiarPanel() {
		txtAceleracionPromedio.setText("");
		txtAniosExperiencia.setText("");
		txtCadenciaPedaleo.setText("");
		txtContextura.setText("");
		txtGradoRampaSoportada.setText("");
		txtId.setText("");
		txtNombre.setText("");
		txtNumClasicoGanado.setText("");
		txtPotenciaPromedio.setText("");
		txtTiempoAcumulado.setText("");
		txtVelocidadMaxima.setText("");
		txtVelocidadPromedio.setText("");
		txtVelocidadPromedioPedaleo.setText("");
	}

	/**
	 * @return the btnEnviar
	 */
	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	/**
	 * @param btnEnviar the btnEnviar to set
	 */
	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	/**
	 * @return the lblEnviar
	 */
	public JLabel getLblEnviar() {
		return lblEnviar;
	}

	/**
	 * @param lblEnviar the lblEnviar to set
	 */
	public void setLblEnviar(JLabel lblEnviar) {
		this.lblEnviar = lblEnviar;
	}

	/**
	 * @return the btnVolver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * @param btnVolver the btnVolver to set
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	/**
	 * @return the lblVolver
	 */
	public JLabel getLblVolver() {
		return lblVolver;
	}

	/**
	 * @param lblVolver the lblVolver to set
	 */
	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}

	/**
	 * @return the lblNombre
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * @param lblNombre the lblNombre to set
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * @return the txtNombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre the txtNombre to set
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return the lblCedula
	 */
	public JLabel getLblCedula() {
		return lblCedula;
	}

	/**
	 * @param lblCedula the lblCedula to set
	 */
	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	/**
	 * @return the txtCedula
	 */
	public JTextField getTxtCedula() {
		return txtCedula;
	}

	/**
	 * @param txtCedula the txtCedula to set
	 */
	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	/**
	 * @return the lblGenero
	 */
	public JLabel getLblGenero() {
		return lblGenero;
	}

	/**
	 * @param lblGenero the lblGenero to set
	 */
	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	/**
	 * @return the boxGenero
	 */
	public JComboBox getBoxGenero() {
		return boxGenero;
	}

	/**
	 * @param boxGenero the boxGenero to set
	 */
	public void setBoxGenero(JComboBox boxGenero) {
		this.boxGenero = boxGenero;
	}

	/**
	 * @return the lblcorreoElectronico
	 */
	public JLabel getLblcorreoElectronico() {
		return lblcorreoElectronico;
	}

	/**
	 * @param lblcorreoElectronico the lblcorreoElectronico to set
	 */
	public void setLblcorreoElectronico(JLabel lblcorreoElectronico) {
		this.lblcorreoElectronico = lblcorreoElectronico;
	}

	/**
	 * @return the txtcorreoElectronico
	 */
	public JTextField getTxtcorreoElectronico() {
		return txtcorreoElectronico;
	}

	/**
	 * @param txtcorreoElectronico the txtcorreoElectronico to set
	 */
	public void setTxtcorreoElectronico(JTextField txtcorreoElectronico) {
		this.txtcorreoElectronico = txtcorreoElectronico;
	}

	/**
	 * @return the lblNombreUsuario
	 */
	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	/**
	 * @param lblNombreUsuario the lblNombreUsuario to set
	 */
	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	/**
	 * @return the txtNombreUsuario
	 */
	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	/**
	 * @param txtNombreUsuario the txtNombreUsuario to set
	 */
	public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
		this.txtNombreUsuario = txtNombreUsuario;
	}

	/**
	 * @return the lblContrasenia
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/**
	 * @param lblContrasenia the lblContrasenia to set
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/**
	 * @return the txtContrasenia
	 */
	public JTextField getTxtContrasenia() {
		return txtContrasenia;
	}

	/**
	 * @param txtContrasenia the txtContrasenia to set
	 */
	public void setTxtContrasenia(JTextField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	/**
	 * @return the lblId
	 */
	public JLabel getLblId() {
		return lblId;
	}

	/**
	 * @param lblId the lblId to set
	 */
	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	/**
	 * @return the txtId
	 */
	public JTextField getTxtId() {
		return txtId;
	}

	/**
	 * @param txtId the txtId to set
	 */
	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	/**
	 * @return the lblTiempoAcumulado
	 */
	public JLabel getLblTiempoAcumulado() {
		return lblTiempoAcumulado;
	}

	/**
	 * @param lblTiempoAcumulado the lblTiempoAcumulado to set
	 */
	public void setLblTiempoAcumulado(JLabel lblTiempoAcumulado) {
		this.lblTiempoAcumulado = lblTiempoAcumulado;
	}

	/**
	 * @return the txtTiempoAcumulado
	 */
	public JTextField getTxtTiempoAcumulado() {
		return txtTiempoAcumulado;
	}

	/**
	 * @param txtTiempoAcumulado the txtTiempoAcumulado to set
	 */
	public void setTxtTiempoAcumulado(JTextField txtTiempoAcumulado) {
		this.txtTiempoAcumulado = txtTiempoAcumulado;
	}

	/**
	 * @return the lblContextura
	 */
	public JLabel getLblContextura() {
		return lblContextura;
	}

	/**
	 * @param lblContextura the lblContextura to set
	 */
	public void setLblContextura(JLabel lblContextura) {
		this.lblContextura = lblContextura;
	}

	/**
	 * @return the txtContextura
	 */
	public JTextField getTxtContextura() {
		return txtContextura;
	}

	/**
	 * @param txtContextura the txtContextura to set
	 */
	public void setTxtContextura(JTextField txtContextura) {
		this.txtContextura = txtContextura;
	}

	/**
	 * @return the lblCadenciaPedaleo
	 */
	public JLabel getLblCadenciaPedaleo() {
		return lblCadenciaPedaleo;
	}

	/**
	 * @param lblCadenciaPedaleo the lblCadenciaPedaleo to set
	 */
	public void setLblCadenciaPedaleo(JLabel lblCadenciaPedaleo) {
		this.lblCadenciaPedaleo = lblCadenciaPedaleo;
	}

	/**
	 * @return the txtCadenciaPedaleo
	 */
	public JTextField getTxtCadenciaPedaleo() {
		return txtCadenciaPedaleo;
	}

	/**
	 * @param txtCadenciaPedaleo the txtCadenciaPedaleo to set
	 */
	public void setTxtCadenciaPedaleo(JTextField txtCadenciaPedaleo) {
		this.txtCadenciaPedaleo = txtCadenciaPedaleo;
	}

	/**
	 * @return the lblAniosExperiencia
	 */
	public JLabel getLblAniosExperiencia() {
		return lblAniosExperiencia;
	}

	/**
	 * @param lblAniosExperiencia the lblAniosExperiencia to set
	 */
	public void setLblAniosExperiencia(JLabel lblAniosExperiencia) {
		this.lblAniosExperiencia = lblAniosExperiencia;
	}

	/**
	 * @return the txtAniosExperiencia
	 */
	public JTextField getTxtAniosExperiencia() {
		return txtAniosExperiencia;
	}

	/**
	 * @param txtAniosExperiencia the txtAniosExperiencia to set
	 */
	public void setTxtAniosExperiencia(JTextField txtAniosExperiencia) {
		this.txtAniosExperiencia = txtAniosExperiencia;
	}

	/**
	 * @return the lblNumClasicoGanado
	 */
	public JLabel getLblNumClasicoGanado() {
		return lblNumClasicoGanado;
	}

	/**
	 * @param lblNumClasicoGanado the lblNumClasicoGanado to set
	 */
	public void setLblNumClasicoGanado(JLabel lblNumClasicoGanado) {
		this.lblNumClasicoGanado = lblNumClasicoGanado;
	}

	/**
	 * @return the txtNumClasicoGanado
	 */
	public JTextField getTxtNumClasicoGanado() {
		return txtNumClasicoGanado;
	}

	/**
	 * @param txtNumClasicoGanado the txtNumClasicoGanado to set
	 */
	public void setTxtNumClasicoGanado(JTextField txtNumClasicoGanado) {
		this.txtNumClasicoGanado = txtNumClasicoGanado;
	}

	/**
	 * @return the lblVelocidadMaxima
	 */
	public JLabel getLblVelocidadMaxima() {
		return lblVelocidadMaxima;
	}

	/**
	 * @param lblVelocidadMaxima the lblVelocidadMaxima to set
	 */
	public void setLblVelocidadMaxima(JLabel lblVelocidadMaxima) {
		this.lblVelocidadMaxima = lblVelocidadMaxima;
	}

	/**
	 * @return the txtVelocidadMaxima
	 */
	public JTextField getTxtVelocidadMaxima() {
		return txtVelocidadMaxima;
	}

	/**
	 * @param txtVelocidadMaxima the txtVelocidadMaxima to set
	 */
	public void setTxtVelocidadMaxima(JTextField txtVelocidadMaxima) {
		this.txtVelocidadMaxima = txtVelocidadMaxima;
	}

	/**
	 * @return the lblPotenciaPromedio
	 */
	public JLabel getLblPotenciaPromedio() {
		return lblPotenciaPromedio;
	}

	/**
	 * @param lblPotenciaPromedio the lblPotenciaPromedio to set
	 */
	public void setLblPotenciaPromedio(JLabel lblPotenciaPromedio) {
		this.lblPotenciaPromedio = lblPotenciaPromedio;
	}

	/**
	 * @return the txtPotenciaPromedio
	 */
	public JTextField getTxtPotenciaPromedio() {
		return txtPotenciaPromedio;
	}

	/**
	 * @param txtPotenciaPromedio the txtPotenciaPromedio to set
	 */
	public void setTxtPotenciaPromedio(JTextField txtPotenciaPromedio) {
		this.txtPotenciaPromedio = txtPotenciaPromedio;
	}

	/**
	 * @return the lblVelocidadPromedio
	 */
	public JLabel getLblVelocidadPromedio() {
		return lblVelocidadPromedio;
	}

	/**
	 * @param lblVelocidadPromedio the lblVelocidadPromedio to set
	 */
	public void setLblVelocidadPromedio(JLabel lblVelocidadPromedio) {
		this.lblVelocidadPromedio = lblVelocidadPromedio;
	}

	/**
	 * @return the txtVelocidadPromedio
	 */
	public JTextField getTxtVelocidadPromedio() {
		return txtVelocidadPromedio;
	}

	/**
	 * @param txtVelocidadPromedio the txtVelocidadPromedio to set
	 */
	public void setTxtVelocidadPromedio(JTextField txtVelocidadPromedio) {
		this.txtVelocidadPromedio = txtVelocidadPromedio;
	}

	/**
	 * @return the lblAceleracionPromedio
	 */
	public JLabel getLblAceleracionPromedio() {
		return lblAceleracionPromedio;
	}

	/**
	 * @param lblAceleracionPromedio the lblAceleracionPromedio to set
	 */
	public void setLblAceleracionPromedio(JLabel lblAceleracionPromedio) {
		this.lblAceleracionPromedio = lblAceleracionPromedio;
	}

	/**
	 * @return the txtAceleracionPromedio
	 */
	public JTextField getTxtAceleracionPromedio() {
		return txtAceleracionPromedio;
	}

	/**
	 * @param txtAceleracionPromedio the txtAceleracionPromedio to set
	 */
	public void setTxtAceleracionPromedio(JTextField txtAceleracionPromedio) {
		this.txtAceleracionPromedio = txtAceleracionPromedio;
	}

	/**
	 * @return the lblGradoRampaSoportada
	 */
	public JLabel getLblGradoRampaSoportada() {
		return lblGradoRampaSoportada;
	}

	/**
	 * @param lblGradoRampaSoportada the lblGradoRampaSoportada to set
	 */
	public void setLblGradoRampaSoportada(JLabel lblGradoRampaSoportada) {
		this.lblGradoRampaSoportada = lblGradoRampaSoportada;
	}

	/**
	 * @return the txtGradoRampaSoportada
	 */
	public JTextField getTxtGradoRampaSoportada() {
		return txtGradoRampaSoportada;
	}

	/**
	 * @param txtGradoRampaSoportada the txtGradoRampaSoportada to set
	 */
	public void setTxtGradoRampaSoportada(JTextField txtGradoRampaSoportada) {
		this.txtGradoRampaSoportada = txtGradoRampaSoportada;
	}

	/**
	 * @return the rbtnAbastecedor
	 */
	public JRadioButton getRbtnAbastecedor() {
		return rbtnAbastecedor;
	}

	/**
	 * @param rbtnAbastecedor the rbtnAbastecedor to set
	 */
	public void setRbtnAbastecedor(JRadioButton rbtnAbastecedor) {
		this.rbtnAbastecedor = rbtnAbastecedor;
	}

	/**
	 * @return the rbtnMantenerRitmo
	 */
	public JRadioButton getRbtnMantenerRitmo() {
		return rbtnMantenerRitmo;
	}

	/**
	 * @param rbtnMantenerRitmo the rbtnMantenerRitmo to set
	 */
	public void setRbtnMantenerRitmo(JRadioButton rbtnMantenerRitmo) {
		this.rbtnMantenerRitmo = rbtnMantenerRitmo;
	}

	/**
	 * @return the rbtnCapturasFuga
	 */
	public JRadioButton getRbtnCapturasFuga() {
		return rbtnCapturasFuga;
	}

	/**
	 * @param rbtnCapturasFuga the rbtnCapturasFuga to set
	 */
	public void setRbtnCapturasFuga(JRadioButton rbtnCapturasFuga) {
		this.rbtnCapturasFuga = rbtnCapturasFuga;
	}

	/**
	 * @return the rbtnPosicionarLider
	 */
	public JRadioButton getRbtnPosicionarLider() {
		return rbtnPosicionarLider;
	}

	/**
	 * @param rbtnPosicionarLider the rbtnPosicionarLider to set
	 */
	public void setRbtnPosicionarLider(JRadioButton rbtnPosicionarLider) {
		this.rbtnPosicionarLider = rbtnPosicionarLider;
	}

	/**
	 * @return the rbtnProtegerLider
	 */
	public JRadioButton getRbtnProtegerLider() {
		return rbtnProtegerLider;
	}

	/**
	 * @param rbtnProtegerLider the rbtnProtegerLider to set
	 */
	public void setRbtnProtegerLider(JRadioButton rbtnProtegerLider) {
		this.rbtnProtegerLider = rbtnProtegerLider;
	}

	/**
	 * @return the lblVelocidadPromedioPedaleo
	 */
	public JLabel getLblVelocidadPromedioPedaleo() {
		return lblVelocidadPromedioPedaleo;
	}

	/**
	 * @param lblVelocidadPromedioPedaleo the lblVelocidadPromedioPedaleo to set
	 */
	public void setLblVelocidadPromedioPedaleo(JLabel lblVelocidadPromedioPedaleo) {
		this.lblVelocidadPromedioPedaleo = lblVelocidadPromedioPedaleo;
	}

	/**
	 * @return the txtVelocidadPromedioPedaleo
	 */
	public JTextField getTxtVelocidadPromedioPedaleo() {
		return txtVelocidadPromedioPedaleo;
	}

	/**
	 * @param txtVelocidadPromedioPedaleo the txtVelocidadPromedioPedaleo to set
	 */
	public void setTxtVelocidadPromedioPedaleo(JTextField txtVelocidadPromedioPedaleo) {
		this.txtVelocidadPromedioPedaleo = txtVelocidadPromedioPedaleo;
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
	 * @return the rbtnClasicoMano
	 */
	public JRadioButton getRbtnClasicoMano() {
		return rbtnClasicoMano;
	}

	/**
	 * @param rbtnClasicoMano the rbtnClasicoMano to set
	 */
	public void setRbtnClasicoMano(JRadioButton rbtnClasicoMano) {
		this.rbtnClasicoMano = rbtnClasicoMano;
	}

	/**
	 * @return the rbtnContrarreloj
	 */
	public JRadioButton getRbtnContrarreloj() {
		return rbtnContrarreloj;
	}

	/**
	 * @param rbtnContrarreloj the rbtnContrarreloj to set
	 */
	public void setRbtnContrarreloj(JRadioButton rbtnContrarreloj) {
		this.rbtnContrarreloj = rbtnContrarreloj;
	}

	/**
	 * @return the rbtnEmbalador
	 */
	public JRadioButton getRbtnEmbalador() {
		return rbtnEmbalador;
	}

	/**
	 * @param rbtnEmbalador the rbtnEmbalador to set
	 */
	public void setRbtnEmbalador(JRadioButton rbtnEmbalador) {
		this.rbtnEmbalador = rbtnEmbalador;
	}

	/**
	 * @return the rbtnEscalador
	 */
	public JRadioButton getRbtnEscalador() {
		return rbtnEscalador;
	}

	/**
	 * @param rbtnEscalador the rbtnEscalador to set
	 */
	public void setRbtnEscalador(JRadioButton rbtnEscalador) {
		this.rbtnEscalador = rbtnEscalador;
	}

	/**
	 * @return the rbtnGregario
	 */
	public JRadioButton getRbtnGregario() {
		return rbtnGregario;
	}

	/**
	 * @param rbtnGregario the rbtnGregario to set
	 */
	public void setRbtnGregario(JRadioButton rbtnGregario) {
		this.rbtnGregario = rbtnGregario;
	}

	/**
	 * @return the rbtnRodador
	 */
	public JRadioButton getRbtnRodador() {
		return rbtnRodador;
	}

	/**
	 * @param rbtnRodador the rbtnRodador to set
	 */
	public void setRbtnRodador(JRadioButton rbtnRodador) {
		this.rbtnRodador = rbtnRodador;
	}

	/**
	 * @return the rbtnVacio
	 */
	public JRadioButton getRbtnVacio() {
		return rbtnVacio;
	}

	/**
	 * @param rbtnVacio the rbtnVacio to set
	 */
	public void setRbtnVacio(JRadioButton rbtnVacio) {
		this.rbtnVacio = rbtnVacio;
	}

	/**
	 * @return the rbtnTareaCVisualizar
	 */
	public JRadioButton getRbtnTareaCVisualizar() {
		return rbtnTareaCVisualizar;
	}

	/**
	 * @param rbtnTareaCVisualizar the rbtnTareaCVisualizar to set
	 */
	public void setRbtnTareaCVisualizar(JRadioButton rbtnTareaCVisualizar) {
		this.rbtnTareaCVisualizar = rbtnTareaCVisualizar;
	}

	/**
	 * @return the rbtnTareaCConcentrarse
	 */
	public JRadioButton getRbtnTareaCConcentrarse() {
		return rbtnTareaCConcentrarse;
	}

	/**
	 * @param rbtnTareaCConcentrarse the rbtnTareaCConcentrarse to set
	 */
	public void setRbtnTareaCConcentrarse(JRadioButton rbtnTareaCConcentrarse) {
		this.rbtnTareaCConcentrarse = rbtnTareaCConcentrarse;
	}

	/**
	 * @return the rbtnTareaCRegular
	 */
	public JRadioButton getRbtnTareaCRegular() {
		return rbtnTareaCRegular;
	}

	/**
	 * @param rbtnTareaCRegular the rbtnTareaCRegular to set
	 */
	public void setRbtnTareaCRegular(JRadioButton rbtnTareaCRegular) {
		this.rbtnTareaCRegular = rbtnTareaCRegular;
	}

	/**
	 * @return the rbtnTareaEmAumentarRitmo
	 */
	public JRadioButton getRbtnTareaEmAumentarRitmo() {
		return rbtnTareaEmAumentarRitmo;
	}

	/**
	 * @param rbtnTareaEmAumentarRitmo the rbtnTareaEmAumentarRitmo to set
	 */
	public void setRbtnTareaEmAumentarRitmo(JRadioButton rbtnTareaEmAumentarRitmo) {
		this.rbtnTareaEmAumentarRitmo = rbtnTareaEmAumentarRitmo;
	}

	/**
	 * @return the rbtnTareaEmBajarRitmo
	 */
	public JRadioButton getRbtnTareaEmBajarRitmo() {
		return rbtnTareaEmBajarRitmo;
	}

	/**
	 * @param rbtnTareaEmBajarRitmo the rbtnTareaEmBajarRitmo to set
	 */
	public void setRbtnTareaEmBajarRitmo(JRadioButton rbtnTareaEmBajarRitmo) {
		this.rbtnTareaEmBajarRitmo = rbtnTareaEmBajarRitmo;
	}

	/**
	 * @return the rbtnTareaEsPedalearS
	 */
	public JRadioButton getRbtnTareaEsPedalearS() {
		return rbtnTareaEsPedalearS;
	}

	/**
	 * @param rbtnTareaEsPedalearS the rbtnTareaEsPedalearS to set
	 */
	public void setRbtnTareaEsPedalearS(JRadioButton rbtnTareaEsPedalearS) {
		this.rbtnTareaEsPedalearS = rbtnTareaEsPedalearS;
	}

	/**
	 * @return the rbtnTareaEsPedalearP
	 */
	public JRadioButton getRbtnTareaEsPedalearP() {
		return rbtnTareaEsPedalearP;
	}

	/**
	 * @param rbtnTareaEsPedalearP the rbtnTareaEsPedalearP to set
	 */
	public void setRbtnTareaEsPedalearP(JRadioButton rbtnTareaEsPedalearP) {
		this.rbtnTareaEsPedalearP = rbtnTareaEsPedalearP;
	}

	/**
	 * @return the lblCadenciaPedaleo2
	 */
	public JLabel getLblCadenciaPedaleo2() {
		return lblCadenciaPedaleo2;
	}

	/**
	 * @param lblCadenciaPedaleo2 the lblCadenciaPedaleo2 to set
	 */
	public void setLblCadenciaPedaleo2(JLabel lblCadenciaPedaleo2) {
		this.lblCadenciaPedaleo2 = lblCadenciaPedaleo2;
	}

	/**
	 * @return the lblPotenciaPromedio1
	 */
	public JLabel getLblPotenciaPromedio1() {
		return lblPotenciaPromedio1;
	}

	/**
	 * @param lblPotenciaPromedio1 the lblPotenciaPromedio1 to set
	 */
	public void setLblPotenciaPromedio1(JLabel lblPotenciaPromedio1) {
		this.lblPotenciaPromedio1 = lblPotenciaPromedio1;
	}

	/**
	 * @return the lblAceleracionPromedio1
	 */
	public JLabel getLblAceleracionPromedio1() {
		return lblAceleracionPromedio1;
	}

	/**
	 * @param lblAceleracionPromedio1 the lblAceleracionPromedio1 to set
	 */
	public void setLblAceleracionPromedio1(JLabel lblAceleracionPromedio1) {
		this.lblAceleracionPromedio1 = lblAceleracionPromedio1;
	}

	/**
	 * @return the lblVelocidadPromedioPedaleo1
	 */
	public JLabel getLblVelocidadPromedioPedaleo1() {
		return lblVelocidadPromedioPedaleo1;
	}

	/**
	 * @param lblVelocidadPromedioPedaleo1 the lblVelocidadPromedioPedaleo1 to set
	 */
	public void setLblVelocidadPromedioPedaleo1(JLabel lblVelocidadPromedioPedaleo1) {
		this.lblVelocidadPromedioPedaleo1 = lblVelocidadPromedioPedaleo1;
	}

}
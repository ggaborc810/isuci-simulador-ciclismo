/**
 * package in charge of storing the entire graphical user interface
*/
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


public class PanelActualizarCiclista extends JPanel{
	
	// Instance variables

	/** The button to send data. */
	private JButton btnEnviar;

	/** The label for the send button. */
	private JLabel lblEnviar;

	/** The button to go back. */
	private JButton btnVolver;

	/** The label for the back button. */
	private JLabel lblVolver;

	/** The label for the new name field. */
	private JLabel lblNuevoNombre;

	/** The text field for the new name. */
	private JTextField txtNuevoNombre;

	/** The label for the new ID field. */
	private JLabel lblNuevoCedula;

	/** The text field for the new ID. */
	private JTextField txtNuevoCedula;

	/** The label for the new gender field. */
	private JLabel lblNuevoGenero;

	/** The combo box for selecting the new gender. */
	private JComboBox boxNuevoGenero;

	/** The label for the new email field. */
	private JLabel lblNuevocorreoElectronico;

	/** The text field for the new email. */
	private JTextField txtNuevocorreoElectronico;

	/** The label for the new username field. */
	private JLabel lblNuevoNombreUsuario;

	/** The text field for the new username. */
	private JTextField txtNuevoNombreUsuario;

	/** The label for the new password field. */
	private JLabel lblNuevoContrasenia;

	/** The text field for the new password. */
	private JTextField txtNuevoContrasenia;

	/** The label for the new ID field. */
	private JLabel lblNuevoId;

	/** The text field for the new ID. */
	private JTextField txtNuevoId;

	/** The label for the new accumulated time field. */
	private JLabel lblNuevoTiempoAcumulado;

	/** The text field for the new accumulated time. */
	private JTextField txtNuevoTiempoAcumulado;

	/** The label for the new body type field. */
	private JLabel lblNuevoContextura;

	/** The text field for the new body type. */
	private JTextField txtNuevoContextura;

	/** The label for the new pedal cadence field. */
	private JLabel lblNuevoCadenciaPedaleo;

	/** The text field for the new pedal cadence. */
	private JTextField txtNuevoCadenciaPedaleo;

	/** The label for the new experience years field. */
	private JLabel lblNuevoAniosExperiencia;

	/** The text field for the new experience years. */
	private JTextField txtNuevoAniosExperiencia;

	
	// Instance variables

	/** The label for the new number of classic wins field (clasicoMano). */
	private JLabel lblNuevoNumClasicoGanado;

	/** The text field for the new number of classic wins (clasicoMano). */
	private JTextField txtNuevoNumClasicoGanado;

	// ContrReloj

	/** The label for the new maximum speed field (ContrReloj). */
	private JLabel lblNuevoVelocidadMaxima;

	/** The text field for the new maximum speed (ContrReloj). */
	private JTextField txtNuevoVelocidadMaxima;

	// Embalador

	/** The label for the new average power field (Embalador). */
	private JLabel lblNuevoPotenciaPromedio;

	/** The text field for the new average power (Embalador). */
	private JTextField txtNuevoPotenciaPromedio;

	/** The label for the new average speed field (Embalador). */
	private JLabel lblNuevaVelocidadPromedio;

	/** The text field for the new average speed (Embalador). */
	private JTextField txtNuevoVelocidadPromedio;

	// Escalador

	/** The label for the new average acceleration field (Escalador). */
	private JLabel lblNuevoAceleracionPromedio;

	/** The text field for the new average acceleration (Escalador). */
	private JTextField txtNuevoAceleracionPromedio;

	/** The label for the new supported ramp grade field (Escalador). */
	private JLabel lblNuevoGradoRampaSoportada;

	/** The text field for the new supported ramp grade (Escalador). */
	private JTextField txtNuevoGradoRampaSoportada;

	// Gregario

	/** The radio button for the new supplier role (Gregario). */
	private JRadioButton rbtnNuevoAbastecedor;

	/** The radio button for the new maintaining pace role (Gregario). */
	private JRadioButton rbtnNuevoMantenerRitmo;

	/** The radio button for the new breakaway capture role (Gregario). */
	private JRadioButton rbtnNuevoCapturasFuga;

	/** The radio button for the new leader positioning role (Gregario). */
	private JRadioButton rbtnNuevoPosicionarLider;

	/** The radio button for the new leader protection role (Gregario). */
	private JRadioButton rbtnNuevoProtegerLider;

	// Rodador

	/** The label for the new average pedaling speed field (Rodador). */
	private JLabel lblNuevoVelocidadPromedioPedaleo;

	/** The text field for the new average pedaling speed (Rodador). */
	private JTextField txtNuevoVelocidadPromedioPedaleo;

	// Image and title

	/** The image icon for the background or other graphical elements. */
	private ImageIcon imagen;

	/** The label for the title. */
	private JLabel lblTitulo;

	// Ciclista types radio buttons

	/** The radio button for the new classic mano role. */
	private JRadioButton rbtnNuevoClasicoMano;

	/** The radio button for the new time trial role. */
	private JRadioButton rbtnNuevoContrarreloj;

	/** The radio button for the new sprinter role. */
	private JRadioButton rbtnNuevoEmbalador;

	/** The radio button for the new climber role. */
	private JRadioButton rbtnNuevoEscalador;

	/** The radio button for the new gregario role. */
	private JRadioButton rbtnNuevoGregario;

	/** The radio button for the new rouleur role. */
	private JRadioButton rbtnNuevoRodador;

	/** The radio button for no role. */
	private JRadioButton rbtnNuevoVacio;

	// Time trial tasks

	/** The radio button for the new visualization task (Contrarreloj). */
	private JRadioButton rbtnNuevoTareaCVisualizar;

	/** The radio button for the new concentration task (Contrarreloj). */
	private JRadioButton rbtnNuevoTareaCConcentrarse;

	/** The radio button for the new pacing task (Contrarreloj). */
	private JRadioButton rbtnNuevoTareaCRegular;

	// Sprinter tasks

	/** The radio button for the new increase pace task (Embalador). */
	private JRadioButton rbtnNuevoTareaEmAumentarRitmo;

	/** The radio button for the new decrease pace task (Embalador). */
	private JRadioButton rbtnNuevoTareaEmBajarRitmo;

	// Climber tasks

	/** The radio button for the new seated pedaling task (Escalador). */
	private JRadioButton rbtnNuevoTareaEsPedalearS;

	/** The radio button for the new standing pedaling task (Escalador). */
	private JRadioButton rbtnNuevoTareaEsPedalearP;
;
	
/** The label for the new cadencia pedaleo field. */
private JLabel lblNuevoCadenciaPedaleo2;

/** The label for the first new average power field. */
private JLabel lblNuevoPotenciaPromedio1;

/** The label for the first new average acceleration field. */
private JLabel lblNuevoAceleracionPromedio1;

/** The label for the first new average pedaling speed field. */
private JLabel lblNuevoVelocidadPromedioPedaleo1;
/**
 * class constructor  PanelActualizarCiclista
 */
	public PanelActualizarCiclista() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY); 

		lblTitulo = generarMensaje("CREAR CICLISTA", 420, 20, 320, 30);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		rbtnNuevoClasicoMano = generarRadioBoton("Clasicómano", 20, 70, 130, 30);
		rbtnNuevoContrarreloj = generarRadioBoton("Contrarreloj", 160, 70, 120, 30);
		rbtnNuevoEmbalador = generarRadioBoton("Embalador", 300, 70, 120, 30);
		rbtnNuevoEscalador = generarRadioBoton("Escalador", 440, 70, 120, 30);
		rbtnNuevoGregario = generarRadioBoton("Gregario", 580, 70, 100, 30);
		rbtnNuevoRodador = generarRadioBoton("Rodador", 720, 70, 90, 30);
		rbtnNuevoVacio = generarRadioBoton("Sin Atributos", 860, 70, 200, 30);



		lblNuevoNombre = generarMensaje("Nombre:", 20, 115, 100, 50);
		txtNuevoNombre = generarEscritura(20, 155, 110, 30);
		
		lblNuevoGenero = generarMensaje("Genero:", 240, 115, 100, 50);
		boxNuevoGenero = generarGenero(240, 155, 110, 30);
		
		lblNuevoId = generarMensaje("Identificador:", 430, 115, 160, 50);
		txtNuevoId = generarEscritura(430, 155, 110, 30);
		
		lblNuevoCedula = generarMensaje("Cedula: ",640, 115, 300, 50 );
		txtNuevoCedula = generarEscritura(640, 155, 110, 30 );
		
		lblNuevocorreoElectronico = generarMensaje("Correo Electronico:", 795, 115, 200, 50);
		txtNuevocorreoElectronico = generarEscritura(815, 155, 110, 30);
		
		
		lblNuevoNombreUsuario = generarMensaje("Nombre de usuario:",20,220,200,30); 
		txtNuevoNombreUsuario = generarEscritura(20, 255, 110, 30);
		
		lblNuevoContrasenia = generarMensaje("Contraseña:",240,220,200,30 );
		txtNuevoContrasenia = generarEscritura(240, 255, 110, 30);
		
		lblNuevoTiempoAcumulado = generarMensaje("Tiempo Acumulado:", 410,220,200,30 );
		txtNuevoTiempoAcumulado = generarEscritura(430, 255, 110, 30 );
		
		lblNuevoContextura = generarMensaje("Contextura:", 810, 220, 200, 30);
		txtNuevoContextura = generarEscritura(810, 255, 110, 30);
		
		lblNuevoCadenciaPedaleo = generarMensaje("Cadenacia",640, 190, 220, 50);
		lblNuevoCadenciaPedaleo2 = generarMensaje("pedaleo:",640, 210, 220, 50);
		txtNuevoCadenciaPedaleo = generarEscritura(640, 255, 110, 30);
		lblNuevoCadenciaPedaleo.setFont(new Font("Banschrift", Font.BOLD, 18));
		
		
		lblNuevoAniosExperiencia = generarMensaje("Años Experiencia:",20 ,305 ,300 ,30);
		txtNuevoAniosExperiencia = generarEscritura(20,340, 110,30);
		
		
		lblNuevoNumClasicoGanado = generarMensaje("Clasicos Ganados:",220,305 ,300 ,30);
		txtNuevoNumClasicoGanado = generarEscritura(240,340, 110,30);
		
		lblNuevoVelocidadMaxima = generarMensaje("Velocidad Maxima:",220,305 ,300 ,30);
		txtNuevoVelocidadMaxima = generarEscritura(240,340, 110,30);
		
		ButtonGroup grupoBotones1 = new ButtonGroup();
		
		rbtnNuevoTareaCVisualizar = generarRadioBoton("visualizar", 430, 320, 200, 30);
		rbtnNuevoTareaCConcentrarse = generarRadioBoton("concentrarse", 620, 320, 200, 30);
        rbtnNuevoTareaCRegular = generarRadioBoton("regular", 810, 320, 200, 30);
        
        //tareas escalador
        rbtnNuevoTareaEsPedalearS = generarRadioBoton("Pedalear sentado", 620,310 ,200 ,30);
        rbtnNuevoTareaEsPedalearP = generarRadioBoton("Pedalear parado", 620, 370, 200, 30);

      //tareas embalador
        rbtnNuevoTareaEmAumentarRitmo = generarRadioBoton("Aumentar ritmo", 620,340 ,150 ,30);
        rbtnNuevoTareaEmBajarRitmo = generarRadioBoton("Bajar ritmo", 790,340, 110,30);
		lblNuevoPotenciaPromedio = generarMensaje("Potencia",240,295 ,300 ,30);
		lblNuevoPotenciaPromedio1 = generarMensaje("Promedio:",240,315 ,300 ,30);
		txtNuevoPotenciaPromedio = generarEscritura(240,340, 110,30);
		lblNuevaVelocidadPromedio = generarMensaje("Velocidad Promedio:",410,305,200,30);
		txtNuevoVelocidadPromedio = generarEscritura(430, 340, 110, 30);
		
		
		lblNuevoAceleracionPromedio = generarMensaje("Aceleración",240,290 ,300 ,30);
		lblNuevoAceleracionPromedio1 = generarMensaje("Promedio:",240,305 ,300 ,30);
		txtNuevoAceleracionPromedio = generarEscritura(240,340, 110,30);
		lblNuevoGradoRampaSoportada = generarMensaje("Grado de la rampa:",410,305,200,30);
		txtNuevoGradoRampaSoportada = generarEscritura(430, 340, 110, 30);
		
		
		
		rbtnNuevoAbastecedor = generarRadioBoton("Abastecedor",240, 350, 200,30);
		rbtnNuevoMantenerRitmo = generarRadioBoton("Mantener el Ritmo",410,350, 200,30);
		rbtnNuevoCapturasFuga = generarRadioBoton("Capturar Fuga", 640, 350, 200, 30);
		rbtnNuevoPosicionarLider = generarRadioBoton("Posicionar Lider", 240, 400, 150,30);
		rbtnNuevoProtegerLider = generarRadioBoton("Protege al lider", 410,400, 200,30);
		
		lblNuevoVelocidadPromedioPedaleo = generarMensaje("Velocidad Promedio",240,300 ,300 ,30);
		lblNuevoVelocidadPromedioPedaleo1 = generarMensaje("Pedaleo:",240,315 ,300 ,30);
		txtNuevoVelocidadPromedioPedaleo = generarEscritura(240,345, 110,30);
		
		btnEnviar = generarBoton("ENVIAR", 930, 500, 30, 30, "fotos/rueda.png");
		lblEnviar = generarMensaje("Enviar", 850, 500, 200, 30);
		lblEnviar.setFont(new Font("Banschrift", Font.BOLD, 25));
		
		btnVolver = generarBoton("VOLVER", 30, 500, 30, 30, "fotos/rueda.png");
		lblVolver = generarMensaje("Volver", 65, 500, 200, 30);
		lblVolver.setFont(new Font("Banschrift", Font.BOLD, 25));
		
		imagen = new ImageIcon("fotos/PanelActualizarCiclista.png");

//		add(lblTitulo);
		add(rbtnNuevoClasicoMano);
		add(rbtnNuevoContrarreloj);
		add(rbtnNuevoEmbalador);
		add(rbtnNuevoEscalador);
		add(rbtnNuevoGregario);
		add(rbtnNuevoRodador);
		add(rbtnNuevoVacio);
//		add(imagen);

		add(lblNuevoCedula);
		add(txtNuevoCedula);
		add(lblNuevoGenero);
		add(boxNuevoGenero);
		add(lblNuevocorreoElectronico);
		add(txtNuevocorreoElectronico);
		add(lblNuevoNombreUsuario);
		add(txtNuevoNombreUsuario);
		add(lblNuevoContrasenia);
		add(txtNuevoContrasenia);
		add(lblNuevoId);
		add(txtNuevoId);
		add(lblNuevoTiempoAcumulado);
		add(txtNuevoTiempoAcumulado);
		add(lblNuevoContextura);
		add(txtNuevoContextura);
		add(lblNuevoCadenciaPedaleo);
		add(lblNuevoCadenciaPedaleo2);
		add(txtNuevoCadenciaPedaleo);
		add(lblNuevoAniosExperiencia);
		add(txtNuevoAniosExperiencia);
		
		add(lblNuevoNumClasicoGanado).setVisible(false);
		add(txtNuevoNumClasicoGanado).setVisible(false);
		add(lblNuevoVelocidadMaxima).setVisible(false);;
		add(txtNuevoVelocidadMaxima).setVisible(false);;
		add(lblNuevoPotenciaPromedio).setVisible(false);
		add(lblNuevoPotenciaPromedio1).setVisible(false);
		add(txtNuevoPotenciaPromedio).setVisible(false);
		add(lblNuevaVelocidadPromedio).setVisible(false);
		add(txtNuevoVelocidadPromedio).setVisible(false);
		
		add(lblNuevoAceleracionPromedio).setVisible(false);
		add(lblNuevoAceleracionPromedio1).setVisible(false);
		add(txtNuevoAceleracionPromedio).setVisible(false);
		add(lblNuevoGradoRampaSoportada).setVisible(false);
		add(txtNuevoGradoRampaSoportada).setVisible(false); 


		
		add(rbtnNuevoAbastecedor).setVisible(false);
		add(rbtnNuevoMantenerRitmo).setVisible(false);
		add(rbtnNuevoCapturasFuga).setVisible(false);
		add(rbtnNuevoPosicionarLider).setVisible(false);
		add(rbtnNuevoProtegerLider).setVisible(false);
		
		add(rbtnNuevoTareaCConcentrarse).setVisible(false);
		add(rbtnNuevoTareaCRegular).setVisible(false);
		add(rbtnNuevoTareaCVisualizar).setVisible(false);
		
		add(rbtnNuevoTareaEmAumentarRitmo).setVisible(false);
		add(rbtnNuevoTareaEmBajarRitmo).setVisible(false);
		
		add(rbtnNuevoTareaEsPedalearS).setVisible(false);
		add(rbtnNuevoTareaEsPedalearP).setVisible(false);

		add(lblNuevoVelocidadPromedioPedaleo).setVisible(false);
		add(txtNuevoVelocidadPromedioPedaleo).setVisible(false);
		
		add(lblEnviar);
		add(btnEnviar);
		add(btnVolver);
		add(lblVolver);
		add(lblNuevoNombre);
		add(txtNuevoNombre);
		grupoBotones.add(rbtnNuevoClasicoMano);
        grupoBotones.add(rbtnNuevoContrarreloj);
        grupoBotones.add(rbtnNuevoEmbalador);
        grupoBotones.add(rbtnNuevoEscalador);
        grupoBotones.add(rbtnNuevoGregario);
        grupoBotones.add(rbtnNuevoRodador);
        grupoBotones.add(rbtnNuevoVacio);
        
        grupoBotones.add(rbtnNuevoTareaEmAumentarRitmo);
        grupoBotones.add(rbtnNuevoTareaEmBajarRitmo);
        
        grupoBotones.add(rbtnNuevoTareaEsPedalearS);
        grupoBotones.add(rbtnNuevoTareaEsPedalearP);
        
        grupoBotones.add(rbtnNuevoTareaCVisualizar);
		grupoBotones.add(rbtnNuevoTareaCConcentrarse);
        grupoBotones.add(rbtnNuevoTareaCRegular);
        
        grupoBotones1.add(rbtnNuevoTareaEmAumentarRitmo);
        grupoBotones1.add(rbtnNuevoTareaEmBajarRitmo);
        
        grupoBotones1.add(rbtnNuevoTareaEsPedalearS);
        grupoBotones1.add(rbtnNuevoTareaEsPedalearP);
        
        grupoBotones1.add(rbtnNuevoTareaCVisualizar);
		grupoBotones1.add(rbtnNuevoTareaCConcentrarse);
        grupoBotones1.add(rbtnNuevoTareaCRegular);
        
		repaint();
		

	}
	

    /**
     * Clears the text fields in the panel.
     */
	public void limpiarPanel() {
		txtNuevoAceleracionPromedio.setText("");
		txtNuevoAniosExperiencia.setText("");
		txtNuevoCadenciaPedaleo.setText("");
		txtNuevoContextura.setText("");
		txtNuevoGradoRampaSoportada.setText("");
		txtNuevoNombre.setText("");
		txtNuevoNumClasicoGanado.setText("");
		txtNuevoPotenciaPromedio.setText("");
		txtNuevoTiempoAcumulado.setText("");
		txtNuevoVelocidadMaxima.setText("");
		txtNuevoVelocidadPromedio.setText("");
		txtNuevoVelocidadPromedioPedaleo.setText("");
		txtNuevoId.setText("");
	}
	/**
     * Generates a button with the specified properties.
     *
     * @param texto the text to be displayed on the button
     * @param x     the x-coordinate of the button
     * @param y     the y-coordinate of the button
     * @param ancho the width of the button
     * @param alto  the height of the button
     * @param url   the URL of the icon image
     * @return the generated JButton
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
     * Generates a radio button with the specified properties.
     *
     * @param texto the text to be displayed on the radio button
     * @param x     the x-coordinate of the radio button
     * @param y     the y-coordinate of the radio button
     * @param ancho the width of the radio button
     * @param alto  the height of the radio button
     * @return the generated JRadioButton
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
     * Generates a label with the specified properties.
     *
     * @param texto the text to be displayed on the label
     * @param x     the x-coordinate of the label
     * @param y     the y-coordinate of the label
     * @param ancho the width of the label
     * @param alto  the height of the label
     * @return the generated JLabel
     */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Banschrift", Font.BOLD, 18));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}


    /**
     * Generates a text field with the specified properties.
     *
     * @param x     the x-coordinate of the text field
     * @param y     the y-coordinate of the text field
     * @param ancho the width of the text field
     * @param alto  the height of the text field
     * @return the generated JTextField
     */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}


    /**
     * Generates a combo box for gender selection with the specified properties.
     *
     * @param x     the x-coordinate of the combo box
     * @param y     the y-coordinate of the combo box
     * @param ancho the width of the combo box
     * @param alto  the height of the combo box
     * @return the generated JComboBox
     */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = {"Hombre", "Mujer" };

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
	 * clean update panel cyclist
	 */
	public void limpiarPanelActualizarCiclista() {
		add(lblNuevoNumClasicoGanado).setVisible(false);
		add(txtNuevoNumClasicoGanado).setVisible(false);
		add(lblNuevoVelocidadMaxima).setVisible(false);;
		add(txtNuevoVelocidadMaxima).setVisible(false);;
		add(lblNuevoPotenciaPromedio).setVisible(false);
		add(lblNuevoPotenciaPromedio1).setVisible(false);
		add(txtNuevoPotenciaPromedio).setVisible(false);
		add(lblNuevaVelocidadPromedio).setVisible(false);
		add(txtNuevoVelocidadPromedio).setVisible(false);
		
		add(lblNuevoAceleracionPromedio).setVisible(false);
		add(lblNuevoAceleracionPromedio1).setVisible(false);
		add(txtNuevoAceleracionPromedio).setVisible(false);
		add(lblNuevoGradoRampaSoportada).setVisible(false);
		add(txtNuevoGradoRampaSoportada).setVisible(false); 


		
		add(rbtnNuevoAbastecedor).setVisible(false);
		add(rbtnNuevoMantenerRitmo).setVisible(false);
		add(rbtnNuevoCapturasFuga).setVisible(false);
		add(rbtnNuevoPosicionarLider).setVisible(false);
		add(rbtnNuevoProtegerLider).setVisible(false);

		add(lblNuevoVelocidadPromedioPedaleo).setVisible(false);
		add(lblNuevoVelocidadPromedioPedaleo1).setVisible(false);
		add(txtNuevoVelocidadPromedioPedaleo).setVisible(false);
		
		add(rbtnNuevoTareaCConcentrarse).setVisible(false);
		add(rbtnNuevoTareaCRegular).setVisible(false);
		add(rbtnNuevoTareaCVisualizar).setVisible(false);
		
		add(rbtnNuevoTareaEmAumentarRitmo).setVisible(false);
		add(rbtnNuevoTareaEmBajarRitmo).setVisible(false);
		
		add(rbtnNuevoTareaEsPedalearS).setVisible(false);
		add(rbtnNuevoTareaEsPedalearP).setVisible(false);
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
	 * @return the lblNuevoNombre
	 */
	public JLabel getLblNuevoNombre() {
		return lblNuevoNombre;
	}


	/**
	 * @param lblNuevoNombre the lblNuevoNombre to set
	 */
	public void setLblNuevoNombre(JLabel lblNuevoNombre) {
		this.lblNuevoNombre = lblNuevoNombre;
	}


	/**
	 * @return the txtNuevoNombre
	 */
	public JTextField getTxtNuevoNombre() {
		return txtNuevoNombre;
	}


	/**
	 * @param txtNuevoNombre the txtNuevoNombre to set
	 */
	public void setTxtNuevoNombre(JTextField txtNuevoNombre) {
		this.txtNuevoNombre = txtNuevoNombre;
	}


	/**
	 * @return the lblNuevoCedula
	 */
	public JLabel getLblNuevoCedula() {
		return lblNuevoCedula;
	}


	/**
	 * @param lblNuevoCedula the lblNuevoCedula to set
	 */
	public void setLblNuevoCedula(JLabel lblNuevoCedula) {
		this.lblNuevoCedula = lblNuevoCedula;
	}


	/**
	 * @return the txtNuevoCedula
	 */
	public JTextField getTxtNuevoCedula() {
		return txtNuevoCedula;
	}


	/**
	 * @param txtNuevoCedula the txtNuevoCedula to set
	 */
	public void setTxtNuevoCedula(JTextField txtNuevoCedula) {
		this.txtNuevoCedula = txtNuevoCedula;
	}


	/**
	 * @return the lblNuevoGenero
	 */
	public JLabel getLblNuevoGenero() {
		return lblNuevoGenero;
	}


	/**
	 * @param lblNuevoGenero the lblNuevoGenero to set
	 */
	public void setLblNuevoGenero(JLabel lblNuevoGenero) {
		this.lblNuevoGenero = lblNuevoGenero;
	}


	/**
	 * @return the boxNuevoGenero
	 */
	public JComboBox getBoxNuevoGenero() {
		return boxNuevoGenero;
	}


	/**
	 * @param boxNuevoGenero the boxNuevoGenero to set
	 */
	public void setBoxNuevoGenero(JComboBox boxNuevoGenero) {
		this.boxNuevoGenero = boxNuevoGenero;
	}


	/**
	 * @return the lblNuevocorreoElectronico
	 */
	public JLabel getLblNuevocorreoElectronico() {
		return lblNuevocorreoElectronico;
	}


	/**
	 * @param lblNuevocorreoElectronico the lblNuevocorreoElectronico to set
	 */
	public void setLblNuevocorreoElectronico(JLabel lblNuevocorreoElectronico) {
		this.lblNuevocorreoElectronico = lblNuevocorreoElectronico;
	}


	/**
	 * @return the txtNuevocorreoElectronico
	 */
	public JTextField getTxtNuevocorreoElectronico() {
		return txtNuevocorreoElectronico;
	}


	/**
	 * @param txtNuevocorreoElectronico the txtNuevocorreoElectronico to set
	 */
	public void setTxtNuevocorreoElectronico(JTextField txtNuevocorreoElectronico) {
		this.txtNuevocorreoElectronico = txtNuevocorreoElectronico;
	}


	/**
	 * @return the lblNuevoNombreUsuario
	 */
	public JLabel getLblNuevoNombreUsuario() {
		return lblNuevoNombreUsuario;
	}


	/**
	 * @param lblNuevoNombreUsuario the lblNuevoNombreUsuario to set
	 */
	public void setLblNuevoNombreUsuario(JLabel lblNuevoNombreUsuario) {
		this.lblNuevoNombreUsuario = lblNuevoNombreUsuario;
	}


	/**
	 * @return the txtNuevoNombreUsuario
	 */
	public JTextField getTxtNuevoNombreUsuario() {
		return txtNuevoNombreUsuario;
	}


	/**
	 * @param txtNuevoNombreUsuario the txtNuevoNombreUsuario to set
	 */
	public void setTxtNuevoNombreUsuario(JTextField txtNuevoNombreUsuario) {
		this.txtNuevoNombreUsuario = txtNuevoNombreUsuario;
	}


	/**
	 * @return the lblNuevoContrasenia
	 */
	public JLabel getLblNuevoContrasenia() {
		return lblNuevoContrasenia;
	}


	/**
	 * @param lblNuevoContrasenia the lblNuevoContrasenia to set
	 */
	public void setLblNuevoContrasenia(JLabel lblNuevoContrasenia) {
		this.lblNuevoContrasenia = lblNuevoContrasenia;
	}


	/**
	 * @return the txtNuevoContrasenia
	 */
	public JTextField getTxtNuevoContrasenia() {
		return txtNuevoContrasenia;
	}


	/**
	 * @param txtNuevoContrasenia the txtNuevoContrasenia to set
	 */
	public void setTxtNuevoContrasenia(JTextField txtNuevoContrasenia) {
		this.txtNuevoContrasenia = txtNuevoContrasenia;
	}


	/**
	 * @return the lblNuevoId
	 */
	public JLabel getLblNuevoId() {
		return lblNuevoId;
	}


	/**
	 * @param lblNuevoId the lblNuevoId to set
	 */
	public void setLblNuevoId(JLabel lblNuevoId) {
		this.lblNuevoId = lblNuevoId;
	}


	/**
	 * @return the txtNuevoId
	 */
	public JTextField getTxtNuevoId() {
		return txtNuevoId;
	}


	/**
	 * @param txtNuevoId the txtNuevoId to set
	 */
	public void setTxtNuevoId(JTextField txtNuevoId) {
		this.txtNuevoId = txtNuevoId;
	}


	/**
	 * @return the lblNuevoTiempoAcumulado
	 */
	public JLabel getLblNuevoTiempoAcumulado() {
		return lblNuevoTiempoAcumulado;
	}


	/**
	 * @param lblNuevoTiempoAcumulado the lblNuevoTiempoAcumulado to set
	 */
	public void setLblNuevoTiempoAcumulado(JLabel lblNuevoTiempoAcumulado) {
		this.lblNuevoTiempoAcumulado = lblNuevoTiempoAcumulado;
	}


	/**
	 * @return the txtNuevoTiempoAcumulado
	 */
	public JTextField getTxtNuevoTiempoAcumulado() {
		return txtNuevoTiempoAcumulado;
	}


	/**
	 * @param txtNuevoTiempoAcumulado the txtNuevoTiempoAcumulado to set
	 */
	public void setTxtNuevoTiempoAcumulado(JTextField txtNuevoTiempoAcumulado) {
		this.txtNuevoTiempoAcumulado = txtNuevoTiempoAcumulado;
	}


	/**
	 * @return the lblNuevoContextura
	 */
	public JLabel getLblNuevoContextura() {
		return lblNuevoContextura;
	}


	/**
	 * @param lblNuevoContextura the lblNuevoContextura to set
	 */
	public void setLblNuevoContextura(JLabel lblNuevoContextura) {
		this.lblNuevoContextura = lblNuevoContextura;
	}


	/**
	 * @return the txtNuevoContextura
	 */
	public JTextField getTxtNuevoContextura() {
		return txtNuevoContextura;
	}


	/**
	 * @param txtNuevoContextura the txtNuevoContextura to set
	 */
	public void setTxtNuevoContextura(JTextField txtNuevoContextura) {
		this.txtNuevoContextura = txtNuevoContextura;
	}


	/**
	 * @return the lblNuevoCadenciaPedaleo
	 */
	public JLabel getLblNuevoCadenciaPedaleo() {
		return lblNuevoCadenciaPedaleo;
	}


	/**
	 * @param lblNuevoCadenciaPedaleo the lblNuevoCadenciaPedaleo to set
	 */
	public void setLblNuevoCadenciaPedaleo(JLabel lblNuevoCadenciaPedaleo) {
		this.lblNuevoCadenciaPedaleo = lblNuevoCadenciaPedaleo;
	}


	/**
	 * @return the txtNuevoCadenciaPedaleo
	 */
	public JTextField getTxtNuevoCadenciaPedaleo() {
		return txtNuevoCadenciaPedaleo;
	}


	/**
	 * @param txtNuevoCadenciaPedaleo the txtNuevoCadenciaPedaleo to set
	 */
	public void setTxtNuevoCadenciaPedaleo(JTextField txtNuevoCadenciaPedaleo) {
		this.txtNuevoCadenciaPedaleo = txtNuevoCadenciaPedaleo;
	}


	/**
	 * @return the lblNuevoAniosExperiencia
	 */
	public JLabel getLblNuevoAniosExperiencia() {
		return lblNuevoAniosExperiencia;
	}


	/**
	 * @param lblNuevoAniosExperiencia the lblNuevoAniosExperiencia to set
	 */
	public void setLblNuevoAniosExperiencia(JLabel lblNuevoAniosExperiencia) {
		this.lblNuevoAniosExperiencia = lblNuevoAniosExperiencia;
	}


	/**
	 * @return the txtNuevoAniosExperiencia
	 */
	public JTextField getTxtNuevoAniosExperiencia() {
		return txtNuevoAniosExperiencia;
	}


	/**
	 * @param txtNuevoAniosExperiencia the txtNuevoAniosExperiencia to set
	 */
	public void setTxtNuevoAniosExperiencia(JTextField txtNuevoAniosExperiencia) {
		this.txtNuevoAniosExperiencia = txtNuevoAniosExperiencia;
	}


	/**
	 * @return the lblNuevoNumClasicoGanado
	 */
	public JLabel getLblNuevoNumClasicoGanado() {
		return lblNuevoNumClasicoGanado;
	}


	/**
	 * @param lblNuevoNumClasicoGanado the lblNuevoNumClasicoGanado to set
	 */
	public void setLblNuevoNumClasicoGanado(JLabel lblNuevoNumClasicoGanado) {
		this.lblNuevoNumClasicoGanado = lblNuevoNumClasicoGanado;
	}


	/**
	 * @return the txtNuevoNumClasicoGanado
	 */
	public JTextField getTxtNuevoNumClasicoGanado() {
		return txtNuevoNumClasicoGanado;
	}


	/**
	 * @param txtNuevoNumClasicoGanado the txtNuevoNumClasicoGanado to set
	 */
	public void setTxtNuevoNumClasicoGanado(JTextField txtNuevoNumClasicoGanado) {
		this.txtNuevoNumClasicoGanado = txtNuevoNumClasicoGanado;
	}


	/**
	 * @return the lblNuevoVelocidadMaxima
	 */
	public JLabel getLblNuevoVelocidadMaxima() {
		return lblNuevoVelocidadMaxima;
	}


	/**
	 * @param lblNuevoVelocidadMaxima the lblNuevoVelocidadMaxima to set
	 */
	public void setLblNuevoVelocidadMaxima(JLabel lblNuevoVelocidadMaxima) {
		this.lblNuevoVelocidadMaxima = lblNuevoVelocidadMaxima;
	}


	/**
	 * @return the txtNuevoVelocidadMaxima
	 */
	public JTextField getTxtNuevoVelocidadMaxima() {
		return txtNuevoVelocidadMaxima;
	}


	/**
	 * @param txtNuevoVelocidadMaxima the txtNuevoVelocidadMaxima to set
	 */
	public void setTxtNuevoVelocidadMaxima(JTextField txtNuevoVelocidadMaxima) {
		this.txtNuevoVelocidadMaxima = txtNuevoVelocidadMaxima;
	}


	/**
	 * @return the lblNuevoPotenciaPromedio
	 */
	public JLabel getLblNuevoPotenciaPromedio() {
		return lblNuevoPotenciaPromedio;
	}


	/**
	 * @param lblNuevoPotenciaPromedio the lblNuevoPotenciaPromedio to set
	 */
	public void setLblNuevoPotenciaPromedio(JLabel lblNuevoPotenciaPromedio) {
		this.lblNuevoPotenciaPromedio = lblNuevoPotenciaPromedio;
	}


	/**
	 * @return the txtNuevoPotenciaPromedio
	 */
	public JTextField getTxtNuevoPotenciaPromedio() {
		return txtNuevoPotenciaPromedio;
	}


	/**
	 * @param txtNuevoPotenciaPromedio the txtNuevoPotenciaPromedio to set
	 */
	public void setTxtNuevoPotenciaPromedio(JTextField txtNuevoPotenciaPromedio) {
		this.txtNuevoPotenciaPromedio = txtNuevoPotenciaPromedio;
	}


	/**
	 * @return the lblNuevaVelocidadPromedio
	 */
	public JLabel getLblNuevaVelocidadPromedio() {
		return lblNuevaVelocidadPromedio;
	}


	/**
	 * @param lblNuevaVelocidadPromedio the lblNuevaVelocidadPromedio to set
	 */
	public void setLblNuevaVelocidadPromedio(JLabel lblNuevaVelocidadPromedio) {
		this.lblNuevaVelocidadPromedio = lblNuevaVelocidadPromedio;
	}


	/**
	 * @return the txtNuevoVelocidadPromedio
	 */
	public JTextField getTxtNuevoVelocidadPromedio() {
		return txtNuevoVelocidadPromedio;
	}


	/**
	 * @param txtNuevoVelocidadPromedio the txtNuevoVelocidadPromedio to set
	 */
	public void setTxtNuevoVelocidadPromedio(JTextField txtNuevoVelocidadPromedio) {
		this.txtNuevoVelocidadPromedio = txtNuevoVelocidadPromedio;
	}


	/**
	 * @return the lblNuevoAceleracionPromedio
	 */
	public JLabel getLblNuevoAceleracionPromedio() {
		return lblNuevoAceleracionPromedio;
	}


	/**
	 * @param lblNuevoAceleracionPromedio the lblNuevoAceleracionPromedio to set
	 */
	public void setLblNuevoAceleracionPromedio(JLabel lblNuevoAceleracionPromedio) {
		this.lblNuevoAceleracionPromedio = lblNuevoAceleracionPromedio;
	}


	/**
	 * @return the txtNuevoAceleracionPromedio
	 */
	public JTextField getTxtNuevoAceleracionPromedio() {
		return txtNuevoAceleracionPromedio;
	}


	/**
	 * @param txtNuevoAceleracionPromedio the txtNuevoAceleracionPromedio to set
	 */
	public void setTxtNuevoAceleracionPromedio(JTextField txtNuevoAceleracionPromedio) {
		this.txtNuevoAceleracionPromedio = txtNuevoAceleracionPromedio;
	}


	/**
	 * @return the lblNuevoGradoRampaSoportada
	 */
	public JLabel getLblNuevoGradoRampaSoportada() {
		return lblNuevoGradoRampaSoportada;
	}


	/**
	 * @param lblNuevoGradoRampaSoportada the lblNuevoGradoRampaSoportada to set
	 */
	public void setLblNuevoGradoRampaSoportada(JLabel lblNuevoGradoRampaSoportada) {
		this.lblNuevoGradoRampaSoportada = lblNuevoGradoRampaSoportada;
	}


	/**
	 * @return the txtNuevoGradoRampaSoportada
	 */
	public JTextField getTxtNuevoGradoRampaSoportada() {
		return txtNuevoGradoRampaSoportada;
	}


	/**
	 * @param txtNuevoGradoRampaSoportada the txtNuevoGradoRampaSoportada to set
	 */
	public void setTxtNuevoGradoRampaSoportada(JTextField txtNuevoGradoRampaSoportada) {
		this.txtNuevoGradoRampaSoportada = txtNuevoGradoRampaSoportada;
	}


	/**
	 * @return the rbtnNuevoAbastecedor
	 */
	public JRadioButton getRbtnNuevoAbastecedor() {
		return rbtnNuevoAbastecedor;
	}


	/**
	 * @param rbtnNuevoAbastecedor the rbtnNuevoAbastecedor to set
	 */
	public void setRbtnNuevoAbastecedor(JRadioButton rbtnNuevoAbastecedor) {
		this.rbtnNuevoAbastecedor = rbtnNuevoAbastecedor;
	}


	/**
	 * @return the rbtnNuevoMantenerRitmo
	 */
	public JRadioButton getRbtnNuevoMantenerRitmo() {
		return rbtnNuevoMantenerRitmo;
	}


	/**
	 * @param rbtnNuevoMantenerRitmo the rbtnNuevoMantenerRitmo to set
	 */
	public void setRbtnNuevoMantenerRitmo(JRadioButton rbtnNuevoMantenerRitmo) {
		this.rbtnNuevoMantenerRitmo = rbtnNuevoMantenerRitmo;
	}


	/**
	 * @return the rbtnNuevoCapturasFuga
	 */
	public JRadioButton getRbtnNuevoCapturasFuga() {
		return rbtnNuevoCapturasFuga;
	}


	/**
	 * @param rbtnNuevoCapturasFuga the rbtnNuevoCapturasFuga to set
	 */
	public void setRbtnNuevoCapturasFuga(JRadioButton rbtnNuevoCapturasFuga) {
		this.rbtnNuevoCapturasFuga = rbtnNuevoCapturasFuga;
	}


	/**
	 * @return the rbtnNuevoPosicionarLider
	 */
	public JRadioButton getRbtnNuevoPosicionarLider() {
		return rbtnNuevoPosicionarLider;
	}


	/**
	 * @param rbtnNuevoPosicionarLider the rbtnNuevoPosicionarLider to set
	 */
	public void setRbtnNuevoPosicionarLider(JRadioButton rbtnNuevoPosicionarLider) {
		this.rbtnNuevoPosicionarLider = rbtnNuevoPosicionarLider;
	}


	/**
	 * @return the rbtnNuevoProtegerLider
	 */
	public JRadioButton getRbtnNuevoProtegerLider() {
		return rbtnNuevoProtegerLider;
	}


	/**
	 * @param rbtnNuevoProtegerLider the rbtnNuevoProtegerLider to set
	 */
	public void setRbtnNuevoProtegerLider(JRadioButton rbtnNuevoProtegerLider) {
		this.rbtnNuevoProtegerLider = rbtnNuevoProtegerLider;
	}


	/**
	 * @return the lblNuevoVelocidadPromedioPedaleo
	 */
	public JLabel getLblNuevoVelocidadPromedioPedaleo() {
		return lblNuevoVelocidadPromedioPedaleo;
	}


	/**
	 * @param lblNuevoVelocidadPromedioPedaleo the lblNuevoVelocidadPromedioPedaleo to set
	 */
	public void setLblNuevoVelocidadPromedioPedaleo(JLabel lblNuevoVelocidadPromedioPedaleo) {
		this.lblNuevoVelocidadPromedioPedaleo = lblNuevoVelocidadPromedioPedaleo;
	}


	/**
	 * @return the txtNuevoVelocidadPromedioPedaleo
	 */
	public JTextField getTxtNuevoVelocidadPromedioPedaleo() {
		return txtNuevoVelocidadPromedioPedaleo;
	}


	/**
	 * @param txtNuevoVelocidadPromedioPedaleo the txtNuevoVelocidadPromedioPedaleo to set
	 */
	public void setTxtNuevoVelocidadPromedioPedaleo(JTextField txtNuevoVelocidadPromedioPedaleo) {
		this.txtNuevoVelocidadPromedioPedaleo = txtNuevoVelocidadPromedioPedaleo;
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
	 * @return the rbtnNuevoClasicoMano
	 */
	public JRadioButton getRbtnNuevoClasicoMano() {
		return rbtnNuevoClasicoMano;
	}


	/**
	 * @param rbtnNuevoClasicoMano the rbtnNuevoClasicoMano to set
	 */
	public void setRbtnNuevoClasicoMano(JRadioButton rbtnNuevoClasicoMano) {
		this.rbtnNuevoClasicoMano = rbtnNuevoClasicoMano;
	}


	/**
	 * @return the rbtnNuevoContrarreloj
	 */
	public JRadioButton getRbtnNuevoContrarreloj() {
		return rbtnNuevoContrarreloj;
	}


	/**
	 * @param rbtnNuevoContrarreloj the rbtnNuevoContrarreloj to set
	 */
	public void setRbtnNuevoContrarreloj(JRadioButton rbtnNuevoContrarreloj) {
		this.rbtnNuevoContrarreloj = rbtnNuevoContrarreloj;
	}


	/**
	 * @return the rbtnNuevoEmbalador
	 */
	public JRadioButton getRbtnNuevoEmbalador() {
		return rbtnNuevoEmbalador;
	}


	/**
	 * @param rbtnNuevoEmbalador the rbtnNuevoEmbalador to set
	 */
	public void setRbtnNuevoEmbalador(JRadioButton rbtnNuevoEmbalador) {
		this.rbtnNuevoEmbalador = rbtnNuevoEmbalador;
	}


	/**
	 * @return the rbtnNuevoEscalador
	 */
	public JRadioButton getRbtnNuevoEscalador() {
		return rbtnNuevoEscalador;
	}


	/**
	 * @param rbtnNuevoEscalador the rbtnNuevoEscalador to set
	 */
	public void setRbtnNuevoEscalador(JRadioButton rbtnNuevoEscalador) {
		this.rbtnNuevoEscalador = rbtnNuevoEscalador;
	}


	/**
	 * @return the rbtnNuevoGregario
	 */
	public JRadioButton getRbtnNuevoGregario() {
		return rbtnNuevoGregario;
	}


	/**
	 * @param rbtnNuevoGregario the rbtnNuevoGregario to set
	 */
	public void setRbtnNuevoGregario(JRadioButton rbtnNuevoGregario) {
		this.rbtnNuevoGregario = rbtnNuevoGregario;
	}


	/**
	 * @return the rbtnNuevoRodador
	 */
	public JRadioButton getRbtnNuevoRodador() {
		return rbtnNuevoRodador;
	}


	/**
	 * @param rbtnNuevoRodador the rbtnNuevoRodador to set
	 */
	public void setRbtnNuevoRodador(JRadioButton rbtnNuevoRodador) {
		this.rbtnNuevoRodador = rbtnNuevoRodador;
	}


	/**
	 * @return the rbtnNuevoVacio
	 */
	public JRadioButton getRbtnNuevoVacio() {
		return rbtnNuevoVacio;
	}


	/**
	 * @param rbtnNuevoVacio the rbtnNuevoVacio to set
	 */
	public void setRbtnNuevoVacio(JRadioButton rbtnNuevoVacio) {
		this.rbtnNuevoVacio = rbtnNuevoVacio;
	}


	/**
	 * @return the rbtnNuevoTareaCVisualizar
	 */
	public JRadioButton getRbtnNuevoTareaCVisualizar() {
		return rbtnNuevoTareaCVisualizar;
	}


	/**
	 * @param rbtnNuevoTareaCVisualizar the rbtnNuevoTareaCVisualizar to set
	 */
	public void setRbtnNuevoTareaCVisualizar(JRadioButton rbtnNuevoTareaCVisualizar) {
		this.rbtnNuevoTareaCVisualizar = rbtnNuevoTareaCVisualizar;
	}


	/**
	 * @return the rbtnNuevoTareaCConcentrarse
	 */
	public JRadioButton getRbtnNuevoTareaCConcentrarse() {
		return rbtnNuevoTareaCConcentrarse;
	}


	/**
	 * @param rbtnNuevoTareaCConcentrarse the rbtnNuevoTareaCConcentrarse to set
	 */
	public void setRbtnNuevoTareaCConcentrarse(JRadioButton rbtnNuevoTareaCConcentrarse) {
		this.rbtnNuevoTareaCConcentrarse = rbtnNuevoTareaCConcentrarse;
	}


	/**
	 * @return the rbtnNuevoTareaCRegular
	 */
	public JRadioButton getRbtnNuevoTareaCRegular() {
		return rbtnNuevoTareaCRegular;
	}


	/**
	 * @param rbtnNuevoTareaCRegular the rbtnNuevoTareaCRegular to set
	 */
	public void setRbtnNuevoTareaCRegular(JRadioButton rbtnNuevoTareaCRegular) {
		this.rbtnNuevoTareaCRegular = rbtnNuevoTareaCRegular;
	}


	/**
	 * @return the rbtnNuevoTareaEmAumentarRitmo
	 */
	public JRadioButton getRbtnNuevoTareaEmAumentarRitmo() {
		return rbtnNuevoTareaEmAumentarRitmo;
	}


	/**
	 * @param rbtnNuevoTareaEmAumentarRitmo the rbtnNuevoTareaEmAumentarRitmo to set
	 */
	public void setRbtnNuevoTareaEmAumentarRitmo(JRadioButton rbtnNuevoTareaEmAumentarRitmo) {
		this.rbtnNuevoTareaEmAumentarRitmo = rbtnNuevoTareaEmAumentarRitmo;
	}


	/**
	 * @return the rbtnNuevoTareaEmBajarRitmo
	 */
	public JRadioButton getRbtnNuevoTareaEmBajarRitmo() {
		return rbtnNuevoTareaEmBajarRitmo;
	}


	/**
	 * @param rbtnNuevoTareaEmBajarRitmo the rbtnNuevoTareaEmBajarRitmo to set
	 */
	public void setRbtnNuevoTareaEmBajarRitmo(JRadioButton rbtnNuevoTareaEmBajarRitmo) {
		this.rbtnNuevoTareaEmBajarRitmo = rbtnNuevoTareaEmBajarRitmo;
	}


	/**
	 * @return the rbtnNuevoTareaEsPedalearS
	 */
	public JRadioButton getRbtnNuevoTareaEsPedalearS() {
		return rbtnNuevoTareaEsPedalearS;
	}


	/**
	 * @param rbtnNuevoTareaEsPedalearS the rbtnNuevoTareaEsPedalearS to set
	 */
	public void setRbtnNuevoTareaEsPedalearS(JRadioButton rbtnNuevoTareaEsPedalearS) {
		this.rbtnNuevoTareaEsPedalearS = rbtnNuevoTareaEsPedalearS;
	}


	/**
	 * @return the rbtnNuevoTareaEsPedalearP
	 */
	public JRadioButton getRbtnNuevoTareaEsPedalearP() {
		return rbtnNuevoTareaEsPedalearP;
	}


	/**
	 * @param rbtnNuevoTareaEsPedalearP the rbtnNuevoTareaEsPedalearP to set
	 */
	public void setRbtnNuevoTareaEsPedalearP(JRadioButton rbtnNuevoTareaEsPedalearP) {
		this.rbtnNuevoTareaEsPedalearP = rbtnNuevoTareaEsPedalearP;
	}


	/**
	 * @return the lblNuevoCadenciaPedaleo2
	 */
	public JLabel getLblNuevoCadenciaPedaleo2() {
		return lblNuevoCadenciaPedaleo2;
	}


	/**
	 * @param lblNuevoCadenciaPedaleo2 the lblNuevoCadenciaPedaleo2 to set
	 */
	public void setLblNuevoCadenciaPedaleo2(JLabel lblNuevoCadenciaPedaleo2) {
		this.lblNuevoCadenciaPedaleo2 = lblNuevoCadenciaPedaleo2;
	}


	/**
	 * @return the lblNuevoPotenciaPromedio1
	 */
	public JLabel getLblNuevoPotenciaPromedio1() {
		return lblNuevoPotenciaPromedio1;
	}


	/**
	 * @param lblNuevoPotenciaPromedio1 the lblNuevoPotenciaPromedio1 to set
	 */
	public void setLblNuevoPotenciaPromedio1(JLabel lblNuevoPotenciaPromedio1) {
		this.lblNuevoPotenciaPromedio1 = lblNuevoPotenciaPromedio1;
	}


	/**
	 * @return the lblNuevoAceleracionPromedio1
	 */
	public JLabel getLblNuevoAceleracionPromedio1() {
		return lblNuevoAceleracionPromedio1;
	}


	/**
	 * @param lblNuevoAceleracionPromedio1 the lblNuevoAceleracionPromedio1 to set
	 */
	public void setLblNuevoAceleracionPromedio1(JLabel lblNuevoAceleracionPromedio1) {
		this.lblNuevoAceleracionPromedio1 = lblNuevoAceleracionPromedio1;
	}


	/**
	 * @return the lblNuevoVelocidadPromedioPedaleo1
	 */
	public JLabel getLblNuevoVelocidadPromedioPedaleo1() {
		return lblNuevoVelocidadPromedioPedaleo1;
	}


	/**
	 * @param lblNuevoVelocidadPromedioPedaleo1 the lblNuevoVelocidadPromedioPedaleo1 to set
	 */
	public void setLblNuevoVelocidadPromedioPedaleo1(JLabel lblNuevoVelocidadPromedioPedaleo1) {
		this.lblNuevoVelocidadPromedioPedaleo1 = lblNuevoVelocidadPromedioPedaleo1;
	}

}
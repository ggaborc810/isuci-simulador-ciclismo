/**
 * controller package, will have the classes in charge of executing the program and managing the logic of the application
 */

package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.ClasicoManoDTO;
import co.edu.unbosque.model.ContraRelojDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.EmbaladorDTO;
import co.edu.unbosque.model.EscaladorDTO;
import co.edu.unbosque.model.EscuadraDTO;
import co.edu.unbosque.model.GregarioDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.util.exceptions.CheckMail;
import co.edu.unbosque.util.exceptions.ExceptionChecker;
import co.edu.unbosque.util.exceptions.InvalidEmptyException;
import co.edu.unbosque.util.exceptions.InvalidNameException;
import co.edu.unbosque.util.exceptions.InvalidNameExceptionS;
import co.edu.unbosque.util.exceptions.NegativeNumberException;
import co.edu.unbosque.util.mail.Correo;
import co.edu.unbosque.util.sort.BubbleSort;
import co.edu.unbosque.util.sort.CiclistaTiempoAcumuladoComparator;
import co.edu.unbosque.view.MensajeEmergente;
import co.edu.unbosque.view.PanelDeIngreso;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.ViewFacade;
/**
 * * Controller class implements ActionListener to handle events from the GUI.
 *
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class Controller implements ActionListener {
	/**
	 * Facade for managing views in the application.
	 */
	private ViewFacade vf;

	/**
	 * Facade for interacting with the application's models.
	 */
	private ModelFacade mf;

	/**
	 * Properties used for configuring the email sending process.
	 */
	private Properties mProperties;

	/**
	 * Email session for sending emails.
	 */
	private Session mSeccion;

	/**
	 * MimeMessage object representing the email message to be sent.
	 */
	private MimeMessage mCorreo;

	/**
	 * Correo object representing email details such as sender, recipient, subject,
	 * and content.
	 */
	private Correo correo;

	/**
	 * Constructor for the Controller class. Initializes the view facade, model
	 * facade, correo object, and properties for email configuration. Assigns event
	 * listeners and sets initial visibility of view panels.
	 */
	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		correo = new Correo();
		mProperties = new Properties();

		asignarOyentes();

		vf.getV().getJpnPortada().setVisible(true);
		vf.getV().getJpnOpciones().setVisible(false);
		vf.getV().getJpnCrearCiclista().setVisible(false);
		vf.getV().getJpnSeleccionCiclista().setVisible(false);
	}

	public void init() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		correo = new Correo();
		mProperties = new Properties();

		asignarOyentes();

		vf.getV().getJpnPortada().setVisible(true);
		vf.getV().getJpnOpciones().setVisible(false);
		vf.getV().getJpnCrearCiclista().setVisible(false);
		vf.getV().getJpnSeleccionCiclista().setVisible(false);
		correrGUI();
	}

	/**
	 * This method initializes a new EscuadraDTO object with sample data. It creates
	 * sample cyclists, masseurs, and sports directors, then adds them to the
	 * escuadra.
	 */

	public void crearEscuadra() {

		EscuadraDTO nuevaEscuadra = new EscuadraDTO();
		String idciclista = "";
		String idmasajista = "";
		String bandera[] = {
				((ImageIcon) vf.getV().getJpnCrearEscuadra().getPais().getSelectedItem()).getDescription() };

		String nombre = "";
		try {
			nombre = vf.getV().getJpnCrearEscuadra().getTxtNombreEscuadra().getText();
			ExceptionChecker.revisarNombre(nombre);

			String ciclistasmano[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaClasicoManos().getSelectedItem().toString() };

			String ciclistasContraReloj[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaContraReloj().getSelectedItem().toString() };

			String ciclistasEmbalador[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaEmbalador().getSelectedItem().toString() };

			String ciclistasEscalador[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaEscalador().getSelectedItem().toString() };

			String ciclistasGregario[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaGregario().getSelectedItem().toString() };

			String ciclistasRodador[] = {
					vf.getV().getJpnCrearEscuadra().getCiclistaRodador().getSelectedItem().toString() };

			String masajista[] = { vf.getV().getJpnCrearEscuadra().getMasajista().getSelectedItem().toString() };

			if (!ciclistasmano[0].equals("")) {
				idciclista = ciclistasmano[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}

			}

			if (!ciclistasContraReloj[0].equals("")) {
				idciclista = ciclistasContraReloj[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);

				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (!ciclistasEmbalador[0].equals("")) {
				idciclista = ciclistasEmbalador[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (!ciclistasEscalador[0].equals("")) {
				idciclista = ciclistasEscalador[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (!ciclistasGregario[0].equals("")) {
				idciclista = ciclistasGregario[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (!ciclistasRodador[0].equals("")) {
				idciclista = ciclistasRodador[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaCiclistas().add((CiclistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (!masajista[0].equals("")) {
				idmasajista = masajista[0].split("-")[0];
				UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idmasajista);
				if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
					nuevaEscuadra.getListaMasajistas().add((MasajistaDTO) userConsulta);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId()
							+ "Ya esta Creado en la escuadra " + userConsulta.getEscuadra());
					return;
				}
			}

			if (mf.getUsuarioLoginDTO() != null) {

				nuevaEscuadra.setPaisEscuadra(bandera);
				nuevaEscuadra.setNombreEscuadra(nombre);
				mf.getEscuadraDAO().create(nuevaEscuadra);
				MensajeEmergente.mostrarMensaje("Escuadra creada con exito");
			}

		} catch (InvalidNameExceptionS e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
			return;
		}

	}

	
	/**
	 * This method adds a cyclist to an escuadra (squad). It first checks if the
	 * specified escuadra exists, then checks if the cyclist is already part of
	 * another escuadra. If not, it adds the cyclist to the escuadra and updates the
	 * display table.
	 */

	public void agregarCiclistaAEscuadra() {

		String nombre = vf.getV().getJpnAgregarAEscuadra().getTxtEscuadra().getText();

		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int indice = 0;
		for (int i = 0; i < mf.getEscuadraDAO().getListaEscuadras().size(); i++) {
			if (mf.getEscuadraDAO().getListaEscuadras().get(i).getNombreEscuadra()
					.matches(escuadrabuscada.getNombreEscuadra())) {
				indice = i;
			}
		}

		String idciclista = "";

		String ciclista[] = { vf.getV().getJpnAgregarAEscuadra().getBoxCiclista().getSelectedItem().toString() };

		if (!ciclista[0].equals("")) {
			idciclista = ciclista[0].split("-")[0];
			UsuarioDTO userConsulta = mf.getUsuarioDAO().getUsuarios(idciclista);
			if (userConsulta.getEscuadra() == null || userConsulta.getEscuadra().equals("")) {
				mf.getEscuadraDAO().agregarCiclistaAEscuadra(indice, (CiclistaDTO) userConsulta);
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + userConsulta.getId() + "Ya esta Creado en la escuadra "
						+ userConsulta.getEscuadra());
				return;
			}
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getNombre(), i + 1, 0);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getId(), i + 1, 1);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(ciclistaesc), i + 1, 2);
			i++;
		}

		for (MasajistaDTO masajista : escuadrabuscada.getListaMasajistas()) {
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(masajista.getNombre(), i + 1, 0);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(masajista.getId(), i + 1, 1);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(masajista), i + 1, 2);
			i++;
		}

		vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setVisible(true);

		vf.getV().repaint();

	}

	
	/**
	 * This method searches for an escuadra (squad) by its name in the text field.
	 * If the escuadra is found, it populates the table with the list of cyclists
	 * and masseurs. If not found, it displays an error message.
	 */

	public void buscarEscuadraEnAgregar() {
		String nombre = vf.getV().getJpnAgregarAEscuadra().getTxtEscuadra().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getNombre(), i + 1, 0);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getId(), i + 1, 1);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(ciclistaesc), i + 1, 2);
			i++;
		}

		for (MasajistaDTO masajista : escuadrabuscada.getListaMasajistas()) {
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(masajista.getNombre(), i + 1, 0);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(masajista.getId(), i + 1, 1);
			vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(masajista), i + 1, 2);
			i++;
		}

		vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setVisible(true);

		vf.getV().getJpnAgregarAEscuadra().getTablaCiclistas().setEnabled(false);

		vf.getV().repaint();
	}

	/**
	 * This method searches for an escuadra (squad) by its name in the text field.
	 * If the escuadra is found, it populates the table with the list of cyclists,
	 * masseurs, and sports directors. If not found, it displays an error message.
	 */

	public void buscarEscuadra() {

		String nombre = vf.getV().getJpnMostrarEscuadra().getTxtMostrarEscuadra().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getNombre(), i + 1, 0);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(ciclistaesc.getId(), i + 1, 1);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(ciclistaesc), i + 1, 2);
			i++;
		}

		for (MasajistaDTO masajista : escuadrabuscada.getListaMasajistas()) {
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(masajista.getNombre(), i + 1, 0);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(masajista.getId(), i + 1, 1);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(masajista), i + 1, 2);
			i++;
		}

		for (DirectorDeportivoDTO director : escuadrabuscada.getListaDirectores()) {
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(director.getNombre(), i + 1, 0);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(director.getId(), i + 1, 1);
			vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setValueAt(getTipoUsuario(director), i + 1, 2);
			i++;
		}

		vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setVisible(true);
		vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setEnabled(false);
		vf.getV().repaint();

	}

	
	/**
	 * This method searches for an escuadra (squad) by its name and populates the
	 * table with its cyclists. If the escuadra is not found, it displays an error
	 * message.
	 */

	public void seleccionarCiclista() {
		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().setVisible(true);

		vf.getV().repaint();

	}

	/**
	 * This method searches for an escuadra (squad) by its name from a specific text
	 * field and populates a specific table with its cyclists. If the escuadra is
	 * not found, it displays an error message.
	 */
	public void seleccionarCiclista1() {

		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra1().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().setVisible(true);

		vf.getV().repaint();

	}

	/**
	 * This method searches for an escuadra (squad) by its name from a specific text
	 * field and populates a specific table with its cyclists. If the escuadra is
	 * not found, it displays an error message.
	 */

	public void seleccionarCiclista2() {

		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra2().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().setVisible(true);

		vf.getV().repaint();

	}


	/**
	 * This method searches for an escuadra (squad) by its name from a specific text
	 * field and populates a specific table with its cyclists. If the escuadra is
	 * not found, it displays an error message.
	 */

	public void seleccionarCiclista3() {

		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra3().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		// vf.getV().getJpnMostrarEscuadra().add(tablaJ);
		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().setVisible(true);

		vf.getV().repaint();

	}

	
	/**
	 * This method searches for an escuadra (squad) by its name from a specific text
	 * field and populates a specific table with its cyclists. If the escuadra is
	 * not found, it displays an error message.
	 */

	public void seleccionarCiclista4() {

		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra4().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		// vf.getV().getJpnMostrarEscuadra().add(tablaJ);
		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().setVisible(true);

		vf.getV().repaint();

	}

	
	/**
	 * This method searches for an escuadra (squad) by its name from a specific text
	 * field and populates a specific table with its cyclists. If the escuadra is
	 * not found, it displays an error message.
	 */

	public void seleccionarCiclista5() {

		String nombre = vf.getV().getJpnSeleccionCiclista().getTxtEscuadra5().getText();
		EscuadraDTO escuadrabuscada = null;

		for (EscuadraDTO escuadra : mf.getEscuadraDAO().getListaEscuadras()) {
			if (nombre.equals(escuadra.getNombreEscuadra()))
				escuadrabuscada = escuadra;
		}

		if (escuadrabuscada == null) {
			MensajeEmergente.mostrarMensaje("La escuadra no se Encontro ");
			return;
		}

		int i = 0;
		for (CiclistaDTO ciclistaesc : escuadrabuscada.getListaCiclistas()) {
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().setValueAt(ciclistaesc.getNombre(), i, 0);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().setValueAt(ciclistaesc.getId(), i, 1);
			vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().setValueAt(getTipoUsuario(ciclistaesc), i, 2);
			i++;
		}

		// vf.getV().getJpnMostrarEscuadra().add(tablaJ);
		vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().setVisible(true);

		vf.getV().repaint();

	}

	
	/**
	 * This method adds selected cyclists from the selection panel to the simulator
	 * panel. It checks if the number of selected cyclists exceeds the limit of 6,
	 * in which case it displays an error message and exits the method. Then, it
	 * iterates over the rows of the table in the selection panel, and for each
	 * selected cyclist, it updates the corresponding labels in the simulator panels
	 * for different terrains (llano, montaña, plano, semillano) with the cyclist's
	 * ID.
	 */

	public void agregarAlSimulador() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

//		 String tipoUsuario = "";
		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}

	}

	
	/**
	 * This method adds selected cyclists from the second selection panel to the
	 * simulator panel. It checks if the number of selected cyclists exceeds the
	 * limit of 6, in which case it displays an error message and exits the method.
	 * Then, it iterates over the rows of the table in the second selection panel,
	 * and for each selected cyclist, it updates the corresponding labels in the
	 * simulator panels for different terrains (llano, montaña, plano, semillano)
	 * with the cyclist's ID.
	 */

	public void agregarAlSimulador1() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas1().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}

	}

	/**
	 * This method adds selected cyclists from the third selection panel to the
	 * simulator panel. It checks if the number of selected cyclists exceeds the
	 * limit of 6, in which case it displays an error message and exits the method.
	 * Then, it iterates over the rows of the table in the third selection panel,
	 * and for each selected cyclist, it updates the corresponding labels in the
	 * simulator panels for different terrains (llano, montaña, plano, semillano)
	 * with the cyclist's ID.
	 */

	public void agregarAlSimulador2() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas2().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}
	}

	/**
	 * This method adds selected cyclists from the fourth selection panel to the
	 * simulator panel. It checks if the number of selected cyclists exceeds the
	 * limit of 6, in which case it displays an error message and exits the method.
	 * Then, it iterates over the rows of the table in the fourth selection panel,
	 * and for each selected cyclist, it updates the corresponding labels in the
	 * simulator panels for different terrains (llano, montaña, plano, semillano)
	 * with the cyclist's ID.
	 */

	public void agregarAlSimulador3() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

//			 String tipoUsuario = "";
		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas3().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}
	}

	
	/**
	 * This method adds selected cyclists from the fifth selection panel to the
	 * simulator panel. It checks if the number of selected cyclists exceeds the
	 * limit of 6, in which case it displays an error message and exits the method.
	 * Then, it iterates over the rows of the table in the fifth selection panel,
	 * and for each selected cyclist, it updates the corresponding labels in the
	 * simulator panels for different terrains (llano, montaña, plano, semillano)
	 * with the cyclist's ID.
	 */

	public void agregarAlSimulador4() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

//			 String tipoUsuario = "";
		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas4().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}
	}

	/**
	 * Adds the selected cyclists to the simulator panel labeled "4". If more than 6
	 * cyclists are selected, it displays an error message and returns. Iterates
	 * through the rows of the table, retrieves the ID of each selected cyclist, and
	 * updates the corresponding labels in the llano, montaña, plano, and semillano
	 * simulator panels.
	 */

	public void agregarAlSimulador5() {
		int contadorselec = 0;

		int row = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().getRowCount();
		int column = vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().getColumnCount();

		for (int t = 0; t < row; t++)
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().isRowSelected(t)) {
				contadorselec++;
			}
		if (contadorselec > 6) {
			MensajeEmergente.mostrarMensaje("los cliclistan superan el limite de 6 ");
			return;
		}

//			 String tipoUsuario = "";
		for (int t = 0; t < row; t++) {
			if (vf.getV().getJpnSeleccionCiclista().getTablaCiclistas5().isRowSelected(t)) {
				String id = (String) vf.getV().getJpnSeleccionCiclista().getTablaCiclistas().getValueAt(t, 1);
				vf.getV().getJpnSimuladorLlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorMontania().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorPlano().getLblCiclistas()[t].setText(id);
				vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[t].setText(id);
			}
		}
	}

	/**
	 * Updates the information of the selected team. Retrieves the country flag and
	 * name entered by the user from the view. Sets the country and name of the team
	 * in a new EscuadraDTO object. Note: The actual update operation on the
	 * database is commented out.
	 */

	public void ActualizarEscuadra() {

		EscuadraDTO nuevaEscuadra = new EscuadraDTO();
		String bandera[] = {
				((ImageIcon) vf.getV().getJpnCrearEscuadra().getPais().getSelectedItem()).getDescription() };
		String nombre = vf.getV().getJpnCrearEscuadra().getTxtNombreEscuadra().getText();

		nuevaEscuadra.setPaisEscuadra(bandera);
		nuevaEscuadra.setNombreEscuadra(nombre);

//		mf.getEscuadraDAO().update(0, nuevaEscuadra);
	}
//mostrar----------------------------------------------------------------------------------------------------------------------------

	/**
	 * Creates a new user based on the information provided in the registration
	 * panel. Retrieves the user's personal details such as ID, gender, email, and
	 * password. Validates the email address format. Validates the uniqueness of the
	 * user ID. Determines the type of user (Director, Cyclist, Masseur, or
	 * Administrative) based on radio button selection. Creates a new instance of
	 * the corresponding UserDTO subclass. Attempts to create the user in the
	 * database via the UserDAO. Returns an integer indicating the success or
	 * failure of the user creation process: 1 - User created successfully. 0 - An
	 * error occurred during user creation (e.g., invalid input, duplicate user ID).
	 */

	public int crearUsuario() {

		int creacion = -1;
		try {
			UsuarioDTO aux = new UsuarioDTO();
			long cc = Long.parseLong(vf.getV().getJpnRegister().getTxtCedula().getText());
			aux.setCedula(cc);
			ExceptionChecker.revisarEspacioBlanco(cc + "");
			ExceptionChecker.revisarNumeroNegativo(cc);
			String genero = "";
			if (vf.getV().getJpnRegister().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
				genero = "Mujer";
			} else {
				genero = "Hombre";
			}

			String correo = vf.getV().getJpnRegister().getTxtCorreoElectronico().getText();
			ExceptionChecker.checkEmail(correo);
			ExceptionChecker.revisarEspacioBlanco(correo);
			String id = vf.getV().getJpnRegister().getTxtId().getText();
			ExceptionChecker.revisarNombreInvalido(id);
			ExceptionChecker.revisarEspacioBlanco(id);
			String contrasenia = vf.getV().getJpnRegister().getTxtContrasenia().getText();

			UsuarioDTO nuevoUsuario = new UsuarioDTO();
			UsuarioDTO UsuarioConsulta;

			if (vf.getV().getJpnRegister().getRbtnDirector().isSelected()) {
				nuevoUsuario = new DirectorDeportivoDTO();
			} else if (vf.getV().getJpnRegister().getRbtnCiclista().isSelected()) {
				nuevoUsuario = new CiclistaDTO();
			} else if (vf.getV().getJpnRegister().getRbtnMasajista().isSelected()) {
				nuevoUsuario = new MasajistaDTO();
			} else if (vf.getV().getJpnRegister().getRbtnAdministrativo().isSelected()) {
				nuevoUsuario = new UsuarioDTO();
			} else {
				MensajeEmergente.mostrarMensaje("debe seleccionar un Tipo de Usuario ");

				return creacion;
			}

			UsuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);

			if (UsuarioConsulta == null) {
				nuevoUsuario.setCedula(cc);
				nuevoUsuario.setGenero(genero);
				nuevoUsuario.setCorreoElectronico(correo);
				nuevoUsuario.setId(id);
				nuevoUsuario.setContrasenia(contrasenia);
				mf.getUsuarioDAO().create(nuevoUsuario);
				creacion = 1;
			} else
				MensajeEmergente.mostrarMensaje("El Usuario " + UsuarioConsulta.getId() + "Ya esta Creado");
		} catch (InvalidEmptyException e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
			return 0;
		} catch (

		NumberFormatException e1) {
			MensajeEmergente.mostrarMensaje("La cedula no puede tener letras,simbolos");
			return 0;
		} catch (CheckMail e2) {
			MensajeEmergente.mostrarMensaje(e2.getMessage());
			return 0;
		} catch (InvalidNameException e3) {
			MensajeEmergente.mostrarMensaje(e3.getMessage());
			return 0;
		} catch (NegativeNumberException e3) {
			MensajeEmergente.mostrarMensaje(e3.getMessage());
			return 0;
		}
		return creacion;
	}

	
	/**
	 * Retrieves and displays the details of the logged-in Director Deportivo
	 * (Sports Director). Retrieves the DirectorDeportivoDTO instance from the mf
	 * (Model Facade) object representing the logged-in user. Sets the text fields
	 * in the view's "Mostrar Director" panel with the Director's information. Makes
	 * the text fields non-editable to prevent modification of Director's details.
	 * Sets the gender dropdown box to reflect the Director's gender. Disables the
	 * gender dropdown box to prevent changes.
	 */

	public void mostrarDirector() {

		DirectorDeportivoDTO directorConsul = (DirectorDeportivoDTO) mf.getUsuarioLoginDTO();

		vf.getV().getJpnMostrarDirector().getTxtNombreCompleto().setText(directorConsul.getNombre());
		vf.getV().getJpnMostrarDirector().getTxtNombreCompleto().setEditable(false);
		vf.getV().getJpnMostrarDirector().getTxtNombreUsuario().setText(directorConsul.getId());
		vf.getV().getJpnMostrarDirector().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarDirector().getTxtNacionalidad().setText(directorConsul.getNacionalidad());
		vf.getV().getJpnMostrarDirector().getTxtNacionalidad().setEditable(false);
		vf.getV().getJpnMostrarDirector().getTxtNumeroCedula().setText(directorConsul.getCedula() + "");
		vf.getV().getJpnMostrarDirector().getTxtNumeroCedula().setEditable(false);
		vf.getV().getJpnMostrarDirector().getTxtCorreoElectronico().setText(directorConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarDirector().getTxtCorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarDirector().getTxtContrasenia().setText(directorConsul.getContrasenia());
		vf.getV().getJpnMostrarDirector().getTxtContrasenia().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarDirector().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarDirector().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarDirector().getBoxGenero().setEnabled(false);
	}

	/**
	 * Retrieves and displays the details of the logged-in Masajista (Massage
	 * Therapist). Retrieves the MasajistaDTO instance from the mf (Model Facade)
	 * object representing the logged-in user. Sets the text fields in the view's
	 * "Mostrar Masajista" panel with the Masajista's information. Makes the text
	 * fields non-editable to prevent modification of Masajista's details. Sets the
	 * gender dropdown box to reflect the Masajista's gender. Disables the gender
	 * dropdown box to prevent changes.
	 */

	public void mostrarMasajista() {

		MasajistaDTO masajistaConsul = (MasajistaDTO) mf.getUsuarioLoginDTO();

		vf.getV().getJpnMostrarMasajista().getTxtNombre().setText(masajistaConsul.getNombre());
		vf.getV().getJpnMostrarMasajista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarMasajista().getTxtNombreUsuario().setText(masajistaConsul.getId());
		vf.getV().getJpnMostrarMasajista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarMasajista().getAniosExperiencia().setText(masajistaConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarMasajista().getAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarMasajista().getTxtCedula().setText(masajistaConsul.getCedula() + "");
		vf.getV().getJpnMostrarMasajista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarMasajista().getCorreoElectronico().setText(masajistaConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarMasajista().getCorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarMasajista().getContraseña().setText(masajistaConsul.getContrasenia());
		vf.getV().getJpnMostrarMasajista().getContraseña().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarMasajista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarMasajista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarMasajista().getBoxGenero().setEnabled(false);

	}

	/**
	 * Displays the details of the logged-in Ciclista (Cyclist). Disables the radio
	 * buttons for selecting the type of cyclist. Retrieves and sets the details of
	 * the logged-in Ciclista from the Model Facade (mf). Populates the text fields
	 * in the view's "Mostrar Ciclista" panel with the Ciclista's information. Makes
	 * the text fields non-editable to prevent modification of Ciclista's details.
	 * Sets the gender dropdown box to reflect the Ciclista's gender. Disables the
	 * gender dropdown box to prevent changes.
	 */

	public void mostrarCiclista() {
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setSelected(false);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();
		vf.getV().getJpnMostrarCiclista().limpiarPanel();

		CiclistaDTO cilcistaConsul = (CiclistaDTO) mf.getUsuarioLoginDTO();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(cilcistaConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(cilcistaConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(cilcistaConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(cilcistaConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(cilcistaConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(cilcistaConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(cilcistaConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(cilcistaConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(cilcistaConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(cilcistaConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(cilcistaConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);
	}

	
	/**
	 * Displays the details of the logged-in ClasicoMano Ciclista (Classic Sprinter
	 * Cyclist). Enables and selects the radio button for ClasicoMano Ciclista.
	 * Disables the radio buttons for other types of cyclists. Retrieves and sets
	 * the details of the logged-in ClasicoMano Ciclista from the Model Facade (mf).
	 * Populates the text fields in the view's "Mostrar Ciclista" panel with the
	 * ClasicoMano Ciclista's information. Makes the text fields non-editable to
	 * prevent modification of the ClasicoMano Ciclista's details. Sets the gender
	 * dropdown box to reflect the ClasicoMano Ciclista's gender. Disables the
	 * gender dropdown box to prevent changes. Sets the number of classic wins text
	 * field with the number of classics won by the ClasicoMano Ciclista.
	 */

	public void mostrarCiclistaClasicoMano() {

		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(true);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();
		vf.getV().getJpnMostrarCiclista().limpiarPanel();

		ClasicoManoDTO clasicoConsul = (ClasicoManoDTO) mf.getUsuarioLoginDTO();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(clasicoConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(clasicoConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(clasicoConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(clasicoConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(clasicoConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(clasicoConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(clasicoConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(clasicoConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(clasicoConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(clasicoConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(clasicoConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getTxtNumClasicoGanado().setText(clasicoConsul.getNumClasicosGanados() + "");
		vf.getV().getJpnMostrarCiclista().getTxtNumClasicoGanado().setEditable(false);

	}


	/**
	 * Displays the details of the logged-in ContraReloj Ciclista (Time Trial
	 * Cyclist). Enables and selects the radio button for ContraReloj Ciclista.
	 * Disables the radio buttons for other types of cyclists. Retrieves and sets
	 * the details of the logged-in ContraReloj Ciclista from the Model Facade (mf).
	 * Populates the text fields in the view's "Mostrar Ciclista" panel with the
	 * ContraReloj Ciclista's information. Makes the text fields non-editable to
	 * prevent modification of the ContraReloj Ciclista's details. Sets the gender
	 * dropdown box to reflect the ContraReloj Ciclista's gender. Disables the
	 * gender dropdown box to prevent changes. Sets the maximum speed text field
	 * with the maximum speed of the ContraReloj Ciclista. Sets the appropriate
	 * radio button for the ContraReloj Ciclista's task based on its attributes.
	 */

	public void mostrarCiclistaContraReloj() {
		ContraRelojDTO contraRelojConsul = (ContraRelojDTO) mf.getUsuarioLoginDTO();
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(contraRelojConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(contraRelojConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia()
				.setText(contraRelojConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(contraRelojConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(contraRelojConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(contraRelojConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(contraRelojConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(contraRelojConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(contraRelojConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(contraRelojConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(contraRelojConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getTxtVelocidadMaxima().setText(contraRelojConsul.getVelocidadMaxima() + "");
		vf.getV().getJpnMostrarCiclista().getTxtVelocidadMaxima().setEditable(false);

		if (contraRelojConsul.isTareaContrareloj()) {
			vf.getV().getJpnCrearCiclista().getRbtnTareaCConcentrarse().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnTareaCConcentrarse().setSelected(true);

		} else {

			if (contraRelojConsul.isTareaContrareloj3()) {
				vf.getV().getJpnCrearCiclista().getRbtnTareaCVisualizar().isSelected();
				vf.getV().getJpnMostrarCiclista().getRbtnTareaCVisualizar().setSelected(true);

			} else {

				if (contraRelojConsul.isTareaContrareloj2()) {
					vf.getV().getJpnCrearCiclista().getRbtnTareaCRegular().isSelected();
					vf.getV().getJpnMostrarCiclista().getRbtnTareaCRegular().setSelected(true);

				}

			}
		}
	}

	/**
	 * Displays the details of the logged-in Embalador Ciclista (Sprinter Cyclist).
	 * Enables and selects the radio button for Embalador Ciclista. Disables the
	 * radio buttons for other types of cyclists. Retrieves and sets the details of
	 * the logged-in Embalador Ciclista from the Model Facade (mf). Populates the
	 * text fields in the view's "Mostrar Ciclista" panel with the Embalador
	 * Ciclista's information. Makes the text fields non-editable to prevent
	 * modification of the Embalador Ciclista's details. Sets the gender dropdown
	 * box to reflect the Embalador Ciclista's gender. Disables the gender dropdown
	 * box to prevent changes. Sets the power and average speed text fields with the
	 * corresponding attributes of the Embalador Ciclista. Sets the appropriate
	 * radio button for the Embalador Ciclista's task based on its attributes.
	 */

	public void mostrarCiclistaEmbalador() {
		EmbaladorDTO embaladorConsul = (EmbaladorDTO) mf.getUsuarioLoginDTO();
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(embaladorConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(embaladorConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(embaladorConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(embaladorConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(embaladorConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(embaladorConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(embaladorConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(embaladorConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(embaladorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(embaladorConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(embaladorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getTxtPotenciaPromedio().setText(embaladorConsul.getPotenciaPromedio() + "");
		vf.getV().getJpnMostrarCiclista().getTxtPotenciaPromedio().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedio()
				.setText(embaladorConsul.getVelocidadPromedioEmbalador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedio().setEditable(false);

		if (embaladorConsul.isTareaEmbalador()) {
			vf.getV().getJpnCrearCiclista().getRbtnTareaEmAumentarRitmo().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEmAumentarRitmo().setSelected(true);

		} else {
			embaladorConsul.isTareaEmbalador2();

			vf.getV().getJpnCrearCiclista().getRbtnTareaEmBajarRitmo().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEmBajarRitmo().setSelected(true);

		}

	}

	/**
	 * Displays the details of the logged-in Escalador Ciclista (Climber Cyclist).
	 * Enables and selects the radio button for Escalador Ciclista. Disables the
	 * radio buttons for other types of cyclists. Retrieves and sets the details of
	 * the logged-in Escalador Ciclista from the Model Facade (mf). Populates the
	 * text fields in the view's "Mostrar Ciclista" panel with the Escalador
	 * Ciclista's information. Makes the text fields non-editable to prevent
	 * modification of the Escalador Ciclista's details. Sets the gender dropdown
	 * box to reflect the Escalador Ciclista's gender. Disables the gender dropdown
	 * box to prevent changes. Sets the acceleration and supported ramp grade text
	 * fields with the corresponding attributes of the Escalador Ciclista. Sets the
	 * appropriate radio button for the Escalador Ciclista's task based on its
	 * attributes.
	 */

	public void mostrarCiclistaEscalador() {
		EscaladorDTO escaladorConsul = (EscaladorDTO) mf.getUsuarioLoginDTO();
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(escaladorConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(escaladorConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(escaladorConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(escaladorConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(escaladorConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(escaladorConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(escaladorConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(escaladorConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(escaladorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(escaladorConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(escaladorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getTxtAceleracionPromedio()
				.setText(escaladorConsul.getAceleracionPromedio() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAceleracionPromedio().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtGradoRampaSoportada()
				.setText(escaladorConsul.getGradoRampaSoportada() + "");
		vf.getV().getJpnMostrarCiclista().getTxtGradoRampaSoportada().setEditable(false);

		if (escaladorConsul.isTareaEscalador()) {
			vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearP().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEsPedalearP().setSelected(true);

		} else {
			escaladorConsul.isTareaEscalador2();
			vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearS().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEsPedalearS().setSelected(true);
		}

	}

	/**
	 * Displays the details of the logged-in Gregario Ciclista (Support Cyclist).
	 * Enables and selects the radio button for Gregario Ciclista. Disables the
	 * radio buttons for other types of cyclists. Retrieves and sets the details of
	 * the logged-in Gregario Ciclista from the Model Facade (mf). Populates the
	 * text fields in the view's "Mostrar Ciclista" panel with the Gregario
	 * Ciclista's information. Makes the text fields non-editable to prevent
	 * modification of the Gregario Ciclista's details. Sets the gender dropdown box
	 * to reflect the Gregario Ciclista's gender. Disables the gender dropdown box
	 * to prevent changes. Sets the appropriate radio button for the Gregario
	 * Ciclista's role based on its attributes.
	 */

	public void mostrarCiclistaGregario() {
		GregarioDTO gregarioConsul = (GregarioDTO) mf.getUsuarioLoginDTO();
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(gregarioConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(gregarioConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(gregarioConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(gregarioConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(gregarioConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(gregarioConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(gregarioConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(gregarioConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(gregarioConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(gregarioConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(gregarioConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		if (gregarioConsul.isEsAbastecedor()) {
			vf.getV().getJpnCrearCiclista().getRbtnAbastecedor().isSelected();
			vf.getV().getJpnMostrarCiclista().getRbtnAbastecedor().setSelected(true);
			vf.getV().getJpnMostrarCiclista().getRbtnAbastecedor().setEnabled(false);

		} else {

			if (gregarioConsul.isEsMantenerRitmo()) {
				vf.getV().getJpnCrearCiclista().getRbtnMantenerRitmo().isSelected();
				vf.getV().getJpnMostrarCiclista().getRbtnMantenerRitmo().setSelected(true);
				vf.getV().getJpnMostrarCiclista().getRbtnMantenerRitmo().setEnabled(false);

			} else {

				if (gregarioConsul.isEsCapturasFuga()) {
					vf.getV().getJpnCrearCiclista().getRbtnCapturasFuga().isSelected();
					vf.getV().getJpnMostrarCiclista().getRbtnCapturasFuga().setSelected(true);
					vf.getV().getJpnMostrarCiclista().getRbtnCapturasFuga().setEnabled(false);

				} else {
					if (gregarioConsul.isEsPosicionarLider()) {
						vf.getV().getJpnCrearCiclista().getRbtnPosicionarLider().isSelected();
						vf.getV().getJpnMostrarCiclista().getRbtnPosicionarLider().setSelected(true);
						vf.getV().getJpnMostrarCiclista().getRbtnPosicionarLider().setEnabled(false);
					} else {
						if (gregarioConsul.isEsPosicionarLider()) {
							vf.getV().getJpnCrearCiclista().getRbtnProtegerLider().isSelected();
							vf.getV().getJpnMostrarCiclista().getRbtnProtegerLider().setSelected(true);
							vf.getV().getJpnMostrarCiclista().getRbtnProtegerLider().setEnabled(false);
						}
					}
				}

			}
		}

	}

	/**
	 * Displays the details of the logged-in Rodador Ciclista (Rouleur Cyclist).
	 * Enables and selects the radio button for Rodador Ciclista. Disables the radio
	 * buttons for other types of cyclists. Retrieves and sets the details of the
	 * logged-in Rodador Ciclista from the Model Facade (mf). Populates the text
	 * fields in the view's "Mostrar Ciclista" panel with the Rodador Ciclista's
	 * information. Makes the text fields non-editable to prevent modification of
	 * the Rodador Ciclista's details. Sets the gender dropdown box to reflect the
	 * Rodador Ciclista's gender. Disables the gender dropdown box to prevent
	 * changes. Sets the text field for displaying average pedaling speed with the
	 * Rodador Ciclista's value.
	 */

	public void mostrarCiclistaRodador() {
		RodadorDTO rodadorConsul = (RodadorDTO) mf.getUsuarioLoginDTO();
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setSelected(true);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setEnabled(false);
		vf.getV().getJpnMostrarCiclista().getRbtnVacio().setEnabled(false);
		tipoCiclistaMostrar();

		vf.getV().getJpnMostrarCiclista().getTxtNombre().setText(rodadorConsul.getNombre());
		vf.getV().getJpnMostrarCiclista().getTxtNombre().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setText(rodadorConsul.getId());
		vf.getV().getJpnMostrarCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setText(rodadorConsul.getAniosExperiencia() + "");
		vf.getV().getJpnMostrarCiclista().getTxtAniosExperiencia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setText(rodadorConsul.getCedula() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCedula().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setText(rodadorConsul.getCorreoElectronico());
		vf.getV().getJpnMostrarCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setText(rodadorConsul.getContrasenia());
		vf.getV().getJpnMostrarCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtId().setText(rodadorConsul.getIdentificador() + "");
		vf.getV().getJpnMostrarCiclista().getTxtId().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setText(rodadorConsul.getTiempoAcumulado() + "");
		vf.getV().getJpnMostrarCiclista().getTxtTiempoAcumulado().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(rodadorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setText(rodadorConsul.getCadenciaPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtCadenciaPedaleo().setEditable(false);
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setText(rodadorConsul.getContextura());
		vf.getV().getJpnMostrarCiclista().getTxtContextura().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnMostrarCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnMostrarCiclista().getBoxGenero().setEnabled(false);

		vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedioPedaleo()
				.setText(rodadorConsul.getVelocidadPromedioPedaleo() + "");

		vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedioPedaleo()
				.setText(rodadorConsul.getVelocidadPromedioPedaleo() + "");
		vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedioPedaleo().setEditable(false);

	}

	/**
	 * Displays the details of the logged-in cyclist based on their type. Checks the
	 * type of the logged-in user using instanceof operator and calls the respective
	 * method to display their details. If the logged-in user is of type
	 * CiclistaDTO, it calls the mostrarCiclista() method. If the logged-in user is
	 * of type ClasicoManoDTO, it calls the mostrarCiclistaClasicoMano() method. If
	 * the logged-in user is of type ContraRelojDTO, it calls the
	 * mostrarCiclistaContraReloj() method. If the logged-in user is of type
	 * EmbaladorDTO, it calls the mostrarCiclistaEmbalador() method. If the
	 * logged-in user is of type EscaladorDTO, it calls the
	 * mostrarCiclistaEscalador() method. If the logged-in user is of type
	 * GregarioDTO, it calls the mostrarCiclistaGregario() method. If the logged-in
	 * user is of type RodadorDTO, it calls the mostrarCiclistaRodador() method.
	 */

	public void mostrarTipoCiclista() {

		if (mf.getUsuarioLoginDTO() instanceof CiclistaDTO) {
			mostrarCiclista();
		}

		if (mf.getUsuarioLoginDTO() instanceof ClasicoManoDTO) {
			mostrarCiclistaClasicoMano();
		}
		if (mf.getUsuarioLoginDTO() instanceof ContraRelojDTO) {
			mostrarCiclistaContraReloj();
		}
		if (mf.getUsuarioLoginDTO() instanceof EmbaladorDTO) {
			mostrarCiclistaEmbalador();
		}
		if (mf.getUsuarioLoginDTO() instanceof EscaladorDTO) {
			mostrarCiclistaEscalador();
		}
		if (mf.getUsuarioLoginDTO() instanceof GregarioDTO) {
			mostrarCiclistaGregario();
		}
		if (mf.getUsuarioLoginDTO() instanceof RodadorDTO) {
			mostrarCiclistaRodador();
		}

	}

	/**
	 * Updates the display based on the type of cyclist selected. Checks the
	 * selected radio button in the panel and shows relevant fields accordingly. If
	 * the "Clasico Mano" radio button is selected, it displays fields related to
	 * classic races won. If the "Contrarreloj" radio button is selected, it
	 * displays fields related to time trial cycling. If the "Embalador" radio
	 * button is selected, it displays fields related to sprinting ability. If the
	 * "Escalador" radio button is selected, it displays fields related to climbing
	 * ability. If the "Gregario" radio button is selected, it displays fields
	 * related to supporting roles in a cycling team. If the "Rodador" radio button
	 * is selected, it displays fields related to endurance cycling. If the "Vacio"
	 * (Empty) radio button is selected, it clears the panel. Repaints the panel to
	 * ensure changes are visible.
	 */

	public void tipoCiclistaMostrar() {

		if (vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getLblNumClasicoGanado().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtNumClasicoGanado().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getLblVelocidadMaxima().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtVelocidadMaxima().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaCConcentrarse().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaCRegular().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaCVisualizar().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getLblPotenciaPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtPotenciaPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getLblVelocidadPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getLblPotenciaPromedio1().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEmAumentarRitmo().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEmBajarRitmo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnEscalador().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getLblAceleracionPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getLblAceleracionPromedio1().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtAceleracionPromedio().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getLblGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEsPedalearP().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnTareaEsPedalearS().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnGregario().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getRbtnAbastecedor().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnMantenerRitmo().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnCapturasFuga().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnPosicionarLider().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getRbtnProtegerLider().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnRodador().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnMostrarCiclista().getLblVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getLblVelocidadPromedioPedaleo1().setVisible(true);
			vf.getV().getJpnMostrarCiclista().getTxtVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnMostrarCiclista().getRbtnVacio().isSelected()) {
			vf.getV().getJpnMostrarCiclista().limpiarPanelCrearCiclista();
		}
	}

	/**
	 * Validates the user's credentials and updates the user interface accordingly.
	 * If the credentials are correct, it displays the main options panel and sets
	 * the user label. If the credentials are incorrect, it shows an error message
	 * and resets the login interface.
	 */

	public void login() {
		String id = vf.getV().getJpnIngreso().getTxtId().getText();

		String contrasena = vf.getV().getJpnIngreso().getTxtContrasenia().getText();

		mf.setUsuarioLoginDTO(mf.getUsuarioDAO().getUsuarios(id));

		if (mf.getUsuarioLoginDTO() != null) {
			if (mf.getUsuarioLoginDTO().getContrasenia().equals(contrasena)) {
				vf.getV().getJpnOpciones().setVisible(true);
				vf.getV().getJpnMenuUsuarios().setVisible(false);
				vf.getV().getJpnCrearCiclista().setVisible(false);
				vf.getV().getJpnIngreso().setVisible(false);
				String tipoUsuario = "";

				if (mf.getUsuarioLoginDTO() instanceof UsuarioDTO)
					tipoUsuario = "Administrativo : ";
				if (mf.getUsuarioLoginDTO() instanceof DirectorDeportivoDTO)
					tipoUsuario = "Director : ";
				if (mf.getUsuarioLoginDTO() instanceof MasajistaDTO)
					tipoUsuario = "Masajista : ";
				if (mf.getUsuarioLoginDTO() instanceof CiclistaDTO)
					tipoUsuario = "Ciclista : ";
				if (mf.getUsuarioLoginDTO() instanceof ClasicoManoDTO)
					tipoUsuario = "C. ClasicoMano : ";
				if (mf.getUsuarioLoginDTO() instanceof ContraRelojDTO)
					tipoUsuario = "C. ContraReloj : ";
				if (mf.getUsuarioLoginDTO() instanceof EmbaladorDTO)
					tipoUsuario = "C. Embalador : ";
				if (mf.getUsuarioLoginDTO() instanceof EscaladorDTO)
					tipoUsuario = "C. Escalador : ";
				if (mf.getUsuarioLoginDTO() instanceof GregarioDTO)
					tipoUsuario = "C. Gregario : ";
				else if (mf.getUsuarioLoginDTO() instanceof RodadorDTO)
					tipoUsuario = "C. Rodador : ";

				vf.getV().getJpnOpciones().getLblUsuario().setText(tipoUsuario + mf.getUsuarioLoginDTO().getId());
				vf.getV().getJpnOpciones().repaint();
			} else {
				MensajeEmergente.mostrarMensaje("Contraseña o nombre de usuario invalido");
			}
		} else {
			MensajeEmergente.mostrarMensaje("Contraseña o nombre de usuario invalido");
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnCrearCiclista().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().getJpnOpciones().repaint();

		}

	}

//Eliminar -------------------------------------------------------------------------------------------------------------------------	
	/**
	 * Deletes a masajista (masseur) user from the system based on the entered user
	 * ID. Retrieves the user ID from the corresponding text field in the user
	 * interface. Searches for the position of the user in the user data access
	 * object (DAO) based on the ID. If the user is found, deletes the user from the
	 * DAO and displays a success message. If the user is not found, displays a
	 * message indicating that the user was not found.
	 */

	public void eliminarUsuarioMasajista() {
		String id = vf.getV().getJpnEliminarMasajista().getNombreUsuarioEliminar().getText();

		int index = mf.getUsuarioDAO().buscarPosicion(id);

		if (index != -1) {
			MensajeEmergente.mostrarMensaje(mf.getUsuarioDAO().delete(index));
		} else {

			MensajeEmergente.mostrarMensaje("Usuario no encontrado");

		}
	}

	/**
	 * Deletes a director user from the system based on the entered user ID.
	 * Retrieves the user ID from the corresponding text field in the user
	 * interface. Searches for the position of the user in the user data access
	 * object (DAO) based on the ID. If the user is found, deletes the user from the
	 * DAO and displays a success message. If the user is not found, displays a
	 * message indicating that the user was not found.
	 */

	public void eliminarUsuarioDirector() {
		String id = vf.getV().getJpnEliminarDirector().getTxtNombreUsuario().getText();

		int index = mf.getUsuarioDAO().buscarPosicion(id);

		if (index != -1) {
			MensajeEmergente.mostrarMensaje(mf.getUsuarioDAO().delete(index));
		} else {

			MensajeEmergente.mostrarMensaje("Usuario no encontrado");
		}
	}

	/**
	 * Deletes a user from the system based on the entered user ID. Retrieves the
	 * user ID from the corresponding text field in the user interface. Searches for
	 * the position of the user in the user data access object (DAO) based on the
	 * ID. If the user is found, deletes the user from the DAO, displays a success
	 * message, and adjusts the visibility of user interface components accordingly.
	 * If the user is not found, displays a message indicating that the user was not
	 * found and adjusts the visibility of user interface components accordingly.
	 */

	public void eliminarUsuario() {
		String id = vf.getV().getJpnEliminarUsuario().getTxtEliminarUsuario().getText();
		int index = mf.getUsuarioDAO().buscarPosicion(id);

		if (index != -1) {
			MensajeEmergente.mostrarMensaje(mf.getUsuarioDAO().delete(index));
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().getJpnEliminarUsuario().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
		} else {
			MensajeEmergente.mostrarMensaje("Usuario no encontrado");
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnEliminarUsuario().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);

		}

	}

	/**
	 * Deletes a bracket from the system based on the entered user ID. Retrieves the
	 * user ID from the corresponding text field in the user interface. Searches for
	 * the position of the user in the user data access object (DAO) based on the
	 * ID. If the user is found, deletes the user from the DAO, displays a success
	 * message, and adjusts the visibility of user interface components accordingly.
	 * If the user is not found, displays a message indicating that the user was not
	 * found and adjusts the visibility of user interface components accordingly.
	 */
	public void eliminarEscuadra() {
		String id = vf.getV().getJpnEliminarEscuadra().getTxtEliminarEscuadra().getText();
		int index = mf.getEscuadraDAO().buscarPosicion(id);

		if (index != -1) {
			MensajeEmergente.mostrarMensaje(mf.getEscuadraDAO().delete(index));
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().getJpnEliminarEscuadra().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
		} else {
			MensajeEmergente.mostrarMensaje("escuadra no encontrado");
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnEliminarEscuadra().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);

		}
	}

//llenar----------------------------------------------------------------------------------------------------------------------------
	/**
	 * Fills the fields of the "Crear Ciclista" panel in the user interface with
	 * information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void llenarUsuarioACiclista() {

		vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico()
				.setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().setEditable(false);
		vf.getV().getJpnCrearCiclista().getTxtContrasenia().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnCrearCiclista().getTxtContrasenia().setEditable(false);
		vf.getV().getJpnCrearCiclista().getTxtCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnCrearCiclista().getTxtCedula().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnCrearCiclista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnCrearCiclista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnCrearCiclista().getBoxGenero().setEnabled(false);

	}

	/**
	 * Fills the fields of the "Actualizar Ciclista" panel in the user interface
	 * with information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void llenarActualizarUsuarioCiclista() {
		vf.getV().getJpnActualizarCiclista().getTxtNuevoNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnActualizarCiclista().getTxtNuevoNombreUsuario().setEditable(false);
		vf.getV().getJpnActualizarCiclista().getTxtNuevocorreoElectronico()
				.setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnActualizarCiclista().getTxtNuevocorreoElectronico().setEditable(false);
		vf.getV().getJpnActualizarCiclista().getTxtNuevoContrasenia().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnActualizarCiclista().getTxtNuevoContrasenia().setEditable(false);
		vf.getV().getJpnActualizarCiclista().getTxtNuevoCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnActualizarCiclista().getTxtNuevoCedula().setEditable(false);
		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnActualizarCiclista().getBoxNuevoGenero().setSelectedIndex(1);
		} else {
			vf.getV().getJpnActualizarCiclista().getBoxNuevoGenero().setSelectedIndex(0);
		}

		vf.getV().getJpnActualizarCiclista().getBoxNuevoGenero().setEnabled(false);
	}

	/**
	 * Fills the fields of the "Crear Masajista" panel in the user interface with
	 * information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void llenarCrearUsuarioAMasajista() {
		vf.getV().getJpnCrearMasajista().getNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnCrearMasajista().getNombreUsuario().setEditable(false);
		vf.getV().getJpnCrearMasajista().getCorreoElectronico().setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnCrearMasajista().getCorreoElectronico().setEditable(false);
		vf.getV().getJpnCrearMasajista().getContrasenia().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnCrearMasajista().getContrasenia().setEditable(false);
		vf.getV().getJpnCrearMasajista().getCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnCrearMasajista().getCedula().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnCrearMasajista().getGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnCrearMasajista().getGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnCrearMasajista().getGenero().setEnabled(false);
	}

	/**
	 * Fills the fields of the "Actualizar Masajista" panel in the user interface
	 * with information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void llenarActualizarUsuarioAMasajista() {
		vf.getV().getJpnActualizarMasajista().getNuevoNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnActualizarMasajista().getNuevoNombreUsuario().setEditable(false);
		vf.getV().getJpnActualizarMasajista().getCorreoElectronico()
				.setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnActualizarMasajista().getCorreoElectronico().setEditable(false);
		vf.getV().getJpnActualizarMasajista().getContrasenia().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnActualizarMasajista().getContrasenia().setEditable(false);
		vf.getV().getJpnActualizarMasajista().getNuevaCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnActualizarMasajista().getNuevaCedula().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnActualizarMasajista().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnActualizarMasajista().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnActualizarMasajista().getBoxGenero().setEnabled(false);
	}

	/**
	 * Fills the fields of the "Crear Director" panel in the user interface with
	 * information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void llenarCrearUsuarioADirector() {
		vf.getV().getJpnCrearDirector().getTxtNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnCrearDirector().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnCrearDirector().getTxtCorreoElectronico()
				.setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnCrearDirector().getTxtCorreoElectronico().setEditable(false);
		vf.getV().getJpnCrearDirector().getTxtContraseña().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnCrearDirector().getTxtContraseña().setEditable(false);
		vf.getV().getJpnCrearDirector().getTxtNumeroCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnCrearDirector().getTxtNumeroCedula().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnCrearDirector().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnCrearDirector().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnCrearDirector().getBoxGenero().setEnabled(false);
	}

	/**
	 * Fills the fields of the "Crear Director" panel in the user interface with
	 * information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */
	public void llenarActualizarUsuarioADirector() {

		vf.getV().getJpnActualizarDirector().getTxtNombreUsuario().setText(mf.getUsuarioLoginDTO().getId());
		vf.getV().getJpnActualizarDirector().getTxtNombreUsuario().setEditable(false);
		vf.getV().getJpnActualizarDirector().getTxtCorreoElectronico()
				.setText(mf.getUsuarioLoginDTO().getCorreoElectronico());
		vf.getV().getJpnActualizarDirector().getTxtCorreoElectronico().setEditable(false);
		vf.getV().getJpnActualizarDirector().getTxtContraseña().setText(mf.getUsuarioLoginDTO().getContrasenia());
		vf.getV().getJpnActualizarDirector().getTxtContraseña().setEditable(false);
		vf.getV().getJpnActualizarDirector().getTxtNumeroCedula().setText(mf.getUsuarioLoginDTO().getCedula() + "");
		vf.getV().getJpnActualizarDirector().getTxtNumeroCedula().setEditable(false);

		if (mf.getUsuarioLoginDTO().getGenero().equals("Mujer")) {
			vf.getV().getJpnActualizarDirector().getBoxGenero().setSelectedIndex(1);

		} else {
			vf.getV().getJpnActualizarDirector().getBoxGenero().setSelectedIndex(0);

		}

		vf.getV().getJpnActualizarDirector().getBoxGenero().setEnabled(false);

	}

	// Actualizar
	// -----------------------------------------------------------------------------------------------------------------------

	/**
	 * Fills the fields of the "Actualizar Director" panel in the user interface
	 * with information from the currently logged-in user. Sets the text fields for
	 * username, email, password, and ID number with the corresponding data from the
	 * logged-in user. Disables editing for these fields to prevent modification of
	 * user information. Sets the gender selection box to the appropriate index
	 * based on the gender of the logged-in user. Disables editing for the gender
	 * selection box to prevent modification.
	 */

	public void actualizarDirector() {
		if (mf.getUsuarioLoginDTO() instanceof DirectorDeportivoDTO) {
			String nacionalidad = vf.getV().getJpnActualizarDirector().getTxtNacionalidad().getText();
			String nombre = vf.getV().getJpnActualizarDirector().getTxtNombreCompleto().getText();

			DirectorDeportivoDTO directorActualizado = (DirectorDeportivoDTO) mf.getUsuarioLoginDTO();
			directorActualizado.setNacionalidad(nacionalidad);
			directorActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else
			MensajeEmergente.mostrarMensaje("No se pudo actualizar");
	}

	/**
	 * Updates the information of the logged-in user if they are a massage
	 * therapist. Retrieves the years of experience and name entered in the
	 * "Actualizar Masajista" panel from the user interface. Sets the years of
	 * experience and name for the massage therapist DTO with the retrieved data.
	 * Calls the update method of the user DAO to persist the changes to the
	 * database. Displays an error message if the logged-in user is not a massage
	 * therapist.
	 */

	public void actualizarMasajista() {
		if (mf.getUsuarioLoginDTO() instanceof MasajistaDTO) {
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarMasajista().getAniosDeExperiencia().getText());
			String nombre = vf.getV().getJpnActualizarMasajista().getNuevoNombre().getText();

			MasajistaDTO masajistaActualizado = (MasajistaDTO) mf.getUsuarioLoginDTO();
			masajistaActualizado.setAniosExperiencia(aniosExperencia);
			masajistaActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else
			MensajeEmergente.mostrarMensaje("No se pudo actualizar");
	}


	/**
	 * Updates the information of the logged-in user if they are a cyclist.
	 * Retrieves the identifier, accumulated time, physique, pedaling cadence, years
	 * of experience, and name entered in the "Actualizar Ciclista" panel from the
	 * user interface. If the logged-in user is a cyclist: - Sets the retrieved data
	 * to the corresponding fields of the logged-in cyclist DTO. - Calls the update
	 * method of the user DAO to persist the changes. If the logged-in user is not a
	 * cyclist: - Creates a new cyclist DTO object and sets the retrieved data along
	 * with the general user information. - Calls the update method of the user DAO
	 * with the index of the logged-in user and the new cyclist DTO to update the
	 * user information.
	 */

	public void actualizarCiclista() {

		if (mf.getUsuarioLoginDTO() instanceof CiclistaDTO) {
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();

			CiclistaDTO ciclistaActualizado = (CiclistaDTO) mf.getUsuarioLoginDTO();
			ciclistaActualizado.setIdentificador(identificador);
			ciclistaActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaActualizado.setContextura(contextura);
			ciclistaActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO cilcistaActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();

			CiclistaDTO nuevoCiclista = new CiclistaDTO();

			nuevoCiclista.setCedula(cilcistaActualizado.getCedula());
			nuevoCiclista.setGenero(cilcistaActualizado.getGenero());
			nuevoCiclista.setCorreoElectronico(cilcistaActualizado.getCorreoElectronico());
			nuevoCiclista.setId(cilcistaActualizado.getId());
			nuevoCiclista.setContrasenia(cilcistaActualizado.getContrasenia());
			nuevoCiclista.setIdentificador(identificador);
			nuevoCiclista.setTiempoAcumulado(tiempoAcumulado);
			nuevoCiclista.setContextura(contextura);
			nuevoCiclista.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoCiclista.setAniosExperiencia(aniosExperencia);
			nuevoCiclista.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(cilcistaActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoCiclista);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are a Classic Hand
	 * cyclist. Retrieves the identifier, accumulated time, physique, pedaling
	 * cadence, years of experience, number of classic wins, and name entered in the
	 * "Actualizar Ciclista" panel from the user interface. If the logged-in user is
	 * a Classic Hand cyclist: - Sets the retrieved data to the corresponding fields
	 * of the logged-in Classic Hand cyclist DTO. - Calls the update method of the
	 * user DAO to persist the changes. If the logged-in user is not a Classic Hand
	 * cyclist: - Creates a new Classic Hand cyclist DTO object and sets the
	 * retrieved data along with the general user information. - Calls the update
	 * method of the user DAO with the index of the logged-in user and the new
	 * Classic Hand cyclist DTO to update the user information.
	 */

	public void actualizarCiclistaClasicoMano() {

		if (mf.getUsuarioLoginDTO() instanceof ClasicoManoDTO) {
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			int numClasicosGanados = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoNumClasicoGanado().getText());
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();

			ClasicoManoDTO ciclistaClasicoManoActualizado = (ClasicoManoDTO) mf.getUsuarioLoginDTO();
			ciclistaClasicoManoActualizado.setIdentificador(identificador);
			ciclistaClasicoManoActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaClasicoManoActualizado.setContextura(contextura);
			ciclistaClasicoManoActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaClasicoManoActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaClasicoManoActualizado.setNumClasicosGanados(numClasicosGanados);
			ciclistaClasicoManoActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO clasicoManoActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			int numClasicosGanados = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoNumClasicoGanado().getText());
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();

			ClasicoManoDTO nuevoClasicoMano = new ClasicoManoDTO();

			nuevoClasicoMano.setCedula(clasicoManoActualizado.getCedula());
			nuevoClasicoMano.setGenero(clasicoManoActualizado.getGenero());
			nuevoClasicoMano.setCorreoElectronico(clasicoManoActualizado.getCorreoElectronico());
			nuevoClasicoMano.setId(clasicoManoActualizado.getId());
			nuevoClasicoMano.setContrasenia(clasicoManoActualizado.getContrasenia());
			nuevoClasicoMano.setIdentificador(identificador);
			nuevoClasicoMano.setTiempoAcumulado(tiempoAcumulado);
			nuevoClasicoMano.setContextura(contextura);
			nuevoClasicoMano.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoClasicoMano.setAniosExperiencia(aniosExperencia);
			nuevoClasicoMano.setNumClasicosGanados(numClasicosGanados);
			nuevoClasicoMano.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(clasicoManoActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoClasicoMano);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are a Time Trial
	 * cyclist. Retrieves the name, identifier, accumulated time, physique, pedaling
	 * cadence, years of experience, maximum speed, and time trial task details
	 * entered in the "Actualizar Ciclista" panel from the user interface. If the
	 * logged-in user is a Time Trial cyclist: - Sets the retrieved data to the
	 * corresponding fields of the logged-in Time Trial cyclist DTO. - Calls the
	 * update method of the user DAO to persist the changes. If the logged-in user
	 * is not a Time Trial cyclist: - Creates a new Time Trial cyclist DTO object
	 * and sets the retrieved data along with the general user information. - Calls
	 * the update method of the user DAO with the index of the logged-in user and
	 * the new Time Trial cyclist DTO to update the user information. Additionally,
	 * updates the selected task option in the "Crear Ciclista" and "Mostrar
	 * Ciclista" panels based on the updated time trial task details.
	 */

	public void actualizarCiclistaContraReloj() {

		if (mf.getUsuarioLoginDTO() instanceof ContraRelojDTO) {

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double velocidadMaxima = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadMaxima().getText());
			boolean tareaContrareloj = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCConcentrarse()
					.isSelected();
			boolean tareaContrareloj2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCRegular().isSelected();
			boolean tareaContrareloj3 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCVisualizar()
					.isSelected();

			ContraRelojDTO ciclistaContrarelojActualizado = (ContraRelojDTO) mf.getUsuarioLoginDTO();
			ciclistaContrarelojActualizado.setIdentificador(identificador);
			ciclistaContrarelojActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaContrarelojActualizado.setContextura(contextura);
			ciclistaContrarelojActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaContrarelojActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaContrarelojActualizado.setVelocidadMaxima(velocidadMaxima);
			ciclistaContrarelojActualizado.setTareaContrareloj(tareaContrareloj);
			ciclistaContrarelojActualizado.setTareaContrareloj(tareaContrareloj2);
			ciclistaContrarelojActualizado.setTareaContrareloj(tareaContrareloj3);
			ciclistaContrarelojActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO contraRelojActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double velocidadMaxima = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadMaxima().getText());
			boolean tareaContrareloj = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCConcentrarse()
					.isSelected();
			boolean tareaContrareloj2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCRegular().isSelected();
			boolean tareaContrareloj3 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCVisualizar()
					.isSelected();

			ContraRelojDTO nuevocontraReloj = new ContraRelojDTO();

			nuevocontraReloj.setCedula(contraRelojActualizado.getCedula());
			nuevocontraReloj.setGenero(contraRelojActualizado.getGenero());
			nuevocontraReloj.setCorreoElectronico(contraRelojActualizado.getCorreoElectronico());
			nuevocontraReloj.setId(contraRelojActualizado.getId());
			nuevocontraReloj.setContrasenia(contraRelojActualizado.getContrasenia());
			nuevocontraReloj.setIdentificador(identificador);
			nuevocontraReloj.setTiempoAcumulado(tiempoAcumulado);
			nuevocontraReloj.setContextura(contextura);
			nuevocontraReloj.setCadenciaPedaleo(cadenciaPedaleo);
			nuevocontraReloj.setAniosExperiencia(aniosExperencia);
			nuevocontraReloj.setVelocidadMaxima(velocidadMaxima);
			nuevocontraReloj.setTareaContrareloj(tareaContrareloj);
			nuevocontraReloj.setTareaContrareloj2(tareaContrareloj2);
			nuevocontraReloj.setTareaContrareloj3(tareaContrareloj3);
			nuevocontraReloj.setNombre(nombre);

			if (nuevocontraReloj.isTareaContrareloj()) {
				vf.getV().getJpnCrearCiclista().getRbtnTareaCConcentrarse().isSelected();
				vf.getV().getJpnMostrarCiclista().getRbtnTareaCConcentrarse().setSelected(true);

			} else {

				if (nuevocontraReloj.isTareaContrareloj3()) {
					vf.getV().getJpnCrearCiclista().getRbtnTareaCVisualizar().isSelected();
					vf.getV().getJpnMostrarCiclista().getRbtnTareaCVisualizar().setSelected(true);

				} else {

					if (nuevocontraReloj.isTareaContrareloj2()) {
						vf.getV().getJpnCrearCiclista().getRbtnTareaCRegular().isSelected();
						vf.getV().getJpnMostrarCiclista().getRbtnTareaCRegular().setSelected(true);

					}

				}
			}

			int index = mf.getUsuarioDAO().buscarPosicion(contraRelojActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevocontraReloj);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are a Sprinter cyclist.
	 * Retrieves the name, identifier, accumulated time, physique, pedaling cadence,
	 * years of experience, average power, and average sprinter speed entered in the
	 * "Actualizar Ciclista" panel from the user interface. If the logged-in user is
	 * a Sprinter cyclist: - Sets the retrieved data to the corresponding fields of
	 * the logged-in Sprinter cyclist DTO. - Calls the update method of the user DAO
	 * to persist the changes. If the logged-in user is not a Sprinter cyclist: -
	 * Creates a new Sprinter cyclist DTO object and sets the retrieved data along
	 * with the general user information. - Calls the update method of the user DAO
	 * with the index of the logged-in user and the new Sprinter cyclist DTO to
	 * update the user information.
	 */

	public void actualizarCiclistaEmbalador() {

		if (mf.getUsuarioLoginDTO() instanceof EmbaladorDTO) {
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double potenciaPromedio = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoPotenciaPromedio().getText());
			double velocidadPromedioE = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedio().getText());
			boolean tareaEmbalador = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmAumentarRitmo()
					.isSelected();
			boolean tareaEmbalador2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmBajarRitmo().isSelected();

			EmbaladorDTO ciclistaEmbaladorActualizado = (EmbaladorDTO) mf.getUsuarioLoginDTO();

			ciclistaEmbaladorActualizado.setIdentificador(identificador);
			ciclistaEmbaladorActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaEmbaladorActualizado.setContextura(contextura);
			ciclistaEmbaladorActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaEmbaladorActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaEmbaladorActualizado.setPotenciaPromedio(potenciaPromedio);
			ciclistaEmbaladorActualizado.setVelocidadPromedioEmbalador(velocidadPromedioE);
			ciclistaEmbaladorActualizado.setVelocidadPromedioEmbalador(velocidadPromedioE);
			ciclistaEmbaladorActualizado.setTareaEmbalador(tareaEmbalador);
			ciclistaEmbaladorActualizado.setTareaEmbalador(tareaEmbalador2);
			ciclistaEmbaladorActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO embaladorActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double potenciaPromedio = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoPotenciaPromedio().getText());
			double velocidadPromedioE = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedio().getText());
			boolean tareaEmbalador = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmAumentarRitmo()
					.isSelected();
			boolean tareaEmbalador2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmBajarRitmo().isSelected();

			EmbaladorDTO nuevoEmbalador = new EmbaladorDTO();

			nuevoEmbalador.setCedula(embaladorActualizado.getCedula());
			nuevoEmbalador.setGenero(embaladorActualizado.getGenero());
			nuevoEmbalador.setCorreoElectronico(embaladorActualizado.getCorreoElectronico());
			nuevoEmbalador.setId(embaladorActualizado.getId());
			nuevoEmbalador.setContrasenia(embaladorActualizado.getContrasenia());
			nuevoEmbalador.setIdentificador(identificador);
			nuevoEmbalador.setTiempoAcumulado(tiempoAcumulado);
			nuevoEmbalador.setContextura(contextura);
			nuevoEmbalador.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoEmbalador.setAniosExperiencia(aniosExperencia);
			nuevoEmbalador.setPotenciaPromedio(potenciaPromedio);
			nuevoEmbalador.setVelocidadPromedioEmbalador(velocidadPromedioE);
			nuevoEmbalador.setTareaEmbalador(tareaEmbalador);
			nuevoEmbalador.setTareaEmbalador(tareaEmbalador2);
			nuevoEmbalador.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(embaladorActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoEmbalador);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are an Escalador
	 * cyclist. Retrieves the name, identifier, accumulated time, physique, pedaling
	 * cadence, years of experience, average acceleration, and supported ramp grade
	 * entered in the "Actualizar Ciclista" panel from the user interface. If the
	 * logged-in user is an Escalador cyclist: - Sets the retrieved data to the
	 * corresponding fields of the logged-in Escalador cyclist DTO. - Calls the
	 * update method of the user DAO to persist the changes. If the logged-in user
	 * is not an Escalador cyclist: - Creates a new Escalador cyclist DTO object and
	 * sets the retrieved data along with the general user information. - Calls the
	 * update method of the user DAO with the index of the logged-in user and the
	 * new Escalador cyclist DTO to update the user information.
	 */

	public void actualizarCiclistaEscalador() {

		if (mf.getUsuarioLoginDTO() instanceof EscaladorDTO) {
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double aceleracionPromedio = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoAceleracionPromedio().getText());
			double gradoRampaSoportada = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoGradoRampaSoportada().getText());
			boolean tareaEscalador = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearP().isSelected();
			boolean tareaEscalador2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearS().isSelected();

			EscaladorDTO ciclistaEscaladorActualizado = (EscaladorDTO) mf.getUsuarioLoginDTO();
			ciclistaEscaladorActualizado.setIdentificador(identificador);
			ciclistaEscaladorActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaEscaladorActualizado.setContextura(contextura);
			ciclistaEscaladorActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaEscaladorActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaEscaladorActualizado.setAceleracionPromedio(aceleracionPromedio);
			ciclistaEscaladorActualizado.setGradoRampaSoportada(gradoRampaSoportada);
			ciclistaEscaladorActualizado.setTareaEscalador(tareaEscalador);
			ciclistaEscaladorActualizado.setTareaEscalador(tareaEscalador2);
			ciclistaEscaladorActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

//			private double aceleracionPromedio;
//			private double gradoRampaSoportada;
//			private boolean tareaEscalador;

		} else {

			UsuarioDTO escaladorActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double aceleracionPromedio = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoAceleracionPromedio().getText());
			double gradoRampaSoportada = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoGradoRampaSoportada().getText());
			boolean tareaEscalador = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearP().isSelected();
			boolean tareaEscalador2 = vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearS().isSelected();

			EscaladorDTO nuevoEscalador = new EscaladorDTO();

			nuevoEscalador.setCedula(escaladorActualizado.getCedula());
			nuevoEscalador.setGenero(escaladorActualizado.getGenero());
			nuevoEscalador.setCorreoElectronico(escaladorActualizado.getCorreoElectronico());
			nuevoEscalador.setId(escaladorActualizado.getId());
			nuevoEscalador.setContrasenia(escaladorActualizado.getContrasenia());
			nuevoEscalador.setIdentificador(identificador);
			nuevoEscalador.setTiempoAcumulado(tiempoAcumulado);
			nuevoEscalador.setContextura(contextura);
			nuevoEscalador.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoEscalador.setAniosExperiencia(aniosExperencia);
			nuevoEscalador.setAceleracionPromedio(aceleracionPromedio);
			nuevoEscalador.setGradoRampaSoportada(gradoRampaSoportada);
			nuevoEscalador.setTareaEscalador(tareaEscalador);
			nuevoEscalador.setTareaEscalador(tareaEscalador2);
			nuevoEscalador.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(escaladorActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoEscalador);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are a Gregario cyclist.
	 * Retrieves the name, identifier, accumulated time, physique, pedaling cadence,
	 * years of experience, and specific tasks entered in the "Actualizar Ciclista"
	 * panel from the user interface. If the logged-in user is a Gregario cyclist: -
	 * Sets the retrieved data to the corresponding fields of the logged-in Gregario
	 * cyclist DTO. - Calls the update method of the user DAO to persist the
	 * changes. If the logged-in user is not a Gregario cyclist: - Creates a new
	 * Gregario cyclist DTO object and sets the retrieved data along with the
	 * general user information. - Calls the update method of the user DAO with the
	 * index of the logged-in user and the new Gregario cyclist DTO to update the
	 * user information.
	 */

	public void actualizarCiclistaGregario() {

		if (mf.getUsuarioLoginDTO() instanceof GregarioDTO) {
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			boolean esAbastecedor = vf.getV().getJpnActualizarCiclista().getRbtnNuevoAbastecedor().isSelected();
			boolean esMantenerRitmo = vf.getV().getJpnActualizarCiclista().getRbtnNuevoMantenerRitmo().isSelected();
			boolean esCapturasFuga = vf.getV().getJpnActualizarCiclista().getRbtnNuevoCapturasFuga().isSelected();
			boolean esPosicionarLider = vf.getV().getJpnActualizarCiclista().getRbtnNuevoPosicionarLider().isSelected();
			boolean esProtegerLider = vf.getV().getJpnActualizarCiclista().getRbtnNuevoProtegerLider().isSelected();

			GregarioDTO ciclistaGregarioActualizado = (GregarioDTO) mf.getUsuarioLoginDTO();
			ciclistaGregarioActualizado.setIdentificador(identificador);
			ciclistaGregarioActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaGregarioActualizado.setContextura(contextura);
			ciclistaGregarioActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaGregarioActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaGregarioActualizado.setEsAbastecedor(esAbastecedor);
			ciclistaGregarioActualizado.setEsMantenerRitmo(esMantenerRitmo);
			ciclistaGregarioActualizado.setEsCapturasFuga(esCapturasFuga);
			ciclistaGregarioActualizado.setEsPosicionarLider(esPosicionarLider);
			ciclistaGregarioActualizado.setEsProtegerLider(esProtegerLider);

			ciclistaGregarioActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO gregarioActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			boolean esAbastecedor = vf.getV().getJpnActualizarCiclista().getRbtnNuevoAbastecedor().isSelected();
			boolean esMantenerRitmo = vf.getV().getJpnActualizarCiclista().getRbtnNuevoMantenerRitmo().isSelected();
			boolean esCapturasFuga = vf.getV().getJpnActualizarCiclista().getRbtnNuevoCapturasFuga().isSelected();
			boolean esPosicionarLider = vf.getV().getJpnActualizarCiclista().getRbtnNuevoPosicionarLider().isSelected();
			boolean esProtegerLider = vf.getV().getJpnActualizarCiclista().getRbtnNuevoProtegerLider().isSelected();

			GregarioDTO nuevoGregario = new GregarioDTO();

			nuevoGregario.setCedula(gregarioActualizado.getCedula());
			nuevoGregario.setGenero(gregarioActualizado.getGenero());
			nuevoGregario.setCorreoElectronico(gregarioActualizado.getCorreoElectronico());
			nuevoGregario.setId(gregarioActualizado.getId());
			nuevoGregario.setContrasenia(gregarioActualizado.getContrasenia());
			nuevoGregario.setIdentificador(identificador);
			nuevoGregario.setTiempoAcumulado(tiempoAcumulado);
			nuevoGregario.setContextura(contextura);
			nuevoGregario.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoGregario.setAniosExperiencia(aniosExperencia);
			nuevoGregario.setEsAbastecedor(esAbastecedor);
			nuevoGregario.setEsMantenerRitmo(esMantenerRitmo);
			nuevoGregario.setEsCapturasFuga(esCapturasFuga);
			nuevoGregario.setEsProtegerLider(esProtegerLider);
			nuevoGregario.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(gregarioActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoGregario);

		}
	}

	/**
	 * Updates the information of the logged-in user if they are a Rodador cyclist.
	 * Retrieves the name, identifier, accumulated time, physique, pedaling cadence,
	 * years of experience, and average pedaling speed entered in the "Actualizar
	 * Ciclista" panel from the user interface. If the logged-in user is a Rodador
	 * cyclist: - Sets the retrieved data to the corresponding fields of the
	 * logged-in Rodador cyclist DTO. - Calls the update method of the user DAO to
	 * persist the changes. If the logged-in user is not a Rodador cyclist: -
	 * Creates a new Rodador cyclist DTO object and sets the retrieved data along
	 * with the general user information. - Calls the update method of the user DAO
	 * with the index of the logged-in user and the new Rodador cyclist DTO to
	 * update the user information.
	 */

	public void actualizarCiclistaRodador() {

		if (mf.getUsuarioLoginDTO() instanceof RodadorDTO) {
			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double velocidadPromedioP = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedioPedaleo().getText());

			RodadorDTO ciclistaRodadorActualizado = (RodadorDTO) mf.getUsuarioLoginDTO();
			ciclistaRodadorActualizado.setIdentificador(identificador);
			ciclistaRodadorActualizado.setTiempoAcumulado(tiempoAcumulado);
			ciclistaRodadorActualizado.setContextura(contextura);
			ciclistaRodadorActualizado.setCadenciaPedaleo(cadenciaPedaleo);
			ciclistaRodadorActualizado.setAniosExperiencia(aniosExperencia);
			ciclistaRodadorActualizado.setVelocidadPromedioPedaleo(velocidadPromedioP);

			ciclistaRodadorActualizado.setNombre(nombre);
			mf.getUsuarioDAO().update();

		} else {

			UsuarioDTO rodadorActualizado = (UsuarioDTO) mf.getUsuarioLoginDTO();

			String nombre = vf.getV().getJpnActualizarCiclista().getTxtNuevoNombre().getText();
			int identificador = Integer.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoId().getText());
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoTiempoAcumulado().getText());
			String contextura = vf.getV().getJpnActualizarCiclista().getTxtNuevoContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoCadenciaPedaleo().getText());
			int aniosExperencia = Integer
					.parseInt(vf.getV().getJpnActualizarCiclista().getTxtNuevoAniosExperiencia().getText());
			double velocidadPromedioP = Double
					.parseDouble(vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedioPedaleo().getText());

			RodadorDTO nuevoRodador = new RodadorDTO();

			nuevoRodador.setCedula(rodadorActualizado.getCedula());
			nuevoRodador.setGenero(rodadorActualizado.getGenero());
			nuevoRodador.setCorreoElectronico(rodadorActualizado.getCorreoElectronico());
			nuevoRodador.setId(rodadorActualizado.getId());
			nuevoRodador.setContrasenia(rodadorActualizado.getContrasenia());
			nuevoRodador.setIdentificador(identificador);
			nuevoRodador.setTiempoAcumulado(tiempoAcumulado);
			nuevoRodador.setContextura(contextura);
			nuevoRodador.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoRodador.setAniosExperiencia(aniosExperencia);
			nuevoRodador.setVelocidadPromedioPedaleo(velocidadPromedioP);
			nuevoRodador.setNombre(nombre);

			int index = mf.getUsuarioDAO().buscarPosicion(rodadorActualizado.getId());

			mf.getUsuarioDAO().update(index, nuevoRodador);

		}
	}

	/**
	 * Updates the type of cyclist based on the selection made in the "Actualizar
	 * Ciclista" panel. If the "Clasico de Mano" option is selected: - Calls the
	 * method to update Clasico de Mano cyclist. If the "Contrarreloj" option is
	 * selected: - Calls the method to update Contrarreloj cyclist. If the
	 * "Embalador" option is selected: - Calls the method to update Embalador
	 * cyclist. If the "Escalador" option is selected: - Calls the method to update
	 * Escalador cyclist. If the "Gregario" option is selected: - Calls the method
	 * to update Gregario cyclist. If the "Rodador" option is selected: - Calls the
	 * method to update Rodador cyclist. If no specific type is selected: - Calls
	 * the generic update method.
	 */
	
	public void actualizarTipoCiclista() {// revisaaaa

		if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoClasicoMano().isSelected()) {

			actualizarCiclistaClasicoMano();
		} else {
			if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoContrarreloj().isSelected()) {
				actualizarCiclistaContraReloj();
			} else {
				if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoEmbalador().isSelected()) {
					actualizarCiclistaEmbalador();
				} else {
					if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoEscalador().isSelected()) {
						actualizarCiclistaEscalador();
					} else {
						if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoGregario().isSelected()) {
							actualizarCiclistaGregario();
						} else {
							if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoRodador().isSelected()) {
								actualizarCiclistaRodador();
							} else {
								actualizarCiclista();

							}
						}
					}
				}
			}
		}
	}

	// Crear
	// ------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Creates a new DirectorDeportivoDTO object based on the information provided
	 * in the user interface and adds it to the data access object.
	 * 
	 * This method retrieves the nationality and full name from the corresponding
	 * text fields in the user interface. It creates a new instance of
	 * DirectorDeportivoDTO and sets its common attributes (cedula, genero,
	 * correoElectronico, id, contrasenia) using the attributes of the currently
	 * logged-in user obtained from the mf.getUsuarioLoginDTO() method. Then, it
	 * sets the nationality and full name of the new DirectorDeportivoDTO object.
	 * Finally, it adds the new DirectorDeportivoDTO object to the user data access
	 * object.
	 */

	public void crearUsuarioADirector() {
		try {
			String nacionalidad = vf.getV().getJpnCrearDirector().getTxtNacionalidad().getText();
			String nombre = vf.getV().getJpnCrearDirector().getTxtNombreCompleto().getText();
			ExceptionChecker.revisarEspacioBlanco(nombre);
			ExceptionChecker.revisarNombre(nombre);
			ExceptionChecker.revisarEspacioBlanco(nacionalidad);
			ExceptionChecker.revisarNombre(nacionalidad);
			DirectorDeportivoDTO nuevoDirector = new DirectorDeportivoDTO();

			nuevoDirector.setNacionalidad(nacionalidad);
			nuevoDirector.setNombre(nombre);

			nuevoDirector.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoDirector.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoDirector.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoDirector.setId(mf.getUsuarioLoginDTO().getId());
			nuevoDirector.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());
			mf.getUsuarioDAO().update(index, nuevoDirector);
			MensajeEmergente.mostrarMensaje("El director ha sido creado");
		} catch (InvalidEmptyException e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
		}catch (InvalidNameExceptionS e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
		}
	}

	/**
	 * Creates a new ClasicoManoDTO object based on the information provided in the
	 * user interface and adds it to the data access object. If the logged-in user
	 * is a DirectorDeportivo, it checks if the user with the provided ID already
	 * exists. If not, it creates a new user with the provided information. If the
	 * logged-in user is not a DirectorDeportivo, it updates the information of the
	 * existing user with the provided information.
	 * 
	 * This method retrieves the user's personal information such as ID, email,
	 * password, and gender from the corresponding text fields and combo boxes in
	 * the user interface. It also retrieves cycling-related information such as
	 * accumulated time, cyclist ID, body build, pedaling cadence, years of
	 * experience, and number of classic wins. Then, it creates a new instance of
	 * ClasicoManoDTO and sets its attributes using the retrieved information. If
	 * the logged-in user is a DirectorDeportivo, it checks if the user with the
	 * provided ID already exists. If not, it sets the common attributes (cedula,
	 * genero, correoElectronico, id, contrasenia) and adds the new ClasicoManoDTO
	 * object to the user data access object. If the user already exists, it
	 * displays an error message. If the logged-in user is not a DirectorDeportivo,
	 * it sets the common attributes (cedula, genero, correoElectronico, id,
	 * contrasenia) of the logged-in user and updates the existing user information
	 * with the new ClasicoManoDTO object.
	 */

	public void crearUsuarioACiclistaClasicoMano() {
		long cedula = 0;
		String email = "";
		String id = "";
		String password = "";
		try {
			cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
			email = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
			id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
			password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
			String genero = "";
			if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
				genero = "Mujer";
			} else {
				genero = "Hombre";
			}

			double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
			ExceptionChecker.revisarEspacioBlanco(tiempoAcumulado+"");
			ExceptionChecker.revisarNumeroNegativo2(tiempoAcumulado);
			int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
			String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
			int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
			int numClasicosGanados = Integer
					.parseInt(vf.getV().getJpnCrearCiclista().getTxtNumClasicoGanado().getText());
			String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
			ClasicoManoDTO nuevoClasicoMano = new ClasicoManoDTO();

			nuevoClasicoMano.setIdentificador(identificador);
			nuevoClasicoMano.setTiempoAcumulado(tiempoAcumulado);
			nuevoClasicoMano.setContextura(contextura);
			nuevoClasicoMano.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoClasicoMano.setAniosExperiencia(aniosExperencia);
			nuevoClasicoMano.setNumClasicosGanados(numClasicosGanados);
			nuevoClasicoMano.setNombre(nombre);

			if (TipoUsuariologin().equals("DirectorDeportivo")) {

				UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);

				if (usuarioConsulta == null) {
					nuevoClasicoMano.setCedula(cedula);
					nuevoClasicoMano.setGenero(genero);
					nuevoClasicoMano.setCorreoElectronico(email);
					nuevoClasicoMano.setId(id);
					nuevoClasicoMano.setContrasenia(password);
					mf.getUsuarioDAO().create(nuevoClasicoMano);
					createEmail("Ciclista");
					sendEmail();
					MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
				} else {

					MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
					return;

				}

			} else {
				nuevoClasicoMano.setCedula(mf.getUsuarioLoginDTO().getCedula());
				nuevoClasicoMano.setGenero(mf.getUsuarioLoginDTO().getGenero());
				nuevoClasicoMano.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
				nuevoClasicoMano.setId(mf.getUsuarioLoginDTO().getId());
				nuevoClasicoMano.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());

				int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

				mf.getUsuarioDAO().update(index, nuevoClasicoMano);
			}
		} catch (InvalidEmptyException e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
			return;
		}catch (NegativeNumberException e1) {
			MensajeEmergente.mostrarMensaje(e1.getMessage());
			return;
		}
	}

	/**
	 * Creates a new ContraRelojDTO object based on the information provided in the
	 * user interface and adds it to the data access object. If the logged-in user
	 * is a DirectorDeportivo, it checks if the user with the provided ID already
	 * exists. If not, it creates a new user with the provided information. If the
	 * logged-in user is not a DirectorDeportivo, it updates the information of the
	 * existing user with the provided information.
	 * 
	 * This method retrieves the user's personal information such as ID, email,
	 * password, and gender from the corresponding text fields and combo boxes in
	 * the user interface. It also retrieves cycling-related information such as
	 * accumulated time, cyclist ID, body build, pedaling cadence, years of
	 * experience, maximum speed, and tasks related to time trial. Then, it creates
	 * a new instance of ContraRelojDTO and sets its attributes using the retrieved
	 * information. If the logged-in user is a DirectorDeportivo, it checks if the
	 * user with the provided ID already exists. If not, it sets the common
	 * attributes (cedula, genero, correoElectronico, id, contrasenia) and adds the
	 * new ContraRelojDTO object to the user data access object. If the user already
	 * exists, it displays an error message. If the logged-in user is not a
	 * DirectorDeportivo, it sets the common attributes (cedula, genero,
	 * correoElectronico, id, contrasenia) of the logged-in user and updates the
	 * existing user information with the new ContraRelojDTO object.
	 */

	public void crearUsuarioACiclistaContrareloj() {
		long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
		String email = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
		int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
		double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
		String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
		double cadenciaPedaleo = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
		double velocidadMaxima = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtVelocidadMaxima().getText());
		boolean tareaContrareloj = vf.getV().getJpnCrearCiclista().getRbtnTareaCConcentrarse().isSelected();
		boolean tareaContrareloj2 = vf.getV().getJpnCrearCiclista().getRbtnTareaCRegular().isSelected();
		boolean tareaContrareloj3 = vf.getV().getJpnCrearCiclista().getRbtnTareaCVisualizar().isSelected();
		ContraRelojDTO nuevoContra = new ContraRelojDTO();

		nuevoContra.setIdentificador(identificador);
		nuevoContra.setTiempoAcumulado(tiempoAcumulado);
		nuevoContra.setContextura(contextura);
		nuevoContra.setCadenciaPedaleo(cadenciaPedaleo);
		nuevoContra.setAniosExperiencia(aniosExperencia);
		nuevoContra.setVelocidadMaxima(velocidadMaxima);
		nuevoContra.setTareaContrareloj(tareaContrareloj);
		nuevoContra.setTareaContrareloj2(tareaContrareloj2);
		nuevoContra.setTareaContrareloj3(tareaContrareloj3);
		nuevoContra.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
			if (usuarioConsulta == null) {
				nuevoContra.setCedula(cedula);
				nuevoContra.setGenero(genero);
				nuevoContra.setCorreoElectronico(email);
				nuevoContra.setId(id);
				nuevoContra.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoContra);
				createEmail("Ciclista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
			} else {

				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoContra.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoContra.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoContra.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoContra.setId(mf.getUsuarioLoginDTO().getId());
			nuevoContra.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

			mf.getUsuarioDAO().update(index, nuevoContra);

		}
	}

	/**
	 * Creates a new ContraRelojDTO object based on the information provided in the
	 * user interface and adds it to the data access object. If the logged-in user
	 * is a DirectorDeportivo, it checks if the user with the provided ID already
	 * exists. If not, it creates a new user with the provided information. If the
	 * logged-in user is not a DirectorDeportivo, it updates the information of the
	 * existing user with the provided information.
	 * 
	 * This method retrieves the user's personal information such as ID, email,
	 * password, and gender from the corresponding text fields and combo boxes in
	 * the user interface. It also retrieves cycling-related information such as
	 * accumulated time, cyclist ID, body build, pedaling cadence, years of
	 * experience, maximum speed, and tasks related to time trial. Then, it creates
	 * a new instance of ContraRelojDTO and sets its attributes using the retrieved
	 * information. If the logged-in user is a DirectorDeportivo, it checks if the
	 * user with the provided ID already exists. If not, it sets the common
	 * attributes (cedula, genero, correoElectronico, id, contrasenia) and adds the
	 * new ContraRelojDTO object to the user data access object. If the user already
	 * exists, it displays an error message. If the logged-in user is not a
	 * DirectorDeportivo, it sets the common attributes (cedula, genero,
	 * correoElectronico, id, contrasenia) of the logged-in user and updates the
	 * existing user information with the new ContraRelojDTO object.
	 */
	public void crearUsuarioACiclistaEmbalador() {
		long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
		String email = vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText();
		String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
		int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
		double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
		String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
		double cadenciaPedaleo = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
		double potenciaPromedio = Double
				.parseDouble(vf.getV().getJpnCrearCiclista().getTxtPotenciaPromedio().getText());
		double velocidadPromedioE = Double
				.parseDouble(vf.getV().getJpnCrearCiclista().getTxtVelocidadPromedio().getText());
		boolean tareaEmbalador = vf.getV().getJpnCrearCiclista().getRbtnTareaEmAumentarRitmo().isSelected();
		boolean tareaEmbalador2 = vf.getV().getJpnCrearCiclista().getRbtnTareaEmAumentarRitmo().isSelected();

		EmbaladorDTO nuevoEmbalador = new EmbaladorDTO();

		nuevoEmbalador.setIdentificador(identificador);
		nuevoEmbalador.setTiempoAcumulado(tiempoAcumulado);
		nuevoEmbalador.setContextura(contextura);
		nuevoEmbalador.setCadenciaPedaleo(cadenciaPedaleo);
		nuevoEmbalador.setAniosExperiencia(aniosExperencia);
		nuevoEmbalador.setPotenciaPromedio(potenciaPromedio);
		nuevoEmbalador.setVelocidadPromedioEmbalador(velocidadPromedioE);
		nuevoEmbalador.setTareaEmbalador(tareaEmbalador);
		nuevoEmbalador.setTareaEmbalador(tareaEmbalador2);
		nuevoEmbalador.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
			if (usuarioConsulta == null) {
				nuevoEmbalador.setCedula(cedula);
				nuevoEmbalador.setGenero(genero);
				nuevoEmbalador.setCorreoElectronico(email);
				nuevoEmbalador.setId(id);
				nuevoEmbalador.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoEmbalador);
				createEmail("Ciclista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoEmbalador.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoEmbalador.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoEmbalador.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoEmbalador.setId(mf.getUsuarioLoginDTO().getId());
			nuevoEmbalador.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

			mf.getUsuarioDAO().update(index, nuevoEmbalador);
		}
	}

	/**
	 * Creates a new EmbaladorDTO object based on the information provided in the
	 * user interface and adds it to the data access object. If the logged-in user
	 * is a DirectorDeportivo, it checks if the user with the provided ID already
	 * exists. If not, it creates a new user with the provided information. If the
	 * logged-in user is not a DirectorDeportivo, it updates the information of the
	 * existing user with the provided information.
	 * 
	 * This method retrieves the user's personal information such as ID, email,
	 * password, and gender from the corresponding text fields and combo boxes in
	 * the user interface. It also retrieves cycling-related information such as
	 * accumulated time, cyclist ID, body build, pedaling cadence, years of
	 * experience, average power, average speed, and tasks related to sprinting.
	 * Then, it creates a new instance of EmbaladorDTO and sets its attributes using
	 * the retrieved information. If the logged-in user is a DirectorDeportivo, it
	 * checks if the user with the provided ID already exists. If not, it sets the
	 * common attributes (cedula, genero, correoElectronico, id, contrasenia) and
	 * adds the new EmbaladorDTO object to the user data access object. If the user
	 * already exists, it displays an error message. If the logged-in user is not a
	 * DirectorDeportivo, it sets the common attributes (cedula, genero,
	 * correoElectronico, id, contrasenia) of the logged-in user and updates the
	 * existing user information with the new EmbaladorDTO object.
	 */

	public void crearUsuarioACiclistaEscalador() {

		long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
		String email = vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText();
		String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
		int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
		double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
		String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
		double cadenciaPedaleo = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
		double aceleracionPromedio = Double
				.parseDouble(vf.getV().getJpnCrearCiclista().getTxtAceleracionPromedio().getText());
		double gradoRampaSoportada = Double
				.parseDouble(vf.getV().getJpnCrearCiclista().getTxtGradoRampaSoportada().getText());
		boolean tareaEscalador = vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearP().isSelected();
		boolean tareaEscalador2 = vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearS().isSelected();

		EscaladorDTO nuevoEscalador = new EscaladorDTO();

		nuevoEscalador.setIdentificador(identificador);
		nuevoEscalador.setTiempoAcumulado(tiempoAcumulado);
		nuevoEscalador.setContextura(contextura);
		nuevoEscalador.setCadenciaPedaleo(cadenciaPedaleo);
		nuevoEscalador.setAniosExperiencia(aniosExperencia);
		nuevoEscalador.setAceleracionPromedio(aceleracionPromedio);
		nuevoEscalador.setGradoRampaSoportada(gradoRampaSoportada);
		nuevoEscalador.setTareaEscalador(tareaEscalador);
		nuevoEscalador.setTareaEscalador(tareaEscalador2);
		nuevoEscalador.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
			if (usuarioConsulta == null) {
				nuevoEscalador.setCedula(cedula);
				nuevoEscalador.setGenero(genero);
				nuevoEscalador.setCorreoElectronico(email);
				nuevoEscalador.setId(id);
				nuevoEscalador.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoEscalador);
				createEmail("Ciclista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoEscalador.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoEscalador.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoEscalador.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoEscalador.setId(mf.getUsuarioLoginDTO().getId());
			nuevoEscalador.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());

			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

			mf.getUsuarioDAO().update(index, nuevoEscalador);
		}
	}

	/**
	 * Creates a new GregarioDTO object based on the information provided in the
	 * user interface and adds it to the data access object. If the logged-in user
	 * is a DirectorDeportivo, it checks if the user with the provided ID already
	 * exists. If not, it creates a new user with the provided information. If the
	 * logged-in user is not a DirectorDeportivo, it updates the information of the
	 * existing user with the provided information.
	 * 
	 * This method retrieves user information from the UI fields and creates a
	 * GregarioDTO object with the gathered data. If the logged-in user is a
	 * DirectorDeportivo, it checks if the user already exists before adding the new
	 * GregarioDTO object. Otherwise, it updates the existing user information.
	 */

	public void crearUsuarioACiclistaGregario() {

		long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
		String email = vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText();
		String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
		int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
		double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
		String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
		double cadenciaPedaleo = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
		boolean esAbastecedor = vf.getV().getJpnCrearCiclista().getRbtnAbastecedor().isSelected();
		boolean esMantenerRitmo = vf.getV().getJpnCrearCiclista().getRbtnMantenerRitmo().isSelected();
		boolean esCapturasFuga = vf.getV().getJpnCrearCiclista().getRbtnCapturasFuga().isSelected();
		boolean esPosicionarLider = vf.getV().getJpnCrearCiclista().getRbtnPosicionarLider().isSelected();
		boolean esProtegerLider = vf.getV().getJpnCrearCiclista().getRbtnProtegerLider().isSelected();

		GregarioDTO nuevoGregario = new GregarioDTO();

		nuevoGregario.setIdentificador(identificador);
		nuevoGregario.setTiempoAcumulado(tiempoAcumulado);
		nuevoGregario.setContextura(contextura);
		nuevoGregario.setCadenciaPedaleo(cadenciaPedaleo);
		nuevoGregario.setAniosExperiencia(aniosExperencia);
		nuevoGregario.setEsAbastecedor(esAbastecedor);
		nuevoGregario.setEsMantenerRitmo(esMantenerRitmo);
		nuevoGregario.setEsCapturasFuga(esCapturasFuga);
		nuevoGregario.setEsPosicionarLider(esPosicionarLider);
		nuevoGregario.setEsProtegerLider(esProtegerLider);
		nuevoGregario.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
			if (usuarioConsulta == null) {
				nuevoGregario.setCedula(cedula);
				nuevoGregario.setGenero(genero);
				nuevoGregario.setCorreoElectronico(email);
				nuevoGregario.setId(id);
				nuevoGregario.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoGregario);
				createEmail("Ciclista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoGregario.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoGregario.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoGregario.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoGregario.setId(mf.getUsuarioLoginDTO().getId());
			nuevoGregario.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());
			mf.getUsuarioDAO().update(index, nuevoGregario);
		}
	}

	/**
	 * Creates a new RodadorDTO object based on the information provided in the user
	 * interface and adds it to the data access object. If the logged-in user is a
	 * DirectorDeportivo, it checks if the user with the provided ID already exists.
	 * If not, it creates a new user with the provided information. If the logged-in
	 * user is not a DirectorDeportivo, it updates the information of the existing
	 * user with the provided information.
	 * 
	 * This method retrieves user information from the UI fields and creates a
	 * RodadorDTO object with the gathered data. If the logged-in user is a
	 * DirectorDeportivo, it checks if the user already exists before adding the new
	 * RodadorDTO object. Otherwise, it updates the existing user information.
	 */

	public void crearUsuarioACiclistaRodador() {

		long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
		String email = vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText();
		String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
		String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
		int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
		double tiempoAcumulado = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
		String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
		double cadenciaPedaleo = Double.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
		double velocidadPromedioP = Double
				.parseDouble(vf.getV().getJpnCrearCiclista().getTxtVelocidadPromedioPedaleo().getText());

		RodadorDTO nuevoRodador = new RodadorDTO();

		nuevoRodador.setIdentificador(identificador);
		nuevoRodador.setTiempoAcumulado(tiempoAcumulado);
		nuevoRodador.setContextura(contextura);
		nuevoRodador.setCadenciaPedaleo(cadenciaPedaleo);
		nuevoRodador.setAniosExperiencia(aniosExperencia);
		nuevoRodador.setVelocidadPromedioPedaleo(velocidadPromedioP);
		nuevoRodador.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
			if (usuarioConsulta == null) {
				nuevoRodador.setCedula(cedula);
				nuevoRodador.setGenero(genero);
				nuevoRodador.setCorreoElectronico(email);
				nuevoRodador.setId(id);
				nuevoRodador.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoRodador);
				createEmail("Ciclista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoRodador.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoRodador.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoRodador.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoRodador.setId(mf.getUsuarioLoginDTO().getId());
			nuevoRodador.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

			mf.getUsuarioDAO().update(index, nuevoRodador);
		}
	}


	/**
	 * Creates a new cyclist user.
	 * 
	 * This method retrieves user input from the cyclist creation panel, validates
	 * the input data, and updates the user information with the new cyclist
	 * details.
	 */

	public void crearUsuarioACiclista() {
		try {
			long cedula = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtCedula().getText());
			String email = vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText();
			String id = vf.getV().getJpnCrearCiclista().getTxtNombreUsuario().getText();
			String password = vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText();
			String genero = "";
			if (vf.getV().getJpnCrearCiclista().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
				genero = "Mujer";
			} else {
				genero = "Hombre";
			}
			int identificador = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtId().getText());
			ExceptionChecker.revisarNumeroNegativo(identificador);
			double tiempoAcumulado = Double
					.parseDouble(vf.getV().getJpnCrearCiclista().getTxtTiempoAcumulado().getText());
			ExceptionChecker.revisarNumeroNegativo2(tiempoAcumulado);
			String contextura = vf.getV().getJpnCrearCiclista().getTxtContextura().getText();
			ExceptionChecker.revisarNombreInvalido(contextura);
			double cadenciaPedaleo = Double
					.parseDouble(vf.getV().getJpnCrearCiclista().getTxtCadenciaPedaleo().getText());
			ExceptionChecker.revisarNumeroNegativo(identificador);
			int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearCiclista().getTxtAniosExperiencia().getText());
			ExceptionChecker.revisarNumeroNegativo(aniosExperencia);
			String nombre = vf.getV().getJpnCrearCiclista().getTxtNombre().getText();
			ExceptionChecker.revisarNombreInvalido(nombre);

			CiclistaDTO nuevoCiclista = new CiclistaDTO();
			nuevoCiclista.setIdentificador(identificador);
			nuevoCiclista.setTiempoAcumulado(tiempoAcumulado);
			nuevoCiclista.setContextura(contextura);
			nuevoCiclista.setCadenciaPedaleo(cadenciaPedaleo);
			nuevoCiclista.setAniosExperiencia(aniosExperencia);
			nuevoCiclista.setNombre(nombre);

			if (TipoUsuariologin().equals("DirectorDeportivo")) {
				UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);
				if (usuarioConsulta == null) {
					nuevoCiclista.setCedula(cedula);
					nuevoCiclista.setGenero(genero);
					nuevoCiclista.setCorreoElectronico(email);
					nuevoCiclista.setId(id);
					nuevoCiclista.setContrasenia(password);
					mf.getUsuarioDAO().create(nuevoCiclista);
					createEmail("Ciclista");
					sendEmail();
					MensajeEmergente.mostrarMensaje("Se creo el cliclista " + nombre);
				} else {
					MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
					return;
				}
			} else {

				nuevoCiclista.setCedula(cedula);
				nuevoCiclista.setGenero(mf.getUsuarioLoginDTO().getGenero());
				nuevoCiclista.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
				nuevoCiclista.setId(mf.getUsuarioLoginDTO().getId());
				nuevoCiclista.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
				int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

				mf.getUsuarioDAO().update(index, nuevoCiclista);
			}
		} catch (NumberFormatException e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
			return;
		} catch (NegativeNumberException e) {
			MensajeEmergente.mostrarMensaje(e.getMessage());
			return;
		} catch (InvalidNameException e2) {
			MensajeEmergente.mostrarMensaje(e2.getMessage());
			return;
		}
	}

	/**
	 * Creates a new masajist user.
	 * 
	 * This method retrieves user input from the cyclist creation panel, validates
	 * the input data, and updates the user information with the new cyclist
	 * details.
	 */

	public void crearUsuarioAMasajista() {
		long cedula = Long.parseLong(vf.getV().getJpnCrearMasajista().getCedula().getText());
		String email = vf.getV().getJpnCrearMasajista().getCorreoElectronico().getText();
		String id = vf.getV().getJpnCrearMasajista().getNombreUsuario().getText();
		String password = vf.getV().getJpnCrearMasajista().getContrasenia().getText();
		String genero = "";
		if (vf.getV().getJpnCrearMasajista().getGenero().getSelectedItem().toString().equals("Mujer")) {
			genero = "Mujer";
		} else {
			genero = "Hombre";
		}

		int aniosExperencia = Integer.parseInt(vf.getV().getJpnCrearMasajista().getAniosDeExperiencia().getText());
		String nombre = vf.getV().getJpnCrearMasajista().getNombre().getText();

		MasajistaDTO nuevoMasajista = new MasajistaDTO();

		nuevoMasajista.setAniosExperiencia(aniosExperencia);
		nuevoMasajista.setNombre(nombre);

		if (TipoUsuariologin().equals("DirectorDeportivo")) {
			UsuarioDTO usuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);

			if (usuarioConsulta == null) {
				nuevoMasajista.setCedula(cedula);
				nuevoMasajista.setGenero(genero);
				nuevoMasajista.setCorreoElectronico(email);
				nuevoMasajista.setId(id);
				nuevoMasajista.setContrasenia(password);
				mf.getUsuarioDAO().create(nuevoMasajista);
				createEmail("Masajista");
				sendEmail();
				MensajeEmergente.mostrarMensaje("Se creo el masajista " + nombre);
				return;
			} else {
				MensajeEmergente.mostrarMensaje("El Usuario " + usuarioConsulta.getId() + "Ya esta Creado");
				return;
			}
		} else {
			nuevoMasajista.setCedula(mf.getUsuarioLoginDTO().getCedula());
			nuevoMasajista.setGenero(mf.getUsuarioLoginDTO().getGenero());
			nuevoMasajista.setCorreoElectronico(mf.getUsuarioLoginDTO().getCorreoElectronico());
			nuevoMasajista.setId(mf.getUsuarioLoginDTO().getId());
			nuevoMasajista.setContrasenia(mf.getUsuarioLoginDTO().getContrasenia());
			int index = mf.getUsuarioDAO().buscarPosicion(mf.getUsuarioLoginDTO().getId());

			mf.getUsuarioDAO().update(index, nuevoMasajista);
			vf.getV().getJpnOpciones().limpiarPanelO();
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Updates the visibility of UI components in the panel for updating a cyclist
	 * based on the selected cyclist type.
	 * 
	 * This method checks the selected cyclist type in the update panel and adjusts
	 * the visibility of relevant UI components accordingly.
	 */

	public void tipoCiclistaActualizar() {
		if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoClasicoMano().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getLblNuevoNumClasicoGanado().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoNumClasicoGanado().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoContrarreloj().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getLblNuevoVelocidadMaxima().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadMaxima().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCConcentrarse().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCRegular().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaCVisualizar().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoEmbalador().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getLblNuevoPotenciaPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoPotenciaPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getLblNuevaVelocidadPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getLblNuevoPotenciaPromedio1().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmAumentarRitmo().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEmBajarRitmo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoEscalador().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getLblNuevoAceleracionPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getLblNuevoAceleracionPromedio1().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoAceleracionPromedio().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getLblNuevoGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearP().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoTareaEsPedalearS().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoGregario().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoAbastecedor().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoMantenerRitmo().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoCapturasFuga().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoPosicionarLider().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getRbtnNuevoProtegerLider().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoRodador().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
			vf.getV().getJpnActualizarCiclista().getLblNuevoVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getLblNuevoVelocidadPromedioPedaleo1().setVisible(true);
			vf.getV().getJpnActualizarCiclista().getTxtNuevoVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnActualizarCiclista().getRbtnNuevoVacio().isSelected()) {
			vf.getV().getJpnActualizarCiclista().limpiarPanelActualizarCiclista();
		}
	}

	/**
	 * Updates the visibility of UI components in the panel for creating a cyclist
	 * based on the selected cyclist type.
	 * 
	 * This method checks the selected cyclist type in the create panel and adjusts
	 * the visibility of relevant UI components accordingly.
	 */

	public void tipoCiclistaCrear() {
		if (vf.getV().getJpnCrearCiclista().getRbtnClasicoMano().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getLblNumClasicoGanado().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtNumClasicoGanado().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnContrarreloj().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getLblVelocidadMaxima().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtVelocidadMaxima().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaCConcentrarse().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaCRegular().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaCVisualizar().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnEmbalador().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getLblPotenciaPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtPotenciaPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getLblVelocidadPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtVelocidadPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getLblPotenciaPromedio1().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaEmAumentarRitmo().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaEmBajarRitmo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnEscalador().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getLblAceleracionPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getLblAceleracionPromedio1().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtAceleracionPromedio().setVisible(true);
			vf.getV().getJpnCrearCiclista().getLblGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtGradoRampaSoportada().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearP().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnTareaEsPedalearS().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnGregario().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getRbtnAbastecedor().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnMantenerRitmo().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnCapturasFuga().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnPosicionarLider().setVisible(true);
			vf.getV().getJpnCrearCiclista().getRbtnProtegerLider().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnRodador().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
			vf.getV().getJpnCrearCiclista().getLblVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().getJpnCrearCiclista().getLblVelocidadPromedioPedaleo1().setVisible(true);
			vf.getV().getJpnCrearCiclista().getTxtVelocidadPromedioPedaleo().setVisible(true);
			vf.getV().repaint();

		} else if (vf.getV().getJpnCrearCiclista().getRbtnVacio().isSelected()) {
			vf.getV().getJpnCrearCiclista().limpiarPanelCrearCiclista();
		}
	}

	/**
	 * Creates a cyclist based on the selected cyclist type.
	 * 
	 * This method checks the selected cyclist type in the create panel and calls
	 * the corresponding method to create a cyclist.
	 * 
	 * @see crearUsuarioACiclistaClasicoMano
	 * @see crearUsuarioACiclistaContrareloj
	 * @see crearUsuarioACiclistaEmbalador
	 * @see crearUsuarioACiclistaEscalador
	 * @see crearUsuarioACiclistaGregario
	 * @see crearUsuarioACiclistaRodador
	 * @see crearUsuarioACiclista
	 */
	public void crearTipoCiclista() {

		if (vf.getV().getJpnCrearCiclista().getRbtnClasicoMano().isSelected()) {
			crearUsuarioACiclistaClasicoMano();
		} else {
			if (vf.getV().getJpnCrearCiclista().getRbtnContrarreloj().isSelected()) {
				crearUsuarioACiclistaContrareloj();
			} else {
				if (vf.getV().getJpnCrearCiclista().getRbtnEmbalador().isSelected()) {
					crearUsuarioACiclistaEmbalador();
				} else {
					if (vf.getV().getJpnCrearCiclista().getRbtnEscalador().isSelected()) {
						crearUsuarioACiclistaEscalador();
					} else {
						if (vf.getV().getJpnCrearCiclista().getRbtnGregario().isSelected()) {
							crearUsuarioACiclistaGregario();
						} else {
							if (vf.getV().getJpnCrearCiclista().getRbtnRodador().isSelected()) {
								crearUsuarioACiclistaRodador();
							} else {
								crearUsuarioACiclista();

							}
						}
					}
				}
			}
		}
	}

	/**
	 * Registers a new administrator user.
	 * 
	 * This method retrieves user input from the registration panel, validates the
	 * input data, and creates a new administrator user if the provided username is
	 * unique.
	 * 
	 * @return An integer indicating the result of the registration process: - 1 if
	 *         the administrator user was successfully created. - 0 if there was an
	 *         error during the registration process (e.g., invalid input data).
	 */


	public int registrarTipoAdmin() {
		int creacion = -1;
		try {

			long cc = Long.parseLong(vf.getV().getJpnRegister().getTxtCedula().getText());
			String genero = "";
			if (vf.getV().getJpnRegister().getBoxGenero().getSelectedItem().toString().equals("Mujer")) {
				genero = "Mujer";
			} else {
				genero = "Hombre";
			}

			String correo = vf.getV().getJpnRegister().getTxtCorreoElectronico().getText();
			ExceptionChecker.checkEmail(correo);
			String id = vf.getV().getJpnRegister().getTxtId().getText();
			ExceptionChecker.revisarNombreInvalido(id);
			String contrasenia = vf.getV().getJpnRegister().getTxtContrasenia().getText();
			UsuarioDTO nuevoUsuario = new UsuarioDTO();
			UsuarioDTO UsuarioConsulta;

			UsuarioConsulta = mf.getUsuarioDAO().getUsuarios(id);

			if (UsuarioConsulta == null) {
				nuevoUsuario.setCedula(cc);
				nuevoUsuario.setGenero(genero);
				nuevoUsuario.setCorreoElectronico(correo);
				nuevoUsuario.setId(id);
				nuevoUsuario.setContrasenia(contrasenia);
				mf.getUsuarioDAO().create(nuevoUsuario);
				creacion = 1;
			} else
				MensajeEmergente.mostrarMensaje("El Usuario " + UsuarioConsulta.getId() + "Ya esta Creado");

		} catch (NumberFormatException e) {
			MensajeEmergente.mostrarMensaje("La cedula no puede tener valores númericos , tiene letras o está vacío. ");
			return 0;
		} catch (CheckMail e2) {
			MensajeEmergente.mostrarMensaje(e2.getMessage());
			return 0;
		} catch (InvalidNameException e3) {
			MensajeEmergente.mostrarMensaje(e3.getMessage());
		}
		return creacion;

	}

	/**
	 * Retrieves the type of the logged-in user.
	 * 
	 * This method checks the type of the logged-in user based on the instance of
	 * the UsuarioDTO. It returns a string representing the type of user.
	 * 
	 * @return A string representing the type of the logged-in user: -
	 *         "DirectorDeportivo" for DirectorDeportivoDTO instances. - "Ciclista"
	 *         for CiclistaDTO instances. - "Masajista" for MasajistaDTO instances.
	 *         - "Administrativo" for other types of UsuarioDTO instances.
	 */

	
	public String TipoUsuariologin() {

		String tipoUser = "";

		UsuarioDTO userlogin = (UsuarioDTO) mf.getUsuarioLoginDTO();

		if (userlogin instanceof DirectorDeportivoDTO) {
			tipoUser = "DirectorDeportivo";
		} else if (userlogin instanceof CiclistaDTO) {
			tipoUser = "Ciclista";
		} else if (userlogin instanceof MasajistaDTO) {
			tipoUser = "Masajista";
		} else if (userlogin instanceof UsuarioDTO) {
			tipoUser = "Administrativo";
		}

		return tipoUser;
	}

	
	/**
	 * Clears all the lists of cyclists and masseurs in the panel for creating a
	 * squad.
	 * 
	 * This method removes all items from the lists of cyclists and masseurs in the
	 * panel used for creating a squad.
	 */

	public void limpiarListas() {
		vf.getV().getJpnCrearEscuadra().getCiclistaClasicoManos().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getCiclistaContraReloj().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getCiclistaEmbalador().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getCiclistaEscalador().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getCiclistaGregario().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getCiclistaRodador().removeAllItems();
		vf.getV().getJpnCrearEscuadra().getMasajista().removeAllItems();

	}

	/**
	 * Gets the type of the user based on the instance of the user DTO provided.
	 * 
	 * This method determines the type of the user based on its instance and returns
	 * a string representing the user type.
	 * 
	 * @param user The user DTO whose type is to be determined.
	 * @return A string representing the type of the user.
	 */

	public String getTipoUsuario(UsuarioDTO user) {

		String tipoUsuario = "";

		if (user instanceof UsuarioDTO)
			tipoUsuario = "Administrativo : ";
		if (user instanceof DirectorDeportivoDTO)
			tipoUsuario = "Director : ";
		if (user instanceof MasajistaDTO)
			tipoUsuario = "Masajista : ";
		if (user instanceof CiclistaDTO)
			tipoUsuario = "Ciclista : ";
		if (user instanceof ClasicoManoDTO)
			tipoUsuario = "C. ClasicoMano : ";
		if (user instanceof ContraRelojDTO)
			tipoUsuario = "C. ContraReloj : ";
		if (user instanceof EmbaladorDTO)
			tipoUsuario = "C. Embalador : ";
		if (user instanceof EscaladorDTO)
			tipoUsuario = "C. Escalador : ";
		if (user instanceof GregarioDTO)
			tipoUsuario = "C. Gregario : ";
		else if (user instanceof RodadorDTO)
			tipoUsuario = "C. Rodador : ";

		return tipoUsuario;
	}

	// ordenamiento y simulacion montaña

	// ordenamiento y simulacion montaña
		/**
		 * Simulates a mountain race for cyclists. Initializes time array, creates
		 * threads for each cyclist, and updates their progress until race completion.
		 */

	private void carreraBotonInicioMontania() {
		vf.getV().getJpnSimuladorMontania().setTiempo(new long[vf.getV().getJpnSimuladorMontania().getnCiclista()]);

		for (int i = 0; i < vf.getV().getJpnSimuladorMontania().getnCiclista(); i++) {
			final int cyclistIndex = i;
			String nombreCiclista = vf.getV().getJpnSimuladorMontania().getLblCiclistas()[cyclistIndex].getText();

			vf.getV().getJpnSimuladorMontania().getCiclistas()[cyclistIndex] = new CiclistaDTO(nombreCiclista, 0, 0, 0,
					0);

			vf.getV().getJpnSimuladorMontania()
					.setThreadCiclista(new Thread[vf.getV().getJpnSimuladorMontania().getnCiclista()]);
			vf.getV().getJpnSimuladorMontania().getThreadCiclista()[i] = new Thread(() -> {
				long startTime = System.currentTimeMillis();

				while (vf.getV().getJpnSimuladorMontania().getProgresoBarra()[cyclistIndex].getValue() < vf.getV()
						.getJpnSimuladorMontania().getDistanciaSimulacion()) {
					try {
						Thread.sleep((int) (Math.random() * 500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vf.getV().getJpnSimuladorMontania().getProgresoBarra()[cyclistIndex].setValue(
							vf.getV().getJpnSimuladorMontania().getProgresoBarra()[cyclistIndex].getValue() + 1);
				}
				// vf.getV().getJpnSimuladorMontania().setProgresoBarra(new
				// JProgressBar[vf.getV().getJpnSimuladorMontania().getnCiclista()]);

				long endTime = System.currentTimeMillis();
				vf.getV().getJpnSimuladorMontania().getTiempo()[cyclistIndex] = endTime - startTime;
				vf.getV().getJpnSimuladorMontania().getCiclistas()[cyclistIndex]
						.setTiempoAcumulado(vf.getV().getJpnSimuladorMontania().getTiempo()[cyclistIndex] / 1000.0);
				if (carreraFinalizadaMontania()) {
					mostrarTiempoMontania();
				}
			});
			vf.getV().getJpnSimuladorMontania().getThreadCiclista()[i].start();
		}

	}

	/**
	 * Checks if the mountain race simulation has been completed for all cyclists.
	 * 
	 * @return true if all cyclists have reached or surpassed the race distance,
	 *         false otherwise.
	 */

	private boolean carreraFinalizadaMontania() {

		for (int i = 0; i < vf.getV().getJpnSimuladorMontania().getnCiclista(); i++) {
			if (vf.getV().getJpnSimuladorMontania().getProgresoBarra()[i].getValue() < vf.getV()
					.getJpnSimuladorMontania().getDistanciaSimulacion()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Displays the race completion time for each cyclist in the mountain race
	 * simulation.
	 */

	private void mostrarTiempoMontania() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vf.getV().getJpnSimuladorMontania().getnCiclista(); i++) {
			double tiempoEnSegundos = vf.getV().getJpnSimuladorMontania().getTiempo()[i] / 1000.0;
			sb.append(vf.getV().getJpnSimuladorMontania().getLblCiclistas()[i].getText()).append(": ")
					.append(tiempoEnSegundos).append(" s\n");
		}
		vf.getV().getJpnSimuladorMontania().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Sorts the cyclists in the mountain race simulation based on their accumulated
	 * time and displays the sorted list.
	 */

	private void ordenarMontania() {
		Arrays.sort(vf.getV().getJpnSimuladorMontania().getCiclistas(), new CiclistaTiempoAcumuladoComparator());
		StringBuilder sb = new StringBuilder();
		for (CiclistaDTO ciclista : vf.getV().getJpnSimuladorMontania().getCiclistas()) {
			sb.append(ciclista.getNombre()).append(": ").append(ciclista.getTiempoAcumulado()).append(" s\n");
		}
		vf.getV().getJpnSimuladorMontania().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Initiates the simulation of a cycling race on flat terrain. This method sets
	 * up the necessary data structures, starts the simulation threads for each
	 * cyclist, and monitors the progress of the race until completion.
	 */

	private void carreraBotonInicioLlano() {
		vf.getV().getJpnSimuladorLlano().settiempo(new long[vf.getV().getJpnSimuladorLlano().getnCiclista()]);

		for (int i = 0; i < vf.getV().getJpnSimuladorLlano().getnCiclista(); i++) {
			final int cyclistIndex = i;
			String nombreCiclista = vf.getV().getJpnSimuladorLlano().getLblCiclistas()[cyclistIndex].getText();

			vf.getV().getJpnSimuladorLlano().getciclistas()[cyclistIndex] = new CiclistaDTO(nombreCiclista, 0, 0, 0, 0);

			vf.getV().getJpnSimuladorLlano()
					.setthreadCiclista(new Thread[vf.getV().getJpnSimuladorLlano().getnCiclista()]);
			vf.getV().getJpnSimuladorLlano().getthreadCiclista()[i] = new Thread(() -> {
				long startTime = System.currentTimeMillis();

				while (vf.getV().getJpnSimuladorLlano().getProgresoBarra()[cyclistIndex].getValue() < vf.getV()
						.getJpnSimuladorLlano().getdistanciaSimulacion()) {
					try {
						Thread.sleep((int) (Math.random() * 500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vf.getV().getJpnSimuladorLlano().getProgresoBarra()[cyclistIndex]
							.setValue(vf.getV().getJpnSimuladorLlano().getProgresoBarra()[cyclistIndex].getValue() + 1);
				}
				// vf.getV().getJpnSimuladorMontania().setProgresoBarra(new
				// JProgressBar[vf.getV().getJpnSimuladorMontania().getnCiclista()]);

				long endTime = System.currentTimeMillis();
				vf.getV().getJpnSimuladorLlano().gettiempo()[cyclistIndex] = endTime - startTime;
				vf.getV().getJpnSimuladorLlano().getciclistas()[cyclistIndex]
						.setTiempoAcumulado(vf.getV().getJpnSimuladorLlano().gettiempo()[cyclistIndex] / 1000.0);
				if (carreraFinalizadaLlano()) {
					mostrarTiempoLlano();
				}
			});
			vf.getV().getJpnSimuladorLlano().getthreadCiclista()[i].start();
		}

	}

	/**
	 * Checks whether the race on flat terrain has been completed by all cyclists.
	 *
	 * @return true if all cyclists have reached or surpassed the finish line, false
	 *         otherwise.
	 */

	private boolean carreraFinalizadaLlano() {

		for (int i = 0; i < vf.getV().getJpnSimuladorLlano().getnCiclista(); i++) {
			if (vf.getV().getJpnSimuladorLlano().getProgresoBarra()[i].getValue() < vf.getV().getJpnSimuladorLlano()
					.getdistanciaSimulacion()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Displays the flat terrain cycling times in seconds for each cyclist.
	 * <p>
	 * This method iterates over the list of cyclists in the flat terrain simulator,
	 * calculates their times in seconds (by converting milliseconds to seconds),
	 * and appends this information to a StringBuilder. The resulting string is then
	 * set as the text of a text area in the flat terrain simulator panel.
	 * </p>
	 */

	private void mostrarTiempoLlano() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vf.getV().getJpnSimuladorLlano().getnCiclista(); i++) {
			double tiempoEnSegundos = vf.getV().getJpnSimuladorLlano().gettiempo()[i] / 1000.0;
			sb.append(vf.getV().getJpnSimuladorLlano().getLblCiclistas()[i].getText()).append(": ")
					.append(tiempoEnSegundos).append(" s\n");
		}
		vf.getV().getJpnSimuladorLlano().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Sorts the flat terrain cyclists by their accumulated time and displays the
	 * sorted times.
	 *
	 * <p>
	 * This method first sorts the list of cyclists in the flat terrain simulator by
	 * their accumulated time using the BubbleSort algorithm. After sorting, it
	 * iterates over the sorted list of cyclists and appends each cyclist's name and
	 * accumulated time to a StringBuilder.
	 * </p>
	 *
	 * <p>
	 * The resulting string, which contains the sorted times for all cyclists, is
	 * then set as the text of a text area in the flat terrain simulator panel.
	 * </p>
	 */

	private void ordenarLlano() {
		BubbleSort.bubbleSortOrdenarTiempos(vf.getV().getJpnSimuladorLlano().getciclistas());
		StringBuilder sb = new StringBuilder();
		for (CiclistaDTO ciclista : vf.getV().getJpnSimuladorLlano().getciclistas()) {
			sb.append(ciclista.getNombre()).append(": ").append(ciclista.getTiempoAcumulado()).append(" s\n");
		}
		vf.getV().getJpnSimuladorLlano().getTxtAreatiempo().setText(sb.toString());
	}

	
	/**
	 * <p>
	 * This method initializes the race by setting up the necessary data structures
	 * for tracking the time and progress of each cyclist. It creates and starts a
	 * thread for each cyclist, simulating their progress in the race. Each
	 * cyclist's progress is updated randomly at intervals, and their total time is
	 * recorded once they finish the race. When all cyclists have finished, the
	 * times are displayed.
	 * </p>
	 *
	 * <p>
	 * Specifically, this method:
	 * <ul>
	 * <li>Initializes the time tracking array for the cyclists.</li>
	 * <li>Sets up the cyclist objects with initial values.</li>
	 * <li>Creates and starts a thread for each cyclist to simulate the race
	 * progress.</li>
	 * <li>Updates the progress bar for each cyclist at random intervals.</li>
	 * <li>Records the total time for each cyclist once they finish the race.</li>
	 * <li>Checks if all cyclists have finished and, if so, displays the race
	 * times.</li>
	 * </ul>
	 * </p>
	 */

	private void carreraBotonInicioSemiLlano() {
		vf.getV().getJpnSimuladorSemiLlano().settiempo(new long[vf.getV().getJpnSimuladorSemiLlano().getnCiclista()]);

		for (int i = 0; i < vf.getV().getJpnSimuladorSemiLlano().getnCiclista(); i++) {
			final int cyclistIndex = i;
			String nombreCiclista = vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[cyclistIndex].getText();
			vf.getV().getJpnSimuladorSemiLlano().getciclistas()[cyclistIndex] = new CiclistaDTO(nombreCiclista, 0, 0, 0,
					0);

			vf.getV().getJpnSimuladorSemiLlano()
					.setthreadCiclista(new Thread[vf.getV().getJpnSimuladorSemiLlano().getnCiclista()]);
			vf.getV().getJpnSimuladorSemiLlano().getthreadCiclista()[i] = new Thread(() -> {
				long startTime = System.currentTimeMillis();

				while (vf.getV().getJpnSimuladorSemiLlano().getProgresoBarra()[cyclistIndex].getValue() < vf.getV()
						.getJpnSimuladorSemiLlano().getdistanciaSimulacion()) {
					try {
						Thread.sleep((int) (Math.random() * 500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vf.getV().getJpnSimuladorSemiLlano().getProgresoBarra()[cyclistIndex].setValue(
							vf.getV().getJpnSimuladorSemiLlano().getProgresoBarra()[cyclistIndex].getValue() + 1);
				}
				// vf.getV().getJpnSimuladorMontania().setProgresoBarra(new
				// JProgressBar[vf.getV().getJpnSimuladorMontania().getnCiclista()]);

				long endTime = System.currentTimeMillis();
				vf.getV().getJpnSimuladorSemiLlano().gettiempo()[cyclistIndex] = endTime - startTime;
				vf.getV().getJpnSimuladorSemiLlano().getciclistas()[cyclistIndex]
						.setTiempoAcumulado(vf.getV().getJpnSimuladorSemiLlano().gettiempo()[cyclistIndex] / 1000.0);
				if (carreraFinalizadaSemiLlano()) {
					mostrarTiempoSemiLlano();
				}
			});
			vf.getV().getJpnSimuladorSemiLlano().getthreadCiclista()[i].start();
		}

	}

	/**
	 * Checks if all cyclists have finished the semi-flat terrain race.
	 *
	 * <p>
	 * This method iterates through the progress bars of all cyclists in the
	 * semi-flat terrain simulator. It checks if any cyclist has not yet reached the
	 * target distance. If at least one cyclist has not finished, the method returns
	 * {@code false}. If all cyclists have finished, the method returns
	 * {@code true}.
	 * </p>
	 *
	 * @return {@code true} if all cyclists have finished the race, {@code false}
	 *         otherwise
	 */
	
	private boolean carreraFinalizadaSemiLlano() {
		for (int i = 0; i < vf.getV().getJpnSimuladorSemiLlano().getnCiclista(); i++) {
			if (vf.getV().getJpnSimuladorSemiLlano().getProgresoBarra()[i].getValue() < vf.getV()
					.getJpnSimuladorSemiLlano().getdistanciaSimulacion()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Displays the semi-flat terrain cycling times in seconds for each cyclist.
	 *
	 * <p>
	 * This method iterates over the list of cyclists in the semi-flat terrain
	 * simulator, calculates their times in seconds (by converting milliseconds to
	 * seconds), and appends this information to a StringBuilder. The resulting
	 * string is then set as the text of a text area in the semi-flat terrain
	 * simulator panel.
	 * </p>
	 */

	private void mostrarTiempoSemiLlano() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vf.getV().getJpnSimuladorSemiLlano().getnCiclista(); i++) {
			double tiempoEnSegundos = vf.getV().getJpnSimuladorSemiLlano().gettiempo()[i] / 1000.0;
			sb.append(vf.getV().getJpnSimuladorSemiLlano().getLblCiclistas()[i].getText()).append(": ")
					.append(tiempoEnSegundos).append(" s\n");
		}
		vf.getV().getJpnSimuladorSemiLlano().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Sorts the semi-flat terrain cyclists by their accumulated time and displays
	 * the sorted times.
	 *
	 * <p>
	 * This method first sorts the list of cyclists in the semi-flat terrain
	 * simulator by their accumulated time using the BubbleSort algorithm. After
	 * sorting, it iterates over the sorted list of cyclists and appends each
	 * cyclist's name and accumulated time to a StringBuilder.
	 * </p>
	 *
	 * <p>
	 * The resulting string, which contains the sorted times for all cyclists, is
	 * then set as the text of a text area in the semi-flat terrain simulator panel.
	 * </p>
	 */
	
	private void ordenarSemiLlano() {
		BubbleSort.bubbleSortOrdenarTiempos(vf.getV().getJpnSimuladorSemiLlano().getciclistas());
		StringBuilder sb = new StringBuilder();
		for (CiclistaDTO ciclista : vf.getV().getJpnSimuladorSemiLlano().getciclistas()) {
			sb.append(ciclista.getNombre()).append(": ").append(ciclista.getTiempoAcumulado()).append(" s\n");
		}
		vf.getV().getJpnSimuladorSemiLlano().getTxtAreatiempo().setText(sb.toString());
	}


	// ordenamiento y simulacion semiLLano
		/**
		 * Starts the flat terrain race simulation for all cyclists.
		 *
		 * <p>
		 * This method initializes the race by setting up the necessary data structures
		 * for tracking the time and progress of each cyclist. It creates and starts a
		 * thread for each cyclist, simulating their progress in the race. Each
		 * cyclist's progress is updated randomly at intervals, and their total time is
		 * recorded once they finish the race. When all cyclists have finished, the
		 * times are displayed.
		 * </p>
		 *
		 * <p>
		 * Specifically, this method:
		 * <ul>
		 * <li>Initializes the time tracking array for the cyclists.</li>
		 * <li>Sets up the cyclist objects with initial values.</li>
		 * <li>Creates and starts a thread for each cyclist to simulate the race
		 * progress.</li>
		 * <li>Updates the progress bar for each cyclist at random intervals.</li>
		 * <li>Records the total time for each cyclist once they finish the race.</li>
		 * <li>Checks if all cyclists have finished and, if so, displays the race
		 * times.</li>
		 * </ul>
		 * </p>
		 */
	
	private void carreraBotonInicioPlano() {
		vf.getV().getJpnSimuladorPlano().settiempo(new long[vf.getV().getJpnSimuladorPlano().getnCiclista()]);

		for (int i = 0; i < vf.getV().getJpnSimuladorPlano().getnCiclista(); i++) {
			final int cyclistIndex = i;
			String nombreCiclista = vf.getV().getJpnSimuladorPlano().getLblCiclistas()[cyclistIndex].getText();
			vf.getV().getJpnSimuladorPlano().getciclistas()[cyclistIndex] = new CiclistaDTO(nombreCiclista, 0, 0, 0, 0);

			vf.getV().getJpnSimuladorPlano()
					.setthreadCiclista(new Thread[vf.getV().getJpnSimuladorPlano().getnCiclista()]);
			vf.getV().getJpnSimuladorPlano().getthreadCiclista()[i] = new Thread(() -> {
				long startTime = System.currentTimeMillis();

				while (vf.getV().getJpnSimuladorPlano().getProgresoBarra()[cyclistIndex].getValue() < vf.getV()
						.getJpnSimuladorPlano().getdistanciaSimulacion()) {
					try {
						Thread.sleep((int) (Math.random() * 500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vf.getV().getJpnSimuladorPlano().getProgresoBarra()[cyclistIndex]
							.setValue(vf.getV().getJpnSimuladorPlano().getProgresoBarra()[cyclistIndex].getValue() + 1);
				}
				// vf.getV().getJpnSimuladorMontania().setProgresoBarra(new
				// JProgressBar[vf.getV().getJpnSimuladorMontania().getnCiclista()]);

				long endTime = System.currentTimeMillis();
				vf.getV().getJpnSimuladorPlano().gettiempo()[cyclistIndex] = endTime - startTime;
				vf.getV().getJpnSimuladorPlano().getciclistas()[cyclistIndex]
						.setTiempoAcumulado(vf.getV().getJpnSimuladorPlano().gettiempo()[cyclistIndex] / 1000.0);
				if (carreraFinalizadaPlano()) {
					mostrarTiempoPlano();
				}
			});
			vf.getV().getJpnSimuladorPlano().getthreadCiclista()[i].start();
		}

	}

	/**
	 * Checks if all cyclists have finished the flat terrain race.
	 *
	 * <p>
	 * This method iterates through the progress bars of all cyclists in the flat
	 * terrain simulator. It checks if any cyclist has not yet reached the target
	 * distance. If at least one cyclist has not finished, the method returns
	 * {@code false}. If all cyclists have finished, the method returns
	 * {@code true}.
	 * </p>
	 *
	 * @return {@code true} if all cyclists have finished the race, {@code false}
	 *         otherwise
	 */

	private boolean carreraFinalizadaPlano() {
		for (int i = 0; i < vf.getV().getJpnSimuladorPlano().getnCiclista(); i++) {
			if (vf.getV().getJpnSimuladorPlano().getProgresoBarra()[i].getValue() < vf.getV().getJpnSimuladorPlano()
					.getdistanciaSimulacion()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Displays the flat terrain cycling times in seconds for each cyclist.
	 *
	 * <p>
	 * This method iterates over the list of cyclists in the flat terrain simulator,
	 * calculates their times in seconds (by converting milliseconds to seconds),
	 * and appends this information to a StringBuilder. The resulting string is then
	 * set as the text of a text area in the flat terrain simulator panel.
	 * </p>
	 */

	private void mostrarTiempoPlano() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vf.getV().getJpnSimuladorPlano().getnCiclista(); i++) {
			double tiempoEnSegundos = vf.getV().getJpnSimuladorPlano().gettiempo()[i] / 1000.0;
			sb.append(vf.getV().getJpnSimuladorPlano().getLblCiclistas()[i].getText()).append(": ")
					.append(tiempoEnSegundos).append(" s\n");
		}
		vf.getV().getJpnSimuladorPlano().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Sorts the flat terrain cyclists by their accumulated time and displays the
	 * sorted times.
	 *
	 * <p>
	 * This method sorts the list of cyclists in the flat terrain simulator by their
	 * accumulated time using a custom comparator
	 * {@link CiclistaTiempoAcumuladoComparator}. After sorting, it iterates over
	 * the sorted list of cyclists and appends each cyclist's name and accumulated
	 * time to a StringBuilder.
	 * </p>
	 *
	 * <p>
	 * The resulting string, which contains the sorted times for all cyclists, is
	 * then set as the text of a text area in the flat terrain simulator panel.
	 * </p>
	 */

	private void ordenarPlano() {
		Arrays.sort(vf.getV().getJpnSimuladorPlano().getciclistas(), new CiclistaTiempoAcumuladoComparator());
		StringBuilder sb = new StringBuilder();
		for (CiclistaDTO ciclista : vf.getV().getJpnSimuladorPlano().getciclistas()) {
			sb.append(ciclista.getNombre()).append(": ").append(ciclista.getTiempoAcumulado()).append(" s\n");
		}
		vf.getV().getJpnSimuladorPlano().getTxtAreatiempo().setText(sb.toString());
	}

	/**
	 * Switches the visibility of simulation panels based on the selected map type.
	 *
	 * <p>
	 * This method hides the panel for choosing the map and shows the simulation
	 * panel corresponding to the selected map type from the drop-down list. The
	 * possible map types are "semillano", "montaña", "plano", and "llano".
	 * Depending on the selected map type, the corresponding simulation panel is
	 * made visible.
	 * </p>
	 *
	 * <p>
	 * If the selected map type does not match any of the predefined types, no
	 * action is taken.
	 * </p>
	 */

	public void irSimulacion() {

		vf.getV().getJpnElegirMapa().setVisible(false);
		if (vf.getV().getJpnElegirMapa().getMapa().getSelectedItem().toString().matches("semillano")) {
			vf.getV().getJpnSimuladorSemiLlano().setVisible(true);
		} else if (vf.getV().getJpnElegirMapa().getMapa().getSelectedItem().toString().matches("montaña")) {
			vf.getV().getJpnSimuladorMontania().setVisible(true);
		} else if (vf.getV().getJpnElegirMapa().getMapa().getSelectedItem().toString().matches("plano")) {
			vf.getV().getJpnSimuladorPlano().setVisible(true);
		} else if (vf.getV().getJpnElegirMapa().getMapa().getSelectedItem().toString().matches("llano")) {
			vf.getV().getJpnSimuladorLlano().setVisible(true);
		}

	}

//-----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Assigns action listeners to GUI components and sets action commands for each
	 * component.
	 */

	public void asignarOyentes() {

		vf.getV().getJpnPortada().getBtnEntrar().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion1().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion1().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion2().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion2().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion3().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion3().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion4().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion5().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion5().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion6().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion6().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion7().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion7().setVisible(false);
		vf.getV().getJpnOpciones().getBtnOpcion8().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnOpcion8().setVisible(false);
		vf.getV().getJpnMenuUsuarios().getBtnCiclista().addActionListener(this);
		vf.getV().getJpnMenuUsuarios().getBtnDirector().addActionListener(this);
		vf.getV().getJpnMenuUsuarios().getBtnMasajista().addActionListener(this);
		vf.getV().getJpnIngreso().getBtnRegistrarse().addActionListener(this);
		vf.getV().getJpnRegister().getBtnEnviar().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getBtnEnviar().addActionListener(this);
		vf.getV().getJpnIngreso().getBtnContinuar().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnClasicoMano().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnContrarreloj().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnEmbalador().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnEscalador().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnGregario().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnRodador().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getRbtnVacio().addActionListener(this);
		vf.getV().getJpnCrearCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnActualizar().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnCrear().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnMostrar().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnActualizar().setVisible(false);
		vf.getV().getJpnMenuCiclista().getBtnEliminar().setVisible(false);
		vf.getV().getJpnMenuCiclista().getBtnCrear().setVisible(false);
		vf.getV().getJpnCrearCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnActualizar().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnCrear().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnMostrar().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuMasajista().getBtnCrear().setVisible(false);
		vf.getV().getJpnMenuMasajista().getBtnActualizar().setVisible(false);
		vf.getV().getJpnMenuMasajista().getBtnMostrar().setVisible(false);
		vf.getV().getJpnMenuMasajista().getBtnEliminar().setVisible(false);
		vf.getV().getJpnPanelPerfilMasajista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnCrearMasajista().getBtnRegistrarse().addActionListener(this);
		vf.getV().getJpnCrearMasajista().getBtnvolver().addActionListener(this);
		vf.getV().getJpnActualizarMasajista().getBtnActualizar().addActionListener(this);
		vf.getV().getJpnActualizarMasajista().getBtnvolver().addActionListener(this);
		vf.getV().getJpnEliminarMasajista().getBtneliminar().addActionListener(this);
		vf.getV().getJpnEliminarMasajista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnCrear().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnActualizar().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnMostrar().addActionListener(this);
		vf.getV().getJpnCrearDirector().getBtnRegistrar().addActionListener(this);
		vf.getV().getJpnCrearDirector().getBtnVolver().addActionListener(this);
		vf.getV().getJpnActualizarDirector().getBtnRegistrar().addActionListener(this);
		vf.getV().getJpnActualizarDirector().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuDirector().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnMenuUsuarios().getBtnVolver().addActionListener(this);
		vf.getV().getJpnEliminarDirector().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMostrarDirector().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuEscuadra().getBtnActualizar().addActionListener(this);
		vf.getV().getJpnMenuEscuadra().getBtnCrear().addActionListener(this);
		vf.getV().getJpnMenuEscuadra().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnMenuEscuadra().getBtnMostrar().addActionListener(this);
		vf.getV().getJpnCrearEscuadra().getBtnRegistrar().addActionListener(this);
		vf.getV().getJpnCrearEscuadra().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMostrarMasajista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnRegister().getBtnVolver().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoClasicoMano().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoContrarreloj().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoEmbalador().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoEscalador().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoGregario().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoRodador().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoVacio().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnActualizarCiclista().getBtnEnviar().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().addActionListener(this);
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().addActionListener(this);
		vf.getV().getJpnElegirMapa().getBtnSeleccionarMapa().addActionListener(this);
		vf.getV().getJpnElegirMapa().getBtnVolver().addActionListener(this);
		vf.getV().getJpnEliminarUsuario().getBtnEliminar().addActionListener(this);
		vf.getV().getJpnEliminarUsuario().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMenuEscuadra().getBtnVolver().addActionListener(this);
		vf.getV().getJpnMostrarEscuadra().getBtnBuscar().addActionListener(this);
		vf.getV().getJpnMostrarEscuadra().getBtnVolver().addActionListener(this);
		vf.getV().getJpnAgregarAEscuadra().getBtnAgregar().addActionListener(this);
		vf.getV().getJpnAgregarAEscuadra().getBtnBuscar().addActionListener(this);
		vf.getV().getJpnAgregarAEscuadra().getBtnVolver().addActionListener(this);
		vf.getV().getJpnSimuladorSemiLlano().getBtnVolver().addActionListener(this);
		vf.getV().getJpnSimuladorSemiLlano().getBtnOrdenartiempo().addActionListener(this);
		vf.getV().getJpnSimuladorSemiLlano().getBtnIniciar().addActionListener(this);
		vf.getV().getJpnSimuladorMontania().getBtnVolver().addActionListener(this);
		vf.getV().getJpnSimuladorMontania().getBtnOrdenartiempo().addActionListener(this);
		vf.getV().getJpnSimuladorMontania().getBtnIniciar().addActionListener(this);
		vf.getV().getJpnSimuladorPlano().getBtnVolver().addActionListener(this);
		vf.getV().getJpnSimuladorPlano().getBtnOrdenartiempo().addActionListener(this);
		vf.getV().getJpnSimuladorPlano().getBtnIniciar().addActionListener(this);
		vf.getV().getJpnSimuladorLlano().getBtnVolver().addActionListener(this);
		vf.getV().getJpnSimuladorLlano().getBtnOrdenartiempo().addActionListener(this);
		vf.getV().getJpnSimuladorLlano().getBtnIniciar().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar1().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar2().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar3().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar4().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar5().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnAgregar().addActionListener(this);
		vf.getV().getJpnSeleccionCiclista().getBtnVolver().addActionListener(this);
		vf.getV().getJpnOpciones().getBtnVolver().addActionListener(this);
		vf.getV().getJpnEliminarEscuadra().getBtnEliminar().addActionListener(this);
//-----------------------------------------------------------------------------------------------------------------
		vf.getV().getJpnPortada().getBtnEntrar().setActionCommand("menu");
		vf.getV().getJpnIngreso().getBtnRegistrarse().setActionCommand("ir a registrarse");
		vf.getV().getJpnRegister().getBtnEnviar().setActionCommand("registrarse");
		vf.getV().getJpnIngreso().getBtnContinuar().setActionCommand("loguearse");
		vf.getV().getJpnRegister().getBtnVolver().setActionCommand("volver de log");
		vf.getV().getJpnOpciones().getBtnVolver().setActionCommand("Volver de opciones");
		// OPCIONES
		vf.getV().getJpnOpciones().getBtnOpcion1().setActionCommand("opcion 1");
		vf.getV().getJpnOpciones().getBtnOpcion2().setActionCommand("opcion 2");
		vf.getV().getJpnOpciones().getBtnOpcion3().setActionCommand("opcion 3");
		vf.getV().getJpnOpciones().getBtnOpcion4().setActionCommand("opcion 4");
		vf.getV().getJpnOpciones().getBtnOpcion5().setActionCommand("opcion 5");
		vf.getV().getJpnOpciones().getBtnOpcion6().setActionCommand("opcion 6");
		vf.getV().getJpnOpciones().getBtnOpcion7().setActionCommand("opcion 7");
		vf.getV().getJpnOpciones().getBtnOpcion8().setActionCommand("opcion 8");

		// MENUS
		vf.getV().getJpnMenuUsuarios().getBtnCiclista().setActionCommand("menu ciclista");
		vf.getV().getJpnMenuUsuarios().getBtnDirector().setActionCommand("menu director");
		vf.getV().getJpnMenuUsuarios().getBtnMasajista().setActionCommand("menu masajista");
		vf.getV().getJpnMenuUsuarios().getBtnVolver().setActionCommand("volver Menu");

		// TIPOS CICLISTAS
		vf.getV().getJpnCrearCiclista().getBtnEnviar().setActionCommand("enviar crear");
		vf.getV().getJpnCrearCiclista().getRbtnClasicoMano().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnContrarreloj().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnEmbalador().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnEscalador().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnGregario().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnRodador().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getRbtnVacio().setActionCommand("Tipo de ciclista");
		vf.getV().getJpnCrearCiclista().getBtnVolver().setActionCommand("Volver Crear");

		// CICLISTA
		vf.getV().getJpnMenuCiclista().getBtnCrear().setActionCommand("crear ciclista");
		vf.getV().getJpnMenuCiclista().getBtnEliminar().setActionCommand("eliminar ciclista");
		vf.getV().getJpnMenuCiclista().getBtnMostrar().setActionCommand("mostrar ciclista");
		vf.getV().getJpnMenuCiclista().getBtnVolver().setActionCommand("volver a menu usuarios de c");

		// TIPOS CICLISTAS ACTUALIZAR
		vf.getV().getJpnMenuCiclista().getBtnActualizar().setActionCommand("ir a actualizar ciclista");
		vf.getV().getJpnActualizarCiclista().getBtnEnviar().setActionCommand("actualizar ciclista");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoClasicoMano().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoContrarreloj().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoEmbalador().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoEscalador().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoGregario().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoRodador().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getRbtnNuevoVacio().setActionCommand("Tipo de ciclista a");
		vf.getV().getJpnActualizarCiclista().getBtnVolver().setActionCommand("volver a menu c de a");

		// mostrar
		vf.getV().getJpnMostrarCiclista().getBtnVolver().setActionCommand("volver mostrar ciclista");
		vf.getV().getJpnMostrarCiclista().getRbtnClasicoMano().setActionCommand("Tipo de ciclista m");
		vf.getV().getJpnMostrarCiclista().getRbtnContrarreloj().setActionCommand("Tipo de ciclista m");
		vf.getV().getJpnMostrarCiclista().getRbtnEmbalador().setActionCommand("Tipo de ciclista m");
		vf.getV().getJpnMostrarCiclista().getRbtnEscalador().setActionCommand("Tipo de ciclista m");
		vf.getV().getJpnMostrarCiclista().getRbtnGregario().setActionCommand("Tipo de ciclista m");
		vf.getV().getJpnMostrarCiclista().getRbtnRodador().setActionCommand("Tipo de ciclista m");

		// MASAJISTA
		vf.getV().getJpnMenuMasajista().getBtnCrear().setActionCommand("ir a crear masajista");
		vf.getV().getJpnMenuMasajista().getBtnEliminar().setActionCommand("ir a eliminar masajista");
		vf.getV().getJpnMenuMasajista().getBtnMostrar().setActionCommand("ir a mostrar masajista");
		vf.getV().getJpnCrearMasajista().getBtnRegistrarse().setActionCommand("crear masajista");
		vf.getV().getJpnMenuMasajista().getBtnVolver().setActionCommand("Volver a menu usuarios de m");
		vf.getV().getJpnCrearMasajista().getBtnvolver().setActionCommand("Volver de crear a crud maajista");
		vf.getV().getJpnActualizarMasajista().getBtnActualizar().setActionCommand("actualizar masajista");
		vf.getV().getJpnActualizarMasajista().getBtnvolver().setActionCommand("Volver de actualizar a crud masajista");
		vf.getV().getJpnMenuMasajista().getBtnActualizar().setActionCommand("ir a actualizar masajista");
		vf.getV().getJpnEliminarMasajista().getBtneliminar().setActionCommand("eliminar masajista");
		vf.getV().getJpnEliminarMasajista().getBtnVolver().setActionCommand("Volver de eliminar a crud majista");
		vf.getV().getJpnPanelPerfilMasajista().getBtnVolver().setActionCommand("Volver de mostrar a crud masajista");
		vf.getV().getJpnMostrarMasajista().getBtnVolver().setActionCommand("Volver crud masajista de m");

		// DIRECTOR
		vf.getV().getJpnMenuDirector().getBtnActualizar().setActionCommand("ir a actualizar director");
		vf.getV().getJpnMenuDirector().getBtnCrear().setActionCommand("ir a crear director");
		vf.getV().getJpnMenuDirector().getBtnEliminar().setActionCommand("ir a eliminar director");
		vf.getV().getJpnEliminarDirector().getBtnVolver().setActionCommand("volver a menu director de E");
		vf.getV().getJpnEliminarDirector().getBtnEnviar().setActionCommand("eliminar director");
		vf.getV().getJpnMenuDirector().getBtnMostrar().setActionCommand("ir a mostrar director");
		vf.getV().getJpnMostrarDirector().getBtnVolver().setActionCommand("volver a menu director de M");
		vf.getV().getJpnCrearDirector().getBtnRegistrar().setActionCommand("crear director");
		vf.getV().getJpnCrearDirector().getBtnVolver().setActionCommand("volver a menu director c");
		vf.getV().getJpnActualizarDirector().getBtnRegistrar().setActionCommand("actualizar director");
		vf.getV().getJpnActualizarDirector().getBtnVolver().setActionCommand("volver a menu director a");
		vf.getV().getJpnMenuDirector().getBtnVolver().setActionCommand("volver a menu usuarios director");

		// ESCUADRA
		vf.getV().getJpnMenuEscuadra().getBtnActualizar().setActionCommand("ir a actualizar escuadra");
		vf.getV().getJpnMenuEscuadra().getBtnCrear().setActionCommand("ir a crear escuadra");
		vf.getV().getJpnMenuEscuadra().getBtnEliminar().setActionCommand("ir a eliminar escuadra");
		vf.getV().getJpnMenuEscuadra().getBtnMostrar().setActionCommand("ir a mostrar escuadra");
		vf.getV().getJpnMenuEscuadra().getBtnVolver().setActionCommand("volver a opciones de esc");
		vf.getV().getJpnCrearEscuadra().getBtnRegistrar().setActionCommand("crear escuadra");
		vf.getV().getJpnCrearEscuadra().getBtnVolver().setActionCommand("volver a menu escuadra c");
		vf.getV().getJpnAgregarAEscuadra().getBtnAgregar().setActionCommand("agregar usuario");
		vf.getV().getJpnAgregarAEscuadra().getBtnBuscar().setActionCommand("buscar escuadra en agregar");
		vf.getV().getJpnAgregarAEscuadra().getBtnVolver().setActionCommand("volver menu opciones de a");
		vf.getV().getJpnEliminarEscuadra().getBtnEliminar().setActionCommand("eliminar escuadra");
		vf.getV().getJpnCrearEscuadra().getBtnVolver().setActionCommand("volver de crear e");

		vf.getV().getJpnMostrarEscuadra().getBtnBuscar().setActionCommand("buscar escuadra");
		vf.getV().getJpnMostrarEscuadra().getBtnVolver().setActionCommand("volver a menu escuadra m");
		// USUARIO
		vf.getV().getJpnEliminarUsuario().getBtnEliminar().setActionCommand("eliminar usuario");
		vf.getV().getJpnEliminarUsuario().getBtnVolver().setActionCommand("volver menu opciones de e");

		// SIMULACION
		vf.getV().getJpnElegirMapa().getBtnSeleccionarMapa().setActionCommand("elegir mapa");
		vf.getV().getJpnSimuladorSemiLlano().getBtnVolver().setActionCommand("volver simulacion semi llano");
		vf.getV().getJpnSimuladorSemiLlano().getBtnIniciar().setActionCommand("empezar simulacion semi llano");
		vf.getV().getJpnSimuladorSemiLlano().getBtnOrdenartiempo().setActionCommand("ordenamiento semi llano");
		vf.getV().getJpnSimuladorPlano().getBtnVolver().setActionCommand("volver simulacion plano");
		vf.getV().getJpnSimuladorPlano().getBtnIniciar().setActionCommand("empezar simulacion plano");
		vf.getV().getJpnSimuladorPlano().getBtnOrdenartiempo().setActionCommand("ordenamiento plano");
		vf.getV().getJpnSimuladorMontania().getBtnVolver().setActionCommand("volver simulacion montaña");
		vf.getV().getJpnSimuladorMontania().getBtnIniciar().setActionCommand("empezar simulacion montaña");
		vf.getV().getJpnSimuladorMontania().getBtnOrdenartiempo().setActionCommand("ordenamiento montaña");
		vf.getV().getJpnSimuladorLlano().getBtnVolver().setActionCommand("volver simulacion llano");
		vf.getV().getJpnSimuladorLlano().getBtnIniciar().setActionCommand("empezar simulacion llano");
		vf.getV().getJpnSimuladorLlano().getBtnOrdenartiempo().setActionCommand("ordenamiento llano");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar().setActionCommand("buscar escuadra seleccion");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar1().setActionCommand("buscar escuadra seleccion 1");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar2().setActionCommand("buscar escuadra seleccion 2");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar3().setActionCommand("buscar escuadra seleccion 3");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar4().setActionCommand("buscar escuadra seleccion 4");
		vf.getV().getJpnSeleccionCiclista().getBtnBuscar5().setActionCommand("buscar escuadra seleccion 5");
		vf.getV().getJpnSeleccionCiclista().getBtnAgregar().setActionCommand("ir al simulador del mapa");
		vf.getV().getJpnSeleccionCiclista().getBtnVolver().setActionCommand("volver de elergir c de e");
		vf.getV().getJpnElegirMapa().getBtnVolver().setActionCommand("Volver de elegir mapa a o");
	}


	/**
	 * Makes the graphical user interface visible.
	 */

	public void correrGUI() {
		vf.getV().setVisible(true);
	}

	/**
	 * Handles actions performed on components.
	 * 
	 * @param e ActionEvent that contains information about the event.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "menu": {
			vf.getV().getJpnPortada().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnCrearCiclista().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "ir a registrarse": {

			vf.getV().getJpnPortada().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnCrearCiclista().setVisible(false);
			vf.getV().getJpnRegister().setVisible(true);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().repaint();
			break;
		}
		case "registrarse": {
			if (crearUsuario() == 1) {
//				registroTipo();
//			vf.getV().getJpnIngreso().setVisible(true);
				createEmail("Registro");
				sendEmail();
				vf.getV().getJpnPortada().setVisible(false);
				vf.getV().getJpnOpciones().setVisible(false);
				vf.getV().getJpnCrearCiclista().setVisible(false);
				vf.getV().getJpnRegister().setVisible(false);
				vf.getV().getJpnIngreso().setVisible(true);
				vf.getV().repaint();
			}
			break;
		}
		case "loguearse": {
			login();
			if (TipoUsuariologin().equals("DirectorDeportivo")) {
				vf.getV().getJpnOpciones().limpiarPanelO();
				vf.getV().getJpnOpciones().getBtnOpcion1().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion2().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion3().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion5().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion6().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion5().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnEliminar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnEliminar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcionNov1().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov2().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov3().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov4().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov5().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov6().setVisible(false);
				vf.getV().getJpnMenuCiclista().getBtnEliminarNov1().setVisible(false);
				vf.getV().getJpnMenuMasajista().getBtnEliminarNov1().setVisible(false);
				vf.getV().getJpnOpciones().getImageLabelDirector().setVisible(true);
				vf.getV().repaint();
			}
			if (TipoUsuariologin().equals("Masajista")) {
				vf.getV().getJpnOpciones().limpiarPanelO();
				vf.getV().getJpnOpciones().getBtnOpcion5().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcionNov5().setVisible(false);
				vf.getV().getJpnMenuMasajista().getBtnEliminarNov1().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnEliminar().setVisible(false);
				vf.getV().getJpnOpciones().getImageLabelMasajista().setVisible(true);
				vf.getV().repaint();

			}
			if (TipoUsuariologin().equals("Ciclista")) {
				vf.getV().getJpnOpciones().limpiarPanelO();
				vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcionNov4().setVisible(false);
				vf.getV().getJpnMenuCiclista().getBtnEliminar().setVisible(false);
				vf.getV().getJpnMenuMasajista().getBtnEliminarNov1().setVisible(true);
				vf.getV().getJpnOpciones().getImageLabelCiclista().setVisible(true);
				vf.getV().repaint();
			}

			if (TipoUsuariologin().equals("Administrativo")) {
				vf.getV().getJpnOpciones().limpiarPanelO();
				vf.getV().getJpnMenuCiclista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuCiclista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion4().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcion7().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcion8().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnCrear().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnActualizar().setVisible(true);
				vf.getV().getJpnMenuMasajista().getBtnMostrar().setVisible(true);
				vf.getV().getJpnOpciones().getBtnOpcionNov7().setVisible(false);
				vf.getV().getJpnOpciones().getBtnOpcionNov8().setVisible(false);
				vf.getV().getJpnOpciones().getImageLabelAdministrativo().setVisible(true);
				vf.getV().repaint();
			}

			vf.getV().repaint();
			break;
		}
		case "Menu Opciones": {

			break;
		}
		case "opcion 1": {
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnMenuEscuadra().setVisible(true);
			vf.getV().getJpnOpciones().repaint();
			break;
		}
		case "opcion 2": {
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnEliminarUsuario().setVisible(true);
			break;

		}
		case "opcion 3": {
			for (CiclistaDTO ciclista : mf.getCiclistas()) {
				if (ciclista instanceof CiclistaDTO) {
					vf.getV().getJpnAgregarAEscuadra().getBoxCiclista()
							.addItem(ciclista.getId() + "-" + ciclista.toString());

				}
			}
			vf.getV().getJpnMenuCiclista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnAgregarAEscuadra().setVisible(true);
			break;
		}

		case "opcion 4": {

			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(true);
			if (TipoUsuariologin().equals("DirectorDeportivo"))

				vf.getV().getJpnMenuCiclista().getBtnCrear().setVisible(true);

			break;

		}
		case "opcion 5": {

			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			break;

		}
		case "opcion 6": {
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			break;

		}
		case "opcion 7": {
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);

			break;

		}

		case "elegir mapa": {
//			irSimulacion();

			vf.getV().getJpnSeleccionCiclista().setVisible(true);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			vf.getV().repaint();
			break;
		}

		case "ir al simulador del mapa": {
			vf.getV().limpiarPanel();
			irSimulacion();
			agregarAlSimulador();
			agregarAlSimulador1();
			agregarAlSimulador2();
			agregarAlSimulador3();
			agregarAlSimulador4();
			agregarAlSimulador5();
			vf.getV().getJpnSeleccionCiclista().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			vf.getV().repaint();
			break;
		}

		case "empezar simulacion semi llano": {
			carreraBotonInicioSemiLlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}
		case "ordenamiento semi llano": {
			ordenarSemiLlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}

		case "empezar simulacion montaña": {
			carreraBotonInicioMontania();

//			vf.getV().getJpnSimuladorMontania().carreraBotonInicio();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}

		case "ordenamiento montaña": {
			ordenarMontania();
//			vf.getV().getJpnSimuladorMontania().carreraBotonInicio();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}

		case "empezar simulacion plano": {
			carreraBotonInicioPlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}

		case "ordenamiento plano": {
			ordenarPlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}
		case "empezar simulacion llano": {
			carreraBotonInicioLlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}
		case "ordenamiento llano": {
			ordenarLlano();
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(false);
			break;
		}

		case "eliminar usuario": {
			eliminarUsuario();
			vf.getV().repaint();
			break;
		}

		case "volver Menu": {
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "crear": {

			llenarUsuarioACiclista();
			break;
		}
		case "enviar crear": {

			crearTipoCiclista();
			break;
		}
		case "Tipo de ciclista": {
			tipoCiclistaCrear();
			break;
		}
		case "Volver Crear": {
			vf.getV().getJpnCrearCiclista().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "actualizar ciclista": {
			// actualizarCiclista();
			actualizarTipoCiclista();
			MensajeEmergente.mostrarMensaje("Ciclista Actualizado");
			vf.getV().getJpnActualizarCiclista().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "ir a actualizar masajista": {
			vf.getV().getJpnActualizarMasajista().lipiarInfoActualizarM();
			llenarActualizarUsuarioAMasajista();
			vf.getV().getJpnMenuMasajista().setVisible(false);
			vf.getV().getJpnActualizarMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "actualizar masajista": {
			actualizarMasajista();
			MensajeEmergente.mostrarMensaje("Masajista Actualizado!");
			vf.getV().getJpnActualizarMasajista().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "ir a actualizar ciclista": {
			vf.getV().getJpnActualizarCiclista().limpiarPanel();
			llenarActualizarUsuarioCiclista();
			vf.getV().getJpnMenuCiclista().setVisible(false);
			vf.getV().getJpnActualizarCiclista().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "Tipo de ciclista a": {
			tipoCiclistaActualizar();
			break;
		}

		case "Tipo de ciclista m": {
			tipoCiclistaMostrar();
			break;
		}

		case "menu ciclista": {
			vf.getV().getJpnCrearCiclista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnPortada().setVisible(false);
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(true);

			break;
		}
		case "menu director": {
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			break;
		}

		case "menu masajista": {
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			break;
		}
		case "menu escuadra": {
			vf.getV().getJpnCrearEscuadra().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuEscuadra().setVisible(true);
			break;
		}

		case "crear ciclista": {
			vf.getV().getJpnCrearCiclista().limpiarPanel();
			if (!TipoUsuariologin().equals("DirectorDeportivo")) {
				llenarUsuarioACiclista();
			}
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuUsuarios().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(false);
			vf.getV().getJpnCrearCiclista().setVisible(true);
			vf.getV().repaint();

			break;
		}

		case "ir a crear masajista": {
			vf.getV().getJpnCrearMasajista().lipiarInfoCrearM();
			if (!TipoUsuariologin().equals("DirectorDeportivo")) {
				llenarCrearUsuarioAMasajista();
			}

			vf.getV().getJpnCrearMasajista().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(false);
			vf.getV().repaint();
			break;
		}

		case "crear masajista": {
			crearUsuarioAMasajista();
			MensajeEmergente.mostrarMensaje("El masajista ha sido creado");
			vf.getV().getJpnCrearMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "ir a crear director": {
			vf.getV().getJpnCrearDirector().lipiarInfoCrearD();
			llenarCrearUsuarioADirector();
			vf.getV().getJpnCrearDirector().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(false);
			vf.getV().repaint();
			break;
		}
		case "actualizar director": {
			actualizarDirector();
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(false);
			vf.getV().repaint();
			break;
		}
		case "crear director": {
			crearUsuarioADirector();
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().getJpnCrearDirector().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(false);
			break;
		}
		case "ir a crear escuadra": {
			limpiarListas();
			for (CiclistaDTO ciclista : mf.getCiclistas()) {
				if (ciclista instanceof ClasicoManoDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaClasicoManos()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
				if (ciclista instanceof ContraRelojDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaContraReloj()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
				if (ciclista instanceof EmbaladorDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaEmbalador()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
				if (ciclista instanceof EscaladorDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaEscalador()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
				if (ciclista instanceof GregarioDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaGregario()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
				if (ciclista instanceof RodadorDTO) {
					vf.getV().getJpnCrearEscuadra().getCiclistaRodador()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
			}
			for (MasajistaDTO masajista : mf.getMasajistas()) {
				if (masajista instanceof MasajistaDTO)
					vf.getV().getJpnCrearEscuadra().getMasajista()
							.addItem(masajista.getId() + "-" + masajista.toString());
			}

			vf.getV().getJpnCrearEscuadra().setVisible(true);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().repaint();
			break;

		}
		case "ir a mostrar escuadra": {
			for (CiclistaDTO ciclista : mf.getCiclistas()) {
				if (ciclista instanceof CiclistaDTO) {
					vf.getV().getJpnMostrarEscuadra().getBoxCiclista()
							.addItem(ciclista.getId() + "-" + ciclista.toString());
				}
			}

			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().getJpnMostrarEscuadra().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "buscar escuadra": {
			buscarEscuadra();
			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().getJpnMostrarEscuadra().setVisible(true);
			vf.getV().repaint();
			break;

		}
		case "ir a eliminar escuadra": {
			vf.getV().getJpnEliminarEscuadra().setVisible(true);
			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().repaint();
			break;
		}
		case "eliminar escuadra": {
			eliminarEscuadra();
			vf.getV().repaint();
			break;
		}

		case "buscar escuadra seleccion": {
			seleccionarCiclista();
			break;
		}
		case "buscar escuadra seleccion 1": {
			seleccionarCiclista1();
			break;
		}
		case "buscar escuadra seleccion 2": {
			seleccionarCiclista2();
			break;
		}
		case "buscar escuadra seleccion 3": {
			seleccionarCiclista3();
			break;
		}
		case "buscar escuadra seleccion 4": {
			seleccionarCiclista4();
			break;
		}
		case "buscar escuadra seleccion 5": {
			seleccionarCiclista5();
			break;
		}
		case "buscar escuadra en agregar": {
			buscarEscuadraEnAgregar();
			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().getJpnAgregarAEscuadra().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "agregar usuario": {
			agregarCiclistaAEscuadra();
			break;
		}

		case "crear escuadra": {
			crearEscuadra();
			break;
		}

		case "ir a actualizar director": {
			vf.getV().getJpnActualizarDirector().lipiarInfoActualizaD();
			llenarActualizarUsuarioADirector();
			vf.getV().getJpnCrearDirector().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(false);
			vf.getV().getJpnActualizarDirector().setVisible(true);
			vf.getV().repaint();
			break;

		}
		case "ir a mostrar director": {
			try {
				mostrarDirector();
				vf.getV().getJpnMenuDirector().setVisible(false);
				vf.getV().getJpnMostrarDirector().setVisible(true);
				vf.getV().repaint();
			} catch (ClassCastException e1) {
				MensajeEmergente.mostrarMensaje("Aun no eres un usuario de tipo Director");
				return;
			}
			break;
		}

		case "ir a mostrar masajista": {
			try {
				mostrarMasajista();
				vf.getV().getJpnMenuMasajista().setVisible(false);
				vf.getV().getJpnMostrarMasajista().setVisible(true);
				vf.getV().repaint();
			} catch (ClassCastException e1) {
				MensajeEmergente.mostrarMensaje("Aun no eres un usuario de tipo Masajista");
				return;
			}
			break;

		}
		case "mostrar ciclista": {
			try {
				mostrarTipoCiclista();
				vf.getV().getJpnMenuCiclista().setVisible(false);
				vf.getV().getJpnMostrarCiclista().setVisible(true);
				vf.getV().repaint();
			} catch (ClassCastException e1) {
				MensajeEmergente.mostrarMensaje("Aun no eres un usuario de tipo Ciclista");
				return;
			}
			break;
		}

		case "ir a eliminar director": {
			vf.getV().getJpnEliminarDirector().setVisible(true);
			vf.getV().getJpnMenuDirector().setVisible(false);
			vf.getV().repaint();
			break;
		}

		case "ir a eliminar masajista": {
			vf.getV().getJpnMenuMasajista().setVisible(false);
			vf.getV().getJpnActualizarMasajista().setVisible(false);
			vf.getV().getJpnEliminarMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "eliminar masajista": {
			eliminarUsuarioMasajista();
			vf.getV().repaint();
			break;
		}
		case "eliminar director": {
			eliminarUsuarioDirector();
			vf.getV().repaint();
			break;
		}
		case "eliminar ciclista": {
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu usuarios de c": {
			vf.getV().getJpnMenuCiclista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver mostrar ciclista": {
			vf.getV().getJpnMostrarCiclista().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver a menu director c": {
			vf.getV().getJpnCrearDirector().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu masajista a": {
			vf.getV().getJpnActualizarMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver a menu escuadra m": {
			vf.getV().getJpnMenuEscuadra().setVisible(true);
			vf.getV().getJpnMostrarEscuadra().setVisible(false);
			vf.getV().repaint();
			break;
		}

		case "volver a menu masajista c": {
			vf.getV().getJpnCrearMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu masajista e": {
			vf.getV().getJpnEliminarMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "Volver crud masajista de m": {
			vf.getV().getJpnMostrarMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "Volver de opciones": {
			vf.getV().setVisible(false);
			init();
			break;
		}

		case "volver a menu director a": {
			vf.getV().getJpnActualizarDirector().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu usuarios director": {
			vf.getV().getJpnMenuDirector().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu director de E": {
			vf.getV().getJpnEliminarDirector().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "Volver a menu usuarios de m": {
			vf.getV().getJpnMenuMasajista().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver a menu director de M": {
			vf.getV().getJpnMostrarDirector().setVisible(false);
			vf.getV().getJpnMenuDirector().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "Volver de crear a crud maajista": {
			vf.getV().getJpnCrearMasajista().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;

		}

		case "Volver de eliminar a crud majista": {
			vf.getV().getJpnEliminarMasajista().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;

		}

		case "Volver de actualizar a crud masajista": {
			vf.getV().getJpnActualizarMasajista().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;

		}

		case "Volver de mostrar a crud masajista": {
			vf.getV().getJpnPanelPerfilMasajista().setVisible(false);
			vf.getV().getJpnMenuMasajista().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver a menu c de a": {
			vf.getV().getJpnActualizarCiclista().setVisible(false);
			vf.getV().getJpnMenuCiclista().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver menu opciones de a": {
			vf.getV().getJpnAgregarAEscuadra().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver de log": {
			vf.getV().getJpnRegister().setVisible(false);
			vf.getV().getJpnIngreso().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver menu opciones de e": {
			vf.getV().getJpnEliminarUsuario().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver a opciones de esc": {
			vf.getV().getJpnMenuEscuadra().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}

		case "volver simulacion semi llano": {
			vf.getV().getJpnSimuladorSemiLlano().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver simulacion plano": {
			vf.getV().getJpnSimuladorPlano().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver simulacion montaña": {
			vf.getV().getJpnSimuladorMontania().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver simulacion llano": {
			vf.getV().getJpnSimuladorLlano().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver de elergir c de e": {
			vf.getV().getJpnSeleccionCiclista().setVisible(false);
			vf.getV().getJpnElegirMapa().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "volver de crear e": {
			vf.getV().getJpnCrearEscuadra().setVisible(false);
			vf.getV().getJpnMenuEscuadra().setVisible(true);
			vf.getV().repaint();
			break;
		}
		case "Volver de elegir mapa a o" :{
			vf.getV().getJpnElegirMapa().setVisible(false);
			vf.getV().getJpnOpciones().setVisible(true);
			vf.getV().repaint();
			break;
		}
		}
	}

	/**
	 * Creates an email message based on the type.
	 *
	 * @param tipo The type of email ("Registro", "Ciclista", "Masajista").
	 */

	public void createEmail(String tipo) {
		if (tipo.equals("Registro"))
			correo.setPara(vf.getV().getJpnRegister().getTxtCorreoElectronico().getText());
		else if (tipo.equals("Ciclista"))
			correo.setPara(vf.getV().getJpnCrearCiclista().getTxtcorreoElectronico().getText());
		else if (tipo.equals("Masajista"))
			correo.setPara(vf.getV().getJpnCrearMasajista().getCorreoElectronico().getText());
		else if (tipo.equals("Director"))
			correo.setPara(vf.getV().getJpnCrearMasajista().getCorreoElectronico().getText());

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", correo.getPara());
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSeccion = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSeccion);
			mCorreo.setFrom(new InternetAddress(correo.getDe()));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correo.getPara()));
			mCorreo.setSubject(correo.getAsunto());

			if (tipo.equals("Registro"))
				mCorreo.setText(correo.getContenido() + " Su nombre de Usuario es: "
						+ vf.getV().getJpnRegister().getTxtId().getText() + "\n" + "Su contraseña es: "
						+ vf.getV().getJpnRegister().getTxtContrasenia().getText(), "ISO-8859-1", "html");
			else if (tipo.equals("Ciclista"))
				mCorreo.setText(correo.getContenido() + " Su nombre de Usuario es: "
						+ vf.getV().getJpnCrearCiclista().getTxtId().getText() + "\n" + "Su contraseña es: "
						+ vf.getV().getJpnCrearCiclista().getTxtContrasenia().getText(), "ISO-8859-1", "html");

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Sends the previously created email.
	 */

	public void sendEmail() {

		try {
			Transport mTransport = mSeccion.getTransport("smtp");
			mTransport.connect(correo.getDe(), correo.getContrasenia());
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
			JOptionPane.showMessageDialog(vf.getV(), "Enviado");

		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

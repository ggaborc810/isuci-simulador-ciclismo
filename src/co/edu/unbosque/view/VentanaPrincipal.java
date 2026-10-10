package co.edu.unbosque.view;

import java.awt.Dimension;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import co.edu.unbosque.model.persistence.FileHandler;

public class VentanaPrincipal extends JFrame {

	private Properties propertiesInfoV;
	private PanelPortada jpnPortada;
	private PanelOpciones jpnOpciones;
	private PanelMenuUsuario jpnMenuUsuarios;
	private PanelRegistro jpnRegister;
	private PanelDeIngreso jpnIngreso;
	private PanelCrearCiclista jpnCrearCiclista;
	private PanelMenuCiclista jpnMenuCiclista;
	private PanelMenuDirector jpnMenuDirector;
	private PanelMenuMasajista jpnMenuMasajista;
	private PanelCrearMasajista jpnCrearMasajista;
	private PanelActualizarMasajista jpnActualizarMasajista;
	private PanelEliminarMasajista jpnEliminarMasajista;
	private PanelMostrarMasajista jpnPanelPerfilMasajista;
	private PanelCrearDirector jpnCrearDirector;
	private PanelActualizarDirector jpnActualizarDirector;
	private PanelMostrarDirector jpnMostrarDirector;
	private PanelEliminarDirector jpnEliminarDirector;
	private PanelCrearEscuadra jpnCrearEscuadra;
	private PanelMenuEscuadra jpnMenuEscuadra;
	private PanelMostrarMasajista jpnMostrarMasajista;
	private PanelActualizarCiclista jpnActualizarCiclista;
	private PanelMostrarCiclista jpnMostrarCiclista;
	private PanelElegirMapa jpnElegirMapa;
	private PanelEliminarUsuario jpnEliminarUsuario;
	private PanelEliminarEscuadra jpnEliminarEscuadra;
	private PanelMostrarEscuadra jpnMostrarEscuadra;
	private PanelAgregarAEscuadra jpnAgregarAEscuadra;
	private PanelMapaMontania jpnMontania;
	private PanelMapaPlano jpnPlano;
	private PanelMapaLlano jpnLlano;
	private PanelMapaSemiLlano jpnSemiLlano;
	private PanelSimuladorSemiLlano jpnSimuladorSemiLlano;
	private PanelSimuladorMontania jpnSimuladorMontania;
	private PanelSimuladorPlano jpnSimuladorPlano;
	private PanelSimuladorLlano jpnSimuladorLlano;
	private PanelSeleccionCiclista jpnSeleccionCiclista;

	public VentanaPrincipal() {

		propertiesInfoV = FileHandler.cargarPropiedades("datos/ventana.properties");
		String titulo = propertiesInfoV.getProperty("ventana.title");
		int posX = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.horizontal"));
		int posY = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.vertical"));

		setTitle(titulo);
		setSize(posX, posY);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		jpnPortada = new PanelPortada();
		jpnPortada.setVisible(false);

		jpnOpciones = new PanelOpciones();
		jpnOpciones.setVisible(false);

		jpnMenuUsuarios = new PanelMenuUsuario();
		jpnMenuUsuarios.setVisible(false);

		jpnRegister = new PanelRegistro();
		jpnRegister.setVisible(false);

		jpnIngreso = new PanelDeIngreso();
		jpnIngreso.setVisible(false);

		jpnCrearCiclista = new PanelCrearCiclista();
		jpnCrearCiclista.setVisible(false);

		jpnMenuCiclista = new PanelMenuCiclista();
		jpnMenuCiclista.setVisible(false);

		jpnMenuDirector = new PanelMenuDirector();
		jpnMenuDirector.setVisible(false);

		jpnMenuMasajista = new PanelMenuMasajista();
		jpnMenuMasajista.setVisible(false);

		jpnCrearMasajista = new PanelCrearMasajista();
		jpnCrearMasajista.setVisible(false);

		jpnActualizarMasajista = new PanelActualizarMasajista();
		jpnActualizarMasajista.setVisible(false);

		jpnEliminarMasajista = new PanelEliminarMasajista();
		jpnEliminarMasajista.setVisible(false);

		jpnPanelPerfilMasajista = new PanelMostrarMasajista();
		jpnPanelPerfilMasajista.setVisible(false);

		jpnCrearDirector = new PanelCrearDirector();
		jpnCrearDirector.setVisible(false);

		jpnActualizarDirector = new PanelActualizarDirector();
		jpnActualizarDirector.setVisible(false);

		jpnMostrarDirector = new PanelMostrarDirector();
		jpnMostrarDirector.setVisible(false);

		jpnEliminarDirector = new PanelEliminarDirector();
		jpnEliminarDirector.setVisible(false);

		jpnCrearEscuadra = new PanelCrearEscuadra();
		jpnCrearEscuadra.setVisible(false);

		jpnMenuEscuadra = new PanelMenuEscuadra();
		jpnMenuEscuadra.setVisible(false);

		jpnMostrarMasajista = new PanelMostrarMasajista();
		jpnMostrarMasajista.setVisible(false);

		jpnMostrarDirector = new PanelMostrarDirector();
		jpnMostrarDirector.setVisible(false);

		jpnActualizarCiclista = new PanelActualizarCiclista();
		jpnActualizarCiclista.setVisible(false);

		jpnMostrarCiclista = new PanelMostrarCiclista();
		jpnMostrarCiclista.setVisible(false);

		jpnElegirMapa = new PanelElegirMapa();
		jpnElegirMapa.setVisible(false);

		jpnEliminarUsuario = new PanelEliminarUsuario();
		jpnEliminarUsuario.setVisible(false);

		jpnEliminarEscuadra = new PanelEliminarEscuadra();
		jpnEliminarEscuadra.setVisible(false);

		jpnMostrarEscuadra = new PanelMostrarEscuadra();
		jpnMostrarEscuadra.setVisible(false);

		jpnMontania = new PanelMapaMontania();
		jpnMontania.setVisible(false);

		jpnPlano = new PanelMapaPlano();
		jpnPlano.setVisible(false);

		jpnLlano = new PanelMapaLlano();
		jpnLlano.setVisible(false);

		jpnSemiLlano = new PanelMapaSemiLlano();
		jpnSemiLlano.setVisible(false);

		jpnAgregarAEscuadra = new PanelAgregarAEscuadra();
		jpnAgregarAEscuadra.setVisible(false);

		jpnElegirMapa = new PanelElegirMapa();
		jpnElegirMapa.setVisible(false);

		jpnMostrarEscuadra = new PanelMostrarEscuadra();
		jpnMostrarEscuadra.setVisible(false);

		jpnSimuladorSemiLlano = new PanelSimuladorSemiLlano();
		jpnSimuladorSemiLlano.setVisible(false);

		jpnSimuladorMontania = new PanelSimuladorMontania();
		jpnSimuladorMontania.setVisible(false);

		jpnSimuladorPlano = new PanelSimuladorPlano();
		jpnSimuladorPlano.setVisible(false);

		jpnSimuladorLlano = new PanelSimuladorLlano();
		jpnSimuladorLlano.setVisible(false);

		jpnSeleccionCiclista = new PanelSeleccionCiclista();
		jpnSeleccionCiclista.setVisible(false);

		add(jpnPortada);
		add(jpnOpciones);
		add(jpnMenuUsuarios);
		add(jpnRegister);
		add(jpnIngreso);
		add(jpnCrearCiclista);
		add(jpnMenuCiclista);
		add(jpnMenuDirector);
		add(jpnMenuMasajista);
		add(jpnCrearMasajista);
		add(jpnActualizarCiclista);
		add(jpnActualizarMasajista);
		add(jpnEliminarMasajista);
		add(jpnPanelPerfilMasajista);
		add(jpnCrearDirector);
		add(jpnActualizarDirector);
		add(jpnMostrarDirector);
		add(jpnEliminarDirector);
		add(jpnCrearEscuadra);
		add(jpnMenuEscuadra);
		add(jpnMostrarDirector);
		add(jpnMostrarMasajista);
		add(jpnMostrarCiclista);
		add(jpnElegirMapa);
		add(jpnEliminarUsuario);
		add(jpnEliminarEscuadra);
		add(jpnMostrarEscuadra);
		add(jpnAgregarAEscuadra);
		add(jpnMontania);
		add(jpnPlano);
		add(jpnLlano);
		add(jpnSemiLlano);
		add(jpnElegirMapa);
		add(jpnSimuladorSemiLlano);
		add(jpnSimuladorMontania);
		add(jpnSimuladorPlano);
		add(jpnSimuladorLlano);
		add(jpnSeleccionCiclista);
		
		repaint();
	}

	public void limpiarPanel() {

		jpnOpciones.setVisible(false);
		jpnMenuUsuarios.setVisible(false);
		jpnRegister.setVisible(false);
		jpnIngreso.setVisible(false);
		jpnCrearCiclista.setVisible(false);
		jpnMenuCiclista.setVisible(false);
		jpnMenuDirector.setVisible(false);
		jpnMenuMasajista.setVisible(false);
		jpnCrearMasajista.setVisible(false);
		jpnActualizarMasajista.setVisible(false);
		jpnEliminarMasajista.setVisible(false);
		jpnPanelPerfilMasajista.setVisible(false);
		jpnCrearDirector.setVisible(false);
		jpnActualizarDirector.setVisible(false);
		jpnMostrarDirector.setVisible(false);
		jpnEliminarDirector.setVisible(false);
		jpnCrearEscuadra.setVisible(false);
		jpnMenuEscuadra.setVisible(false);
		jpnMostrarMasajista.setVisible(false);
		jpnActualizarCiclista.setVisible(false);
		jpnMostrarCiclista.setVisible(false);
		jpnElegirMapa.setVisible(false);
		jpnEliminarUsuario.setVisible(false);
		jpnEliminarEscuadra.setVisible(false);
		jpnMostrarEscuadra.setVisible(false);
		jpnAgregarAEscuadra.setVisible(false);
		jpnMontania.setVisible(false);
		jpnPlano.setVisible(false);
		jpnLlano.setVisible(false);
		jpnSemiLlano.setVisible(false);
		jpnSimuladorSemiLlano.setVisible(false);
		jpnSimuladorMontania.setVisible(false);
		jpnSimuladorPlano.setVisible(false);
		jpnSimuladorLlano.setVisible(false);
		jpnSeleccionCiclista.setVisible(false);
	}

	public Properties getPropertiesInfoV() {
		return propertiesInfoV;
	}

	public void setPropertiesInfoV(Properties propertiesInfoV) {
		this.propertiesInfoV = propertiesInfoV;
	}

	public PanelPortada getJpnPortada() {
		return jpnPortada;
	}

	public void setJpnPortada(PanelPortada jpnPortada) {
		this.jpnPortada = jpnPortada;
	}

	public PanelOpciones getJpnOpciones() {
		return jpnOpciones;
	}

	public void setJpnOpciones(PanelOpciones jpnOpciones) {
		this.jpnOpciones = jpnOpciones;
	}

	public PanelCrearEscuadra getJpnCrearEscuadra() {
		return jpnCrearEscuadra;
	}

	public void setJpnCrearEscuadra(PanelCrearEscuadra jpnCrearEscuadra) {
		this.jpnCrearEscuadra = jpnCrearEscuadra;
	}

	public PanelMenuEscuadra getJpnMenuEscuadra() {
		return jpnMenuEscuadra;
	}

	public void setJpnMenuEscuadra(PanelMenuEscuadra jpnMenuEscuadra) {
		this.jpnMenuEscuadra = jpnMenuEscuadra;
	}

	public PanelMenuUsuario getJpnMenuUsuarios() {
		return jpnMenuUsuarios;
	}

	public void setJpnMenuUsuarios(PanelMenuUsuario jpnMenuUsuarios) {
		this.jpnMenuUsuarios = jpnMenuUsuarios;
	}

	public PanelRegistro getJpnRegister() {
		return jpnRegister;
	}

	public void setJpnRegister(PanelRegistro jpnRegister) {
		this.jpnRegister = jpnRegister;
	}

	public PanelDeIngreso getJpnIngreso() {
		return jpnIngreso;
	}

	public void setJpnIngreso(PanelDeIngreso jpnIngreso) {
		this.jpnIngreso = jpnIngreso;
	}

	public PanelCrearCiclista getJpnCrearCiclista() {
		return jpnCrearCiclista;
	}

	public void setJpnCrearCiclista(PanelCrearCiclista jpnCrearCiclista) {
		this.jpnCrearCiclista = jpnCrearCiclista;
	}

	public PanelMenuCiclista getJpnMenuCiclista() {
		return jpnMenuCiclista;
	}

	public void setJpnMenuCiclista(PanelMenuCiclista jpnMenuCiclista) {
		this.jpnMenuCiclista = jpnMenuCiclista;
	}

	public PanelMenuDirector getJpnMenuDirector() {
		return jpnMenuDirector;
	}

	public void setJpnMenuDirector(PanelMenuDirector jpnMenuDirector) {
		this.jpnMenuDirector = jpnMenuDirector;
	}

	public PanelMenuMasajista getJpnMenuMasajista() {
		return jpnMenuMasajista;
	}

	public void setJpnMenuMasajista(PanelMenuMasajista jpnMenuMasajista) {
		this.jpnMenuMasajista = jpnMenuMasajista;
	}

	public PanelCrearMasajista getJpnCrearMasajista() {
		return jpnCrearMasajista;
	}

	public void setJpnCrearMasajista(PanelCrearMasajista jpnCrearMasajista) {
		this.jpnCrearMasajista = jpnCrearMasajista;
	}

	public PanelActualizarMasajista getJpnActualizarMasajista() {
		return jpnActualizarMasajista;
	}

	public void setJpnActualizarMasajista(PanelActualizarMasajista jpnActualizarMasajista) {
		this.jpnActualizarMasajista = jpnActualizarMasajista;
	}

	public PanelEliminarMasajista getJpnEliminarMasajista() {
		return jpnEliminarMasajista;
	}

	public void setJpnEliminarMasajista(PanelEliminarMasajista jpnEliminarMasajista) {
		this.jpnEliminarMasajista = jpnEliminarMasajista;
	}

	public PanelMostrarMasajista getJpnPanelPerfilMasajista() {
		return jpnPanelPerfilMasajista;
	}

	public void setJpnPanelPerfilMasajista(PanelMostrarMasajista jpnPanelPerfilMasajista) {
		this.jpnPanelPerfilMasajista = jpnPanelPerfilMasajista;
	}

	public PanelCrearDirector getJpnCrearDirector() {
		return jpnCrearDirector;
	}

	public void setJpnCrearDirector(PanelCrearDirector jpnCrearDirector) {
		this.jpnCrearDirector = jpnCrearDirector;
	}

	public PanelActualizarDirector getJpnActualizarDirector() {
		return jpnActualizarDirector;
	}

	public void setJpnActualizarDirector(PanelActualizarDirector jpnActualizarDirector) {
		this.jpnActualizarDirector = jpnActualizarDirector;
	}

	public PanelMostrarDirector getJpnMostrarDirector() {
		return jpnMostrarDirector;
	}

	public void setJpnMostrarDirector(PanelMostrarDirector jpnMostrarDirector) {
		this.jpnMostrarDirector = jpnMostrarDirector;
	}

	public PanelMostrarMasajista getJpnMostrarMasajista() {
		return jpnMostrarMasajista;
	}

	public void setJpnMostrarMasajista(PanelMostrarMasajista jpnMostrarMasajista) {
		this.jpnMostrarMasajista = jpnMostrarMasajista;
	}

	public PanelEliminarDirector getJpnEliminarDirector() {
		return jpnEliminarDirector;
	}

	public void setJpnEliminarDirector(PanelEliminarDirector jpnEliminarDirector) {
		this.jpnEliminarDirector = jpnEliminarDirector;
	}

	public PanelActualizarCiclista getJpnActualizarCiclista() {
		return jpnActualizarCiclista;
	}

	public void setJpnActualizarCiclista(PanelActualizarCiclista jpnActualizarCiclista) {
		this.jpnActualizarCiclista = jpnActualizarCiclista;
	}

	public PanelMostrarCiclista getJpnMostrarCiclista() {
		return jpnMostrarCiclista;
	}

	public void setJpnMostrarCiclista(PanelMostrarCiclista jpnMostrarCiclista) {
		this.jpnMostrarCiclista = jpnMostrarCiclista;
	}

	public PanelElegirMapa getJpnElegirMapa() {
		return jpnElegirMapa;
	}

	public void setJpnElegirMapa(PanelElegirMapa jpnElegirMapa) {
		this.jpnElegirMapa = jpnElegirMapa;
	}

	public PanelEliminarUsuario getJpnEliminarUsuario() {
		return jpnEliminarUsuario;
	}

	public void setJpnEliminarUsuario(PanelEliminarUsuario jpnEliminarUsuario) {
		this.jpnEliminarUsuario = jpnEliminarUsuario;
	}

	public PanelEliminarEscuadra getJpnEliminarEscuadra() {
		return jpnEliminarEscuadra;
	}

	public void setJpnEliminarEscuadra(PanelEliminarEscuadra jpnEliminarEscuadra) {
		this.jpnEliminarEscuadra = jpnEliminarEscuadra;
	}

	public PanelMostrarEscuadra getJpnMostrarEscuadra() {
		return jpnMostrarEscuadra;
	}

	public void setJpnMostrarEscuadra(PanelMostrarEscuadra jpnMostrarEscuadra) {
		this.jpnMostrarEscuadra = jpnMostrarEscuadra;
	}

	public PanelMapaMontania getJpnMontania() {
		return jpnMontania;
	}

	public void setJpnMontania(PanelMapaMontania jpnMontania) {
		this.jpnMontania = jpnMontania;
	}

	public PanelMapaPlano getJpnPlano() {
		return jpnPlano;
	}

	public void setJpnPlano(PanelMapaPlano jpnPlano) {
		this.jpnPlano = jpnPlano;
	}

	public PanelMapaLlano getJpnLlano() {
		return jpnLlano;
	}

	public void setJpnLlano(PanelMapaLlano jpnLlano) {
		this.jpnLlano = jpnLlano;
	}

	public PanelMapaSemiLlano getJpnSemiLlano() {
		return jpnSemiLlano;
	}

	public void setJpnSemiLlano(PanelMapaSemiLlano jpnSemiLlano) {
		this.jpnSemiLlano = jpnSemiLlano;
	}

	public PanelAgregarAEscuadra getJpnAgregarAEscuadra() {
		return jpnAgregarAEscuadra;
	}

	public void setJpnAgregarAEscuadra(PanelAgregarAEscuadra jpnAgregarAEscuadra) {
		this.jpnAgregarAEscuadra = jpnAgregarAEscuadra;
	}

	public PanelSimuladorSemiLlano getJpnSimuladorSemiLlano() {
		return jpnSimuladorSemiLlano;
	}

	public void setJpnSimuladorSemiLlano(PanelSimuladorSemiLlano jpnSimuladorSemiLlano) {
		this.jpnSimuladorSemiLlano = jpnSimuladorSemiLlano;
	}

	public PanelSimuladorMontania getJpnSimuladorMontania() {
		return jpnSimuladorMontania;
	}

	public void setJpnSimuladorMontania(PanelSimuladorMontania jpnSimuladorMontania) {
		this.jpnSimuladorMontania = jpnSimuladorMontania;
	}

	public PanelSimuladorPlano getJpnSimuladorPlano() {
		return jpnSimuladorPlano;
	}

	public void setJpnSimuladorPlano(PanelSimuladorPlano jpnSimuladorPlano) {
		this.jpnSimuladorPlano = jpnSimuladorPlano;
	}

	public PanelSimuladorLlano getJpnSimuladorLlano() {
		return jpnSimuladorLlano;
	}

	public void setJpnSimuladorLlano(PanelSimuladorLlano jpnSimuladorLlano) {
		this.jpnSimuladorLlano = jpnSimuladorLlano;
	}

	public PanelSeleccionCiclista getJpnSeleccionCiclista() {
		return jpnSeleccionCiclista;
	}

	public void setJpnSeleccionCiclista(PanelSeleccionCiclista jpnSeleccionCiclista) {
		this.jpnSeleccionCiclista = jpnSeleccionCiclista;
	}

}

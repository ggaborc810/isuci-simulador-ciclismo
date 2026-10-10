/** 
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The EscuadraDTO class represents a squad in the cycling context. It contains
 * information about the squad's name, race times, associated countries, and
 * lists of cyclists, masseurs, and sports directors.
 */
public class EscuadraDTO implements Serializable {
	/**
	 * The name of the squad.
	 */
	private String nombreEscuadra;

	/**
	 * The cumulative race time for the squad.
	 */
	private double tiemposCarrera;

	/**
	 * The countries associated with the squad.
	 */
	private String[] paisEscuadra;

	/**
	 * The list of cyclists in the squad.
	 */
	private ArrayList<CiclistaDTO> listaCiclistas;

	/**
	 * The list of masseurs in the squad.
	 */
	private ArrayList<MasajistaDTO> listaMasajistas;

	/**
	 * The list of sports directors in the squad.
	 */
	private ArrayList<DirectorDeportivoDTO> listaDirectores;

	/**
	 * Default constructor that initializes the lists of cyclists, masseurs, and
	 * sports directors.
	 */
	public EscuadraDTO() {
		listaCiclistas = new ArrayList<CiclistaDTO>();
		listaMasajistas = new ArrayList<MasajistaDTO>();
		listaDirectores = new ArrayList<DirectorDeportivoDTO>();
	}

	/**
	 * Parameterized constructor that initializes all fields.
	 * 
	 * @param nombreEscuadra  the name of the squad
	 * @param tiemposCarrera  the cumulative race time for the squad
	 * @param paisEscuadra    the countries associated with the squad
	 * @param listaCiclistas  the list of cyclists in the squad
	 * @param listaMasajistas the list of masseurs in the squad
	 * @param listaDirectores the list of sports directors in the squad
	 */
	public EscuadraDTO(String nombreEscuadra, double tiemposCarrera, String[] paisEscuadra,
			ArrayList<CiclistaDTO> listaCiclistas, ArrayList<MasajistaDTO> listaMasajistas,
			ArrayList<DirectorDeportivoDTO> listaDirectores) {
		super();
		this.nombreEscuadra = nombreEscuadra;
		this.tiemposCarrera = tiemposCarrera;
		this.paisEscuadra = paisEscuadra;
		this.listaCiclistas = listaCiclistas;
		this.listaMasajistas = listaMasajistas;
		this.listaDirectores = listaDirectores;
	}

	/**
	 * @return the nombreEscuadra
	 */
	public String getNombreEscuadra() {
		return nombreEscuadra;
	}

	/**
	 * @param nombreEscuadra the nombreEscuadra to set
	 */
	public void setNombreEscuadra(String nombreEscuadra) {
		this.nombreEscuadra = nombreEscuadra;
	}

	/**
	 * @return the tiemposCarrera
	 */
	public double getTiemposCarrera() {
		return tiemposCarrera;
	}

	/**
	 * @param tiemposCarrera the tiemposCarrera to set
	 */
	public void setTiemposCarrera(double tiemposCarrera) {
		this.tiemposCarrera = tiemposCarrera;
	}

	/**
	 * @return the paisEscuadra
	 */
	public String[] getPaisEscuadra() {
		return paisEscuadra;
	}

	/**
	 * @param paisEscuadra the paisEscuadra to set
	 */
	public void setPaisEscuadra(String[] paisEscuadra) {
		this.paisEscuadra = paisEscuadra;
	}

	/**
	 * @return the listaCiclistas
	 */
	public ArrayList<CiclistaDTO> getListaCiclistas() {
		return listaCiclistas;
	}

	/**
	 * @param listaCiclistas the listaCiclistas to set
	 */
	public void setListaCiclistas(ArrayList<CiclistaDTO> listaCiclistas) {
		this.listaCiclistas = listaCiclistas;
	}

	/**
	 * @return the listaMasajistas
	 */
	public ArrayList<MasajistaDTO> getListaMasajistas() {
		return listaMasajistas;
	}

	/**
	 * @param listaMasajistas the listaMasajistas to set
	 */
	public void setListaMasajistas(ArrayList<MasajistaDTO> listaMasajistas) {
		this.listaMasajistas = listaMasajistas;
	}

	/**
	 * @return the listaDirectores
	 */
	public ArrayList<DirectorDeportivoDTO> getListaDirectores() {
		return listaDirectores;
	}

	/**
	 * @param listaDirectores the listaDirectores to set
	 */
	public void setListaDirectores(ArrayList<DirectorDeportivoDTO> listaDirectores) {
		this.listaDirectores = listaDirectores;
	}

}

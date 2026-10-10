/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.DirectorDeportivoDTO;

/**
 * Interface where the functions to create, update, delete, and display objects are established.
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public interface EscuadraOp {
	/**
	 * Function to add a user to the squad
	 * 
	 * @param idxEsc
	 * @param u
	 */
	void agregarUsuario(int idxEsc, UsuarioDTO u);

	/**
	 * Function to add a cyclist to the squad
	 * 
	 * @param escIndex
	 * @param c
	 */
	public void agregarCiclistaAEscuadra(int escIndex, CiclistaDTO c);

	/**
	 * Function to add a masseur to the squad
	 * 
	 * @param escIndex
	 * @param m
	 */
	public void agregarMasajistaAEscuadra(int escIndex, MasajistaDTO m);

	/**
	 * Function to add a sports director to the squad
	 * 
	 * @param escIndex
	 * @param d
	 */
	public void agregarDirectorAEscuadra(int escIndex, DirectorDeportivoDTO d);

	/**
	 * Function to read people from a squad
	 * 
	 * @param escIndex
	 * @return String
	 */
	public String leerPersonasDeEscuadra(int escIndex);

	/**
	 * Function to update a cyclist in a squad
	 * 
	 * @param escIndex
	 * @param indexCicl
	 * @param c
	 * @return String
	 */
	public String ActualizarCiclista(int escIndex, int indexCicl, CiclistaDTO c);

	/**
	 * Function to update a masseur in a squad
	 * 
	 * @param escIndex
	 * @param indexMas
	 * @param m
	 * @return
	 */
	public String ActualizarMasajista(int escIndex, int indexMas, MasajistaDTO m);

	/**
	 * Function to update a sports director in a squad
	 * 
	 * @param escIndex
	 * @param indexDir
	 * @param d
	 * @return
	 */
	public String ActualizarDirector(int escIndex, int indexDir, DirectorDeportivoDTO d);

	/**
	 * Function to delete a cyclist from a squad
	 * 
	 * @param escIndex
	 * @param indexCicl
	 * @return
	 */
	public String eliminarCiclista(int escIndex, int indexCicl);

	/**
	 * Function to delete a masseur from a squad
	 * 
	 * @param escIndex
	 * @param indexMas
	 * @return
	 */
	public String eliminarMasajista(int escIndex, int indexMas);

	/**
	 * Function to delete a sports director from a squad
	 * 
	 * @param escIndex
	 * @param indexDir
	 * @return
	 */
	public String eliminarDirector(int escIndex, int indexDir);
}

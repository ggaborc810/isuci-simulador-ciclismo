/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.DirectorDeportivoDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface.
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public class DirectorDeportivoDAO implements CRUDOperation<DirectorDeportivoDTO> {
	/**
	 * List of sports directors
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> sportsDirectorsList;

	/**
	 * Constructor of the DirectorDeportivoDAO class creates an instance of the list
	 * 
	 * @param sportsDirectorsList
	 */
	public DirectorDeportivoDAO(ArrayList<UsuarioDTO> sportsDirectorsList) {
		this.sportsDirectorsList = sportsDirectorsList;
		sportsDirectorsList = new ArrayList<>();
	}

	/**
	 * Function that creates a DirectorDeportivoDTO object
	 * 
	 * @return text message
	 */
	@Override
	public String create(DirectorDeportivoDTO data) {
		sportsDirectorsList.add(data);

		return "Sports director: \n" + data.toString() + "created.";
	}

	/**
	 * Function that updates the data of a DirectorDeportivoDTO type object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, DirectorDeportivoDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= sportsDirectorsList.size()) {
			return "The index has exceeded the size of the list, current size: " + sportsDirectorsList.size()
					+ " data";
		}
		sportsDirectorsList.set(index, newData);
		return "Sports director updated successfully";
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects as text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		sportsDirectorsList.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Function that deletes an object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String delete(int index) {
		if (index < 0 || index >= sportsDirectorsList.size()) {
			return "Sports director with index " + index + " not deleted.";

		} else {
			sportsDirectorsList.remove(index);
			return "Sports director with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of sports directors
	 * 
	 * @return sportsDirectorsList
	 */
	public ArrayList<UsuarioDTO> getSportsDirectorsList() {
		return sportsDirectorsList;
	}

	/**
	 * Sets the list of sports directors
	 * 
	 * @param sportsDirectorsList
	 */

	public void setSportsDirectorsList(ArrayList<UsuarioDTO> sportsDirectorsList) {
		this.sportsDirectorsList = sportsDirectorsList;
	}

}

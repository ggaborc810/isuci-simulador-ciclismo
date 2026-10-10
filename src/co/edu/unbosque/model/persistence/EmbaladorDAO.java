/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.EmbaladorDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface.
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public class EmbaladorDAO implements CRUDOperation<EmbaladorDTO> {
	/**
	 * List of packers
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> packersList;

	/**
	 * Constructor of the EmbaladorDAO class creates an instance of the list
	 * 
	 * @param packersList
	 */
	public EmbaladorDAO(ArrayList<UsuarioDTO> packersList) {
		this.packersList = packersList;
		packersList = new ArrayList<>();
	}

	/**
	 * Function that creates a EmbaladorDTO object
	 * 
	 * @return text message
	 */
	@Override
	public String create(EmbaladorDTO data) {
		packersList.add(data);
		return "Packer Cyclist: \n" + data.toString() + "created.";
	}

	/**
	 * Function that updates the data of a EmbaladorDTO type object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, EmbaladorDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= packersList.size()) {
			return "The index has exceeded the size of the list, current size: " + packersList.size()
					+ " data";
		}
		packersList.set(index, newData);
		return "Packer Cyclist updated successfully";
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects as text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		packersList.forEach((e) -> {
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
		if (index < 0 || index >= packersList.size()) {
			return "Packer Cyclist with index " + index + " not deleted.";

		} else {
			packersList.remove(index);
			return "Packer Cyclist with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of packers
	 * 
	 * @return packersList
	 */
	public ArrayList<UsuarioDTO> getPackersList() {
		return packersList;
	}

	/**
	 * Sets the list of packers
	 * 
	 * @param packersList
	 */
	public void setPackerList(ArrayList<UsuarioDTO> packersList) {
		this.packersList = packersList;
	}

}

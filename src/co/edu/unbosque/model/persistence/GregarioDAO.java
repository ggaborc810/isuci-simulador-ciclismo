/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.GregarioDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class GregarioDAO implements CRUDOperation<GregarioDTO> {
	/**
	 * List of gregarios
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaGregarios;

	/**
	 * Constructor of the GregarioDAO class creates an instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public GregarioDAO(ArrayList<UsuarioDTO> listaGregarios) {
		this.listaGregarios = listaGregarios;
		listaGregarios = new ArrayList<>();
	}

	/**
	 * Function that creates a GregarioDTO object
	 * 
	 * @return text message
	 */
	@Override
	public String create(GregarioDTO data) {
		listaGregarios.add(data);
		return "Cyclist Gregario: \n" + data.toString() + " created.";
	}

	/**
	 * Function that updates the data of a GregarioDTO type object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, GregarioDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaGregarios.size()) {
			return "The index has exceeded the size of the list, current size: " + listaGregarios.size() + " data";
		}
		listaGregarios.set(index, newData);
		return "Cyclist Gregario updated successfully";
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaGregarios.forEach((e) -> {
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
		if (index < 0 || index >= listaGregarios.size()) {
			return "Cyclist Gregario with index " + index + " not deleted.";

		} else {
			listaGregarios.remove(index);
			return "Cyclist Gregario with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of gregarios
	 * 
	 * @return listaGregarios
	 */
	public ArrayList<UsuarioDTO> getListaGregarios() {
		return listaGregarios;
	}

	/**
	 * Sets the list of gregarios
	 * 
	 * @param listaGregarios
	 */
	public void setListaGregarios(ArrayList<UsuarioDTO> listaGregarios) {
		this.listaGregarios = listaGregarios;
	}

}

/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.RodadorDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class RodadorDAO implements CRUDOperation<RodadorDTO> {

	/**
	 * List of rodadors
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaRodador;

	/**
	 * Constructor of the RodadorDAO class creates an instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public RodadorDAO(ArrayList<UsuarioDTO> listaRodador) {
		this.listaRodador = listaRodador;
		listaRodador = new ArrayList<>();
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaRodador.forEach((e) -> {
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
		if (index < 0 || index >= listaRodador.size()) {
			return "Cyclist Rodador with index " + index + " not deleted.";

		} else {
			listaRodador.remove(index);
			return "Cyclist Rodador with index " + index + " has been deleted.";

		}
	}

	/**
	 * Function that creates a RodadorDTO object
	 * 
	 * @return message in text form
	 */
	@Override
	public String create(RodadorDTO data) {
		listaRodador.add(data);
		return "Cyclist Rodador: \n" + data.toString() + "created.";
	}

	/**
	 * Function that updates the data of a CyclistDTO type object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, RodadorDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaRodador.size()) {
			return "The index has exceeded the size of the list, current size: " + listaRodador.size() + " data";
		}
		listaRodador.set(index, newData);
		return "Cyclist Rodador updated successfully";
	}

	/**
	 * Gets the list of rodadors
	 * 
	 * @return listaRodador
	 */
	public ArrayList<UsuarioDTO> getListaRodador() {
		return listaRodador;
	}

	/**
	 * Sets the list of rodadors
	 * 
	 * @param listaRodador
	 */
	public void setListaRodador(ArrayList<UsuarioDTO> listaRodador) {
		this.listaRodador = listaRodador;
	}

}

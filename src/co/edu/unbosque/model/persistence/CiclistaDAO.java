/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperarion interface.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class CiclistaDAO implements CRUDOperation<CiclistaDTO> {
	/**
	 * List of cyclists
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaCiclistas;

	/**
	 * Constructor of the CiclistaDAO class creates the instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public CiclistaDAO(ArrayList<UsuarioDTO> listaCiclistas) {
		this.listaCiclistas = listaCiclistas;
		listaCiclistas = new ArrayList<>();
	}

	public ArrayList<CiclistaDTO> LlenarListaCiclistas(ArrayList<UsuarioDTO> listaCiclistas) {

		ArrayList<CiclistaDTO> listaCiclistasAct = new ArrayList<CiclistaDTO>();

		for (int i = 0; i < listaCiclistas.size(); i++) {
			UsuarioDTO user = listaCiclistas.get(i);
			if (user instanceof CiclistaDTO)
				listaCiclistasAct.add((CiclistaDTO) user);
		}
		return listaCiclistasAct;
	}

	/**
	 * Function that creates an object of CiclistaDTO
	 * 
	 * @return message as text
	 */
	@Override
	public String create(CiclistaDTO data) {
		listaCiclistas.add(data);
		return "Cyclist: \n" + data.toString() + "created.";
	}

	/**
	 * Function that displays all the objects in the list
	 * 
	 * @return the objects as text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaCiclistas.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Function that updates the data of an object of type CiclistaDTO from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, CiclistaDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaCiclistas.size()) {
			return "The index has exceeded the size of the list, current size: " + listaCiclistas.size() + " data";
		}
		listaCiclistas.set(index, newData);
		return "Cyclist updated successfully";
	}

	/**
	 * Function that deletes an object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String delete(int index) {
		if (index < 0 || index >= listaCiclistas.size()) { // Verifies if the index is out of bounds
			return "Cyclist with index " + index + " not deleted.";

		} else {
			listaCiclistas.remove(index);
			return "Cyclist with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of cyclists
	 * 
	 * @return listaCiclistas
	 */
	public ArrayList<UsuarioDTO> getListaCiclistas() {
		return listaCiclistas;
	}

	/**
	 * Sets the list of cyclists
	 * 
	 * @param listaCiclistas
	 */
	public void setListaCiclistas(ArrayList<UsuarioDTO> listaCiclistas) {
		this.listaCiclistas = listaCiclistas;
	}

}

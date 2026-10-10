/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ClasicoManoDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class ClasicoManoDAO implements CRUDOperation<ClasicoManoDTO> {
	/**
	 * List of classic hand cyclists
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaClasicoManos;

	/**
	 * Constructor of the ClasicoManoDAO class creates the instance of the list
	 * 
	 * @param listaClasicoManos
	 */
	public ClasicoManoDAO(ArrayList<UsuarioDTO> listaClasicoManos) {
		this.listaClasicoManos = listaClasicoManos;
		listaClasicoManos = new ArrayList<>();
	}

	public ArrayList<ClasicoManoDTO> LlenarListaClasicoManos(ArrayList<UsuarioDTO> listaClasicoManos) {

		ArrayList<ClasicoManoDTO> listaClasicoManosAc = new ArrayList<ClasicoManoDTO>();

		for (int i = 0; i < listaClasicoManos.size(); i++) {
			UsuarioDTO user = listaClasicoManos.get(i);
			if (user instanceof ClasicoManoDTO)
				listaClasicoManosAc.add((ClasicoManoDTO) user);
		}
		return listaClasicoManosAc;
	}

	/**
	 * Function that creates an object of ClasicoManoDTO
	 * 
	 * @return message in text form
	 */
	@Override
	public String create(ClasicoManoDTO data) {
		listaClasicoManos.add(data);
		return "Cyclist Classic Hand: \n" + data.toString() + "created.";
	}

	/**
	 * Function that updates the data of an object of type ClasicoManoDTO from the
	 * list
	 * 
	 * @return text type message
	 */
	@Override
	public String update(int index, ClasicoManoDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaClasicoManos.size()) {
			return "The index has exceeded the size of the list, current size: " + listaClasicoManos.size() + " data";
		}
		listaClasicoManos.set(index, newData);
		return "Cyclist Classic Hand updated successfully";
	}

	/**
	 * Function that shows all the objects in the list
	 * 
	 * @return the objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaClasicoManos.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	/**
	 * Function that deletes an object from the list
	 * 
	 * @return text type message
	 */
	@Override
	public String delete(int index) {
		if (index < 0 || index >= listaClasicoManos.size()) {
			return "Cyclist Classic Hand with index " + index + " not deleted.";

		} else {
			listaClasicoManos.remove(index);
			return "Cyclist Classic Hand with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of classic hand cyclists
	 * 
	 * @return listaClasicoManos
	 */
	public ArrayList<UsuarioDTO> getListaClasicoManos() {
		return listaClasicoManos;
	}

	/**
	 * Sets the list of classic hand cyclists
	 * 
	 * @param listaClasicoManos
	 */
	public void setListaClasicoManos(ArrayList<UsuarioDTO> listaClasicoManos) {
		this.listaClasicoManos = listaClasicoManos;
	}

}

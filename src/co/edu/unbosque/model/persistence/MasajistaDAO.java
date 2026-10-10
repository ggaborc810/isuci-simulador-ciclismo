/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class MasajistaDAO implements CRUDOperation<MasajistaDTO> {
	/**
	 * List of massage therapists
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaMajistas;

	/**
	 * Constructor of the MasajistaDAO class creates an instance of the list
	 * 
	 * @param listaCiclistas
	 */
	public MasajistaDAO(ArrayList<UsuarioDTO> listaMajistas) {
		this.listaMajistas = listaMajistas;
		listaMajistas = new ArrayList<>();
	}

	public ArrayList<MasajistaDTO> LlenarListaMasajistas(ArrayList<UsuarioDTO> listaMasajistas) {

		ArrayList<MasajistaDTO> listaMasajistasAct = new ArrayList<MasajistaDTO>();

		for (int i = 0; i < listaMasajistas.size(); i++) {
			UsuarioDTO user = listaMasajistas.get(i);
			if (user instanceof MasajistaDTO)
				listaMasajistasAct.add((MasajistaDTO) user);
		}
		return listaMasajistasAct;
	}

	/**
	 * Function that displays all objects in the list
	 * 
	 * @return objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaMajistas.forEach((e) -> {
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
		if (index < 0 || index >= listaMajistas.size()) {
			return "Masseur with index " + index + " not deleted.";

		} else {
			listaMajistas.remove(index);
			return "Masseur with index " + index + " has been deleted.";

		}
	}

	/**
	 * Function that creates a MasajistaDTO object
	 * 
	 * @return text message
	 */
	@Override
	public String create(MasajistaDTO data) {
		listaMajistas.add(data);
		return "Masseur: \n" + data.toString() + " created.";
	}

	/**
	 * Function that updates the data of a MasajistaDTO type object from the list
	 * 
	 * @return text message
	 */
	@Override
	public String update(int index, MasajistaDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaMajistas.size()) {
			return "The index has exceeded the size of the list, current size: " + listaMajistas.size() + " data";
		}
		listaMajistas.set(index, newData);
		return "Masseur updated successfully";
	}

	/**
	 * Gets the list of massage therapists
	 * 
	 * @return listaMajistas
	 */
	public ArrayList<UsuarioDTO> getListaMajistas() {
		return listaMajistas;
	}

	/**
	 * Sets the list of massage therapists
	 * 
	 * @param listaMajistas
	 */
	public void setListaMajistas(ArrayList<UsuarioDTO> listaMajistas) {
		this.listaMajistas = listaMajistas;
	}

}

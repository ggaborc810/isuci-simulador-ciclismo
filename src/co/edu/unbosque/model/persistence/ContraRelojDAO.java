/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ContraRelojDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Class where objects can be created, updated, deleted, and displayed.
 * Implements the functions of the CRUDOperation interface.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class ContraRelojDAO implements CRUDOperation<ContraRelojDTO> {
	/**
	 * List of time trialists
	 * 
	 * @type ArrayList<>
	 */
	private ArrayList<UsuarioDTO> listaContrarelojistas;

	/**
	 * Constructor of the ContraRelojDAO class creates the instance of the list
	 * 
	 * @param listaContrarelojistas
	 */
	public ContraRelojDAO(ArrayList<UsuarioDTO> listaContrarelojistas) {
		this.listaContrarelojistas = listaContrarelojistas;
		listaContrarelojistas = new ArrayList<>();
	}

	/**
	 * Function that creates an object of ContraRelojDTO
	 * 
	 * @return message in text form
	 */
	@Override
	public String create(ContraRelojDTO data) {
		listaContrarelojistas.add(data);
		return "Time trial cyclist: \n" + data.toString() + "created.";
	}

	/**
	 * Function that updates the data of an object of type ContraRelojDTO from the
	 * list
	 * 
	 * @return text type message
	 */
	@Override
	public String update(int index, ContraRelojDTO newData) {
		if (index < 0) {
			return "Positions cannot be negative";
		}
		if (index >= listaContrarelojistas.size()) {
			return "The index has exceeded the size of the list, current size: " + listaContrarelojistas.size()
					+ " data";
		}
		listaContrarelojistas.set(index, newData);
		return "Time trial cyclist updated successfully";
	}

	/**
	 * Function that shows all the objects in the list
	 * 
	 * @return the objects in text
	 */
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaContrarelojistas.forEach((e) -> {
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
		if (index < 0 || index >= listaContrarelojistas.size()) {
			return "Time trial cyclist with index " + index + " not deleted.";

		} else {
			listaContrarelojistas.remove(index);
			return "Time trial cyclist with index " + index + " has been deleted.";

		}
	}

	/**
	 * Gets the list of time trialists
	 * 
	 * @return listaContrarelojistas
	 */
	public ArrayList<UsuarioDTO> getListaContrarelojistas() {
		return listaContrarelojistas;
	}

	/**
	 * Sets the list of time trialists
	 * 
	 * @param listaContrarelojistas
	 */
	public void setListaContrarelojistas(ArrayList<UsuarioDTO> listaContrarelojistas) {
		this.listaContrarelojistas = listaContrarelojistas;
	}

}

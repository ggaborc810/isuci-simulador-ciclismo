/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

/**
 * Interface where the functions to create, update, delete, and display objects are established.
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public interface CRUDOperation<E> {

	/**
	 * Function to create an Object
	 * 
	 * @param data
	 * @return String
	 */
	public String create(E data);

	/**
	 * Function to read all objects from a list
	 * 
	 * @return String
	 */
	public String readAll();

	/**
	 * Function to update the data of an object in the list
	 * 
	 * @param index
	 * @param newData
	 * @return
	 */
	public String update(int index, E newData);

	/**
	 * Function to delete an object from the list
	 * 
	 * @param index
	 * @return
	 */
	public String delete(int index);
}

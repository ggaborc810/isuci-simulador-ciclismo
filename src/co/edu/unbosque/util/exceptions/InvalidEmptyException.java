/**
 * package to store classes that handle application exceptions
 */

package co.edu.unbosque.util.exceptions;

/**
 * Class Exception thrown when an invalid empty text is encountered.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class InvalidEmptyException extends Exception{

	/**
     * Constructs an InvalidEmptyException with a default error message.
     */
	public InvalidEmptyException() {
		super("No se pueden enviar espacios vacios");
	}
	
}

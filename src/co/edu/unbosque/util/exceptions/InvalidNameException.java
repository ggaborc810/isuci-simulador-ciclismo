/**
 * package to store classes that handle application exceptions
 */

package co.edu.unbosque.util.exceptions;

/**
 * Class where the exception of mistyping the name can be handled.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class InvalidNameException extends Exception{

		/**
		 * Function that will return a text message for name exceptions.
		 */
	public InvalidNameException() {
		super("The username cannot have symbols, please enter it again");
	}

}

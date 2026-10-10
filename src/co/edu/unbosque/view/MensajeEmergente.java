/**
 * package in charge of storing the entire graphical user interface
*/

package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JOptionPane;

/**
 * A utility class for displaying popup messages.
 * Extends the JOptionPane class to leverage its dialog display capabilities.
 */
public class MensajeEmergente extends JOptionPane {

    /**
     * Default constructor for MensajeEmergente.
     */
    public MensajeEmergente() {
    }

    /**
     * Displays a popup message dialog with the provided message.
     *
     * @param mensaje The message to be displayed in the dialog.
     */
    public static void mostrarMensaje(String mensaje) {
        showMessageDialog(null, mensaje);
    }
}
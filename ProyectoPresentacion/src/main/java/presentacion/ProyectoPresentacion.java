package presentacion;

import interfaz.formPrincipal;

/**
 * Clase principal que inicia la presentación del proyecto.
 * Esta clase contiene el método main que crea y muestra el formulario principal del proyecto.
 * @author Adriana
 */
public class ProyectoPresentacion {

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia del formulario principal y lo hace visible.
     * @param args Los argumentos de la línea de comandos (no utilizado en este caso).
     */
    public static void main(String[] args) {
        // Crear instancia del formulario principal
        formPrincipal principal = new formPrincipal();
        //Hacer visible el formulario principal
        principal.setVisible(true);
    }
}

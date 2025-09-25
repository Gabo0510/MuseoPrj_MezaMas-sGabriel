package PrjMuseo;

/**
 * La clase Persona representa a un visitante del museo con información personal
 * y la capacidad de tener asignado un boleto de entrada.
 * 
 * <p>Esta clase almacena los datos básicos de una persona y gestiona su asociación
 * con un boleto del museo mediante una relación de composición.</p>
 * 
 * @author Meza Masís Gabriel
 * @see BoletoMuseo
 */

public class Persona {
    
    /**
     * El nombre completo de la persona.
     * <p>No puede ser nulo, pero puede estar vacío.</p>
     */
    private String nombre;
    
    /**
     * Número de identificación oficial de la persona (DNI, pasaporte, etc.).
     * <p>Puede ser nulo si la persona no ha proporcionado identificación.</p>
     */
    private String identificacion;
    
    /**
     * El boleto de museo asignado a esta persona.
     * <p>Es nulo si la persona no tiene un boleto asignado.</p>
     */
    private BoletoMuseo miBoleto;

    /**
     * Constructor que crea una Persona con nombre e identificación.
     * 
     * @param nombre El nombre completo de la persona (no puede ser nulo)
     * @param ident La identificación oficial de la persona (puede ser nulo)
     * @see #Persona(String)
     */
    public Persona(String nombre, String ident) {
        this(nombre);  // Reutiliza el constructor de un parámetro
        identificacion = ident;
    }

    /**
     * Constructor que crea una Persona solo con nombre.
     * <p>La identificación se inicializa como nula y debe establecerse posteriormente
     * usando {@link #setIdentificacion(String)}.</p>
     * 
     * @param nombre El nombre completo de la persona (no puede ser nulo)
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        // identificacion se inicializa implícitamente como null
        // miBoleto se inicializa implícitamente como null
    }

    /**
     * Establece o actualiza la identificación de la persona.
     * 
     * @param pIdentificacion La nueva identificación (puede ser nulo)
     */
    public void setIdentificacion(String pIdentificacion) {
        identificacion = pIdentificacion;
    }

    /**
     * Asigna un boleto de museo a esta persona.
     * <p>Si ya tenía un boleto asignado, será reemplazado por el nuevo.</p>
     * 
     * @param pMiBoleto El boleto a asignar (no debe ser nulo)
     * @throws NullPointerException Si el boleto proporcionado es nulo
     * @see BoletoMuseo
     */
    public void asignarBoleto(BoletoMuseo pMiBoleto) {
        miBoleto = pMiBoleto;
    }

    /**
     * Consulta el número del boleto asignado a esta persona.
     * 
     * @return El número del boleto asignado
     * @throws NullPointerException Si no hay ningún boleto asignado
     * @see BoletoMuseo#getNumeroBoleto()
     */
    public int consultarMiNumeroDeBoleto() {
        return miBoleto.getNumeroBoleto();
    }

    /**
     * Devuelve una representación en formato String de la información de la persona.
     * <p>El formato incluye nombre, identificación y estado del boleto asignado.</p>
     * 
     * @return Una cadena con la información completa de la persona
     * @see Object#toString()
     */
    @Override
    public String toString() {
        String msg = "Persona\n";
        msg += " Nombre: " + nombre + "\n";
        msg += " Identificacion: " + identificacion + "\n";
        
        if (miBoleto != null) {
            msg += " Boleto asignado: #" + miBoleto.getNumeroBoleto() + "\n";
        } else {
            msg += " Boleto asignado: (ninguno)\n";
        }
        
        return msg;
    }
}
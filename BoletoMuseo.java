package PrjMuseo;

/**
 * La clase BoletoMuseo representa un boleto de entrada al museo con información
 * sobre su precio, número único y fecha de emisión.
 * 
 * <p>Cada boleto tiene un número único autoincremental generado automáticamente
 * y una fecha de emisión correspondiente al día actual.</p>
 * 
 * <p><b>Características principales:</b>
 * <ul>
 *   <li>Números de boleto únicos y secuenciales</li>
 *   <li>Registro automático de fecha de emisión</li>
 *   <li>Seguimiento del total de boletos creados</li>
 * </ul>
 * 
 * @author Meza Masís Gabriel
 * @see LocalDate
 * @see DateTimeFormatter
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoMuseo {
    
    /**
     * El precio del boleto en unidades monetarias.
     * <p>El precio debe ser un valor positivo.</p>
     */
    private double precio;
    
    /**
     * Número único que identifica este boleto.
     * <p>Se genera automáticamente y es secuencial.</p>
     */
    private int numeroBoleto;
    
    /**
     * Fecha en que fue emitido el boleto, en formato "yyyy-MM-dd".
     * <p>Se establece automáticamente al crear el boleto.</p>
     */
    private String fechaEmision;
    
    /**
     * Contador estático que lleva el registro de todos los boletos creados.
     * <p>Este contador es compartido por todas las instancias de BoletoMuseo
     * y se incrementa automáticamente con cada nuevo boleto.</p>
     */
    private static int contador = 0;

    /**
     * Constructor que crea un nuevo boleto de museo con el precio especificado.
     * 
     * <p>Al crear un boleto:
     * <ul>
     *   <li>Se incrementa el contador estático</li>
     *   <li>Se asigna un número único secuencial</li>
     *   <li>Se registra la fecha actual como fecha de emisión</li>
     * </ul>
     * 
     * @param precio El precio del boleto (debe ser mayor a 0)
     * @throws IllegalArgumentException Si el precio es menor o igual a 0
     */
    public BoletoMuseo(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
        contador++;
        this.numeroBoleto = contador;
        this.fechaEmision = establecerFechaEmisionBoleto();
    }

    /**
     * Establece la fecha de emisión del boleto con la fecha actual.
     * 
     * <p>La fecha se formatea como "aaaa-MM-dd" (ej: "2024-01-15").</p>
     * 
     * @return La fecha actual formateada como cadena
     * @see LocalDate#now()
     * @see DateTimeFormatter#ofPattern(String)
     */
    private String establecerFechaEmisionBoleto() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(formateador);
    }

    /**
     * Obtiene el número total de boletos creados hasta el momento.
     * 
     * @return El valor actual del contador estático de boletos
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Obtiene el número único de identificación de este boleto.
     * 
     * @return El número asignado a este boleto
     */
    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    /**
     * Obtiene el precio del boleto.
     * 
     * @return El precio en unidades monetarias
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene la fecha de emisión del boleto.
     * 
     * @return La fecha de emisión en formato "yyyy-MM-dd"
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Devuelve una representación en formato String de la información del boleto.
     * 
     * <p>El formato incluye:
     * <ul>
     *   <li>Número de boleto</li>
     *   <li>Precio</li>
     *   <li>Fecha de emisión</li>
     * </ul>
     * 
     * @return Una cadena con la información completa del boleto
     * @see Object#toString()
     */
    @Override
    public String toString() {
        String msg = "BoletoMuseo\n";
        msg += " Numero: " + numeroBoleto + "\n";
        msg += " Precio: " + precio + "\n";
        msg += " Fecha Emision: " + fechaEmision;
        return msg;
    }
}
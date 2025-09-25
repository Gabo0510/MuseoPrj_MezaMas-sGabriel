package PrjMuseo;

/**
 * La clase VentaDelDia representa el registro de ventas de boletos del museo para un día específico.
 * 
 * <p>Esta clase permite:
 * <ul>
 *   <li>Registrar boletos vendidos en una fecha específica</li>
 *   <li>Calcular el total de ventas del día</li>
 *   <li>Generar reportes detallados de las ventas</li>
 *   <li>Llevar un inventario de boletos vendidos por fecha</li>
 * </ul>
 * 
 * <p><b>Características:</b>
 * <ul>
 *   <li>Fecha automática del sistema</li>
 *   <li>Lista dinámica de boletos vendidos</li>
 *   <li>Cálculo automático de totales</li>
 * </ul>
 * 
 * @author Meza Masís Gabriel
 * @see BoletoMuseo
 * @see LocalDate
 * @see ArrayList
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VentaDelDia {
    
    /**
     * La fecha en que se realizaron las ventas, en formato "yyyy-MM-dd".
     * <p>Se establece automáticamente al crear la instancia y representa el día actual.</p>
     */
    private String fechaDeLaVenta;
    
    /**
     * Lista que contiene todos los boletos vendidos en esta fecha.
     * <p>La lista se inicializa vacía y se va llenando conforme se registran ventas.</p>
     */
    private List<BoletoMuseo> boletosVendidos;

    /**
     * Constructor que crea un nuevo registro de ventas para el día actual.
     * 
     * <p>Al crear una instancia:
     * <ul>
     *   <li>Se establece la fecha actual automáticamente</li>
     *   <li>Se inicializa una lista vacía para los boletos vendidos</li>
     * </ul>
     */
    public VentaDelDia() {
        fechaDeLaVenta = establecerFechaDeLaVenta();
        boletosVendidos = new ArrayList<>();
    }

    /**
     * Registra un boleto vendido en el registro del día.
     * 
     * <p>El boleto se añade a la lista de boletos vendidos y estará incluido
     * en los cálculos de totales y reportes.</p>
     * 
     * @param boleto El boleto vendido que se desea registrar (no puede ser nulo)
     * @throws IllegalArgumentException Si el boleto proporcionado es nulo
     * @see #calcularTotalVentaDelDia()
     * @see #toString()
     */
    public void registrarVentaBoleto(BoletoMuseo boleto) {
        if (boleto == null) {
            throw new IllegalArgumentException("El boleto no puede ser nulo");
        }
        boletosVendidos.add(boleto);
    }

    /**
     * Calcula el total de ventas del día sumando los precios de todos los boletos vendidos.
     * 
     * @return El monto total de ventas del día. Retorna 0.0 si no hay boletos vendidos.
     */
    public double calcularTotalVentaDelDia() {
        double total = 0.0;
        for (BoletoMuseo b : boletosVendidos) {
            total += b.getPrecio();
        }
        return total;
    }

    /**
     * Establece la fecha de la venta con la fecha actual del sistema.
     * 
     * <p>La fecha se formatea como "aaaa-MM-dd" (ej: "2024-01-15").</p>
     * 
     * @return La fecha actual formateada como cadena
     * @see LocalDate#now()
     * @see DateTimeFormatter#ofPattern(String)
     */
    private String establecerFechaDeLaVenta() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(formateador);
    }

    /**
     * Obtiene la cantidad de boletos vendidos en el día.
     * 
     * @return El número total de boletos vendidos
     */
    public int getCantidadBoletosVendidos() {
        return boletosVendidos.size();
    }

    /**
     * Obtiene la fecha de las ventas registradas.
     * 
     * @return La fecha en formato "yyyy-MM-dd"
     */
    public String getFechaDeLaVenta() {
        return fechaDeLaVenta;
    }

    /**
     * Obtiene la lista de boletos vendidos (copia defensiva).
     * 
     * @return Una nueva lista con los boletos vendidos
     */
    public List<BoletoMuseo> getBoletosVendidos() {
        return new ArrayList<>(boletosVendidos); // Copia defensiva
    }

    /**
     * Devuelve una representación detallada en formato String de las ventas del día.
     * 
     * <p>El reporte incluye:
     * <ul>
     *   <li>Fecha de las ventas</li>
     *   <li>Cantidad total de boletos vendidos</li>
     *   <li>Detalle individual de cada boleto (número y precio)</li>
     *   <li>Total de ventas del día</li>
     * </ul>
     * 
     * @return Un reporte completo de las ventas del día formateado como cadena
     * @see Object#toString()
     */
    @Override
    public String toString() {
        String msg = "VentaDelDia\n";
        msg += " Fecha: " + fechaDeLaVenta + "\n";
        msg += " Cantidad de boletos: " + boletosVendidos.size() + "\n";
        msg += " Detalle:\n";
        
        for (BoletoMuseo b : boletosVendidos) {
            msg += " - Boleto #" + b.getNumeroBoleto() + " | $" + b.getPrecio() + "\n";
        }
        
        msg += " Total: $" + calcularTotalVentaDelDia();
        return msg;
    }
}
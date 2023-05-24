package encaje;
/**
 * Clase Banco. Esta clase contiene las variables y los parametros
 * necesarios para inicializar la prueba de funcionamiento del sistema de Encaje.
 *  
 * @version 1.0
 * 
 * @author Ivan Glinka
 * @author Tobias Flores
 * @author Matias Mena Da Dalt
 */

public class Banco {
	/**
	 *  El valor de los depositos de las familias y empresas iniciales
	 *  se guarda en la variable depositos iniciales. */
	private float depositos_Iniciales;
		
	/**
	 * Los Préstamos que dan los bancos a otras familias y empresas.  */
	private float prestamos_Iniciales;
		
	/**
	 * Porcentaje de los depositos que se agrega a las reservas del banco.	
	 */
	private float encaje;
		
	/**
	 *  Nos permitirá mostrar en pantalla cada uno de los calculos que se realizarán.
	 */
	protected String lista = "";
		
	public Banco(float depositos, float prestamos, float encaje) {
		this.depositos_Iniciales = depositos;
		this.prestamos_Iniciales = prestamos;
		this.encaje = encaje;
	}
		
		
	/**
	 * Método que se encarga de calcular el resultado de los prestamos,
	 * en base al Encaje y al valor de deposito inicial.
	 */
	public void calcularResultado() { 
		// DECLARACION DE VARIABLES LOCALES
		/**
		 * Como EncajeLocal es un porcentaje, se lo divide por 100
		 */
		float encajeLocal = encaje/100;         
			
		/**
		 * Las reservas se encuentran constituidas 
		 * por el porcentaje de los depositos que se determina en 
		 * la variable encajeLocal.	
		 */
		float reservas = encajeLocal * depositos_Iniciales;
			
		
		 // El banco no puede prestar las reservas, 
		 // asi que no se tienen en cuenta para los prestamos.	
		prestamos_Iniciales = depositos_Iniciales - reservas;  
			
		float reservasAcumuladas = 0;
		float prestamosAcumulados = 0;	
		float depositosAcumulados = 0;
			
		/**
		 * Muestra la cantidad de veces que puede prestarse el dinero,
		 *  en base a un deposito inicial	
		 */
		int iteraciones = 0;	
			
		// Titulo de la tabla resultados:
		lista += "Reservas \t||  " + "Depositos \t ||  " + "Prestamos   || "+
				 "Iteraciones" + "\n";
			
		while (prestamos_Iniciales > 1) {//Mientras haya un prestamo, hay circulacion del dinero.
		
		reservasAcumuladas += reservas;
		prestamosAcumulados += prestamos_Iniciales;
		depositosAcumulados += depositos_Iniciales;
		depositos_Iniciales = prestamos_Iniciales;
		reservas = encajeLocal * depositos_Iniciales;
		prestamos_Iniciales = depositos_Iniciales - reservas;
	
		iteraciones++;
		
		// se escribe el dato en la variable lista
		lista += String.format("%-12.2f\t||%12.2f  ||%12.2f  ||%3d\n",reservasAcumuladas, 
					    											     depositosAcumulados,
					    											     prestamosAcumulados, 
					    											     iteraciones);		
		}
		
	} // Fin calcularResultado


	public float getDepositos() {
		return depositos_Iniciales;
		}
		
	public void setDepositos(float depositos) {
		this.depositos_Iniciales = depositos;
		}
	
	public float getPrestamos() {
		return prestamos_Iniciales;
		}

	public void setPrestamos(float prestamos) {
		this.prestamos_Iniciales = prestamos;
		}

	public float getEncaje() {
		return encaje;
		}

	public void setEncaje(float encaje) {
		this.encaje = encaje;
		}
}

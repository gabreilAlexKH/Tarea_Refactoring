package habitacion;

import cliente.Cliente;

public class HabitacionSuite extends Habitacion {
	
	public HabitacionSuite(int dia, int mes, int anyo, int numeroHabitacion, int diasEstancia,  
			Cliente cliente,boolean ocupada, boolean fumadores,int precioSuite, Extras extras){
		super(dia,  mes,  anyo, numeroHabitacion, diasEstancia, cliente, ocupada, fumadores);
		this.precio=precioSuite;
		this.extras=extras;
	}
}
	
	

package habitacion;

import cliente.Cliente;

public class HabitacionDoble extends Habitacion{
	
	public HabitacionDoble(int dia, int mes, int anyo, int numeroHabitacion, int diasEstancia,
			Cliente cliente, boolean ocupada, boolean fumadores, int precioHabitacionDoble, Extras extras){
		super(dia,  mes,  anyo, numeroHabitacion, diasEstancia, cliente, ocupada, fumadores);
		this.precio=precioHabitacionDoble;
		this.extras=extras;
		
	}
	
	

}

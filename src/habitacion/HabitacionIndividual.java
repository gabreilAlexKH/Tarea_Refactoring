package habitacion;

import cliente.Cliente;

public class HabitacionIndividual extends Habitacion {
	
	public HabitacionIndividual(int dia, int mes, int anyo, int numeroHabitacion, int diasEstancia, 
			Cliente cliente,boolean ocupada, boolean fumadores, int precioIndividual, Extras extras){
		super(dia, mes, anyo,  numeroHabitacion,  diasEstancia, cliente, ocupada,fumadores);
		this.precio=precioIndividual;
		this.extras=extras;
	}

}

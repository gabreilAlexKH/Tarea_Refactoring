package manejoColleciones;

import java.util.LinkedList;
import java.util.ListIterator;
import cliente.Cliente;
import habitacion.Habitacion;
public class HabitacionesCollection {
	
	private LinkedList<Habitacion> habitaciones;
	
	
	
	public HabitacionesCollection() {
		super();
		habitaciones = new LinkedList<Habitacion>();
	}



	public void addHabitacion( Habitacion Habitacion ) {
		
		habitaciones.addFirst(Habitacion);
	}

	
	public Habitacion getHabitacionCliente (String cliente_DNI) {
		
    	ListIterator<Habitacion> itr= habitaciones.listIterator(habitaciones.size());
    	Habitacion habitacion = null;    	

		while(itr.hasNext()){
			habitacion= itr.next();
			Cliente cliente = habitacion.getDatosReserva().getCliente();
			String DNI = cliente.getId().getDNI();
			
			if(cliente_DNI.equals(DNI)){
				return habitacion;
			}
		}
		return null;
	}

	public LinkedList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
    
    
    
    

}

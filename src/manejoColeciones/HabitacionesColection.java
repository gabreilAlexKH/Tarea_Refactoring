package manejoColeciones;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import cliente.Cliente;
import habitacion.Habitacion;
public class HabitacionesColection {
	
	private LinkedList<Habitacion> habitaciones;
	
	
	
	public HabitacionesColection() {
		super();
		habitaciones = new LinkedList<Habitacion>();
	}



	public void addHabitacion( Habitacion habitacion ) {
		
		habitaciones.addFirst(habitacion);
	}

	
	public Habitacion getHabitacionCliente (String cliente_DNI) {
		
		Iterator<Habitacion>itr= habitaciones.iterator();
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

	public List<Habitacion> getHabitaciones() {
		
		return Collections.unmodifiableList(habitaciones);
	}
    
    
    
    

}

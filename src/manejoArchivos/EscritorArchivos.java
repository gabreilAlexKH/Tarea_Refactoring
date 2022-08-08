package manejoArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cliente.Cliente;
import cliente.ID;
import habitacion.FichaReserva;
import habitacion.Habitacion;

public class EscritorArchivos {
	
	/**
	 * Metodo para escribir clientes, en un fichro de texto
	 * @param todosClientes
	 * @param Fich
	 */
	
	public static void escribirClientes(List<Cliente>todosClientes){
		Iterator<Cliente>itr= todosClientes.iterator();
		String ruta= "clientes.txt";
		File archivo = new File(ruta);
		BufferedWriter bw = null;
		if(archivo.exists()) {
			  try {
				bw = new BufferedWriter(new FileWriter(archivo));
	            bw.write("-. ");
	            	while(itr.hasNext()){
	            		Cliente cliente=itr.next();
	                   bw.write("Nombre: "+ cliente.getNombre()+"\n"
	                		+   "Apellidos: "+cliente.getApellidos()+"\n"
	                		+   "DNI: "+ cliente.getId().getVISA()+"\n"); 
	            	}
	            	bw.flush();
	            } catch (IOException e) {
				e.printStackTrace();
			}
		      
		} else {
			try {
				bw = new BufferedWriter(new FileWriter(archivo));
				bw.write("Los clientes que tiene el hotel son: \n");
	            bw.write("-------------------------------------\n");
	            bw.write("-. ");
				while(itr.hasNext()){
	        		Cliente cliente=itr.next();
	               bw.write("Nombre: "+ cliente.getNombre()+"\n"
	            	     	+"Apellidos: "+cliente.getApellidos()+"\n"
	            		    +"DNI: "+ cliente.getId().getVISA()+"\n"); 
	        	}
				bw.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
		 }
	}
	
	/**
     * Metodo para escribir las reservas del hotel en un fichero de texto
     * @param todasHabitaciones
     * @param Fich
     */
    public static void escribirReservas(List<Habitacion>todasHabitaciones){
    	Iterator<Habitacion>itr= todasHabitaciones.iterator();
		String ruta= "reservas.txt";
		File archivo = new File(ruta);
		BufferedWriter bw = null;
		if(archivo.exists()) {
			  try {
				bw = new BufferedWriter(new FileWriter(archivo));
	            bw.write("-. ");
	            	while(itr.hasNext()){
	            		Habitacion habitacion=itr.next();
	            		FichaReserva datosReserva= habitacion.getDatosReserva();
		        		Cliente cliente = datosReserva.getCliente();
		        		ID id = cliente.getId();
		               bw.write(cliente.getNombre()+" " + cliente.getApellidos() +" con DNI: "+ id.getDNI()+" y tarjeta VISA:"
		                		+id.getVISA()+"\n"+"Tiene una reserva el dia "+ datosReserva.getDate().toString()+" en la habitacion"
		                	    +habitacion.getNumeroHabitacion());
	            	}
	            	bw.flush();
	            	bw.close();
	            } catch (IOException e) {
				e.printStackTrace();
			}
		      
		} else {
			try {
				bw = new BufferedWriter(new FileWriter(archivo));
				bw.write("Los clientes que tiene el hotel son: \n");
	            bw.write("-------------------------------------\n");
	            bw.write("-. ");
				while(itr.hasNext()){
	        		Habitacion habitacion=itr.next();
	        		FichaReserva datosReserva= habitacion.getDatosReserva();
	        		Cliente cliente = datosReserva.getCliente();
	        		ID id = cliente.getId();
	               bw.write(cliente.getNombre()+" " + cliente.getApellidos() +" con DNI: "+ id.getDNI()+" y tarjeta VISA:"
	                		+id.getVISA()+"\n"+"Tiene una reserva el dia "+ datosReserva.getDate().toString()+" en la habitacion"
	                	    +habitacion.getNumeroHabitacion());
				}
	               bw.flush();
	               bw.close();
	        	
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
		 }

    }
}   

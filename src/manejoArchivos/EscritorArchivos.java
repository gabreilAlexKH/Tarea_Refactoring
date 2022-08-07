package manejoArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import cliente.Cliente;
import habitacion.Habitacion;

public class EscritorArchivos {
	
	/**
	 * Metodo para escribir clientes, en un fichro de texto
	 * @param todosClientes
	 * @param Fich
	 */
	
	public static void escribirClientes(LinkedList<Cliente>todosClientes,String Fich){
		Iterator<Cliente>itr= todosClientes.iterator();
		String ruta= "clientes.txt";
		File archivo = new File(ruta);
		BufferedWriter bw = null;
		if(archivo.exists()) {
			  try {
				
	            bw.write("-. ");
	            	while(itr.hasNext()){
	            		Cliente cliente=itr.next();
	                   bw.write("Nombre: "+ cliente.getNombre()+"\n"
	                		+   "Apellidos: "+cliente.getApellidos()+"\n"
	                		+   "DNI: "+ cliente.getVISA()+"\n"); 
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
	            		    +"DNI: "+ cliente.getVISA()+"\n"); 
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
    public static void escribirReservas(LinkedList<Habitacion>todasHabitaciones, String Fich){
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
	            		bw.write(habitacion.getCliente().getNombre()+" " + habitacion.getCliente().getApellidos() +" con DNI: "+ habitacion.getCliente().getDNI()+" y tarjeta VISA: "
		                		+habitacion.getCliente().getVISA()+"\n"+"Tiene una reserva el dia "+habitacion.getDia()+"/"+habitacion.getMes()+"/"+habitacion.getAnyo()+" en la habitacion "
		                	    +habitacion.getNumeroHabitacion());    
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
	        		Habitacion habitacion=itr.next();
	               bw.write(habitacion.getCliente().getNombre()+" " + habitacion.getCliente().getApellidos() +" con DNI: "+ habitacion.getCliente().getDNI()+" y tarjeta VISA:"
	                		+habitacion.getCliente().getVISA()+"\n"+"Tiene una reserva el dia "+habitacion.getDia()+"/"+habitacion.getMes()+"/"+habitacion.getAnyo()+" en la habitacion"
	                	    +habitacion.getNumeroHabitacion());
				}
	               bw.flush();
	             
	        	
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
		 }

    }
}   

package interfasUsuario;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import habitacion.Extras;
import habitacion.Habitacion;

public class Salidas {
	
    static Scanner entrada=  new Scanner(System.in);

	/**
     * Metodo para realizar la factura del hotel
     * @param todasHabitaciones
     */
    public static void hacerFactura(LinkedList<Habitacion>todasHabitaciones){
    	String respuesta;
    	String servicios;
    	int diasDeUso;
    	System.out.println("Se procede a realizar la factura del Cliente");
    	System.out.println("--------------------------------------------");
    	ListIterator<Habitacion> itr= todasHabitaciones.listIterator(todasHabitaciones.size());
    	System.out.println("Dame el DNI del cliente saliente");
    	String dni=entrada.next();
    	int preciototal=0;
    	Habitacion habitacion = null;
    			
    	while(itr.hasNext()){
    		
    		habitacion= itr.next();
    		
    		String dniCliente = habitacion.getDatosReserva().getCliente().getId().getDNI();
    		
    		if(dni.equals(dniCliente)){
    			
    			System.out.println("Cliente correcto, vamos a leer si la habitacion ya esta libre");
    			
    			if(habitacion.isOcupada()==true){
    				
        			desOcuparHabitacion(todasHabitaciones);
        			System.out.println("Se puede empezar ha realizar la factura, la habitacion esta libre.");
        			
    			}else{
    				System.out.println("Ya se ha liberado, saliendo del sistema");
    				return;
    			}
    			
    		}else{
				System.out.println("No hay cliente");
				return;
    		}
    	}
    	
		
		  preciototal=habitacion.getDatosReserva().getDiasEstancia()* habitacion.getPrecio();
		  
		  System.out.println("¿Ha solicitado algun servicio como, Wi-Fi, Parking, Lavanderia o el Servicio de Habitaciones?");
		  System.out.println("Si/No");
		  respuesta=entrada.next();
		  respuesta.toUpperCase().trim();
		  if(respuesta.equals("SI")){
		  System.out.println("¿Que servicios ha pedido?");
		  int i = 1;
	  
		  while(i<4){
			  servicios=entrada.next();
			  if(servicios.equals("Wi-Fi")){
				  System.out.println("Diageme el dias que ha usado Wi-Fi");
				  diasDeUso=entrada.nextInt();
		          preciototal=Extras.WIFI.getPrecio()*diasDeUso;
			  }else if(servicios.equals("Lavanderia")){
				  System.out.println("Diageme el dias que ha usado la Lavanderia");
				  diasDeUso=entrada.nextInt();
				  preciototal=Extras.LAVANDERIA.getPrecio()*diasDeUso;
			  }else if(servicios.equals("Parking")){
				  System.out.println("Diageme el dias que ha usado el Parking");
				  diasDeUso=entrada.nextInt();
				  preciototal=Extras.PARKING.getPrecio()*diasDeUso;
			  }else if(servicios.equals("Servicio de Habitaciones")){
				  System.out.println("Diageme el dias que ha usado el Servicio de Habitaciones");
				  diasDeUso=entrada.nextInt();
				  preciototal=Extras.LAVANDERIA.getPrecio()*diasDeUso;
			  }
			  i++;
		  }
		  System.out.println("Ha usado servicios extra");
		  System.out.println("------------------------");
		  System.out.println("El precio total de la estancia es de: "+preciototal);
			  
		  }else{
			  System.out.println("No ha usado ningun servicio extra");
		  System.out.println("---------------------------------");
		  System.out.println("El precio total de la estancia es de: "+preciototal);
		  }
    	
    }

}

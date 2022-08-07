package interfasUsuario;

import java.util.Scanner;
import habitacion.Extras;
import habitacion.Habitacion;
import manejoColeciones.HabitacionesColection;

public class Salidas {
	
    private static Scanner entrada=  new Scanner(System.in);

    
    /**
     * Solisita al usario que servicios extras y con que frecuancia,
     * para calcular su recrago adicional
     * @return precioExtras
     */
    public static int preguntarServiciosExtra() {
    	
    	int precioExtra = 0;
		String servicios;
    	int diasDeUso;
    	int i = 1;

    	
    	System.out.println("¿Que servicios ha pedido? (Wi-Fi , Lavanderia , Parking , Servicio de Habitaciones)");
		
	  
		  while(i<4){
			  servicios=entrada.next();
			  if(servicios.equals("Wi-Fi")){
				  System.out.println("Diageme el dias que ha usado Wi-Fi");
				  diasDeUso=entrada.nextInt();
				  precioExtra=Extras.WIFI.getPrecio()*diasDeUso;
				  
			  }else if(servicios.equals("Lavanderia")){
				  System.out.println("Diageme el dias que ha usado la Lavanderia");
				  diasDeUso=entrada.nextInt();
				  precioExtra=Extras.LAVANDERIA.getPrecio()*diasDeUso;
				  
			  }else if(servicios.equals("Parking")){
				  System.out.println("Diageme el dias que ha usado el Parking");
				  diasDeUso=entrada.nextInt();
				  precioExtra=Extras.PARKING.getPrecio()*diasDeUso;
				  
			  }else if(servicios.equals("Servicio de Habitaciones")){
				  System.out.println("Diageme el dias que ha usado el Servicio de Habitaciones");
				  diasDeUso=entrada.nextInt();
				  precioExtra=Extras.LAVANDERIA.getPrecio()*diasDeUso;
				  
			  }
			  i++;
		  }
    	
    	return precioExtra;
    }
    
    public static int calcularPrecioEstancia(Habitacion habitacion) {
    	
    	int preciototal=habitacion.getDatosReserva().getDiasEstancia()* habitacion.getPrecio();
		 
		System.out.println("¿Ha solicitado algun servicio como, Wi-Fi, Parking, Lavanderia o el Servicio de Habitaciones?");
		System.out.println("Si/No");
		String respuesta=entrada.next().toUpperCase().trim();
		
		if(respuesta.equals("SI")){
			int precioExtras = preguntarServiciosExtra();
			preciototal+= precioExtras;
		}
		
		return preciototal;
    	
    }
    
	/**
     * Metodo para realizar la factura del hotel
     * @param todasHabitaciones
     */
    public static void hacerFactura(HabitacionesColection todasHabitaciones){
    	
    	System.out.println("Se procede a realizar la factura del Cliente");
    	System.out.println("--------------------------------------------");
    	
    	System.out.println("Dame el DNI del cliente saliente");
    	String dni=entrada.next();
    	
    	Habitacion habitacion = todasHabitaciones.getHabitacionCliente( dni ) ;

    	if(habitacion == null){	
    		System.out.println("No exsite el cliente o habitacion con ese cliente");
    		return;
    	}
    	
		System.out.println("Cliente correcto, desocupando habitacion");
		
		habitacion.desOcuparHabitacion();
    	System.out.println("Se puede empezar ha realizar la factura, la habitacion esta libre.");    	
    	int precioTotal = calcularPrecioEstancia(habitacion);
		
		System.out.println("---------------------------------");
		System.out.println("El precio total de la estancia es de: "+precioTotal);
    	
    }

}

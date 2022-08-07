package interfasUsuario;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import cliente.Cliente;
import habitacion.Extras;
import habitacion.FichaReserva;
import habitacion.Habitacion;
import habitacion.HabitacionDoble;
import habitacion.HabitacionIndividual;
import habitacion.HabitacionSuite;
import habitacion.HabitacionTriple;
import manejoArchivos.EscritorArchivos;
import manejoArchivos.LectorArchivo;
import manejoColleciones.HabitacionesCollection;

public class RegistrosHabitacion {
	
    private static Scanner entrada=  new Scanner(System.in);

public static Extras preguntarTodoIncluido() {
		
		System.out.println("Â¿Desea que su estancia tenga todo incluido?");
    	System.out.println("Si/No");
    	
        String opciones=entrada.next();
        opciones.toUpperCase().trim();
        
        if(opciones.equals("SI")){
        	return Extras.TODOINCLUIDO;
        }
        
        return Extras.NULL;
        
        
	}
	
	public static Habitacion solisitarHabitacion( Cliente cliente) {
		
		System.out.println("Datos Habitacion: Dia / Mes/ Año/ Dias de Estancia/\n"
    			+ "Numº de la Habitacion/ Precio de la Habitacion / Habitacion para fumadores(true o false)/");
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(entrada.nextInt(), entrada.nextInt(), entrada.nextInt());
        Date inicioEstancia = calendar.getTime();
        
        FichaReserva fichaReserva = new FichaReserva(inicioEstancia, entrada.nextInt(), cliente);
        Habitacion habitacion= new Habitacion(entrada.nextInt(), entrada.nextInt(), fichaReserva);
		
		return habitacion;
	}
	
	/**
     * Reservar Habitacion Individual
     * @param todasHabitaciones
     * @return habitacion
     */
    public static Habitacion solisitarHabitacion( ){
    	
		System.out.println("Reserva una habitacion del Hotel ");
		System.out.println("---------------------------------");
		
		Extras TodoIncluido = preguntarTodoIncluido();
        Cliente cliente= RegistrosCliente.solisitarCliente();
        Habitacion habitacion= solisitarHabitacion(cliente);
        
        FichaReserva fichaReserva = habitacion.getDatosReserva();
        fichaReserva.setExtras(TodoIncluido);
        
        System.out.println("¿Son los datos correctos?");
        System.out.println("La habitacion ha sido reservada el "+ fichaReserva.getDate().toString() +" con el NÂº de habitacion "+ habitacion.getNumeroHabitacion()+" durante "+ fichaReserva.getDiasEstancia()+
                "dias, a nombre de "+ cliente.getNombre()+" " + cliente.getApellidos() + "\n con los datos ,"+
                cliente.getId().getDNI() +" ,"+ cliente.getId().getVISA()+ ". El cliente " +cliente.traduccion()+" y se encuentra en una "
                +habitacion.traduccion()+". Su habitacion ya esta "+  habitacion.traduccion1()+" por un precio de  "+ habitacion.getPrecio()+
                "â‚¬/dia. Incluye extra: " + fichaReserva.getExtras()+  " â‚¬/estancia");
        
        
        System.out.println("Escribe: Si / NO"); 
        String confirmar = entrada.next().toUpperCase().trim();
        
        if(confirmar.equals("SI")) {
        	
        }else if(confirmar.equals("NO")){
        	System.out.println("Canselando prosedimiento, retornando a menu previo");
        	return null;
        }
        
	    return habitacion;
	 
	 }
    
    public static void guardarHabitacion( HabitacionesCollection habitaciones , Habitacion habitacion) {
    	
    	habitaciones.addHabitacion(habitacion);
        EscritorArchivos.escribirReservas(habitaciones.getHabitaciones() , "reservas.txt");
    	LectorArchivo.leerReservas();
    	
    }
	
	
	/**
	 * Menu para reservar habitaciones
	 * @return
	 */
	public static int menuReservarHabitacion(){
		int opcion = 0;
		final String MENURESERVAS = "\n\n1.- Reservar Habitacion Individual\n"
				+ "2.- Reservar Habitacion Doble\n"
				+ "3.- Reservar Habitacion Triple\n"
				+ "4.- Reservar Habitacion Suite\n"
				+ "0.- Salir\n"
				+ "Introduce la opcion deseada:";
		System.out.println(MENURESERVAS);
		try {
			opcion = entrada.nextInt();
		} catch (Exception e) {
			opcion = -1;
		}
		while (opcion < 0 || opcion > 4) {
			System.out.println("Opcion no valida\n\n");
			System.out.println(MENURESERVAS);
			try {
				opcion = entrada.nextInt();
			} catch (Exception e) {
				opcion = -1;
			}
		}
		return opcion;
	}
	
	/**
	 * Submenu leer opciones tipo habitaciok
	 */
	public static void reservarHabitacion(HabitacionesCollection habitaciones){
		
		Habitacion habitacion=null;
		
		int opcion = menuReservarHabitacion();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				habitacion=new HabitacionIndividual();
				break;
			case 2:
				habitacion=new HabitacionDoble();;
				break;
			case 3:
				habitacion=new HabitacionTriple();;
				break;
			case 4:
				habitacion=new HabitacionSuite();;
				break;
			case 0:
				return;
			default:
					System.out.println("Opcion no valida, ingresa otra opcion");
					menuReservarHabitacion();
					break;
			}
			if(opcion>=1 && opcion<=4) {
				
				Habitacion habitacion_base = solisitarHabitacion();
				
				if(habitacion_base != null) {
					habitacion.copyHabitacion(habitacion_base);
					guardarHabitacion(habitaciones , habitacion);	
				}
			}
			opcion = menuReservarHabitacion();
		}		
	}
}

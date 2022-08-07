package interfasUsuario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import habitacion.Habitacion;
import manejoColleciones.HabitacionesCollection;

public class Registros {
	
    static Scanner entrada=  new Scanner(System.in);

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
		
		String[] args2= new String[1];
		Habitacion habitacion=null;
		
		int opcion = menuReservarHabitacion();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				habitacion=habitaciones.anadirHabitacion();
				break;
			case 2:
				habitacion=habitaciones.anadirHabitacion();
				break;
			case 3:
				habitacion=habitaciones.anadirHabitacion();
				break;
			case 4:
				habitacion=habitaciones.anadirHabitacion();
				break;
			case 0:
				return;
				
			default:
					System.out.println("Opcion no valida, ingresa otra opcion");
					menuReservarHabitacion();
					break;
			}
			opcion = menuReservarHabitacion();
		}		
	}
	
	/**
     * Metodo para desocupar una habitacion segun el Cliente
     * @param todasHabitaciones
     * @return
     */
    public static boolean desOcuparHabitacion(LinkedList<Habitacion>todasHabitaciones){
    	Iterator<Habitacion>itr=todasHabitaciones.iterator();
    	Habitacion actual= null;
    	boolean libre=false;
    	int numHabitacion=entrada.nextInt();
    	
    	while(itr.hasNext()){
    		actual=itr.next();
    		if(actual.getNumeroHabitacion()==numHabitacion){
    			actual.setOcupada(false);
    			libre=true;
    			System.out.println("La habitacion ha sido liberada, esta libre");
    		}
    	}
    	return libre;
    }
	
	
	

}

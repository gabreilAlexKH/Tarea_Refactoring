package interfasUsuario;

import cliente.*;
import habitacion.*;
import manejoArchivos.EscritorArchivos;
import manejoArchivos.LectorArchivo;
import manejoColleciones.ClientesCollection;
import manejoColleciones.HabitacionesCollection;

import java.util.Scanner;
import java.util.Set;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedList;
public class Principal{
	
    static Scanner entrada=  new Scanner(System.in);
    
    /**
     * Metodo principal, donde se puede elegir entre las siguientes opciones del programa
     * @param args
     */
	public static void main(String[]args){
		
		
		ClientesCollection todosClientes = new ClientesCollection();
		HabitacionesCollection todosHabitaciones = new HabitacionesCollection();
		
		Habitacion habitacion=null;
		Cliente cliente=null;
		
		System.out.println("Bienvenido al programa de reservas del Hotel 5 Estrellas, seleccione la opcion que desea realizar: ");
		System.out.println("---------------------------------------------------------------------------------------------------");
		int opcion = leerMenuHotel();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				cliente= todosClientes.anadirCliente();
				break;
			case 2:
				Registros.reservarHabitacion(todosHabitaciones);
				break;
			case 3:
				LectorArchivo.leerReservas();
				break;
			case 4:
				LectorArchivo.leerClientes();
				break;
			case 5:
				Salidas.hacerFactura(todosHabitaciones.getHabitaciones());
				break;
			case 0:
				entrada.close();
				break;
			default:
					System.out.println("Opcion no valida, ingresa otra opcion");
					leerMenuHotel();
			}
			opcion = leerMenuHotel();
		}
		
		entrada.close();
    }
	
	/**
	 * Leer menu del programa del hotel
	 * @return opcion del menu
	 */
	public static int leerMenuHotel(){
		int opcion = 0;
		final String MENU = "\n\n1.- Añadir cliente al Hotel\n"
				+ "2.- Reservar Habitacion\n"
				+ "3.- Leer Reservas del Hotel\n"
				+ "4.- Leer Clientes del Hotel\n"
				+ "5.- Hacer Factura del Cliente saliente\n"
				+ "0.- Salir\n"
				+ "Introduce la opcion deseada:";
		System.out.println(MENU);
		try {
			opcion = entrada.nextInt();
		} catch (Exception e) {
			opcion = -1;
		}
		while (opcion < 0 || opcion > 7) {
			System.out.println("Opcion no valida\n\n");
			System.out.println(MENU);
			try {
				opcion = entrada.nextInt();
			} catch (Exception e) {
				opcion = -1;
			}
		}
		return opcion;

	}	
	
}

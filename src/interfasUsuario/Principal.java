package interfasUsuario;

import manejoArchivos.LectorArchivo;
import manejoColeciones.ClientesColection;
import manejoColeciones.HabitacionesColection;

import java.util.Scanner;

public class Principal{
	
    private static Scanner entrada=  new Scanner(System.in);
    
    /**
     * Metodo principal, donde se puede elegir entre las siguientes opciones del programa
     * @param args
     */
	public static void main(String[]args){
		
		ClientesColection todosClientes = new ClientesColection();
		HabitacionesColection todosHabitaciones = new HabitacionesColection();

		System.out.println("Bienvenido al programa de reservas del Hotel 5 Estrellas, seleccione la opcion que desea realizar: ");
		System.out.println("---------------------------------------------------------------------------------------------------");
		int opcion = leerMenuHotel();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				RegistrosCliente.anadirCliente(todosClientes);
				break;
			case 2:
				RegistrosHabitacion.reservarHabitacion(todosHabitaciones);
				break;
			case 3:
				LectorArchivo.leerReservas();
				break;
			case 4:
				LectorArchivo.leerClientes();
				break;
			case 5:
				Salidas.hacerFactura(todosHabitaciones);
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

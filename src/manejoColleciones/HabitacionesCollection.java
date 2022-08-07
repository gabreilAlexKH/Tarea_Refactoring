package manejoColleciones;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import cliente.Cliente;
import cliente.ID;
import habitacion.Extras;
import habitacion.FichaReserva;
import habitacion.Habitacion;
import manejoArchivos.EscritorArchivos;
import manejoArchivos.LectorArchivo;

public class HabitacionesCollection {
	
	private LinkedList<Habitacion> habitaciones;
	
	
	
	public HabitacionesCollection() {
		super();
		habitaciones = new LinkedList<Habitacion>();
	}



	/**
     * Reservar Habitacion Individual
     * @param todasHabitaciones
     * @return habitacion
     */
    public Habitacion anadirHabitacion(){
    	
		Scanner entrada=  new Scanner(System.in);

		System.out.println("Reserva una habitacion del Hotel ");
		System.out.println("---------------------------------");
		Habitacion habitacion = null;
		
    	System.out.println("¿Desea que su estancia tenga todo incluido?");
    	System.out.println("Si/No");
    	
        String opciones=entrada.next();
        opciones.toUpperCase().trim();
        Extras extras = null;
        
        if(opciones.equals("SI")){
        	extras = Extras.TODOINCLUIDO;
        	
        }else if(opciones.equals("NO")){
        	extras = Extras.NULL;
        }
        
        System.out.println("Datos Cliente: (Nombre, Apellido, DNI, VISA y si el cliente es fumador o no (true / false))");
		Cliente cliente= new Cliente(entrada.next(), entrada.next(), new ID(entrada.next(), entrada.nextLong()) );
		cliente.setFumador( entrada.nextBoolean());
		
        System.out.println("Datos Habitacion: Dia / Mes/ Año/ Dias de Estancia/\n"
    			+ "Nº de la Habitacion/ Precio de la Habitacion / Habitacion para fumadores(true o false)/");
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(entrada.nextInt(), entrada.nextInt(), entrada.nextInt());
        Date inicioEstancia = calendar.getTime();
        
        FichaReserva fichaReserva = new FichaReserva(inicioEstancia, entrada.nextInt(), cliente);
        
        Habitacion Habitacion= new Habitacion(entrada.nextInt(), entrada.nextInt(), fichaReserva);
        
        Habitacion.getDatosReserva().setExtras(extras);
        
        
        System.out.println("¿Son los datos correctos?");
        
        System.out.println("La habitacion ha sido reservada el "+ fichaReserva.getDate().toString() +" con el Nº de habitacion "+ Habitacion.getNumeroHabitacion()+" durante "+ fichaReserva.getDiasEstancia()+
                "dias, a nombre de "+ cliente.getNombre()+" " + cliente.getApellidos() + "\n con los datos ,"+
                cliente.getId().getDNI() +" ,"+ cliente.getId().getVISA()+ ". El cliente " +cliente.traduccion()+" y se encuentra en una "
                +Habitacion.traduccion()+". Su habitacion ya esta "+  Habitacion.traduccion1()+" por un precio de  "+ Habitacion.getPrecio()+
                "€/dia. Incluye extra: " + fichaReserva.getExtras()+  " €/estancia");
        
        System.out.println("Escribe: Si / NO"); 
        String confirmar = entrada.next();
        confirmar.toUpperCase().trim();
        
        if(confirmar.equals("SI")) {
        	habitaciones.addFirst(Habitacion);
            EscritorArchivos.escribirReservas(habitaciones, "reservas.txt");
        	LectorArchivo.leerReservas();
        	System.out.println("La habitacion ha sido reservada");
        	
        }else if(confirmar.equals("NO")){
        	System.out.println("Canselando prosedimiento, volviendo a menu prisipal");
        }
	    return habitacion;
	 
	 }



	public LinkedList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
    
    
    
    

}

package manejoColleciones;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cliente.Cliente;
import cliente.ID;
import manejoArchivos.EscritorArchivos;
import manejoArchivos.LectorArchivo;

public class ClientesCollection {
	
	private LinkedList<Cliente>clientes;

	
	public ClientesCollection() {
		clientes = new LinkedList<Cliente>() ;
	}


	/**
	 * Metodo para aÃ±adir un cliente a la lista de clientes del hotel
	 * @param todosClientes
	 * @return cliente
	 */
	public  Cliente anadirCliente(){
		
		Scanner entrada=  new Scanner(System.in);
		
		System.out.println("Añade un cliente al Hotel");
		System.out.println("-------------------------");
		System.out.println("Nombre, Apellido, DNI, VISA y si el cliente es fumador o no (true / false)");
		
		Cliente cliente= new Cliente(entrada.next(), entrada.next(), new ID(entrada.next(), entrada.nextLong()) );
		cliente.setFumador( entrada.nextBoolean());
		
		System.out.println("¿Son los datos correctos?");
		System.out.println(cliente.getNombre() +" "+ cliente.getApellidos() +" "+ cliente.getId().getDNI() +" "+ cliente.getId().getVISA()+ " " + cliente.traduccion());
		System.out.println("Escribe: Si / No"); 
		String respuesta1;
        respuesta1 = entrada.next(); 
        if(respuesta1.equals("Si")) {
        	clientes.addFirst(cliente);
            EscritorArchivos.escribirClientes(clientes, "clientes.txt");
            LectorArchivo.leerClientes();
        }else if(respuesta1.equals("No")){
        	anadirCliente();
        }
		System.out.println();
		System.out.println ("Â¿AÃ±adir nuevo cliente?");
		System.out.println("Escribe: Si / No"); 
        String respuesta2;
        respuesta2 = entrada.next();
        
        if(respuesta2.equals("Si")) {
            anadirCliente();
        }else if(respuesta2.equals("No")){
        	System.out.println();
        }
        return cliente;
	
	}


	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	
	
}

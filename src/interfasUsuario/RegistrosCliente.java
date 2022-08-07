package interfasUsuario;

import java.util.Scanner;

import cliente.Cliente;
import cliente.ID;
import manejoArchivos.EscritorArchivos;
import manejoArchivos.LectorArchivo;
import manejoColleciones.ClientesCollection;

public class RegistrosCliente {
	
    private static Scanner entrada=  new Scanner(System.in);
    
    
    /**
     * Pide al usuario los datos para un cliente
     * @return cliente
     */
    public static Cliente solisitarCliente() {
    	
    	System.out.println("Nombre, Apellido, DNI, VISA y si el cliente es fumador o no (true / false)");
		
		Cliente cliente= new Cliente(entrada.next(), entrada.next(), new ID(entrada.next(), entrada.nextLong()) );
		cliente.setFumador( entrada.nextBoolean());
		
		return cliente;
    }
    

    /**
	 * Metodo para añadir un cliente a la lista de clientes del hotel
	 * @param todosClientes
	 * @return cliente
	 */
	public static Cliente anadirCliente(ClientesCollection clientes){
				
		System.out.println("Añade un cliente al Hotel");
		System.out.println("-------------------------");
		
		Cliente cliente = solisitarCliente();
		
		System.out.println("¿Son los datos correctos?");
		System.out.println(cliente.getNombre() +" "+ cliente.getApellidos() +" "+ cliente.getId().getDNI() +" "+ cliente.getId().getVISA()+ " " + cliente.traduccion());
		System.out.println("Escribe: Si / No"); 
		
		String respuesta1 = entrada.next(); 
        if(respuesta1.equals("Si")) {
        	clientes.addCliente(cliente);
            EscritorArchivos.escribirClientes(clientes.getClientes(), "clientes.txt");
            LectorArchivo.leerClientes();
            System.out.println("El cliente ha sido reservado");
            
        }else if(respuesta1.equals("No")){
        	System.out.println("Canselando prosedimiento, retornando a menu previo");;
        }
		
        return cliente;
	
	}
	
	
}

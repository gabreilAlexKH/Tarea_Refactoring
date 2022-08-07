package manejoColeciones;

import java.util.LinkedList;

import cliente.Cliente;

public class ClientesColection {
	
	private LinkedList<Cliente>clientes;

	
	public ClientesColection() {
		clientes = new LinkedList<Cliente>() ;
	}

	public void addCliente( Cliente cliente ) {
		
    	clientes.addFirst(cliente);
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	
	
}

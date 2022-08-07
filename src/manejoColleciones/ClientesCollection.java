package manejoColleciones;

import java.util.LinkedList;

import cliente.Cliente;

public class ClientesCollection {
	
	private LinkedList<Cliente>clientes;

	
	public ClientesCollection() {
		clientes = new LinkedList<Cliente>() ;
	}

	public void addCliente( Cliente cliente ) {
		
    	clientes.addFirst(cliente);
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	
	
}

package manejoColeciones;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

import cliente.Cliente;

public class ClientesColection {
	
	private LinkedList<Cliente>clientes;

	
	public ClientesColection() {
		clientes = new LinkedList<Cliente>() ;
	}

	public void addCliente( Cliente cliente ) {
		
    	clientes.addFirst(cliente);
	}

	public List<Cliente> getClientes() {
		return Collections.unmodifiableList(clientes);
	}

	
	
}

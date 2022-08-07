package cliente;

import java.util.*;

public class Cliente {
	private String Nombre;
	private String Apellidos;
	private ID id;
	private boolean fumador;
	
	public Cliente(String nomb, String ape, ID id) {
		this.Nombre=nomb;
		this.Apellidos=ape;
		this.id= id;
		this.fumador=false;
	}
	public String traduccion(){
	String traduccion;
	
    if(isFumador()==true){
    	traduccion="es fumador";
    }else{
    	traduccion="no es fumador";
    }
	return traduccion;
    }

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public  boolean isFumador() {
		return fumador;
	}
	public  void setFumador(boolean fumador) {
		fumador = fumador;
	}
	



	}



	


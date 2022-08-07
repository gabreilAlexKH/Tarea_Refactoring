package habitacion;

import java.util.*;
import java.util.Map.Entry;

public class Habitacion{
	
	
	private int numeroHabitacion;
	protected int precio;
	private boolean fumadores;
	private boolean ocupada;
	private FichaReserva datosReserva;
	

	/**
	 * Constructor con parametros de Habitacion
	 * @param dia
	 * @param mes
	 * @param anyo
	 * @param numeroHabitacion
	 * @param diasEstancia
	 * @param fumadores
	 * @param cliente
	 * @param ocupada
	 */
	public Habitacion(int numeroHabitacion, int precio, FichaReserva datosReserva){
		this.numeroHabitacion=numeroHabitacion;
		this.ocupada=false;
		this.fumadores=false;
		this.datosReserva =  datosReserva;
	}
	
	public String traduccion(){
		String traduccion;
		
	    if(isFumadores()==true){
	    	traduccion="habitacion para fumadores";
	    }else{
	    	traduccion="habitacion para no fumadores";
	    }
		return traduccion;
	    }
	public String traduccion1(){
		String traduccion;
		
	    if(isOcupada()==true){
	    	traduccion="ocupada";
	    }else{
	    	traduccion="habitacion no ocupada";
	    }
		return traduccion;
	    }
	

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public boolean isFumadores() {
		return fumadores;
	}

	public void setFumadores(boolean fumadores) {
		this.fumadores = fumadores;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public FichaReserva getDatosReserva() {
		return datosReserva;
	}

	public void setDatosReserva(FichaReserva datosReserva) {
		this.datosReserva = datosReserva;
	}
	
	
	
}

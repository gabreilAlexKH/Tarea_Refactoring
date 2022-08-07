package habitacion;

public class Habitacion{
	
	
	private int numeroHabitacion;
	protected int precio;
	private boolean fumadores;
	private boolean ocupada;
	private FichaReserva datosReserva;
	
	
	public Habitacion() {
		
		
	}

	public Habitacion(int numeroHabitacion, int precio, FichaReserva datosReserva){
		this.numeroHabitacion=numeroHabitacion;
		this.precio = precio;
		this.ocupada=true;
		this.fumadores=false;
		this.datosReserva =  datosReserva;
	}
	
	/**
	 * Reinicia la habitacion a un estado sin Cliente
	 * @return 
	 */
    public void desOcuparHabitacion(){
    	this.ocupada=false;
		this.fumadores=false;
		this.datosReserva =  null;
    	
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
	
	/**
	 * Copia los datos de una habitacion en otra
	 * @param habitacion_prima
	 */
	public void copyHabitacion(Habitacion habitacion_prima) {
		
		this.numeroHabitacion=habitacion_prima.numeroHabitacion;
		this.precio = habitacion_prima.precio;
		this.ocupada=habitacion_prima.ocupada;
		this.fumadores=habitacion_prima.fumadores;
		this.datosReserva =  habitacion_prima.datosReserva;
		
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

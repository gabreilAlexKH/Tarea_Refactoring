package habitacion;

import java.util.Date;

import cliente.Cliente;

public class FichaReserva {
	
	private Date date;
	private int diasEstancia;
	protected Extras extras;
	private Cliente cliente;
	
	public FichaReserva(Date date, int diasEstancia, Cliente cliente) {
		super();
		this.date = date;
		this.diasEstancia = diasEstancia;
		this.extras = Extras.NULL;
		this.cliente = cliente;
	}

	public int getDiasEstancia() {
		return diasEstancia;
	}

	public void setDiasEstancia(int diasEstancia) {
		this.diasEstancia = diasEstancia;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

	public Date getDate() {
		return date;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	

	
	


}

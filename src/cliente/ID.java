package cliente;

public class ID {
	public String DNI;
	public long VISA;
	
	public ID(){
		this.DNI = "0";
		this.VISA= 0;
	}
	public ID(String dni, long visa){
		this.DNI=dni;
		this.VISA=visa;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public long getVISA() {
		return VISA;
	}
	public void setVISA(long vISA) {
		VISA = vISA;
	}
	
	
}
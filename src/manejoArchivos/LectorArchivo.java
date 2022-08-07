package manejoArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LectorArchivo {
	
	
	/**
	 * Metodo para leer las reservas de un fichero de texto 
	 */
    public static void leerReservas(){
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           archivo = new File ("reservas.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
              System.out.println(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
    }
    
    /**
	 * Leer clientes de un fichero de texto
	 */
	public static void leerClientes(){
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           archivo = new File ("clientes.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
              System.out.println(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
	}
	
	

}

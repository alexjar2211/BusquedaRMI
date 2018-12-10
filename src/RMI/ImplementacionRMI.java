package RMI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementacionRMI extends UnicastRemoteObject implements InterfazRMI {
    
    private boolean registroEncontrado = false;

    public ImplementacionRMI() throws RemoteException {
        super();
    }

    @Override
    public String saludar(String nombre) throws RemoteException {
        return "Hola" + nombre;
    }

    @Override
    public List<String> leerArchivo(String nombrePersona) throws RemoteException, FileNotFoundException, IOException {
        String csvFile = "C:\\RMI\\archivo\\RMIArchivodePrueba.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line = "";
        int contador = 1;
        //String[] persona = null;
        List<String> persona = null;
        boolean datosEncontrados = false;

        while ((line = br.readLine()) != null && !datosEncontrados) {
            
            String[] datos = line.replace("|", ",").split(",");
                
            if (datos[1].equals(nombrePersona)) {
                persona = new ArrayList<>();
                persona.add("Id: " + datos[0]);
                persona.add("Nombre: " + datos[1]);
                persona.add("Pais: " + datos[2]);
                persona.add("Registro Nro: " + Integer.toString(contador));
                datosEncontrados = true;
            }   
            contador++;
        }
        
        br.close();
        return persona;
    }

}

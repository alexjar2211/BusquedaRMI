package RMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfazRMI extends Remote{
    public String saludar(String nombre) throws RemoteException;
    
    public List<String> leerArchivo(String nombrePersona) throws RemoteException, FileNotFoundException, IOException;
}

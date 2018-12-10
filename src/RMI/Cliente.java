package RMI;

import java.net.Inet4Address;
import java.rmi.Naming;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        try {
            InterfazRMI rmi = (InterfazRMI) Naming.lookup("rmi://192.168.1.9/rmi");
            long startTime = System.currentTimeMillis();
            List<String> persona = rmi.leerArchivo("Dante Holder");
            long endTime = System.currentTimeMillis() - startTime;
            
            persona.forEach((d) -> {
                System.out.println(d);
            });
            
            System.out.println("Tiempo transcurrido: " + endTime + " milisegundos");
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

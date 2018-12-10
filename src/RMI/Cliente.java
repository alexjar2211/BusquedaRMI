package RMI;

import java.net.Inet4Address;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            String IPServidor;
            String idPersona;
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduzca la IP del servidor: ");
            IPServidor = sc.nextLine();
            System.out.print("Introduzca el ID de la persona a buscar: ");
            idPersona = sc.nextLine();
            System.out.println("");
            
            InterfazRMI rmi = (InterfazRMI) Naming.lookup("rmi://" + IPServidor + "/rmi");
            long startTime = System.currentTimeMillis();
            List<String> persona = rmi.leerArchivo(idPersona);
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

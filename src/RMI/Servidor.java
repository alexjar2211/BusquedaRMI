package RMI;

import java.net.Inet4Address;
import java.rmi.Naming;

public class Servidor {
    public Servidor(){
        try {
            InterfazRMI rmi = new ImplementacionRMI();
            String ip = Inet4Address.getLocalHost().getHostAddress();
            Naming.rebind("rmi://" + ip + "/rmi", rmi);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args){
        new Servidor();
    }
}

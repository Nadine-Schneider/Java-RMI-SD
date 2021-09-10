import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) throws RemoteException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Starting account value:");
        double accountTotalValue = scan.nextDouble();
        Server serverRMI = new Server(accountTotalValue);
        System.out.println("Total value:    R$ " + serverRMI.getTotalValue());

        try {

            Naming.rebind("//localhost:3000/TransactionAccount", serverRMI);
            System.out.println("Server is running.");


        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace();
        }

    }
}
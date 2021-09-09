import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.RemoteException;
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
            //Aqui está ocorrendo o ERRO: java.rmi.ConnectException: Connection refused to host: 192.168.1.16;

            Naming.rebind("rmi://localhost:3000/TransactionAccount", serverRMI);
            System.out.println("Server is running.");
            //TransactionAccount stub = (TransactionAccount) UnicastRemoteObject.exportObject(serverRMI, 0);
            //Registry registry = LocateRegistry.getRegistry();

            //registry.rebind("teste", stub);

        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace();
        }

    }
}
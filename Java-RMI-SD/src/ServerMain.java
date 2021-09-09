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

        System.out.println("Antes do server");
        TransactionAccount accountRMI = new Server(accountTotalValue);
        System.out.println("Passou da inicialização do server");
        System.out.println(accountRMI.getTotalValue());

        try {
            //Aqui está ocorrendo o ERRO: java.rmi.ConnectException: Connection refused to host: 192.168.1.16;

            //Naming.rebind("localhost:3000", accountRMI);
            //System.out.println("Server is running.");

            TransactionAccount stub = (TransactionAccount) UnicastRemoteObject.exportObject(accountRMI, 3000);
            Registry registry = LocateRegistry.getRegistry();

            registry.rebind("teste", stub);

        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }
}
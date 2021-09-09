import java.rmi.*;
import java.rmi.server.*;

public class Server implements TransactionAccount {
    private double totalValue;

    public Server (double totalValue){
        this.totalValue = totalValue;
    }

    public synchronized void deposit(double value) throws RemoteException {
        this.totalValue += value;
    }

    public synchronized void withdraw(double value) throws RemoteException {
        this.totalValue -= value;
    }

    public synchronized void move(double value, TransactionAccount account) throws RemoteException {
        this.withdraw(value);
        account.deposit(value);
    }

    public synchronized double getTotalValue() throws RemoteException {
        return totalValue;
    }
}
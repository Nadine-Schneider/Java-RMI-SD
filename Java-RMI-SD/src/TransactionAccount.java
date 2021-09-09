import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TransactionAccount extends Remote {
    void deposit(double value) throws RemoteException;

    void withdraw(double value) throws RemoteException;

    void move(double value, TransactionAccount toAccount) throws RemoteException;

    double getTotalValue() throws RemoteException;
}
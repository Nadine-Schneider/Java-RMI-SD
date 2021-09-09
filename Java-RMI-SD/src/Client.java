import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            TransactionAccount objAccount = (TransactionAccount)Naming.lookup("//localhost:3000/TransactionAccount");

            System.out.println("Inform the deposit amount:");
            double accountTotalValue = scan.nextDouble();
            objAccount.deposit(10);
            System.out.println("Total value:    R$ " + objAccount.getTotalValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
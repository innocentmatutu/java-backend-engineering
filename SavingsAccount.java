public class SavingsAccount extends BankAccount{

    public SavingsAccount(String ownerName, double balance){
        super(ownerName, balance);
    }

    @Override
    public synchronized boolean withdraw(double amount){
        if(amount < 0){
            System.out.println("Invalid withdrawal amount");
            return false;

        } else if (amount > balance){
            System.out.println("Insufficient funds");
            return false;

        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        }
    }
}

public class CurrentAccount extends BankAccount {
    
    public CurrentAccount(String ownerName, double balance){
        super(ownerName, balance);
    }

    @Override
    public synchronized boolean withdraw(double amount){
        if(amount < 0){
            System.out.println("Invalid withdrawal amount");
            return false;

        } else if(balance - amount >= -5000.0){
            balance -= amount;
            System.out.println("Withdrawal successful.New balance: " + balance);
            return true;

        } else {
            System.out.println("Overdraft limit exceeded");
            return false;
        }
    }
}

public abstract class BankAccount {
    protected String ownerName;
    protected double balance;

    public abstract boolean withdraw(double amount);
     

    public BankAccount(String ownerName, double balance){
        if(ownerName == null || ownerName.isBlank()){
            this.ownerName = "Unknown";
        } else {
            this.ownerName = ownerName;
        }

        if(balance < 0){
            throw new IllegalArgumentException("Opening balance must be greater than zero.");
        } else {
            this.balance = balance;
        }
    }

    public String getOwnerName(){
        return ownerName;
    }

    public synchronized double getBalance(){
        return balance;
    }

    public synchronized boolean deposit(double amount){
        if (amount < 0){
            return false;
        }
        
        balance+=amount;
        return true;
    }

    
}

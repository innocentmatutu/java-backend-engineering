import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }
    
    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public double getTotalBalance() {
        return accounts.stream()
                .mapToDouble(account -> account.getBalance())
                .sum();
    }

    public void listAccounts(){
        for (BankAccount account: accounts){
            System.out.println("Owner:" + account.getOwnerName());
            System.out.println("Balance:" + account.getBalance());
            System.out.println("--------------------");
        }
    }

    public BankAccount findAccount(String ownerName){
        for (BankAccount account: accounts){
            if(account.getOwnerName().equals(ownerName)){
                return account;
            } 
        }

        return null;

    }

    public void transfer(String fromOwner,String toOwner, double amount){
        BankAccount sender = findAccount(fromOwner);
        BankAccount receiver = findAccount(toOwner);

        // Validation
        if(sender == null){
            System.out.println("Sender account does not exist");
            return;
        }

        if(receiver == null){
            System.out.println("Receiver account does not exist");
            return;
        }

        if(amount <= 0){
            System.out.println("Invalid transfer amount");
            return;
        }

        if(sender.equals(receiver)){
            System.out.println("Cannot transfer to same account");
            return;
        }

        if(sender.withdraw(amount)){
            receiver.deposit(amount);
            System.out.println("Transfer was successful");
        } else{
            System.out.println("Transfer failed");
        }
            

        
    }
}

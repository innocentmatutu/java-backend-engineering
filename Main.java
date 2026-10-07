import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{

    public static void main(String[] args){
        Bank bank = new Bank();

        //Create scanner
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while(choice != 7){
            
            //Display of the menu
            displayMenu(); 

            //Read user's choice
            choice = readChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println(" Create Savings Account");
                    scanner.nextLine(); 
                    createSavingsAccount(bank, scanner);
                    break;
            
                case 2:
                    System.out.println("Create Current Account");
                    scanner.nextLine();
                    createCurrentAccount(bank, scanner);
                    break;
            
                case 3:
                    System.out.println("Deposit");
                    scanner.nextLine();
                    deposit(bank, scanner);
                    break;

                case 4:
                    System.out.println("Withdraw");
                    scanner.nextLine();
                    withdraw(bank, scanner);
                    break;

                case 5:
                    System.out.println("Transfer");
                    transfer(bank, scanner);
                    break;

                case 6:
                    bank.listAccounts();
                    break;
            
                case 7:
                    break;
        
                default:
                    System.out.println("Invalid option");
                    break;
            }   } 
            System.out.println("Thank you for using our bank.");

         


    }

    private static void displayMenu(){
        //Display of the menu
        System.out.println("===== BANK SYSTEM =====");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("3.Deposit");
        System.out.println("4.Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. List Accounts");
        System.out.println("7.Exit");
    }

    private static int readChoice(Scanner scanner){
            while(true){
                try{
                    System.out.print("Input menu option: ");
                    int choice = scanner.nextInt();
                    if(1 <= choice && choice <= 7){
                        return choice;
                    }else{
                        System.out.println("Invalid option please put a number between 1 and 7");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid option please put a number between 1 and 7");
                    scanner.nextLine();
                }
            }
        }

    private static String readName(Scanner scanner, String prompt){
        
        while(true){
            
            System.out.println(prompt);
            String name = scanner.nextLine().trim();

                if(!name.isEmpty()){
                    return name;
                }

                System.out.println("Name cannot be blank!");
            
        }

    }

    private static double readAmount(Scanner scanner, String prompt){
        
        while(true){
            try{
                System.out.println(prompt);
                double amount = scanner.nextDouble();
                if(amount > 0){
                    return amount;
                } else{
                    System.out.println("Please enter an amount greater than zero");
                }
            } catch(InputMismatchException e){
                System.out.println("Please enter a valid amount");
                scanner.nextLine();

            }
        }
        
    }

    private static void createSavingsAccount(Bank bank, Scanner scanner){
        String ownerName = readName(scanner, "Enter owner name: ");

        double balance = readAmount(scanner, "Enter opening balance: ");

        SavingsAccount account = new SavingsAccount(ownerName, balance);
        bank.addAccount(account);
        System.out.println("Savings account created successfully");
    }

    private static void createCurrentAccount(Bank bank, Scanner scanner){
        String ownerName = readName(scanner, "Enter owner name: ");

        double balance = readAmount(scanner, "Enter opening balance: ");

        CurrentAccount account = new CurrentAccount(ownerName, balance);
        bank.addAccount(account);
        System.out.println("Current account created successfully");
    }

    private static void withdraw(Bank bank, Scanner scanner){
        String ownerName = readName(scanner, "Enter owner name: ");
        
        BankAccount account = bank.findAccount(ownerName);
        if (account != null){
            double amount = readAmount(scanner, "Enter withdrawal amount: ");
            if (account.withdraw(amount)){
                System.out.println("Withdrawal successful");
                System.out.println("New account balance is " + account.getBalance());
            }else{
                System.out.println("Withdrawal unsuccessful");
            }
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(Bank bank, Scanner scanner){
        String ownerName = readName(scanner, "Enter owner name: ");

        BankAccount account = bank.findAccount(ownerName);
        if (account != null){
            double amount = readAmount(scanner, "Enter deposit amount: ");
            if(account.deposit(amount)){
                System.out.println("Deposit successful");
            }else{
                System.out.println("Invalid amount");
            }
            System.out.println("New account balance is " + account.getBalance());
            
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void transfer(Bank bank, Scanner scanner){
        scanner.nextLine();

        String fromOwner = readName(scanner, "Enter sender's name: ");
        String toOwner = readName(scanner, "Enter receiver's name: ");
        double amount = readAmount(scanner, "Enter transfer amount: ");

        bank.transfer(fromOwner, toOwner, amount);
    }
    
}
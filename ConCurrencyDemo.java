public class ConCurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        SavingsAccount account = new SavingsAccount("Amina", 100);

        Runnable withdrawalRequest = () -> {
            boolean successful = account.withdraw(80);
            System.out.println(
                    Thread.currentThread().getName() + " successful: " + successful
            );
        };

        //Thread request1 = new Thread(withdrawalRequest, "Request 1");
        Thread request1 = new Thread(withdrawalRequest, "Request 1");
        Thread request2 = new Thread(withdrawalRequest, "Request 2");

        request1.start();
        request2.start();

        request1.join();
        request2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

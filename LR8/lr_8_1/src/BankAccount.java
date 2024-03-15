/*
    1.	Реализовать многопоточное приложение “Банк”. Имеется банковский счет.
    Сделать синхронным пополнение и снятие денежных средств на счет/со счет
    случайной суммой. При каждой операции (пополнения или снятие) вывести текущий
    баланс счета. В том случае, если денежных средств недостаточно – вывести сообщение.
 */
public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение на " + amount + ". Текущий баланс: " + balance);
        notify();
    }

    public synchronized void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Недостаточно средств для снятия " + amount);
            try {
                wait(); // Ждем пока не будет достаточно средств на счете
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Снятие " + amount + ". Текущий баланс: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread depositThread = new Thread(() -> {
            while (true) {
                int amount = (int) (Math.random() * 500) + 1;
                account.deposit(amount);
                try {
                    Thread.sleep(1000); // Ждем 1 секунду перед следующим пополнением
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            while (true) {
                int amount = (int) (Math.random() * 500) + 1;
                account.withdraw(amount);
                try {
                    Thread.sleep(1500); // Ждем 1.5 секунды перед следующим снятием
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();
        withdrawThread.start();
    }
}
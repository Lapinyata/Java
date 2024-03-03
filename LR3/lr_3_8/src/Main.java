import java.util.ArrayList;
import java.util.List;

/*
    Система Телефонная станция. Абонент оплачивает Счет за разговоры и Услуги,
    может попросить Администратора сменить номер и отказаться от услуг.
    Администратор изменяет номер, Услуги и временно отключает Абонента за неуплату.
*/

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class Subscriber {
    private String number;
    private Account account;
    private List<String> services;
    private boolean active;

    public Subscriber(String number, double initialBalance) {
        this.number = number;
        this.account = new Account(initialBalance);
        this.services = new ArrayList<>();
        this.active = true;
    }

    public void changeNumber(String newNumber) {
        this.number = newNumber;
        System.out.println("Number changed to: " + newNumber);
    }

    public void addService(String service) {
        services.add(service);
        System.out.println("Service added: " + service);
    }

    public void removeService(String service) {
        services.remove(service);
        System.out.println("Service removed: " + service);
    }

    public void deactivateSubscriber() {
        active = false;
        System.out.println("Subscriber deactivated.");
    }

    public void payBill(double amount) {
        if (account.getBalance() >= amount) {
            account.debit(amount);
            System.out.println("Payment successful. Remaining balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds to pay the bill.");
        }
    }

    public boolean isActive() {
        return active;
    }
}

class Administrator {
    public void changeNumber(Subscriber subscriber, String newNumber) {
        subscriber.changeNumber(newNumber);
    }

    public void addService(Subscriber subscriber, String service) {
        subscriber.addService(service);
    }

    public void removeService(Subscriber subscriber, String service) {
        subscriber.removeService(service);
    }

    public void deactivateSubscriber(Subscriber subscriber) {
        subscriber.deactivateSubscriber();
    }
}

public class Main {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber("123456789", 100.0);
        Administrator admin = new Administrator();

        admin.addService(subscriber, "Voicemail");
        admin.addService(subscriber, "Call Waiting");

        subscriber.payBill(50.0);

        admin.changeNumber(subscriber, "987654321");

        admin.removeService(subscriber, "Voicemail");

        subscriber.payBill(80.0); // Attempt to pay more than the balance

        admin.deactivateSubscriber(subscriber);
    }
}
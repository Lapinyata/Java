import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит,
    Время городских и междугородных разговоров. Создать массив объектов.
    Вывести: a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
    b) сведения об абонентах, которые пользовались междугородной связью;
    c) сведения об абонентах в алфавитном порядке.
*/

class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallsTime;
    private double longDistanceCallsTime;

    public Phone(int id, String lastName, String firstName, String middleName, String address, String creditCardNumber, double debit, double credit, double localCallsTime, double longDistanceCallsTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallsTime = localCallsTime;
        this.longDistanceCallsTime = longDistanceCallsTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getLocalCallsTime() {
        return localCallsTime;
    }

    public void setLocalCallsTime(double localCallsTime) {
        this.localCallsTime = localCallsTime;
    }

    public double getLongDistanceCallsTime() {
        return longDistanceCallsTime;
    }

    public void setLongDistanceCallsTime(double longDistanceCallsTime) {
        this.longDistanceCallsTime = longDistanceCallsTime;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", debit=" + debit +
                ", credit=" + credit +
                ", localCallsTime=" + localCallsTime +
                ", longDistanceCallsTime=" + longDistanceCallsTime +
                '}';
    }

    public static ArrayList<Phone> filterByLocalCallsTime(ArrayList<Phone> phoneList, double time) {
        ArrayList<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getLocalCallsTime() > time) {
                result.add(phone);
            }
        }
        return result;
    }

    public static ArrayList<Phone> filterByLongDistanceUsage(ArrayList<Phone> phoneList) {
        ArrayList<Phone> result = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getLongDistanceCallsTime() > 0) {
                result.add(phone);
            }
        }
        return result;
    }

    public static ArrayList<Phone> sortByLastName(ArrayList<Phone> phoneList) {
        Collections.sort(phoneList, Comparator.comparing(Phone::getLastName));
        return phoneList;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phoneList = new ArrayList<>();

        // Добавляем данные в список абонентов
        phoneList.add(new Phone(1, "Иванов", "Иван", "Иванович", "Москва", "1234 5678 9012 3456", 100.0, 50.0, 20.0, 10.0));
        phoneList.add(new Phone(2, "Петров", "Петр", "Петрович", "Санкт-Петербург", "9876 5432 1098 7654", 150.0, 30.0, 15.0, 0.0));

        // Выводим информацию об абонентах с временем внутригородских разговоров более 10 минут
        System.out.println("Абоненты с временем внутригородских разговоров более 10 минут:");
        ArrayList<Phone> filteredByLocalCalls = Phone.filterByLocalCallsTime(phoneList, 10.0);
        for (Phone phone : filteredByLocalCalls) {
            System.out.println(phone);
        }

        // Выводим информацию об абонентах, которые пользовались междугородней связью
        System.out.println("\nАбоненты, которые пользовались междугородней связью:");
        ArrayList<Phone> filteredByLongDistanceUsage = Phone.filterByLongDistanceUsage(phoneList);
        for (Phone phone : filteredByLongDistanceUsage) {
            System.out.println(phone);
        }

        // Выводим информацию об абонентах в алфавитном порядке
        System.out.println("\nАбоненты в алфавитном порядке:");
        ArrayList<Phone> sortedByLastName = Phone.sortByLastName(phoneList);
        for (Phone phone : sortedByLastName) {
            System.out.println(phone);
        }

    }
}
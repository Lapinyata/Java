import java.util.*;
/*
    Выполнить задания из варианта 2 лабораторной работы 3,
    реализуя собственные обработчики исключений и исключения ввода/вывода.
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
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество абонентов: ");
            int k = scanner.nextInt();

            for (int i = 0; i < k; ++i) {
                System.out.print("Введите id " + (i + 1) + " абонента: ");
                int number = scanner.nextInt();
                if (number == 666)
                    throw new InvalidPhoneException("Невалидный id");
                scanner.nextLine();
                System.out.print("Введите фамилию " + (i + 1) + " абонента: ");
                String surname = scanner.nextLine();
                if (surname.equals("rrr"))
                    throw new InvalidPhoneException("Невалидная фамилия");
                System.out.print("Введите имя абонента " + (i + 1) + ": ");
                String name = scanner.nextLine();
                System.out.print("Введите отчество абонента " + (i + 1) + ": ");
                String middlename = scanner.nextLine();
                System.out.print("Введите адрес абонента " + (i + 1) + ": ");
                String address = scanner.nextLine();
                System.out.print("Введите дебет абонента " + (i + 1) + ": ");
                double debit = scanner.nextDouble();
                System.out.print("Введите кредит абонента " + (i + 1) + ": ");
                double credit = scanner.nextDouble();
                scanner.nextLine();
                phoneList.add(new Phone(number, surname, name, middlename, address, "1234 5678 9012 3456", debit, credit, 20.0, 10.0));
            }
            System.out.println();

            System.out.println("Введенные значения: ");
            for(Phone phone : phoneList) {
                System.out.println(phone);
            }
            System.out.println();

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
        } catch (InputMismatchException e) {
        System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Оперативка исчерпана");
        } catch (InvalidPhoneException e) {
            System.out.println("InvalidPhoneException " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
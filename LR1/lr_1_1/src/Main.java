import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/*
    6. Создать приложение, выводящее фамилию разработчика, дату и время
    получения задания, а также дату и время сдачи задания. Для получения
    последней даты и времени использовать класс Calendar из пакета java.util
*/

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Фамилия разработчика
        System.out.print("Введите фамилию:\n");
        String lastName = scanner.nextLine();

        // Дата начала проекта
        System.out.println("Введите дату начала проекта (гггг-мм-дд чч:мм:сс): ");
        String StartDate = scanner.nextLine();

        // Дата и время сдачи задания
        Calendar EndDate = Calendar.getInstance();
        SimpleDateFormat sdf_2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDate = sdf_2.format(EndDate.getTime());

        System.out.println("Фамилия разработчика: " + lastName);
        System.out.println("Дата и время получения задания: " + StartDate);
        System.out.println("Дата и время сдачи задания: " + formattedDate);
    }
}
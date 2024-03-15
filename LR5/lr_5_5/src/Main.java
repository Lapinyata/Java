import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    В каждом слове стихотворения Николая Заболоцкого
    заменить первую букву слова на прописную.
 */

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                StringBuilder resultLine = new StringBuilder();
                for (String word : words) {
                    if (word.length() > 0) {
                        char firstChar = Character.toLowerCase(word.charAt(0));
                        resultLine.append(firstChar).append(word.substring(1)).append(" ");
                    }
                }

                writer.write(resultLine.toString().trim() + "\n");
            }

            System.out.println("Преобразование завершено. Результат записан в файл: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
}

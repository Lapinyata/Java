import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    Определить частоту повторяемости букв и слов в стихотворении Александра Пушкина
 */

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            Map<Character, Integer> charFrequency = new HashMap<>();
            Map<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Подсчет частоты повторяемости букв
                for (char c : line.toCharArray()) {
                    charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                }

                // Подсчет частоты повторяемости слов
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            writer.write("Частота повторяемости букв:\n");
            for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            writer.write("\nЧастота повторяемости слов:\n");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            System.out.println("Программа завершена. Результат записан в файл: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
 */

public class Main {

    public static void main(String[] args) {
        String inputFile = "src/input.txt"; // Имя исходного файла
        String outputFile = "src/output.txt"; // Имя файла для записи результата

        List<String> words = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                    if (word.length() < minLength) {
                        minLength = word.length();
                    }
                    if (word.length() > maxLength) {
                        maxLength = word.length();
                    }
                }
            }

            List<String> minWords = new ArrayList<>();
            List<String> maxWords = new ArrayList<>();

            for (String word : words) {
                if (word.length() == minLength) {
                    minWords.add(word);
                }
                if (word.length() == maxLength) {
                    maxWords.add(word);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Слова минимальной длины (" + minLength + "): ");
                for (String minWord : minWords) {
                    writer.write(minWord + " ");
                }
                writer.newLine();

                writer.write("Слова максимальной длины (" + maxLength + "): ");
                for (String maxWord : maxWords) {
                    writer.write(maxWord + " ");
                }
            }

            System.out.println("Слова минимальной и максимальной длины успешно найдены.");
            System.out.println("Результат сохранен в файл " + outputFile);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
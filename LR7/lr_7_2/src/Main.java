import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

/*
    Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 */

public class Main {

    public static void main(String[] args) {
        String inputFile = "src/input.txt"; // Имя исходного файла
        String outputFile = "src/output.txt"; // Имя файла для записи результата
        int wordLength = 5; // Длина слова, которое нужно удалить
        HashSet<Character> consonants = new HashSet<>(); // Множество согласных русских букв
        consonants.add('б');
        consonants.add('в');
        consonants.add('г');
        consonants.add('д');
        consonants.add('ж');
        consonants.add('з');
        consonants.add('й');
        consonants.add('к');
        consonants.add('л');
        consonants.add('м');
        consonants.add('н');
        consonants.add('п');
        consonants.add('р');
        consonants.add('с');
        consonants.add('т');
        consonants.add('ф');
        consonants.add('х');
        consonants.add('ц');
        consonants.add('ч');
        consonants.add('ш');
        consonants.add('щ');

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                StringBuilder modifiedLine = new StringBuilder();

                for (String word : words) {
                    if (word.length() != wordLength || !consonants.contains(Character.toLowerCase(word.charAt(0)))) {
                        modifiedLine.append(word).append(" ");
                    }
                }

                writer.write(modifiedLine.toString().trim());
                writer.newLine();
            }

            System.out.println("Слова заданной длины, начинающиеся на согласную букву, успешно удалены.");
            System.out.println("Результат сохранен в файл " + outputFile);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
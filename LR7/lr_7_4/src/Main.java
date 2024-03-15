import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.
 */

public class Main {

    public static void main(String[] args) {
        String inputFile = "src/input.txt"; // Имя исходного файла
        int StartEndVowelCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        char firstChar = Character.toLowerCase(word.charAt(0));
                        char lastChar = Character.toLowerCase(word.charAt(word.length() - 1));
                        if (isRussianVowel(firstChar) && isRussianVowel(lastChar)) {
                            StartEndVowelCount++;
                        }
                    }
                }
            }

            System.out.println("Количество слов, начинающихся и заканчивающихся русской гласной буквой: " + StartEndVowelCount);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static boolean isRussianVowel(char ch) {
        return "аеёиоуыэюя".indexOf(ch) != -1;
    }
}
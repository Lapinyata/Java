import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    В тексте после k-го символа вставить заданную подстроку.
 */

public class Main {

    public static void main(String[] args) {
        String inputFileName = "src/input.txt";
        String outputFileName = "src/output.txt";
        int k = 100; // позиция k, после которой вставляем подстроку
        String substringToInsert = "world"; // подстрока для вставки

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String modifiedText = insertSubstring(sb.toString(), k, substringToInsert);
            bw.write(modifiedText);
            System.out.println("Измененный текст сохранен в файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }

    private static String insertSubstring(String text, int k, String sub) {
        if (k < 0 || k > text.length()) {
            return text; // если k выходит за границы текста, вставляем в конец текста
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, k));
        sb.append(sub);
        sb.append(text.substring(k));
        return sb.toString();
    }
}
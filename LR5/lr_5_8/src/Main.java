import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Прочитать строки из файла и поменять местами первое
    и последнее слова в каждой строке. Для вывода результатов создавать новую
    директорию и файл средствами класса File
 */

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);

            File outputDir = new File("output");
            outputDir.mkdir();
            File outputFile = new File(outputDir, "output.txt");
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] words = line.split("\\s+");

                if (words.length > 1) {
                    String temp = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = temp;
                }

                for (String word : words) {
                    writer.write(word + " ");
                }
                writer.write("\n");
            }

            scanner.close();
            writer.close();

            System.out.println("Результат записан в файл: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
}

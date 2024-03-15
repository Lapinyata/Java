import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Из файла удалить все слова, содержащие от трех до пяти символов,
    но при этом из каждой строки должно быть удалено только максимальное
    четное количество таких слов. Для вывода результатов создавать новую
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

                int evenCount = 0;
                for (String word : words) {
                    if (word.length() >= 3 && word.length() <= 5) {
                        evenCount++;
                    }
                }

                int maxEvenCount = evenCount % 2 == 0 ? evenCount : evenCount - 1;

                int removedCount = 0;
                for (String word : words) {
                    if (word.length() >= 3 && word.length() <= 5) {
                        if (removedCount < maxEvenCount) {
                            removedCount++;
                        } else {
                            writer.write(word + " ");
                        }
                    } else {
                        writer.write(word + " ");
                    }
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
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correctCount = 0;

        while (true) {
            System.out.println("Введите путь к файлу:");
            String path = sc.nextLine();

            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                if (!fileExists) {
                    System.out.println("Ошибка: файл по указанному пути не существует.");
                } else {
                    System.out.println("Ошибка: указан путь к папке, а нужен путь к файлу.");
                }
                continue;
            }

            correctCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctCount);

        }
    }
}

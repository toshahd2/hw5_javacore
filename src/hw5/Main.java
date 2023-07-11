package hw5;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 1. Написать функцию, создающую резервную копию всех файлов
        // в директории(без поддиректорий) во вновь созданную папку ./backup
        System.out.println("Задание 1");
        File dataFolder = new File("src/hw5/data");
        File backupFolder = new File("./backup");
        Backup backup = new Backup(dataFolder, backupFolder);
        backup.copy();
        System.out.println(" ");

        // 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
        // и представляют собой, например, состояния ячеек поля для игры в крестики-нолики,
        // где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
        // Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
        // Записать в файл 9 значений так, чтобы они заняли три байта.
        System.out.println("Задание 2");
        int[] data = {2, 1, 0, 2, 0, 2, 0, 1, 3};
        try {
            TicTacToe.saveData(data);
            System.out.println(" ");

            // 3 (*) - В продолжение 2 дописать "разворачивание" поля игры крестики-нолики
            // из сохраненного в файле состояния (распарсить файл,
            // в зависимости от значений (0-3) нарисовать поле со значками 'х' 'о' '.')

            System.out.println("Задание 3");
            TicTacToe.readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
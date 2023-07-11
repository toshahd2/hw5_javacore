package hw5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TicTacToe {
    static void saveData(int[] data) throws IOException {
        int[] array = data;
        try (FileOutputStream file = new FileOutputStream("tictactoe")) {
            for (int b = 0; b < 3; b++) {
                byte wr = 0;
                for (int v = 0; v < 3; v++) {
                    wr += (byte) (array[3 * b + v] << (v * 2));
                }
                file.write(wr);
            }
            System.out.println("Файл записан");
        }
    }
    static void readData() throws IOException {
        int[] arr = new int[9];
        try (FileInputStream read = new FileInputStream("tictactoe")) {
            int b;
            int i = 0;
            while ((b = read.read()) != -1) {
                for (int v = 0; v < 3; ++v) {
                    arr[i++] = b >> (v * 2) & 0x3;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            if (i == 3 || i == 6){
                System.out.println("");
            }
            if (arr[i] == 0){
                System.out.print(" _ ");
            } else if (arr[i] == 1) {
                System.out.print(" x ");
            } else if (arr[i] == 2) {
                System.out.print(" o ");
            } else if (arr[i] == 3) {
                System.out.print(" . ");
            }
        }
    }
}

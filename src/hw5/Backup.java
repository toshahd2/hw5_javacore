package hw5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Backup {
    private File dataFolder;
    private File backupFolder;

    public Backup(File dataFolder, File backupFolder) {
        this.dataFolder = dataFolder;
        this.backupFolder = backupFolder;
    }

    public void copy() {
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        File[] files = dataFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(backupFolder, file.getName());
                    try {
                        Files.copy(file.toPath(), backupFile.toPath());
                        System.out.println("Создана резервная копия файла " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // 1. Написать функцию, создающую резервную копию всех файлов
        // в директории(без поддиректорий) во вновь созданную папку ./backup

        File sourceFolder = new File("./soursceDirectory");
        File backupFolder = new File("./backup");
        DirectoryCopier copier = new DirectoryCopier(sourceFolder, backupFolder);
        copier.copyDirectory();
    }
    }
}
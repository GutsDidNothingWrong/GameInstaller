import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static final File GAMES = new File("D://GamesJava2");

    public static void main(String[] args) {

        File temp = creatDir(GAMES, "temp");

        File tempFile = creatFiles(temp, "temp.txt");

        fileMessage(tempFile);

        File saveGames = creatDir(GAMES, "saveGames");
        File src = creatDir(GAMES, "src");
        File res = creatDir(GAMES, "res");
        File main = creatDir(src, "main");
        File test = creatDir(src, "test");

        File utilsFile = creatFiles(main, "utils.java");
        File mainFile = creatFiles(main, "main.java");

        File drawables = creatDir(res, "drawables");
        File vectors = creatDir(res, "vectors");
        File icons = creatDir(res, "icons");
    }

    public static void directMessage(File file) {
        try (FileWriter writer = new FileWriter("D://GamesJava2//temp//temp.txt", true)) {
            writer.write("Директория " + file.getName() + " успешно создана");
            writer.write('\n');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fileMessage(File file) {
        try (FileWriter writer = new FileWriter("D://GamesJava2//temp//temp.txt", true)) {
            writer.write("Файл " + file.getName() + " успешно создан");
            writer.write('\n');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static File creatDir(File file, String dir) {
        File newDir = new File(file, dir);
        if (newDir.mkdir()) {
            directMessage(newDir);
        }
        return newDir;
    }

    public static File creatFiles(File dir, String files) {
        File newFile = new File(dir, files);
        try {
            if (newFile.createNewFile()) {
                fileMessage(newFile);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return newFile;
    }
}

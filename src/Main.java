import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Zipper zipper = new Zipper();
        UnZipper unZipper = new UnZipper();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose mode: ");
        System.out.println("Type \"Zip\" for ZIP");
        System.out.println("Type \"UnZip\" for UNZIP");
        String variant = scanner.next();

        if (variant.equals("Zip")) {
            try {
                System.out.println("Enter path to file to ZIP: ");
                String zipFile = scanner.next();
                //"C:\\Users\\YB\\Desktop\\test.txt"
                System.out.println("Enter path to ZIP file: ");
                String zipArchive = scanner.next();
                //"C:\\Users\\YB\\Desktop\\test.zip"
                zipper.zipDirectory(new File(zipFile), new File(zipArchive));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (variant.equals("UnZip")) {
            try {
                System.out.println("Enter path ZIP folder: ");
                String zipFolder = scanner.next();
                //"C:\\Users\\YB\\Desktop\\test.zip"
                unZipper.extractFolder(zipFolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Type Zip or Unzip command!");
        }
    }
}

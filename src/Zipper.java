import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {

    public void zipDirectory(File dir, File zipFile) throws IOException {
        FileOutputStream fout = new FileOutputStream(zipFile);
        ZipOutputStream zout = new ZipOutputStream(fout);
        if (dir.isDirectory()) {
            zipSubDirectory("", dir, zout);
        }
        if (dir.isFile()) {
            zipFile(dir, zout);
        }
        zout.close();
    }

    private void zipSubDirectory(String basePath, File dir, ZipOutputStream zout) throws IOException {
        byte[] buffer = new byte[4096];
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String path = basePath + file.getName() + "/";
                zout.putNextEntry(new ZipEntry(path));
                zipSubDirectory(path, file, zout);
                zout.closeEntry();
            } else {
                FileInputStream fin = new FileInputStream(file);
                zout.putNextEntry(new ZipEntry(basePath + file.getName()));
                int length;
                while ((length = fin.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
                zout.closeEntry();
                fin.close();
            }
        }
    }

    private void zipFile(File file, ZipOutputStream zout) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        zout.putNextEntry(new ZipEntry(file.getName()));
        byte[] buffer = new byte[4096];
        int length;
        while ((length = fin.read(buffer)) > 0) {
            zout.write(buffer, 0, length);
        }
        zout.closeEntry();
        fin.close();
    }

}

package ss17_binary_file.exercise.copy_binary_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyBinaryFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter source file");
        String sourcePath = scan.nextLine();
        System.out.println("Enter destination file: ");
        String destPath = scan.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            if (sourceFile.length() == 0) {
                throw new FileNotFoundException();
            } else {
                System.out.println("Copy completed");
                countByte(sourceFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found or is empty");
        } catch (IOException e) {
            System.out.print("Can't copy that file");
        }

        copyFileUsingStream(sourceFile, destFile);
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void countByte(File sourceFile) throws IOException {
        FileInputStream fileInput = new FileInputStream(sourceFile);
        long size = fileInput.getChannel().size();
        System.out.println("The file size is: " + size + " bytes");
    }
}

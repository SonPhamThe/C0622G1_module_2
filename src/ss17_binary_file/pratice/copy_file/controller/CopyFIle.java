package ss17_binary_file.pratice.copy_file.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFIle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter source file");
        String sourcePath = scan.nextLine();
        System.out.println("Enter destination file: ");
        String destPath = scan.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.out.print("Can't copy that file");
            System.out.printf(e.getMessage());
        }
    }
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException{
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
            while ((length = is.read(buffer))>0) {
                os.write(buffer,0,length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}

package ss17_binary_file.exercise.product_managament.service.utils;

import ss17_binary_file.exercise.product_managament.model.ProductModel;
import ss17_binary_file.pratice.readandwrite_list_student.model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFIleBinary {
    public static List<ProductModel> readDataFromFile(String path) {
        List<ProductModel> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<ProductModel>) ois.readObject();
            fis.close();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

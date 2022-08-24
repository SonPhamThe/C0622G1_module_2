package ss17_binary_file.exercise.product_managament.service.utils;

import ss17_binary_file.exercise.product_managament.model.ProductModel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFIleBinary {
    public static void writeToFile(String path, List<ProductModel> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

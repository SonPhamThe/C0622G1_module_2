package ss17_binary_file.exercise.product_managament.service.impl;

import ss17_binary_file.exercise.product_managament.model.ProductModel;
import ss17_binary_file.exercise.product_managament.service.IProduct;
import ss17_binary_file.exercise.product_managament.service.utils.ReadFIleBinary;
import ss17_binary_file.exercise.product_managament.service.utils.WriteFIleBinary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct {

    private static final Scanner scan = new Scanner(System.in);

    private static List<ProductModel> products = new ArrayList<>();

    private static final String path = "ss17_binary_file/exercise/product_managament/data/product.txt";

    @Override
    public void addNewProduct() {
        products = ReadFIleBinary.readDataFromFile(path);
        ProductModel product = this.infoProduct();
        products.add(product);
        System.out.println("Success add");
        WriteFIleBinary.writeToFile(path, products);
    }

    @Override
    public void editProduct() {
        ProductModel productEdit = this.findIdProduct();
        if (productEdit == null) {
            System.out.println("No one product to edit");
        } else {
            System.out.println("Selection option to edit" +
                    "\n 1. Edit id" +
                    "\n 2. Edit name product" +
                    "\n 3. Edit price of the product" +
                    "\n 4. Edit producer of the product" +
                    "\n 5. Exit");
            int chooseEdit = Integer.parseInt(scan.nextLine());
            switch (chooseEdit) {
                case 1:
                    System.out.println("Enter id of the product to edit");
                    int idEdits = Integer.parseInt(scan.nextLine());
                    productEdit.setIdProduct(idEdits);
                    System.out.println("Success edit");
                    break;
                case 2:
                    System.out.println("Enter name of the product to edit");
                    String nameProduct = scan.nextLine();
                    productEdit.setNameProduct(nameProduct);
                    System.out.println("Success edit");
                    break;
                case 3:
                    System.out.println("Enter price of the product to edit");
                    double priceProduct = Double.parseDouble(scan.nextLine());
                    productEdit.setMoneyProduct(priceProduct);
                    System.out.println("Success edit");
                    break;
                case 4:
                    System.out.println("Enter producer of the product to edit");
                    String producerEdit = scan.nextLine();
                    productEdit.setProducer(producerEdit);
                    System.out.println("Success edit");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 5");
            }
        }
    }

    @Override
    public void deleteTheProduct() {
        ProductModel idDelete = this.findIdProduct();
        if (idDelete == null) {
            System.out.println("No one product to delete");
        } else {
            System.out.println("Are you sure you want to delete ? " +
                    "\n 1. Yes" +
                    "\n 2. No");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    products.remove(idDelete);
                    System.out.println("Success delete");
                    break;
                case 2:
                    break;
            }
        }
    }

    @Override
    public void displayListProduct() {
        products = ReadFIleBinary.readDataFromFile(path);
        for (ProductModel product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void searchTheProduct() {
        int count = 0;
        ReadFIleBinary.readDataFromFile(path);
        System.out.println("Enter name of the product to search");
        String nameOfProduct = scan.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNameProduct().equals(nameOfProduct)) {
                System.out.println(products.get(i).toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Don't search the product");
        }
        WriteFIleBinary.writeToFile(path, products);
    }

    @Override
    public void sortTheProduct() {
        ReadFIleBinary.readDataFromFile(path);
        System.out.println("Choice to sort the product" +
                "\n 1. Sort in ascending order" +
                "\n 2. Sort in descending order");
        int chooseSort = Integer.parseInt(scan.nextLine());
        switch (chooseSort) {
            case 1:
                Collections.sort(products);
                System.out.println("Success sort");
                break;
            case 2:
                Collections.sort(products);
                Collections.reverse(products);
                System.out.println("Success sort");
                break;
        }
        WriteFIleBinary.writeToFile(path, products);
    }

    public ProductModel findIdProduct() {
        ReadFIleBinary.readDataFromFile(path);
        System.out.println("Enter ID of the product to find");
        int idProduct = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == idProduct) {
                return products.get(i);
            }
        }
        WriteFIleBinary.writeToFile(path, products);
        return null;
    }

    public ProductModel infoProduct() {
        ReadFIleBinary.readDataFromFile(path);

        System.out.println("Enter id of the product");
        int id = Integer.parseInt(scan.nextLine());

        System.out.println("Enter name of the product");
        String name = scan.nextLine();

        System.out.println("Enter price of the product");
        double price = Double.parseDouble(scan.nextLine());

        System.out.println("Enter producer of the product");
        String producer = scan.nextLine();

        WriteFIleBinary.writeToFile(path, products);

        return new ProductModel(id, name, price, producer);
    }
}

package ss12_java_collection_framework.exercise.arraylist_linkedlist.service.impl;

import ss12_java_collection_framework.exercise.arraylist_linkedlist.model.Product;
import ss12_java_collection_framework.exercise.arraylist_linkedlist.service.IProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct {

    private static final Scanner scan = new Scanner(System.in);

    private static final List<Product> product = new ArrayList<>();

    static {
        product.add(new Product(1, "keo", 56.6, "CodeGym"));
        product.add(new Product(2, "ma tuy", 700, "mafia"));
        product.add(new Product(3, "bia", 25, "tiger"));
    }

    @Override
    public void addNewProduct() {
        Product products = this.infoProduct();
        product.add(products);
        System.out.println("Success add");
    }

    @Override
    public void displayListProduct() {
        for (Product products : product) {
            System.out.println(products);
        }
    }

    @Override
    public void deleteTheProduct() {
        Product idDelete = this.findIdProduct();
        if (idDelete == null) {
            System.out.println("No one product to delete");
        } else {
            System.out.println("Are you sure you want to delete ? " +
                    "\n 1. Yes" +
                    "\n 2. No");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    product.remove(idDelete);
                    System.out.println("Success delete");
                    break;
                case 2:
                    break;
            }
        }
    }

    public Product findIdProduct() {
        System.out.println("Enter ID of the product to find");
        int idProduct = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getIdProduct() == idProduct) {
                return product.get(i);
            }
        }
        return null;
    }

    @Override
    public void searchTheProduct() {
        int count = 0;
        System.out.println("Enter name of the product to search");
        String nameOfProduct = scan.nextLine();
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getNameProduct().equals(nameOfProduct)) {
                System.out.println(product.get(i).toString());
                count++;
            }
        }
        if(count==0) {
            System.out.println("Don't search the product");
        }
    }

    @Override
    public void editProduct() {
        Product productEdit = this.findIdProduct();
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
    public void sortTheProduct() {
        System.out.println("Choice to sort the product" +
                "\n 1. Sort in ascending order" +
                "\n 2. Sort in descending order");
        int chooseSort = Integer.parseInt(scan.nextLine());
        switch (chooseSort) {
            case 1:
                Collections.sort(product);
                System.out.println("Success sort");
                break;
            case 2:
                Collections.sort(product);
                Collections.reverse(product);
                System.out.println("Success sort");
                break;
        }
    }

    public Product infoProduct() {
        System.out.println("Enter id of the product");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter name of the product");
        String name = scan.nextLine();
        System.out.println("Enter price of the product");
        double price = Double.parseDouble(scan.nextLine());
        System.out.println("Enter producer of the product");
        String producer = scan.nextLine();

        return new Product(id, name, price, producer);
    }
}

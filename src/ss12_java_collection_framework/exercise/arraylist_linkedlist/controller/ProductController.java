package ss12_java_collection_framework.exercise.arraylist_linkedlist.controller;

import ss12_java_collection_framework.exercise.arraylist_linkedlist.service.IProduct;
import ss12_java_collection_framework.exercise.arraylist_linkedlist.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static final Scanner scan = new Scanner(System.in);
    private static IProduct product = new ProductService();

    public void menuUser() {
        while (true) {
            System.out.println("Please select the following information" +
                    "\n 1. Add new product" +
                    "\n 2. Edit product" +
                    "\n 3. Delete the product" +
                    "\n 4. Display the list product" +
                    "\n 5. Search the product" +
                    "\n 6. Sort the list product" +
                    "\n 7. Exit");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    product.addNewProduct();
                    break;
                case 2:
                    product.editProduct();
                    break;
                case 3:
                    product.deleteTheProduct();
                    break;
                case 4:
                    product.displayListProduct();
                    break;
                case 5:
                    product.searchTheProduct();
                    break;
                case 6:
                    product.sortTheProduct();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}

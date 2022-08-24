package ss17_binary_file.exercise.product_managament.view;

import ss17_binary_file.exercise.product_managament.controller.ProductController;

public class ProductView {
    private static final ProductController product = new ProductController();
    public static void main(String[] args) {
        product.menuUser();
    }
}

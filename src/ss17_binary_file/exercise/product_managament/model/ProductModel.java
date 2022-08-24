package ss17_binary_file.exercise.product_managament.model;

public class ProductModel implements Comparable<ProductModel> {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private String producer;

    public ProductModel() {
    }

    public ProductModel(int idProduct, String nameProduct, double moneyProduct, String producer) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = moneyProduct;
        this.producer = producer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getMoneyProduct() {
        return priceProduct;
    }

    public void setMoneyProduct(double moneyProduct) {
        this.priceProduct = moneyProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product has a " +
                "idProduct = " + idProduct +
                ", nameProduct = " + nameProduct +
                ", moneyProduct = " + priceProduct +
                ", producer = " + producer;
    }

    @Override
    public int compareTo(ProductModel o) {
        return (int) (this.getMoneyProduct() - o.getMoneyProduct());
    }
}

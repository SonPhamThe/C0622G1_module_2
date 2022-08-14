package self_learning;

public class Myclass {
    void makeRectangle(Rectangle rec) {
        System.out.println(rec);
        rec.setWidth(5);
        rec.setHeight(5);
    }

    public static void main(String[] args) {
        Myclass myclass = new Myclass();
        Rectangle rectangle = new Rectangle(1,1);
        System.out.println(rectangle);
        myclass.makeRectangle(rectangle);
    }
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

package ss4_class_object.exercise.Fan;

public class ClassFan {
    private int speed;
    private double radius;
    private String color;
    private boolean on;

    public ClassFan() {
        this.speed = 1;
        this.color = "blue";
        this.on = false;
        this.radius = 5;
    }

    public ClassFan(int speed, double radius, String color, boolean on) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String speedString;
        if (this.speed == 1) {
            speedString = "Slow";
        } else if (this.speed == 2) {
            speedString = "Medium";
        } else {
            speedString = "fast";
        }
        if (this.on) {
            return String.format("Fan is on has speed: " + this.speed + " color: " + this.color + " radius: " + radius);
        } else {
            return String.format("Fan is off has color: " + this.color + " radius: " + radius);
        }
    }
}

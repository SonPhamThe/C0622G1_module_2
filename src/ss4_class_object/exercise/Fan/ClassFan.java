package ss4_class_object.exercise.Fan;

public class ClassFan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private double radius = 5;
    private String color = "blue";
    private boolean on = false;


    public ClassFan(int speed, double radius, String color, boolean on) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }

    public ClassFan() {

    }

    public void setSpeed(int speed) {
        if (speed != 1 && speed != 2 && speed != 3) {
            System.out.println("Can't set " + speed + "!\n" + "Speed must be 1, 2 or 3");
        } else {
            this.speed = speed;
        }
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

    public String getSpeed() {
        if (on) {
            switch (this.speed) {
                case 1:
                    return " SLOW";
                case 2:
                    return " MEDIUM";
                case 3:
                    return " FAST";
            }
        }
            return "Fan is off";
    }


    @Override
    public String toString() {
        if(on) {
            return "Fan is on " +
                    "speed = " + getSpeed() +
                    ", radius = " + this.radius +
                    ", color = '" + this.color + '\'' ;
        } else {
            return "Fan is off " +
                    ", radius =" + this.radius +
                    ", color ='" + this.color + '\'' ;
        }
    }
}

package ss4_class_object.exercise.Quadratic;

public class ClassQuadratic {
    double a,b,c;

    public ClassQuadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {

        return this.b*2-4*this.a*this.c;
    }

    public double getSingleEquation() {
        return -this.c/this.b;
    }


    public double getRoot1() {

        return (-this.b+Math.sqrt(this.b*this.b-4*this.a*this.c))/2*this.a;
    }

    public double getRoot2() {
        return (-this.b-Math.sqrt(this.b*this.b-4*this.a*this.c))/2*this.a;
    }

    public String display() {
        return "Quadratic have coefficient are: " + "a= " + a + ", b= " + b +", c= "+c+ "}";
    }
}

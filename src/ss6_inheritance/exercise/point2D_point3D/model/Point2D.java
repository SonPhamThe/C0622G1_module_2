package ss6_inheritance.exercise.point2D_point3D.model;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {

    }

    public Point2D(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {

        return new float[]{this.x, this.y};
    }

    public void setXY(float x, float y) {
         this.x = x;
         this.y =y;
    }

    @Override
    public String toString() {
        return "Point2D has a " +
                "x = " + getX() +
                ", y = " + getY() +
                " and has array of "+ Arrays.toString(getXY());
    }
}

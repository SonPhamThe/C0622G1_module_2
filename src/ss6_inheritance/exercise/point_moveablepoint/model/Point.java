package ss6_inheritance.exercise.point_moveablepoint.model;

import java.util.Arrays;

public class Point {
    float x = 0.0f;
    float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
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
        this.y = y;
    }

    @Override
    public String toString() {
        return "The Point has " +
                " x = " + x +
                ", y = " + y +
                "and has a array " + Arrays.toString(getXY());
    }
}

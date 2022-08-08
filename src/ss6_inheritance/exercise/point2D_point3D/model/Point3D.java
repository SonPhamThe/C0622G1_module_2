package ss6_inheritance.exercise.point2D_point3D.model;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public  Point3D() {}

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float z, float x, float y) {
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[] {this.z,getX(),getY()};
    }

    public void setXYZ(float x, float y, float z) {
        this.z = z;
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return "Point3D has a " +
                " z = " + z +
                " has a array of "+ Arrays.toString(getXYZ());
    }
}

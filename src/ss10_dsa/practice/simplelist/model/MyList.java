package ss10_dsa.practice.simplelist.model;

import java.lang.ref.PhantomReference;
import java.util.Arrays;

public class MyList<A> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCap() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(A a) {
        if(size==elements.length) {
            ensureCap();
        }
        elements[size++] = a;
    }

    public A get(int i) {
        if(i>=size||i<0) {
            throw new IndexOutOfBoundsException("Index: "+i+", Size "+i);
        }
        return (A) elements[i];
    }
}

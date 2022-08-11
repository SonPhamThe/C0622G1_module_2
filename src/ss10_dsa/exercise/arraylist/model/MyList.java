package ss10_dsa.exercise.arraylist.model;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    /**
     * consstructor không tham số mặc định số lượng phần tử ban đầu
     */
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * thiết lập số lượng phần tử đầu vào và in ra trường hợp ngoại lệ
     *
     * @param capacity
     */
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    /**
     * xóa tất cả phần tử của mảng và trả về giá trị null
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * phương thức add 1 phần tử vào Arraylist
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * thêm phần tử vào một vị trí bất kì
     *
     * @param index
     * @param element
     */
    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("Index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }


    /**
     * tăng kích thước của mảng
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return 1;
            }
        }
        return index;
    }

    public boolean contain(E element) {
        return this.indexOf(element) >= 0;
    }
}

public class MyArrayList<E> implements List<E> {

    private E[] data;
    private int last; // last unfilled index

    public MyArrayList () {
        last = 0;
        data = (E[])new Object[10];
    }


    private boolean isFull() {
        return (last == data.length);

    }

    private void expand() {
        E[] newData = (E[])new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void ifIsFullExpand() {
        if (isFull()) {
            expand();
        }
    }
    private void shiftOne(int l, boolean right) {
        if (right) {
            for (int i = last; i > l; i--) {
                data[i] = data[i - 1];
            }
        } else {
            for (int i = l; i < last - 1; i++) {
                data[i] = data[i + 1];
            }
        }
    }


    @Override // Since list has this method, override just shows that fact.
    public void add(E val) {
        ifIsFullExpand();
        data[last] = val;
        last++;
    }

    @Override
    public void add(int index, E val) {
        if (index > last || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ifIsFullExpand();
        shiftOne(index, true);
        data[index] = val;
        last++;
    }

    @Override
    public void set(int index, E val) {
        if (index >= last || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        data[index] = val;
    }

    @Override
    public void clear() {
        last = 0;
    }

    @Override
    public E remove(int index) {
        if (index >= last || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        shiftOne(index, false);
        last--;
        return null;
    }

    @Override
    public E get(int index) {
        if (index >= last || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return data[index];
    }

    @Override
    public int size() {
        return last;
    }

    @Override
    public boolean isEmpty() {
        return last == 0;
    }

    @Override
    public boolean contains(E val) {

        for (int i = 0; i < last; i++) {
            if (data[i].equals(val)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(E val) {

        for (int i = 0; i < last; i++) {
            if (data[i].equals(val)) return i;
        }
        return -1;
    }

    @Override
    public boolean equals(List other) {

        if (other.size() != this.size()) return false;
        for (int i = 0; i < last; i++) {
            if (!other.get(i).equals(this.get(i))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < last; i++) {
            s += data[i];
            if (i < last - 1) s += ", ";
            else s += "]";
        }
        return s;
    }

}


// I think E is like generic type but one such type. Object is like anything anything.
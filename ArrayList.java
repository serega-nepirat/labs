public class ArrayList<T> {
    private Object[] data;
    private int size;
    public ArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            grow();
        }
        data[size] = element;
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі");
        }
        if (size == data.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі");
        }
        return (T) data[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    private void grow() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i < size - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}
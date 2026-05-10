public class CustomList<T> {
    private Object[] buffer;
    private int size;
    private int capacity;
    public CustomList() {
        this.capacity = 2;
        this.buffer = new Object[this.capacity];
        this.size = 0;
    }

    private void growBuffer() {
        this.capacity *= 2;
        Object[] newBuffer = new Object[this.capacity];
        System.arraycopy(this.buffer, 0, newBuffer, 0, this.size);
        this.buffer = newBuffer;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі переліку (розмір: " + size + ").");
        }
    }

    private void checkIndexForInsert(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неможливо вставити елемент. Індекс " + index + " виходить за межі.");
        }
    }

    public void add(T element) {
        if (size == capacity) {
            growBuffer();
        }
        buffer[size] = element;
        size++;
    }

    public void insertAt(int index, T element) {
        checkIndexForInsert(index);

        if (size == capacity) {
            growBuffer();
        }

        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }

        buffer[index] = element;
        size++;
    }

    public void removeAt(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }

        buffer[size - 1] = null;
        size--;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) buffer[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
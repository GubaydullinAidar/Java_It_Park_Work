public class ArrayList<T> implements List<T> {

    private static final int MAX_SIZE = 5;
    private int count;
    private Object elements[];

    public ArrayList() {
        this.elements = new Object[MAX_SIZE];
    }

    @Override
    public boolean addFirst(T element) {
        checkRange();
        for (int i = count; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        this.elements[0] = element;
        count++;
        return true;
    }

    public boolean addLast(T element) {
        checkRange();
        this.elements[count] = element;
        count++;
        return true;
    }

    @Override
    public boolean insert(T element, int index) {
        checkRange();
        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        this.elements[index] = element;
        count++;
        return true;
    }

    @Override
    public boolean removeByIndex(int index) {
        checkRange();
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        this.elements[count - 1] = null;
        count--;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) this.elements[index];
    }

    @Override
    public int find(T element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            Object tmp = elements[i];
            elements[i] = elements[count - 1 - i];
            elements[count - 1 - i] = tmp;
        }
    }

    @Override
    public int size() {
        return count;
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }
    }

    private void checkRange() {
        if (count >= MAX_SIZE) {
            throw new IndexOutOfBoundsException();
        }
    }
}
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
        for (int i = count - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        count++;
        return true;
    }

    public boolean addLast(T element) {
        checkRange();
        elements[count] = element;
        count++;
        return true;
    }

    @Override
    public boolean insert(T element, int index) {
        checkRange();
        for (int i = count - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        count++;
        return true;
    }

    @Override
    public boolean removeByIndex(int index) {
        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[count - 1] = 0;
        count--;
        return true;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public int find(T element) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                result = i + 1;
                break;
            }
        }
        return result;
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
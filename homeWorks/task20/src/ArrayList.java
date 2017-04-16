public class ArrayList<T> implements List {

    private static final int MAX_SIZE = 5;
    private int count;
    private int elements[];

    public ArrayList() {
        elements = new int[MAX_SIZE];
    }

    @Override
    public boolean add(int element) {
        if (count < MAX_SIZE) {
            for (int i = count - 1; i >= 0; i--) {
                elements[i + 1] = elements[i];
            }
            elements[0] = element;
            count++;
            return true;
        } else {
            System.err.println("Места больше нет!");
            return false;
        }
    }

    public boolean addToEnd(int element) {
        if (count < MAX_SIZE) {
            elements[count] = element;
            count++;
            return true;
        } else {
            System.err.println("Места больше нет!");
            return false;
        }
    }

    @Override
    public boolean insert(int element, int index) {
        if (count < MAX_SIZE) {
            for (int i = count - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
            count++;
            return true;
        } else {
            System.err.println("Места больше нет");
            return false;
        }
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
    public int get(int index) {
        return elements[index];
    }

    @Override
    public int find(int element) {
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
            int tmp = elements[i];
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
}
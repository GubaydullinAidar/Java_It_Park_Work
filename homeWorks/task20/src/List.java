public interface List<T> {

    /**
     * Добавление элемента в начало списка
     * @param element
     * @return true - если места хватило и добавление прошло успешно
     */
    boolean addFirst(T element);

    boolean addLast(T element);

    boolean insert(T element, int index);

    boolean removeByIndex(int index);

    T get(int index);

    /**
     * Находит элемент по значению
     * @param element элемент, который необходимо найти
     * @return номер элемента
     */
    int find(T element);

    void reverse();

    int size();

}

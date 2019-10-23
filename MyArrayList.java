public class MyArrayList<E> {

    private E[] array;
    private int size;

    public MyArrayList() {
        array = (E[])new Object[16];
        size = 0;
    }
    public void add(E e){
        array[size++] = e;
    }
    public E remove(){
        E element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }
}

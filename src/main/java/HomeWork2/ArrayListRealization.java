package HomeWork2;

import java.util.Arrays;
import java.util.Optional;

public class ArrayListRealization<E>  {

    private int size;
    private Object[] initialArray;

    public ArrayListRealization(){
        this.initialArray = new Object[10];
        this.size = 0;
    }

    public ArrayListRealization(int initialCapacity){
        this.initialArray = new Object[initialCapacity];
    }

    public boolean add(E e) {
        if (size >= initialArray.length) {
            initialArray = Arrays.copyOf(initialArray, initialArray.length * 2);
        }
        this.initialArray[size] = e;
        size++;
        return true;
    }


    public E get(int index) {
        return (E) initialArray[index];
    }


    public int size() {
        return this.size;
    }

    public Optional<E> remove(int index){
        if(index<initialArray.length){
            Optional<E> optional = (Optional<E>) Optional.of(initialArray[index]);
            if(index == size-1){
                initialArray[index] = null;
                size--;
            }else {
                for (int i =index; i<size; i++){
                    initialArray[i] = initialArray[i+1];
                }
                initialArray[size]=null;
                size--;
            }
            return optional;
        }else throw new IndexOutOfBoundsException("Index "+index+" out of bound");

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <size; i++) {
            sb.append(initialArray[i]);
        }
        return sb.toString();
    }

}

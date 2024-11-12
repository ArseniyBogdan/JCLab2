package org.example;

import java.util.*;


public class CustomArrayList<T> implements List<T> {
    private final int INIT_SIZE = 16;
    private int maxSize = INIT_SIZE;
    private long size = 0; // init size
    private Object[] array = new Object[INIT_SIZE];

    @Override
    public boolean add(T item) {
        if(size == array.length)
            resize(array.length*2);
        array[(int)size++] = item;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException(index);
        }
        if(size == array.length)
            resize(array.length*2);
        for (long i = size - 1; i >= index; i--){
            array[(int) i + 1] = array[(int) i];
        }
        array[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < size; i++){
            if(o.equals(array[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException(index);
        }
        Object element = array[index];
        for (int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        size -= 1;
        return (T) element;
    }

    /**
     * Метод для расширения массива в случае превыщения размера array
     *
     * @param newLength - новая длина массива
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, maxSize);
        maxSize = newLength;
        array = newArray;
    }

    @Override
    public int size() {
        if (size >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else{
            return (int) size;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if (array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Object[] newArray = new Object[(int)size];
        System.arraycopy(array, 0, newArray, 0, (int) size);
        return (Iterator<T>) Arrays.stream(newArray).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[(int)size];
        System.arraycopy(array, 0, newArray, 0, (int) size);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length > size){
            for (int i = 0; i < size; i++){
                a[i] = (T1) array[i];
            }
            return a;
        }
        else{
            Object[] newArray = new Object[(int) size];
            System.arraycopy(array, 0, newArray, 0, (int) size);
            return (T1[]) newArray;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object el: c){
            if (!contains(el)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element: c){
            add(element);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element: c){
            add(index, element);
            index++;
        }
        return !c.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        long beforeSize = size;
        for (Object o : c) {
            remove(o);
        }
        return beforeSize != size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        for (int i = 0; i < size; i++){
            if (!c.contains(array[i])){
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Object[INIT_SIZE];
    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException(index);
        }
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException(index);
        }
        array[index] = element;
        return (T) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++){
            if (array[i].equals(o)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        Object[] newArray = new Object[(int)size];
        System.arraycopy(array, 0, newArray, 0, (int) size);
        return (ListIterator<T>) Arrays.asList(newArray).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        Object[] newArray = new Object[(int)size - index];
        System.arraycopy(array, index, newArray, 0, (int) size - index);
        return (ListIterator<T>) Arrays.asList(newArray).listIterator();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if(fromIndex >= size || fromIndex < 0){
            throw new IndexOutOfBoundsException(fromIndex);
        }
        if(toIndex >= size || toIndex < 0){
            throw new IndexOutOfBoundsException(toIndex);
        }
        Object[] newArray = new Object[(int)size];
        System.arraycopy(array, fromIndex, newArray, 0, toIndex - fromIndex);
        return (List<T>) Arrays.asList(newArray);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof List)){
            return false;
        }
        List list = (List) obj;
        for(int i = 0; i < size; i++){
            if (!list.get(i).equals(array[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String elements = "[";
        for(int i = 0; i < size-1; i++){
            elements += array[i].toString() + ", ";
        }
        elements += array[(int)size - 1].toString() + "]";
        return elements;
    }
}

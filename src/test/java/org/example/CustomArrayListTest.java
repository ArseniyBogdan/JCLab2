package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomArrayListTest {

    CustomArrayList<Integer> customList;
    List<Integer> list;


    /**
     * Инициализируем списки перед каждым тестом
     */
    @BeforeEach
    void initLists(){
        customList = new CustomArrayList<>();
        list = new ArrayList<>();
    }


    @Test
    void add(){
        for(int i = 0; i < 30; i++){
            customList.add(i);
            list.add(i);
        }
        Assertions.assertEquals(customList, list);
    }

    @Test
    public void addingByIndex(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for (int i = 0; i < 10; i++){
            customList.add(4, i);
            list.add(4, i);
        }
        Assertions.assertEquals(customList, list);
    }

    @Test
    void remove(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 0; i < 4; i++){
            customList.remove(Integer.valueOf(4));
            list.remove(Integer.valueOf(4));
        }
        Assertions.assertEquals(customList, list);
    }

    @Test
    public void removeByIndex(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 0; i < 4; i++){
            customList.remove(4);
            list.remove(4);
        }
        Assertions.assertEquals(customList, list);
    }

    @Test
    void size(){
        Assertions.assertEquals(customList.size(), list.size());
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Assertions.assertEquals(customList.size(), list.size());
        for(int i = 0; i < 4; i++){
            customList.remove(4);
            list.remove(4);
        }
        Assertions.assertEquals(customList.size(), list.size());
    }

    @Test
    public void isEmpty(){
        Assertions.assertEquals(customList.isEmpty(), list.isEmpty());
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Assertions.assertEquals(customList.isEmpty(), list.isEmpty());
        for(int i = 0; i < 4; i++){
            customList.remove(4);
            list.remove(4);
        }
        Assertions.assertEquals(customList.isEmpty(), list.isEmpty());
    }

    @Test
    public void contains(){
        Assertions.assertEquals(customList.contains(1), list.contains(1));
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for (int i = 3; i < 7; i++) {
            Assertions.assertEquals(customList.contains(i), list.contains(i));
        }
    }

    @Test
    public void iterator(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Iterator<Integer> iter1 = customList.iterator();
        Iterator<Integer> iter2 = list.iterator();

        while (iter1.hasNext()){
            Assertions.assertEquals(iter1.next(), iter2.next());
        }
    }

    @Test
    public void toArray(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Assertions.assertArrayEquals(customList.toArray(), list.toArray());
    }

    @Test
    public void toArray2(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }

        Assertions.assertArrayEquals(customList.toArray(new Integer[0]), list.toArray(new Integer[0]));
        Assertions.assertArrayEquals(customList.toArray(new Integer[20]), list.toArray(new Integer[20]));
    }

    @Test
    public void containsAll(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        List<Integer> testList1 = new ArrayList<>();
        List<Integer> testList2 = new ArrayList<>();
        for(int i = 2; i < 7; i++){
            testList1.add(i);
        }
        for(int i = 7; i < 12; i++){
            testList2.add(i);
        }
        Assertions.assertEquals(customList.containsAll(testList1), list.containsAll(testList1));
        Assertions.assertEquals(customList.containsAll(testList2), list.containsAll(testList2));
    }

    @Test
    public void addAll(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        List<Integer> testList = new ArrayList<>();
        for(int i = 7; i < 12; i++){
            testList.add(i);
        }
        Assertions.assertEquals(customList.addAll(testList), list.addAll(testList));
    }

    @Test
    public void addAllByIndex(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        List<Integer> testList = new ArrayList<>();
        for(int i = 7; i < 12; i++){
            testList.add(i);
        }
        Assertions.assertEquals(customList.addAll(7, testList), list.addAll(7, testList));
    }

    @Test
    public void removeAll(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        List<Integer> testList1 = new ArrayList<>();
        List<Integer> testList2 = new ArrayList<>();
        for(int i = 7; i < 12; i++){
            testList1.add(i);
        }
        for(int i = 3; i < 8; i++){
            testList2.add(i);
        }
        Assertions.assertEquals(customList.removeAll(testList1), list.removeAll(testList1));
        Assertions.assertEquals(customList.removeAll(testList2), list.removeAll(testList2));
    }

    @Test
    public void retainAll(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        List<Integer> testList1 = new ArrayList<>();
        List<Integer> testList2 = new ArrayList<>();
        for(int i = 7; i < 12; i++){
            testList1.add(i);
        }
        for(int i = 0; i < 7; i++){
            testList2.add(i);
        }
        Assertions.assertEquals(customList.retainAll(testList1), list.retainAll(testList1));
        Assertions.assertEquals(customList.retainAll(testList2), list.retainAll(testList2));
    }

    @Test
    public void clear(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        customList.clear();
        list.clear();
        Assertions.assertEquals(customList, list);
    }

    @Test
    public void getByIndex(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 1; i < 7; i++){
            Assertions.assertEquals(customList.get(i), list.get(i));
        }
    }


    @Test
    public void setByIndex(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 1; i < 7; i++){
            customList.set(3, i);
            list.set(3, i);
        }
        Assertions.assertEquals(customList, list);
    }

    @Test
    public void indexOf(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 1; i < 12; i++){
            Assertions.assertEquals(customList.indexOf(i), list.indexOf(i));
        }
    }

    @Test
    public void lastIndexOf(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        for(int i = 1; i < 12; i++){
            Assertions.assertEquals(customList.lastIndexOf(i), list.lastIndexOf(i));
        }
    }

    @Test
    public void listIterator1(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Iterator<Integer> iter1 = customList.listIterator();
        Iterator<Integer> iter2 = list.listIterator();

        while (iter1.hasNext()){
            Assertions.assertEquals(iter1.next(), iter2.next());
        }
    }

    @Test
    public void listIterator2(){
        for(int i = 0; i < 10; i++){
            customList.add(i);
            list.add(i);
        }
        Iterator<Integer> iter1 = customList.listIterator(4);
        Iterator<Integer> iter2 = list.listIterator(4);

        while (iter1.hasNext()){
            Assertions.assertEquals(iter1.next(), iter2.next());
        }
    }

}

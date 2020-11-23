package com.java.learning.datastructure;

import org.junit.Test;

public class DummyHeadLinkedListTest {
    @Test
    public void test(){
        DummyHeadLinkedList<Integer> linkedList = new DummyHeadLinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.insert(666, 2);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}

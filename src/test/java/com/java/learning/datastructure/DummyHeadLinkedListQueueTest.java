package com.java.learning.datastructure;

import org.junit.jupiter.api.Test;

public class DummyHeadLinkedListQueueTest {
    @Test
    public void test() {
        DummyHeadLinkedListQueue<Integer> queue = new DummyHeadLinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}


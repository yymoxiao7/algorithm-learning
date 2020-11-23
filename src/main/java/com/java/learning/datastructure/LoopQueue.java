package com.java.learning.datastructure;

public class LoopQueue<E> implements Queue<E> {
    private E[] array;
    private int tail, front;
    private int size;

    public LoopQueue(int capacity) {
        array = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        //扩容判断
        if((tail+1)%array.length==front){
            resize(array.length*2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E element = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        //缩容
        if(size==getCapacity()/4&& getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return element;
    }

    @Override
    public E getFront() {
        return array[front];
    }

    public void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }
    public int getCapacity(){
        return array.length;
    }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % array.length){
            res.append(array[i]);
            if((i + 1) % array.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}

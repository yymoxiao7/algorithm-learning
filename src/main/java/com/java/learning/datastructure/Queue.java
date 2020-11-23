package com.java.learning.datastructure;

/**
 * 队列
 * 先进先出
 *
 * @param <E>
 */
public interface Queue<E> {
    /**
     * 得到队长度
     *
     * @return
     */
    int getSize();

    /**
     * 返回队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 返回队首
     *
     * @return
     */
    E getFront();
}

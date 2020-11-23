package com.java.learning.datastructure;

/**
 * 栈 后进先出
 * 常规应用：撤销/系统吊用栈/编辑器扩展匹配
 * @param <E>
 */
public interface Stack<E> {
    /**
     * 获取栈中有多少个元素
     *
     * @return size
     */
    int getSize();

    /**
     * 判断 栈是否是空的
     *
     * @return 布尔
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return 出栈的元素
     */
    E pop();

    /**
     * 返回栈尾元素
     *
     * @return 栈尾元素
     */
    E peek();
}

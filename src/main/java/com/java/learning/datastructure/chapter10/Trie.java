package com.java.learning.datastructure.chapter10;

import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {
    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //如果当前节点的下个元素没有c
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);

        }
        //如果最后一个节点的 isWord为false
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return current.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return true;
    }
}

package com.home;

public class HomeMadeBlockQueue<T>{

    private int CAPACITY;
    private int prodPos = 0;
    private int consumePos = 0;
    private int currentSize = 0;
    private Object[] elements;
    private Object produceLock = new Object();
    private Object consumeLock = new Object();
    public HomeMadeBlockQueue(int capacity) {
        if (capacity<=0) {
            throw new RuntimeException("capacity must bigger than 0");
        }
        if ((capacity & capacity-1) !=0) {
            throw new RuntimeException("capacity must power of 2");
        }
        this.CAPACITY = capacity;
        elements = new Object[capacity];
    }

    public void put(T element) throws InterruptedException {
        synchronized (produceLock) {
            if (currentSize==CAPACITY) {//满了
                produceLock.wait();
            }else {
                elements[prodPos] = element;
                prodPos = prodPos & (CAPACITY - 1)+1;
                currentSize++;
            }
            consumeLock.notify();
        }
    }

    public T get() throws InterruptedException {
        synchronized (consumeLock) {
            if (currentSize == 0) {
                consumeLock.wait();
            }else {
                T element = (T) elements[consumePos];
                consumePos = consumePos & (CAPACITY - 1)+1;
                currentSize --;
                return element;
            }
            produceLock.notify();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        HomeMadeBlockQueue<Integer> bq = new HomeMadeBlockQueue<>(8);
        bq.put(1);
    }
}

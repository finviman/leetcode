package com.home;

public class HomeMadeBlockQueue<T>{

    private int CAPACITY;
    private int prodPos = 0;
    private int consumePos = 0;
    private int currentSize = 0;
    private Object[] elements;
    private Object oneLock = new Object();
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
        synchronized (oneLock) {
            if (currentSize==CAPACITY) {//满了
                oneLock.wait();
            }else {
                elements[prodPos] = element;
                System.out.println("put element:"+element);
                prodPos = (prodPos+1) & (CAPACITY - 1);
                currentSize++;
            }
            oneLock.notify();
        }
    }

    public T get() throws InterruptedException {
        synchronized (oneLock) {
            if (currentSize == 0) {
                oneLock.wait();
            }else {
                T element = (T) elements[consumePos];
                consumePos = (consumePos+1) & (CAPACITY - 1);
                currentSize --;
                return element;
            }
            oneLock.notify();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        HomeMadeBlockQueue<Integer> bq = new HomeMadeBlockQueue<>(8);
        Runnable p = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                    bq.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread produce = new Thread(p);
        produce.start();
        Runnable c =()->{
            while (true){
                try {
                    Thread.sleep(100);
                    System.out.println("get element:"+bq.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread(c);
        consumer.start();
    }
}

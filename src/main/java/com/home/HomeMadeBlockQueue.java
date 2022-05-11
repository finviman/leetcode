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
            //生产线程持有锁后开始执行
            while (currentSize == CAPACITY) {
                //符合条件就wait，停止执行进入锁的等待队列，
                //会释放锁，其他线程就可以执行了，等其他线程notify后从这里继续执行
                oneLock.wait();
            }
            elements[prodPos] = element;
            prodPos = (prodPos+1) & (CAPACITY - 1);
            currentSize++;
            System.out.println("put element:"+element+ " and size="+currentSize);
            //执行到这里，就要用notify释放锁，
            //然后通知其他wait的线程(进入锁等待队列的线程)出队，进入ready状态
            //cpu会调度正在ready的线程。
            oneLock.notify();
        }
    }

    public T get() throws InterruptedException {
        synchronized (oneLock) {
            while(currentSize == 0) {
                oneLock.wait();
            }
            T element = (T) elements[consumePos];
            consumePos = (consumePos+1) & (CAPACITY - 1);
            currentSize --;
            System.out.println("get elemment:"+element + " and size="+currentSize);
            oneLock.notify();
            return element;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HomeMadeBlockQueue<Integer> bq = new HomeMadeBlockQueue<>(8);
        Runnable p = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(13);
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
                    Thread.sleep(171);
                    bq.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread(c);
        consumer.start();
    }
}

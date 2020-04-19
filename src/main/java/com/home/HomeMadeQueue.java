package com.home;

/**
 * Created by liyang on 4/17/20.
 * liyang27@le.com;
 * only in letv.
 */
public class HomeMadeQueue {

    private Object[] dataArray;
    private int queueLength = 16;
    private int head=0;
    private int tail=0;

    public HomeMadeQueue(int queueLength) {
        this.queueLength = queueLength;
        dataArray = new Object[queueLength];
    }

    public void push(Object o) throws Exception{
        if((tail+1) % queueLength == head){
            throw new Exception("queue is full");
        }
        dataArray[tail] = o;
        tail = (tail+1) % queueLength ;
    }

    public Object pop() throws Exception{
        if(head == tail){
            throw new Exception("queue is empty");
        }
        Object value = dataArray[head];
        head = (head+1) % queueLength;
        return value;
    }

    public void dumpQueue() {
        for (Object o : dataArray) {
            System.out.print(o);
            System.out.print(" ");
        }
    }
}

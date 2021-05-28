package com.home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by liyang on 4/17/20.
 * liyang27@le.com;
 * only in letv.
 */
class HomeMadeQueueTest {

    @Test
    void testQueueOperation() throws Exception {
        HomeMadeQueue queue = new HomeMadeQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.dumpQueue();
    }

}
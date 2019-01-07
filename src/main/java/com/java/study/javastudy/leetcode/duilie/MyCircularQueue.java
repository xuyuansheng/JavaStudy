package com.java.study.javastudy.leetcode.duilie;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

    private List<Integer> queue = null;
    private Integer head;// 队列头下标
    private Integer tail;//队列尾下标
    private Integer queueSize;//队列长度

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        queue = new ArrayList<>(k);
        head = tail = -1;
        queueSize = k;
    }


    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        if (this.isEmpty()) {
            queue.add(0, value);
            head = tail = 0;
            return true;
        }
        if (tail == queueSize - 1) {
            queue.add(0, value);
            tail = 0;
            return true;
        }
        queue.add(tail + 1, value);
        tail++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.isEmpty())
            return false;
        queue.remove(head);
        if (head == queueSize - 1) {
            head = 0;
        } else {
            head++;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return queue.get(head);
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return queue.get(tail);
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        /** 头 尾指针都指向-1 即为空队列 */
        if (head < 0 && tail < 0)
            return true;
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        /** 满栈的条件: tail多进行一次入栈 tail就会等于head */
        int tailTemp = (tail + 1) == queueSize ? 0 : tail+1;
        return tailTemp!=head;

    }


    public static void main(String[] args) {
        MyCircularQueue myQueue = new MyCircularQueue(7);
        boolean result1 = myQueue.enQueue(1);
        System.out.println(myQueue.queue);
        boolean result2 = myQueue.enQueue(2);
        System.out.println(myQueue.queue);
        boolean result3 = myQueue.enQueue(3);
        System.out.println(myQueue.queue);
        boolean result4 = myQueue.enQueue(4);
        System.out.println(myQueue.queue);
        boolean result5 = myQueue.enQueue(5);
        System.out.println(myQueue.queue);
        boolean result6 = myQueue.deQueue();
        System.out.println(myQueue.queue);
        boolean result7 = myQueue.deQueue();
        System.out.println(myQueue.queue);
        boolean result8 = myQueue.enQueue(6);
        System.out.println(myQueue.queue);
        boolean result9 = myQueue.enQueue(7);
        System.out.println(myQueue.queue);
        boolean result10 = myQueue.enQueue(8);
        System.out.println(myQueue.queue);

    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

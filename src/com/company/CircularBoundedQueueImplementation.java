package com.company;

public class CircularBoundedQueueImplementation implements CircularBoundedQueue {
    private int front;
    private int rear;
    private final int [] queue;
    private final int capacity;
    private int newElem;

    public CircularBoundedQueueImplementation(int capacity) {
        front = -1;
        rear = -1;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    // TODO исправить работу метода
    @Override
    public void offer(CircularBoundedQueueImplementation item) {
        queue[rear] = item.newElem;
        rear++;

    }

    @Override
    public CircularBoundedQueueImplementation poll() {
        if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);

        if (rear < capacity) {
            queue[rear] = 0;
            rear--;
        }
        return null;
    }


    @Override
    public CircularBoundedQueueImplementation peek() {
        if (front != rear) {
            System.out.printf("\nFront Element of the queue: %d", queue[front]);
        }
        return null;
    }

    @Override
    public void flush() {
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            System.out.print("Queue is Empty");
            return true;
        }
        return false;
    }


    @Override
    public boolean isFull() {
        if (capacity == rear) {
            System.out.print("Circular Bounded Queue is full");
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public int capacity() {
        return capacity;
    }

}

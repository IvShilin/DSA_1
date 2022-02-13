package com.company;

public class CircularBoundedQueueImplementation<T> implements CircularBoundedQueueI<T> {
    private int front;
    private int rear;
    private int size;
    private final Object[] queue;
    private final int capacity;

    public CircularBoundedQueueImplementation(int capacity) {
        front = -1;
        rear = -1;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    /**
     * the function insert an element to the rear of the queue, overwrite the oldest elements when the queue is full
     * @param value is a value of element that we need to insert to the queue
     */
    @Override
    public void offer(T value) {
        if (isFull()) {
            queue[rear] = value;
            front = (front + 1) % capacity;
        } else {
            size += 1;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;

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

    /**
     * function look at the element at the front of the queue
     * @return front element
     * @throws IllegalStateException used to indicate that queue is empty, we can't use this function
     */
    @Override
    public CircularBoundedQueueImplementation peek() {
        if (front != rear) {
            System.out.printf("\nFront Element of the queue: %d", queue[front]);
        }
        return null;
    }

    @Override
    public void flush() {
        size = 0;
        front = 0;
        rear = 0;
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
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }
}

package com.company;


public class Main implements CircularBoundedQueue {
    public static void main(int capacity) {
        int front = -1;
        int rear = -1;
        int[] queue = new int[capacity];
    }

    @Override
    public void offer(Main item) {
        queue[rear] = item;
        rear++;

    }

    @Override
    public Main poll() {
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }

        if (rear < capacity) {
            queue[rear] = 0;
            rear--;
        }
        return null;
    }

    @Override
    public Main peek() {
        if (front != rear) {
            System.out.printf("\nFront Element of the queue: %d", queue[front]);
        }
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            System.out.printf("Queue is Empty");
            return true;
        }
        return false;
    }


    @Override
    public boolean isFull() {
        if (capacity == rear) {
            System.out.printf("Circular Bounded Queue is full");
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

}

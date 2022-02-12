package com.company;

public class CircularBoundedQueueImplementation implements CircularBoundedQueue {
    int front;
    int rear;
    int[] queue;
    int capacity;

    public void CircularBoundedQueueImplementation(int capacity) {
        front = -1;
        rear = -1;
        queue = new int[capacity];
    }

    //Исправить несоотвествие типов
    @Override
    public void offer(CircularBoundedQueueImplementation item) {
        queue[rear] = item;
        rear++;

    }

    @Override
    public CircularBoundedQueueImplementation poll() {
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
    public CircularBoundedQueueImplementation peek() {
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

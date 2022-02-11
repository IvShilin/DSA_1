package com.company;
class CircularBoundedQueue {
    private static int front;
    private static int rear;
    private static int capacity;
    private static int[] queue;

    CircularBoundedQueue(int size) {
        front = 0;
        rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    static void isEmpty() {
        if (front == rear) {
            System.out.printf("Queue is Empty");
            return;
        }
    }
    static void insertEl(int item)  {
        if (capacity == rear) {
            System.out.println("\nCircular Bounded Queue is full");
        }
        else {
            queue[rear] = item;
            rear++;
        }
    }

    static void peek()
    {
        if (front == rear) {
            System.out.println("Queue is Empty\n");
        }
        System.out.printf("\nFront Element of the queue: %d", queue[front]);
    }

    static void offer ( int item){
        queue[rear] = item;
        rear++;
    }

    static void poll() {
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }

        if (rear < capacity) {
            queue[rear] = 0;
            rear--;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CircularBoundedQueue q = new CircularBoundedQueue(4);


        q.insertEl(5);
        q.insertEl(20);
        q.insertEl(30);
        q.insertEl(7);


        q.peek();

        q.insertEl(90);

        q.poll();
        q.poll();


        q.peek();
    }
}



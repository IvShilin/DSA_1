package com.company;

public interface CircularBoundedQueue{


    void offer(int value); // insert an element to the rear of the queue
    // overwrite the oldest elements
    // when the queue is full
    CircularBoundedQueueImplementation poll(); // remove an element from the front of the queue
    //
    CircularBoundedQueueImplementation peek(); // look at the element at the front of the queue
    // (without removing it)
    void flush(); // remove all elements from the queue boolean
    boolean isEmpty(); // is the queue empty?
    boolean isFull(); // is the queue full?
    int size(); // number of elements
    int capacity(); // maximum capacity
}

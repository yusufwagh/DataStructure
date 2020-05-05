package com.ds.implementation.priorityqueue.common

import com.ds.implementation.common.BaseOperation

interface PriorityQueueOperation<T> : BaseOperation {
    fun enqueue(value: PriorityQueueNode<T>) : Boolean
    fun dequeue() : Boolean
    fun peek(): PriorityQueueNode<T>?
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}
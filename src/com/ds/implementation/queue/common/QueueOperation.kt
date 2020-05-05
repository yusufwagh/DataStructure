package com.ds.implementation.queue.common

import com.ds.implementation.common.BaseOperation

interface QueueOperation<T> : BaseOperation  {
    fun enqueue(value: T) : Boolean
    fun dequeue() : Boolean
    fun peek(): T?
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}
package com.ds.implementation.queue.array

import com.ds.implementation.queue.common.QueueOperation

class Queue<T>(private val size: Int = 10) : QueueOperation<T> {

    private val queue = Array<QueueNode<T>?>(size) { null }

    private var front = -1
    private var rear = -1


    override fun enqueue(value: T): Boolean {
        if (isFull()) {
            printWaringMessage("Failed to enqueue $value as Queue is full")
            return false
        }
        if (front == -1) front++
        queue[++rear] = QueueNode(value)
        return true
    }

    override fun dequeue(): Boolean {
        if (isEmpty()) {
            printWaringMessage("Failed to dequeue as Queue is empty")
            return false
        }
        front++
        return true
    }

    override fun peek(): T? {
        if (isEmpty()) {
            printWaringMessage("Failed to Peek as Queue is empty")
            return null
        }
        return queue[front]?.value
    }

    override fun isEmpty(): Boolean {
        if (front == -1 || front > rear) {
            front = -1
            rear = -1
            return true
        }
        return false
    }


    override fun isFull(): Boolean = rear >= size - 1


    override fun print(msg: String?) {
        msg?.let { println(it) }
        println("Front of Queue $front")
        println("Rear of Queue $rear")
        if (isEmpty()) {
            println("Queue is empty")
            return
        }
        for (index in front downTo 0) {
            if (queue[index] != null)
                println("Position $index Entry -> ${queue[index]?.value}")
        }
    }

    private fun printWaringMessage(msg: String?) {
        msg?.let { println(it) }
    }
}

data class QueueNode<T>(val value: T)
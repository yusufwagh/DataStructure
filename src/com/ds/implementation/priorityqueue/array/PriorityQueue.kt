package com.ds.implementation.priorityqueue.array

import com.ds.implementation.priorityqueue.common.PriorityQueueNode
import com.ds.implementation.priorityqueue.common.PriorityQueueOperation

class PriorityQueue<T>(private val size: Int = 10) : PriorityQueueOperation<T> {

    private val priorityQueue = Array<PriorityQueueNode<T>?>(size) { null }

    private var front = -1
    private var rear = -1


    override fun enqueue(value: PriorityQueueNode<T>): Boolean {
        if (isFull()) {
            printWaringMessage("Failed to enqueue $value as Queue is full")
            return false
        }
        if (front == -1) {
            front++
            rear++
            priorityQueue[front] = value
            return true
        }
        for(i in rear downTo front) {
            if (value.priority > priorityQueue[i]?.priority!!) {
                for (j in (front) downTo i)
                {
                    priorityQueue[j+1] = priorityQueue[j]
                }
                priorityQueue[i] = value
                break
            }
        }
        priorityQueue[++rear] = value
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


    override fun peek(): PriorityQueueNode<T>? {
        if (isEmpty()) {
            printWaringMessage("Failed to Peek as Queue is empty")
            return null
        }
        return priorityQueue[front]
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
        for (index in front .. rear) {
            if (priorityQueue[index] != null)
                println("Position $index Entry -> ${priorityQueue[index]?.value} and Priority ${priorityQueue[index]?.priority}")
        }
    }

    private fun printWaringMessage(msg: String?) {
        msg?.let { println(it) }
    }
}
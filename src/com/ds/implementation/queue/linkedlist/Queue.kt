package com.ds.implementation.queue.linkedlist

import com.ds.implementation.linkedlist.singly.ListNode
import com.ds.implementation.queue.common.QueueOperation

class Queue<T> : QueueOperation<T> {

    private var head: ListNode<T>? = null

    private var front: ListNode<T>? = null
    private var rear: ListNode<T>? = null


    override fun enqueue(value: T): Boolean {
        val node = ListNode(value)

        if (head == null) {
            front = node
            rear = node
            head = rear
        } else {
            rear?.next = node
            rear = rear?.next
        }
        return true
    }

    override fun dequeue(): Boolean {
        if (isEmpty()) {
            printWaringMessage("Failed to dequeue as Queue is empty")
            return false
        }
        front = front?.next
        head = front
        if(front == null) rear = null
        return true
    }

    override fun peek(): T? {
        if (isEmpty()) {
            printWaringMessage("Failed to Peek as Queue is empty")
            return null
        }
        return front?.value
    }

    override fun isEmpty(): Boolean {
        if(front == null) {
            rear = null
            head = null
            return true
        }
        return false
    }


    override fun isFull(): Boolean = false


    override fun print(msg: String?) {
        msg?.let { println(it) }
        println("Front of Queue ${front?.value}")
        println("Rear of Queue ${rear?.value}")
        if (isEmpty()) {
            println("Queue is empty")
            return
        }
        var current = head
        while (current != null) {
            println("Position Entry -> ${current.value}")
            current = current.next
        }
    }

    private fun printWaringMessage(msg: String?) {
        msg?.let { println(it) }
    }
}

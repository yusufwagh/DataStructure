package com.ds.implementation.priorityqueue.linkedlist

import com.ds.implementation.linkedlist.singly.ListNode
import com.ds.implementation.priorityqueue.common.PriorityQueueNode
import com.ds.implementation.priorityqueue.common.PriorityQueueOperation

class PriorityQueue<T> : PriorityQueueOperation<T> {

    private var head: ListNode<PriorityQueueNode<T>>? = null
    private var front: ListNode<PriorityQueueNode<T>>? = null
    private var rear: ListNode<PriorityQueueNode<T>>? = null


    override fun enqueue(value: PriorityQueueNode<T>): Boolean {
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
        var current = head
        var priority = head?.value?.priority?:0
        var node = head
        var pos = 0
        var counter = 0
        while (current != null) {
            if(priority < current.value .priority)
            {
                node = current
                priority = node.value.priority
                pos = counter
            }
            counter++
            current = current.next
        }
        current = head
        var prev = head
        counter = 0
        while (current != null)
        {
            if(counter == pos)
            {
                prev?.next = current.next
                return true
            }
            prev = current
            current = current.next
            counter++
        }
        return false
    }

    override fun peek(): PriorityQueueNode<T>? = front?.value

    override fun isEmpty(): Boolean = head == null

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
            println("Position Entry -> ${current.value.value} and Priority ${current.value.priority}")
            current = current.next
        }
    }

    private fun printWaringMessage(msg: String?) {
        msg?.let { println(it) }
    }

}
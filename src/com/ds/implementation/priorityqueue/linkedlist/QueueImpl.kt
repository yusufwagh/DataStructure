package com.ds.implementation.priorityqueue.linkedlist

import com.ds.implementation.priorityqueue.common.PriorityQueueNode

fun main() {
    val queue = PriorityQueue<Int>()
    queue.enqueue(PriorityQueueNode(1,10))
    queue.enqueue(PriorityQueueNode(3, 20))
    queue.enqueue(PriorityQueueNode(2, 30))
    queue.enqueue(PriorityQueueNode(22, 15))
    queue.print()
    queue.dequeue()
    queue.print()
}
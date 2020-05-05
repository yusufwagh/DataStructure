package com.ds.implementation.priorityqueue.array

import com.ds.implementation.priorityqueue.common.PriorityQueueNode

fun main() {
    val queue = PriorityQueue<Int>()

   for(i in 1..10)
       queue.enqueue(PriorityQueueNode(i,10-i))
    queue.print("Enqueue 1 - 10")

    queue.dequeue()
    queue.print("Dequeue")




}
package com.ds.implementation.queue.linkedlist

fun main() {
    val queue = Queue<Int>()

    for (i in 1 until 6)
        queue.enqueue(i)

    queue.print("After enqueuing 1 - 6")

    for (i in 1 until 6)
        queue.dequeue()

    queue.print("After dequeuing 1 - 6")

    for (i in 1 until 2)
        queue.enqueue(i)
    queue.print("After enqueuing 1")



}
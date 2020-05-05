package com.ds.implementation.queue.array

fun main() {
    val queue = Queue<Int>()

    queue.enqueue(11)
    queue.enqueue(10)
    for (i in 1..9)
    queue.enqueue(i)

    queue.print("Before enqueuing 9")
    queue.dequeue()
    queue.dequeue()
    queue.enqueue(9)
    queue.enqueue(10)
    queue.print("After enqueuing 9 and 10")
    for (i in 0..12)
        queue.dequeue()
    queue.print("After dequeue all items")
    queue.enqueue(1)
    queue.print("After enqueue to 1 queue")


}
package com.ds.implementation.stack.linkedList

import com.ds.implementation.linkedlist.singly.ListNode
import com.ds.implementation.stack.common.StackOperation

class Stack<T> : StackOperation<T> {

    private var top: ListNode<T>? = null

    override fun push(value: T): Boolean {
        val newTop = ListNode(value)
        if (top == null) {
            top = newTop
        } else {
            newTop.next = top
            top = newTop
        }
        return true
    }

    override fun pop(): T? {
        if (top == null) {
            return null
        } else {
            val topValue = top?.value
            val newTop = top?.next
            top = newTop
            return topValue
        }
    }

    override fun print(msg: String?) {
        msg?.let { println(it) }
        var current = top
        println("Top of Stack is ${current?.value}")
        while (current != null)
        {
            println("Entry -> ${current.value}")
            current = current.next
        }

    }
}
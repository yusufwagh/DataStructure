package com.ds.implementation.stack.array

import com.ds.implementation.stack.common.StackOperation

class Stack<T>(private val size: Int) : StackOperation<T> {

    private var top = -1
    private val stack = Array<StackNode<T>?>(size) { null }


    override fun push(value: T) : Boolean {
        if(isFull()) return false
        top++
        stack[top] = StackNode(value)
        return true
    }

    override fun pop(): T? {
        if(isEmpty()) return null
        val node = stack[top]
        stack[top] = null
        top--
        return node?.value
    }


    override fun print(msg: String?) {
        msg?.let { println(it) }
        println("Top of Stack is $top")
        for (index in top downTo 0) {
            if(stack[index] != null)
                println("Position $index Entry -> ${stack[index]?.value}")
        }
    }

    private fun isEmpty(): Boolean = top < 0

    private fun isFull(): Boolean = top >= size - 1
}

data class StackNode<T>(val value: T)

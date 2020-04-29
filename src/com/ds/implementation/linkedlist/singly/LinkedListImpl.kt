package com.ds.implementation.linkedlist.singly

import com.ds.implementation.linkedlist.common.LinkedListOperation
import com.ds.implementation.linkedlist.common.Node

class LinkedListImpl<T>(private var head: ListNode<T>?) : LinkedListOperation<T> {
    override fun insert(t: T): Boolean {
        if (head == null) {
            head = ListNode(t)
        } else {
            val current = head
            head = ListNode(t)
            head?.next = current
        }
        return true
    }

    override fun insertAtPosition(t: T, position: Int): Boolean {
        if (position == -1) return false
        if (position == 0 || head == null) {
            return insert(t)
        }
        var index = 0
        var current = head
        val iNode = ListNode(t)
        var prev = head

        while (current != null) {
            if (position == index) {
                prev?.next = iNode
                iNode.next = current
                return true
            }
            prev = current
            current = current.next
            index++
        }
        prev?.next = iNode
        return true
    }

    override fun insertAfterNode(t: T, node: Node<T>): Boolean {
        if (head == null) {
            return insert(t)
        }
        var index = 0
        var current = head
        val iNode = ListNode(t)
        var prev = head
        while (current != null) {
            if (node.value == current.value) {
                val next = current.next
                current.next = iNode
                iNode.next = next
                return true
            }
            prev = current
            current = current.next
            index++
        }
        prev?.next = iNode
        return false
    }

    override fun searchByValue(t: T): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (t == current.value) {
                return index
            }
            index++
            current = current.next
        }
        return -1
    }

    override fun searchByNode(node: Node<T>): Int {
       return searchByValue(node.value)
    }

    override fun delete(): Boolean {
        if (head == null) return false
        val newHead = head?.next
        head = null
        head = newHead
        return true
    }

    override fun deleteAtPosition(position: Int): Boolean {
        if (position == -1) return false
        if (position == 0) delete()
        var index = 0
        var current = head
        var prev = head

        while (current != null) {
            if (position == index) {
                prev?.next = current.next
                return true
            }
            prev = current
            current = current.next
            index++
        }
        return false
    }

    override fun deleteAfterNode(node: Node<T>): Boolean {
        var current = head
        while (current != null) {
            if (node.value == current.value) {
                current.next = current.next?.next
                return true
            }
            current = current.next
        }
        return false
    }

    override fun deleteNode(node: Node<T>): Boolean {
        if (head == null) return false
        if (node.value == head?.value) {
            delete()
            return true
        }
        var current = head
        var prev = head

        while (current != null) {
            if (current.value == node.value) {
                prev?.next = current.next
                return true
            }
            prev = current
            current = current.next
        }
        return false
    }

    override fun nodeAtIndex(index: Int): Node<T>? {
        var current = head
        var counter = 0
        while (current != null) {
            if (counter == index) {
                return current
            }
            counter++
            current = current.next
        }
        return null
    }

    override fun reverse() {
        var current = head
        var prev: ListNode<T>? = null
        var next: ListNode<T>? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }


    fun palindrome(){
        var current = head
        var c = ListNode(head?.value)
        var prev: ListNode<T>? = null
        var next: ListNode<T>? = null
        while (current?.next != null) {
            var newNode = ListNode(current.next!!.value)
            newNode.next = prev
            prev = newNode
            current = next
        }
        var valid = head
        var reverse = c
        var isPalindrome = true

        while (reverse!=null && valid != null)
        {
            if(reverse.value != valid.value)
            {
                isPalindrome = false
            }
            reverse = reverse.next!!
            valid = valid.next!!

        }
        println("Is Palindrome $isPalindrome")
    }

    override fun print(msg: String?) {
        msg?.let { println(it) }
        var current = head
        do {
            kotlin.io.print("|${current?.value}|->")
            current = current?.next
        } while (current != null)
        kotlin.io.print("X")
        println()
    }
}
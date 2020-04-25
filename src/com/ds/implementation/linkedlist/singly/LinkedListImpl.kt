package com.ds.implementation.linkedlist.singly

import com.ds.implementation.linkedlist.common.LinkedListOperation
import com.ds.implementation.linkedlist.common.Node

class LinkedListImpl<T>(private var head: ListNode<T>?) : LinkedListOperation<T> {
    override fun insert(t: T) {
        if (head == null) {
            head = ListNode(t)
        } else {
            val current = head
            head = ListNode(t)
            head?.next = current
        }
    }

    override fun insertAtPosition(t: T, position: Int): Boolean {
        if (position == -1) return false
        if (position == 0 || head == null) {
            insert(t)
            return true
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
            insert(t)
            return true
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

    override fun searchByValue(t: T): Node<T>? {
        var current = head
        while (current != null) {
            if (t == current.value) {
                return Node(t)
            }
            current = current.next
        }
        return null
    }

    override fun searchByNode(node: Node<T>): Node<T>? {
        var current = head
        while (current != null) {
            if (node.value == current.value) {
                return node
            }
            current = current.next
        }
        return null
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

    override fun reverse() {
        var current = head
        var prev: ListNode<T>? = null
        var next: ListNode<T>? = null
        while (current != null)
        {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }
}
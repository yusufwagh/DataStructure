package com.ds.implementation.linkedlist.doubly

import com.ds.implementation.linkedlist.common.LinkedListOperation
import com.ds.implementation.linkedlist.common.Node

class DoublyLinkedListImpl<T>(private var head: DListNode<T>?) : LinkedListOperation<T> {
    override fun insert(t: T): Boolean {
        val node = DListNode(t)
        if (head == null) {
            head = node
        } else {
            val current = head
            current?.prev = node
            node.next = current
            head = node
        }
        return true
    }

    override fun insertAtPosition(t: T, position: Int): Boolean {
        if (position == -1) return false
        if (position == 0) return insert(t)
        var current = head
        var index = 0
        var prev = current?.prev
        val node = DListNode(t)
        while (current != null) {
            if (index == position) {
                prev = current.prev
                current.prev = node
                node.prev = prev
                node.next = current
                prev?.next = node
                return true
            }
            current = current.next
            index++
        }
        prev?.next = node
        node.prev = prev
        return true
    }

    override fun insertAfterNode(t: T, node: Node<T>): Boolean {
        if (head == null || head?.value == 0 == node.value) return insert(t)
        var current = head
        val newNode = DListNode(t)
        while (current != null) {
            if (node.value == current.value) {
                val next = current.next
                newNode.next = next
                newNode.prev = current
                newNode.next = next
                current.next = newNode
                next?.prev = newNode
                return true
            }
            current = current.next
        }
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
        val next = head?.next
        head = next
        return true
    }

    override fun deleteAtPosition(position: Int): Boolean {
        if (head == null) return false
        if (position == 0) return delete()
        var current = head
        var index = 0
        while (current != null) {
            if (position == index) {
                val next = current.next
                val prev = current.prev
                prev?.next = current.next
                next?.prev = current.prev
                return true
            }
            index++
            current = current.next
        }
        return false
    }

    override fun deleteAfterNode(node: Node<T>): Boolean {
        if (head == null) return false
        if (head?.value == node.value) return delete()
        var current = head
        while (current != null) {
            if (current.value == node.value) {
                val next = current.next
                current.next = next?.next
                next?.next?.prev = next?.prev
                return true
            }
            current = current.next
        }
        return false
    }

    override fun deleteNode(node: Node<T>): Boolean {
        if (head == null) return false
        if (head?.value == node.value) return delete()
        var current = head
        while (current != null) {
            if (current.value == node.value) {
                val prev = current.prev
                val next = current.next
                prev?.next = next
                next?.prev = prev
                return true
            }
            current = current.next
        }
        return false
    }

    override fun print(msg: String?) {
        msg?.let { println(it) }
        var current = head
        do {
            kotlin.io.print("|${current?.value}|<->")
            current = current?.next
        } while (current != null)
        kotlin.io.print("X")
        println()
    }

    override fun nodeAtIndex(index: Int): Node<T>? {
        var current = head
        while (current != null) {
            if (current.value == index) {
                return current
            }
            current = current.next
        }
        return null
    }

    override fun reverse() {
        var current = head
        var prev: DListNode<T>? = null
        var next: DListNode<T>? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev?.prev = current
            prev = current
            current = next
        }
        head = prev
    }

}
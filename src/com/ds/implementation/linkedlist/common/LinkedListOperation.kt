package com.ds.implementation.linkedlist.common

import com.ds.implementation.common.BaseOperation

interface LinkedListOperation<T> : BaseOperation {
    fun insert(t: T)
    fun insertAtPosition(t: T, position: Int): Boolean
    fun insertAfterNode(t: T, node: Node<T>): Boolean
    fun searchByValue(t: T): Node<T>?
    fun searchByNode(node: Node<T>): Node<T>?
    fun delete() : Boolean
    fun deleteAtPosition(position: Int): Boolean
    fun deleteAfterNode(node: Node<T>): Boolean
    fun deleteNode(node: Node<T>): Boolean
}
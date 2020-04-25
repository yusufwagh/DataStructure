package com.ds.implementation.linkedlist.doubly

import com.ds.implementation.linkedlist.common.Node


fun main() {
    val impl = DoublyLinkedListImpl<Int>(null)
    impl.insert(4)
    impl.insert(1)
    impl.insertAtPosition(2,1)
    impl.print("========Insertion 2 After position 1=============")
    impl.insertAfterNode(3,DListNode(2))
    impl.print("========Insertion 22 After Node 2  =============")
    impl.insertAfterNode(22,DListNode(2))
    impl.print("========Insertion 22 After Node 2  =============")
    impl.deleteAtPosition(2)
    impl.print("========Delete at position 2  =============")
    impl.deleteAfterNode(Node(1))
    impl.print("========Delete atfter Node 4 =============")
    impl.deleteNode(Node(3))
    impl.print("========Delete Node 3 =============")
    impl.insert(1)
    impl.insertAtPosition(3,2)
    impl.print("========Insertion 1 and 3 =============")
    impl.reverse()
    impl.print("Doubly Linked list reversede")


}
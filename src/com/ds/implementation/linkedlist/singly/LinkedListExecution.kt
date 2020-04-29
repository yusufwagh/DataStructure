package com.ds.implementation.linkedlist.singly

import com.ds.implementation.linkedlist.common.Node


fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node4.next = node5
    node3.next = node4
    node2.next = node3
    node1.next = node2

    val impl = LinkedListImpl(node1)
    impl.print()
    println("Search Result "+impl.searchByValue(3))
    println("Search Result "+impl.searchByValue(33))
    println("Search Result "+impl.searchByNode(Node(5)))
    println("Search Result "+impl.searchByNode(Node(11)))
    impl.print("========Before Insertion=============")
    impl.insert(0)
    impl.print("========Insertion 0=============")
    impl.insertAfterNode(11, ListNode(1))
    impl.print("========Insertion 11 Atfer position 1=============")
    impl.insertAtPosition(22, 3)
    impl.print("========Insertion 22 At position 3=============")
    impl.insertAtPosition(222, 0)
    impl.print("========Insertion 222 At position 0=============")
    impl.insertAtPosition(555, 8)
    impl.print("========Insertion 555 At position 8=============")
    impl.insertAtPosition(9999, 10)
    impl.print("========Insertion 9999 At position 10=============")
    impl.deleteAtPosition(0)
    impl.delete()
    impl.deleteAtPosition(8)
    impl.print("========Delete first two values and last=============")
    impl.deleteAfterNode(ListNode(11))
    impl.print("========Delete node after 11=============")
    impl.deleteAtPosition(1)
    impl.print("========Delete node at position 1=============")
    impl.deleteAtPosition(4)
    impl.print("========Delete node at position 4=============")
    impl.nodeAtIndex(2)?.let { println("Node at index 2 -> |${it.value}|") }
    impl.nodeAtIndex(22)?.let { println("Node at index 2 -> |${it.value}|") }?:println("No node found at Index 22")
    impl.reverse()
    impl.print("Linked list reversed")
    impl.palindrome()

}
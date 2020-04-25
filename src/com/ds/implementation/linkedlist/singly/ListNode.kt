package com.ds.implementation.linkedlist.singly

import com.ds.implementation.linkedlist.common.Node

data class ListNode<T>(override var value : T,
                       var next: ListNode<T>? = null) : Node<T>(value)
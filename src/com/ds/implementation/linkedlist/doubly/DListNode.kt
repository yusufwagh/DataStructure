package com.ds.implementation.linkedlist.doubly

import com.ds.implementation.linkedlist.common.Node

data class DListNode<T>(override var value : T, var next: DListNode<T>? = null, var prev: DListNode<T>? = null): Node<T>(value)
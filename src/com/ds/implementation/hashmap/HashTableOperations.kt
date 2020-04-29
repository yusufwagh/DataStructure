package com.ds.implementation.hashmap

import com.ds.implementation.common.BaseOperation

interface HashTableOperations<K,V> : BaseOperation {
    fun add(key : K, value : V)
    fun remove(key : K) : Boolean
    fun get(key: K) : V?
}
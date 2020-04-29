package com.ds.implementation.hashmap

data class HashNode<K, V>(val key: K, val value: V, var next: HashNode<K, V>? = null)
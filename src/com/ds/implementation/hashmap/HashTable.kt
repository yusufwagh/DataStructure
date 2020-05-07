package com.ds.implementation.hashmap

import kotlin.math.abs

class HashTable<K, V>(private val size: Int) : HashTableOperations<K,V>{

    private val table = Array<HashNode<K, V>?>(size) { null }

    private fun createKey(key: K): Int = abs(key.hashCode() % size)


    override fun put(key: K, value: V) {
        val hashNode = HashNode(key, value)
        val hashKey = createKey(key)
        if(table[hashKey] == null)
        {
            table[hashKey] = hashNode
        } else {
            var head = table[hashKey]
            while (head?.next != null)
            {
                head = head.next
            }
            head?.next = hashNode
        }
    }

    override fun remove(key: K) : Boolean {
        val hashKey = createKey(key)
        if(table[hashKey] == null) return false
        else {
            var head = table[hashKey]
            var prev = head
            while (head != null) {
                if(head.key?.equals(key) == true)
                {
                    prev?.next = head.next
                    return true
                }
                prev = head
                head = head.next
            }
        }
        return false
    }

    override fun get(key: K): V? {
        val hashKey = createKey(key)
        if(table[hashKey] == null) return null
        else {
            var head = table[hashKey]
            while (head?.next != null) {
                if(head.key?.equals(key) == true)
                {
                   return head.value
                }
                head = head.next
            }
        }
        return null
    }

    override fun print(msg: String?) {
        msg?.let { println(it) }
        table.forEachIndexed { index, hashNode ->
            kotlin.io.print("HashKey $index Entries ->")
            var head = hashNode
            while (head != null)
            {
                kotlin.io.print("|${head.key}:${head.value}|->")
                head = head.next
            }
            kotlin.io.print("X")
            println()
        }
    }
}

fun main() {
    //Name and Age
    val table = HashTable<String, Int>(10)
    table.put("John", 32)
    table.put("Sam", 22)
    table.put("Asm", 22)
    table.put("Jimmy", 11)
    table.put("Adam", 23)
    table.print()
    table.remove("Sam")
    table.print("After removing Sam")

}
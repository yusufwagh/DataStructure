package com.ds.implementation.search.binary

fun main() {
    val arr = arrayOf(1,2,3,4,5,6,7,8,9)

println(binarySearch(arr, 0 , arr.size - 1, 9))
}


fun  binarySearch(array: Array<Int>, start: Int, end: Int, value: Int, iteration : Int = 0) : Int{
    println(" ===== Iteration $iteration ===== ")
    if(array.isEmpty()) return -1
    val mid = start + ((end - start)/2)
    println(" start -> $start")
    println(" mid -> $mid")
    println(" end -> $end")
    if(array[mid] == value) return mid

    return if(array[mid] > value) binarySearch(array, start, mid-1, value, iteration+1)
    else binarySearch(array, mid + 1 , end, value, iteration+1)
}
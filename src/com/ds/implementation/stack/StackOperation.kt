package com.ds.implementation.stack

import com.ds.implementation.common.BaseOperation

interface StackOperation<T> : BaseOperation {
    fun push(value: T) : Boolean
    fun pop(): T?
}
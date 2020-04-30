package com.ds.implementation.stack.common

import com.ds.implementation.common.BaseOperation

interface StackOperation<T> : BaseOperation {
    fun push(value: T) : Boolean
    fun pop(): T?
}
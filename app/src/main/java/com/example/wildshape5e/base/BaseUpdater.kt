package com.example.wildshape5e.base

interface BaseUpdater<S> {
    fun performUpdate(prevState: S): S
}
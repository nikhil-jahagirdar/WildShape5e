package com.example.wildshape5e.base

sealed class DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>()
    object Loading : DataResult<Nothing>()
    data class Error(val errorMessage: String) : DataResult<Nothing>()
}
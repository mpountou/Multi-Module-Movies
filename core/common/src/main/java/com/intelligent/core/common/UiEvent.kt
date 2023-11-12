package com.intelligent.core.common

sealed class UiEvent<out T> {
    object Loading : UiEvent<Nothing>()
    data class Success<T>(val data: T) : UiEvent<T>()
    data class Error(val message: String) : UiEvent<Nothing>()
}

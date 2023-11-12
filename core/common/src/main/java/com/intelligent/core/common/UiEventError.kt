package com.intelligent.core.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch


fun <T> Flow<UiEvent<T>>.errorCatch() = this.catch {
    emit(UiEvent.Error(message = it.message.orEmpty()))
}
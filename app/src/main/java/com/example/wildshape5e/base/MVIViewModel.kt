package com.example.wildshape5e.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class MVIViewModel<S>(initialState: S) : ViewModel() {
    private val _state: MutableState<S> = mutableStateOf(initialState)
    val state: State<S> = _state
    private val updateFlow = MutableSharedFlow<BaseUpdater<S>>()
    private val _eventFlow = MutableSharedFlow<BaseEvent>()
    val eventFlow: SharedFlow<BaseEvent> = _eventFlow

    init {
        viewModelScope.launch {
            updateFlow.collect { updater ->
                _state.value = updater.performUpdate(state.value)
            }
        }
    }

    private fun sendUpdate(update: BaseUpdater<S>) {
        viewModelScope.launch {
            updateFlow.emit(update)
        }
    }

    private fun sendEvent(event: BaseEvent) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    val performAction: (BaseAction<S>) -> Unit = { action ->
        viewModelScope.launch {
            action.performAction(state.value, ::sendUpdate, ::sendEvent)
        }
    }
}
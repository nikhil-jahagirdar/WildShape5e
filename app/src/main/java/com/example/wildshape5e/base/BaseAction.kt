package com.example.wildshape5e.base

interface BaseAction<S> {
    suspend fun performAction(
        currentState: S,
        sendUpdater: (BaseUpdater<S>) -> Unit,
        sendEvent: (BaseEvent) -> Unit
    )
}
package com.example.wildshape5e.base

import android.content.Context
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

interface BaseEvent {
    fun performEvent(context: Context, navigator: DestinationsNavigator)
}
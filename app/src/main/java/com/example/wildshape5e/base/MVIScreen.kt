package com.example.wildshape5e.base


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun <State> MVIScreen(
    navigator: DestinationsNavigator,
    viewModel: MVIViewModel<State>,
    initialAction: BaseAction<State>? = null,
    content: @Composable ((State) -> Unit),
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        initialAction?.let { viewModel.performAction(initialAction) }
        viewModel.eventFlow.collect { event ->
            event.performEvent(context, navigator)
        }
    }
    content(viewModel.state.value)
}
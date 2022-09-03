package com.example.wildshape5e.beastlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.wildshape5e.base.BaseAction
import com.example.wildshape5e.base.DataResult
import com.example.wildshape5e.base.MVIScreen
import com.example.wildshape5e.beastlist.actions.FilterClickedAction
import com.example.wildshape5e.beastlist.actions.InitBeastListAction
import com.example.wildshape5e.repository.BeastDatabase
import com.example.wildshape5e.repository.BeastRepository
import com.example.wildshape5e.repository.BeastWebService
import com.example.wildshape5e.ui.BeastCard
import com.example.wildshape5e.ui.FilterCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.Dispatchers


@RootNavGraph(start = true)
@Destination
@Composable
fun BeastListScreen(navigator: DestinationsNavigator) {
    val viewModel = beastlistViewModel()
    val beastWebService = BeastWebService.getService()
    val infoDao = BeastDatabase.getDatabase(LocalContext.current).beastDao()
    val beastRepository = BeastRepository(beastWebService, Dispatchers.IO, infoDao)
    MVIScreen(
        navigator = navigator,
        viewModel = viewModel,
        InitBeastListAction(beastRepository)

    ) { BeastListScreenContent(it, viewModel.performAction) }
}

@Composable
fun BeastListScreenContent(
    state: BeastListState,
    performAction: (BaseAction<BeastListState>) -> Unit
) {
    when(state.beastListData) {
        is DataResult.Success -> {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(filterList) { item ->
                        FilterCard(name = item.message(state), {performAction(FilterClickedAction(item))})
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    items(state.filteredBeastList) { item ->
                        BeastCard(name = item.name)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
            if(state.filterClicked != null) {
                state.filterClicked.popUp(state = state, performAction = performAction)
            }
        }
        is DataResult.Error -> {
            Text(state.beastListData.errorMessage)
        }
        is DataResult.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
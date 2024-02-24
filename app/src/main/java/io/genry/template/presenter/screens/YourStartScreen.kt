package io.genry.template.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import io.genry.template.presenter.screens.components.ActionType
import io.genry.template.presenter.screens.components.AppBottomBar
import io.genry.template.presenter.screens.components.AppModal
import io.genry.template.presenter.screens.components.BoxContent
import io.genry.template.presenter.viewmodels.SharedViewModel
import io.genry.template.utils.factories.getOrCreateViewModel

private const val TAG = "YourStartScreen"


class YourStartScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = getOrCreateViewModel<SharedViewModel>()
        val state by viewModel.sharedState.collectAsStateWithLifecycle()
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        val scope = rememberCoroutineScope()
        var showBottomSheet = remember { mutableStateOf(false) }
        var (title, setTitle) = remember { mutableStateOf("") }
        var (description, setDescription) = remember { mutableStateOf("") }
        var currentAction = remember { mutableStateOf<ActionType?>(null) }
        val item by viewModel.item

        Scaffold(modifier = Modifier.fillMaxSize(),
            bottomBar = {
                AppBottomBar(
                    onAddClicked = {
                        currentAction.value = ActionType.ADD
                        showBottomSheet.value = true
                    })
            }) {
            if (showBottomSheet.value) {
                AppModal(
                    showBottomSheet,
                    sheetState,
                    currentAction,
                    title, setTitle, description, setDescription,
                    scope, viewModel,
                    item
                )
            }

            BoxContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.White),
                state,
                viewModel,
                showBottomSheet,
                currentAction
            )
        }
    }
}








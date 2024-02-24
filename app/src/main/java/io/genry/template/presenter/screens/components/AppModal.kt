package io.genry.template.presenter.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.genry.template.domain.models.ItemModel
import io.genry.template.presenter.mvi.Event
import io.genry.template.presenter.viewmodels.SharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppModal(
    showBottomSheet: MutableState<Boolean>,
    sheetState: SheetState,
    currentAction: MutableState<ActionType?>,
    title: String,
    setTitle: (String) -> Unit,
    description: String,
    setDescription: (String) -> Unit,
    scope: CoroutineScope,
    viewModel: SharedViewModel,
    item: ItemModel?
) {

    ModalBottomSheet(
        modifier = Modifier.fillMaxHeight(0.5f),
        containerColor = Color.White,
        onDismissRequest = {
            showBottomSheet.value = false
        },
        sheetState = sheetState
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (currentAction.value) {
                    ActionType.ADD -> {
                        AddScaffoldContent(
                            title, setTitle,
                            description, setDescription,
                            scope, sheetState, showBottomSheet, viewModel
                        )
                    }

                    ActionType.EDIT -> {
                        EditScaffoldContent(
                            scope,sheetState,showBottomSheet,viewModel,item
                        )
                    }

                    ActionType.DELETE -> {
                        DeleteScaffoldContent(
                            item,
                            viewModel, scope,
                            sheetState,
                            showBottomSheet
                        )
                    }

                    else -> {}
                }
            }
        }
    }
}





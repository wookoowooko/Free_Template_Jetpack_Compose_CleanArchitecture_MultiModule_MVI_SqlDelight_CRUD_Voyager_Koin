package io.genry.template.presenter.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import io.genry.template.domain.models.ItemModel
import io.genry.template.presenter.mvi.Event
import io.genry.template.presenter.viewmodels.SharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteScaffoldContent(
    item: ItemModel?,
    viewModel: SharedViewModel,
    scope: CoroutineScope,
    sheetState: SheetState,
    showBottomSheet: MutableState<Boolean>
) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Delete?",
            color = Color.Black,
            fontSize = 22.sp
        )
        item?.let { item ->
            Text(
                text = item.id.toString(),
                color = Color.Black,
                fontSize = 22.sp
            )
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 22.sp
            )
            Text(
                text = item.description,
                color = Color.Black,
                fontSize = 14.sp
            )
            Button(onClick = {
                viewModel.onEvent(Event.DeleteItemById(id = item.id))
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet.value = false
                    }
                }
            }) {
                Text(
                    text = "yes",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
            Button(onClick = {
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet.value = false
                    }
                }
            }) {
                Text(
                    text = "cancel",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
    }
}

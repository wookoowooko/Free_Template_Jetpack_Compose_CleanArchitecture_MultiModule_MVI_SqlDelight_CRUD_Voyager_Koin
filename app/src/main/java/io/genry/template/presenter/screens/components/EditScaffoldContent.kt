package io.genry.template.presenter.screens.components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.genry.template.domain.models.ItemModel
import io.genry.template.presenter.mvi.Event
import io.genry.template.presenter.viewmodels.SharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val TAG = "EditScaffoldContent"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScaffoldContent(
    scope: CoroutineScope,
    sheetState: SheetState,
    showBottomSheet: MutableState<Boolean>,
    viewModel: SharedViewModel,
    item: ItemModel?
) {

    val (title, setTitle) = remember { mutableStateOf(item?.title ?: "") }
    val (description, setDescription) = remember { mutableStateOf(item?.description ?: "") }

    val itemToUpdate =
        item?.let {
            ItemModel(
                id = it.id,
                title = title,
                description = description
            )
        }

    Log.d(TAG, "itemToUpdate->: $itemToUpdate")

    Text(
        text = "Title",
        color = Color.Black
    )
    TextField(
        value = title,
        onValueChange = { titleChanged ->
            setTitle(titleChanged)
        }
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Description",
        color = Color.Black
    )
    TextField(
        value = description,
        onValueChange = { descriptionChanged ->
            setDescription(descriptionChanged)
        }
    )
    Spacer(modifier = Modifier.height(10.dp))
    Button(onClick = {
        scope.launch {
            sheetState.hide()
        }.invokeOnCompletion {
            if (!sheetState.isVisible) {
                showBottomSheet.value = false
            }
        }

    }) {
        Text("Cancel")
    }
    Button(onClick = {
        scope.launch {
            sheetState.hide()
        }.invokeOnCompletion {
            if (!sheetState.isVisible) {
                showBottomSheet.value = false
            }
        }

        if (itemToUpdate != null) {
            viewModel.onEvent(
                Event.UpdateItemById(id = item.id, item = itemToUpdate)
            )
        }

    }) {
        Text("Done")
    }
}


package io.genry.template.presenter.screens.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.genry.template.presenter.mvi.State
import io.genry.template.presenter.viewmodels.SharedViewModel

@Composable
fun BoxContent(
    modifier: Modifier = Modifier,
    state: State,
    viewModel: SharedViewModel,
    showBottomSheet: MutableState<Boolean>,
    currentAction: MutableState<ActionType?>
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.allItems) { item ->
                    Item(item = item,
                        onDelete = {
                            viewModel.setItem(item)
                            showBottomSheet.value = true
                            currentAction.value = ActionType.DELETE
                        },
                        onUpdate = {
                            viewModel.setItem(item)
                            showBottomSheet.value = true
                            currentAction.value = ActionType.EDIT
                        }
                    )
                }
            }
        }
    }
}
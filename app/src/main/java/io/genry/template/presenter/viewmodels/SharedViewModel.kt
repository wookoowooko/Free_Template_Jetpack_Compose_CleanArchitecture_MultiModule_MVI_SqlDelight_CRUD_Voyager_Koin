package io.genry.template.presenter.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.genry.template.domain.models.ItemModel
import io.genry.template.domain.usecases.CreateNewItemUseCase
import io.genry.template.domain.usecases.DeleteItemByIdUseCase
import io.genry.template.domain.usecases.GetAllItemsUseCase
import io.genry.template.domain.usecases.UpdateItemByIdUseCase
import io.genry.template.presenter.mvi.Event
import io.genry.template.presenter.mvi.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SharedViewModel(

    private val getAllItemsUseCase: GetAllItemsUseCase,
    private val createNewItemUseCase: CreateNewItemUseCase,
    private val updateItemByIdUseCase: UpdateItemByIdUseCase,
    private val deleteItemByIdUseCase: DeleteItemByIdUseCase

) : ViewModel() {

    private val _sharedState = MutableStateFlow(State())

    val sharedState = combine(
        _sharedState,
        getAllItemsUseCase()
    ) { sharedState, allItems ->
        sharedState.copy(
            allItems = allItems
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), State())


    var item: MutableState<ItemModel?> = mutableStateOf(null)
        private set


    fun setItem(newItem: ItemModel) {
        item.value = newItem
    }

    fun onEvent(event: Event) {
        when (event) {
            is Event.CreateNewItem -> {
                viewModelScope.launch {
                    createNewItemUseCase.execute(
                        title = event.title,
                        description = event.description
                    )
                }
            }

            is Event.DeleteItemById -> {
                viewModelScope.launch {
                    deleteItemByIdUseCase.execute(event.id)
                }
            }

            is Event.UpdateItemById -> {
                viewModelScope.launch {
                    updateItemByIdUseCase.execute(
                        id = event.id, item = event.item
                    )
                }
            }
        }
    }
}
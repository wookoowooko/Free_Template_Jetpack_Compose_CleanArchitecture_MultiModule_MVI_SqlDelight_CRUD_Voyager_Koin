package io.genry.template.presenter.mvi

import io.genry.template.domain.models.ItemModel

sealed interface Event {

    data class CreateNewItem(val title: String, val description: String) : Event
    data class DeleteItemById(val id: Long) : Event
    data class UpdateItemById(val id:Long, val item:ItemModel) : Event
}
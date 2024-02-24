package io.genry.template.presenter.mvi

import io.genry.template.domain.models.ItemModel

data class State(
   val allItems:List<ItemModel> = emptyList()
)
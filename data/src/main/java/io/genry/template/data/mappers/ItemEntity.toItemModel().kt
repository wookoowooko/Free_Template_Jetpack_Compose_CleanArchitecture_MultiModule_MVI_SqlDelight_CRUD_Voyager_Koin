package io.genry.template.data.mappers

import database.ItemEntity
import io.genry.template.domain.models.ItemModel

fun ItemEntity.toItemModel(): ItemModel {
    return ItemModel(
        id = id,
        title = title,
        description = description
    )
}
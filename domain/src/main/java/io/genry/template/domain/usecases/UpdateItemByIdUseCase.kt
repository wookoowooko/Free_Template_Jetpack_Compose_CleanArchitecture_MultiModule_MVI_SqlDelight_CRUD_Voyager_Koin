package io.genry.template.domain.usecases

import io.genry.template.domain.models.ItemModel
import io.genry.template.domain.repositories.IDataSource

class UpdateItemByIdUseCase(
    private val iDataSource: IDataSource
) {
    suspend fun execute(id: Long, item: ItemModel) = iDataSource.updateItemById(id, item)
}
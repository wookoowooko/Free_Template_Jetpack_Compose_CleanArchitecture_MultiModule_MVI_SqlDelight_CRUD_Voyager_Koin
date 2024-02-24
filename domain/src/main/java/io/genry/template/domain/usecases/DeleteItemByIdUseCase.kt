package io.genry.template.domain.usecases

import io.genry.template.domain.repositories.IDataSource

class DeleteItemByIdUseCase(
    private val iDataSource: IDataSource
) {
    suspend fun execute(id:Long) = iDataSource.deleteItemById(id)
}
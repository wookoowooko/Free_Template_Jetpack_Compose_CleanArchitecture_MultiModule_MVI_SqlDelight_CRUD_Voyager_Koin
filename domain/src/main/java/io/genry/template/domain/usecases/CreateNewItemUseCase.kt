package io.genry.template.domain.usecases

import io.genry.template.domain.repositories.IDataSource

class CreateNewItemUseCase(
    private val iDataSource: IDataSource
) {
    suspend fun execute(title:String,description:String) = iDataSource.createNewItem(title,description)
}
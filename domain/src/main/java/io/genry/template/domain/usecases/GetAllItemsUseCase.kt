package io.genry.template.domain.usecases

import io.genry.template.domain.repositories.IDataSource

class GetAllItemsUseCase(
    private val iDataSource: IDataSource
) {
    operator fun invoke() = iDataSource.getAllItems()

}
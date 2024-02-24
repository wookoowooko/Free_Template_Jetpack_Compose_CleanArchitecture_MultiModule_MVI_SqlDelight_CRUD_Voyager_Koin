package io.genry.template.data.repositoriesImplemetations

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import io.genry.template.data.mappers.toItemModel
import io.genry.template.db.TemplateDB
import io.genry.template.domain.models.ItemModel
import io.genry.template.domain.repositories.IDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataSourceImplementation(
    private val db: TemplateDB
) : IDataSource {

    private val queries = db.itemEntityQueries

    override fun getAllItems(): Flow<List<ItemModel>> {
        return queries.getAllItems().asFlow().mapToList(Dispatchers.IO)
            .map { list ->
                list.map { item ->
                    item.toItemModel()
                }
            }
    }


    override suspend fun createNewItem(title: String, description: String) {
        queries.createNewItem(title, description)
    }

    override suspend fun deleteItemById(id: Long) {
        queries.deleteItemById(id)
    }

    override suspend fun updateItemById(id: Long, item: ItemModel) {
        queries.updateItemById(id = id, newTitle = item.title, newDescription = item.description)
    }
}
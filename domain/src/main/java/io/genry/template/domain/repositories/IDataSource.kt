package io.genry.template.domain.repositories

import io.genry.template.domain.models.ItemModel
import kotlinx.coroutines.flow.Flow


interface IDataSource {

    fun getAllItems(): Flow<List<ItemModel>>

    suspend fun createNewItem(title:String, description:String)

    suspend fun deleteItemById(id: Long)

    suspend fun updateItemById(id: Long, item: ItemModel)

}
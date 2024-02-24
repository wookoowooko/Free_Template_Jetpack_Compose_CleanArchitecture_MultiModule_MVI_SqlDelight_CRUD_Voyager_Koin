package io.genry.template.di

import io.genry.template.domain.usecases.CreateNewItemUseCase
import io.genry.template.domain.usecases.DeleteItemByIdUseCase
import io.genry.template.domain.usecases.GetAllItemsUseCase
import io.genry.template.domain.usecases.UpdateItemByIdUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetAllItemsUseCase> { GetAllItemsUseCase(iDataSource = get()) }
    factory<CreateNewItemUseCase> { CreateNewItemUseCase(iDataSource = get()) }
    factory<UpdateItemByIdUseCase> { UpdateItemByIdUseCase(iDataSource = get()) }
    factory<DeleteItemByIdUseCase> { DeleteItemByIdUseCase(iDataSource = get()) }

}
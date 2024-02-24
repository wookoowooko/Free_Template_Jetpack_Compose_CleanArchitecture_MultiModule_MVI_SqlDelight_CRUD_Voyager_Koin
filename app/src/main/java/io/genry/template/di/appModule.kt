package io.genry.template.di


import io.genry.template.presenter.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<SharedViewModel> {
        SharedViewModel(
            getAllItemsUseCase = get(),
            createNewItemUseCase = get(),
            updateItemByIdUseCase = get(),
            deleteItemByIdUseCase = get()
        )
    }
}
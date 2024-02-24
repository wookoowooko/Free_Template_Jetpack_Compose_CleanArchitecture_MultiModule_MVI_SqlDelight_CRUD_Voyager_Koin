package io.genry.template.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

import io.genry.template.data.repositoriesImplemetations.DataSourceImplementation
import io.genry.template.db.TemplateDB
import io.genry.template.domain.repositories.IDataSource
import org.koin.dsl.module

val dataModule = module {

    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = TemplateDB.Schema,
            context = get(),
            name = "template.db"
        )
    }
    single<TemplateDB> {
        TemplateDB(
            driver = get()
        )
    }


    single<IDataSource> { DataSourceImplementation(
        db = get()
    ) }
}
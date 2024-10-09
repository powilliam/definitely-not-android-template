package com.example.template.di

import com.example.template.data.networking.jsonPlaceHolderClient
import com.example.template.data.repository.PostsRepository
import com.example.template.data.repository.PostsRepositoryImpl
import com.example.template.data.source.remote.PostsRemoteDataSource
import com.example.template.data.source.remote.PostsRemoteDataSourceImpl
import com.example.template.ui.viewmodel.HelloViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<PostsRemoteDataSource> {
        PostsRemoteDataSourceImpl(client = jsonPlaceHolderClient)
    }

    single<PostsRepository> {
        PostsRepositoryImpl(dataSource = get())
    }
}

val domainModule = module {
    includes(dataModule)

    viewModel { HelloViewModel(posts = get()) }
}

val uiModule = module {
    includes(dataModule, domainModule)
}

val mainModule = module {
    includes(dataModule, domainModule, uiModule)
}
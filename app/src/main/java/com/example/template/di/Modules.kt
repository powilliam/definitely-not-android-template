package com.example.template.di

import org.koin.dsl.module

val dataModule = module { }

val domainModule = module {
    includes(dataModule)
}

val uiModule = module {
    includes(dataModule, domainModule)
}

val mainModule = module {
    includes(dataModule, domainModule, uiModule)
}
package com.example.template.di

import org.koin.dsl.module

val dataModule = module { }

val domainModule = module { }

val uiModule = module { }

val mainModule = module {
    includes(dataModule, domainModule, uiModule)
}
package ru.andrey.di

import com.google.inject.AbstractModule
import ru.andrey.search.Searcher
import ru.andrey.settings.SearchEngineConfig

class SearcherModule : AbstractModule() {

    override fun configure() {
        bind(Searcher::class.java)
                .toProvider(SearcherProvider::class.java)
        bind(SearchEngineConfig::class.java)
                .toProvider(SearchEngineConfigProvider::class.java)
    }
}

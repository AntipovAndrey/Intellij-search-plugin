package ru.andrey.di

import com.google.inject.AbstractModule
import ru.andrey.search.Searcher

class SearcherModule : AbstractModule() {

    override fun configure() {
        bind(Searcher::class.java)
                .toProvider(SearcherProvider::class.java)
    }
}

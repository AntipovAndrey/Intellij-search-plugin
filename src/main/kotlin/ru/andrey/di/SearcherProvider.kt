package ru.andrey.di

import com.google.inject.Provider
import ru.andrey.search.Searcher
import ru.andrey.settings.Settings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearcherProvider @Inject constructor(private val settings: Settings) : Provider<Searcher> {

    override fun get() = settings.searchEngine.searcher
}

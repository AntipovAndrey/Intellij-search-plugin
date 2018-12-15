package ru.andrey.di

import com.google.inject.Provider
import javax.inject.Singleton
import ru.andrey.settings.SearchEngine
import ru.andrey.settings.SearchEngine.*
import ru.andrey.settings.Settings
import ru.andrey.search.GoogleSearcher
import ru.andrey.search.Searcher
import ru.andrey.search.StackOverflowGoogleSearcher
import ru.andrey.search.StackOverflowSearcher
import javax.inject.Inject

@Singleton
class SearcherProvider @Inject constructor(private val settings: Settings) : Provider<Searcher> {

    private val searchers: MutableMap<SearchEngine, Searcher> = HashMap();

    override fun get(): Searcher {
        return when (settings.searchEngine) {
            GOOGLE -> searchers.getOrPut(GOOGLE) { GoogleSearcher() }
            GOOGLE_STACKOVERFLOW -> searchers.getOrPut(GOOGLE_STACKOVERFLOW) { StackOverflowGoogleSearcher() }
            STACKOVERFLOW -> searchers.getOrPut(STACKOVERFLOW) { StackOverflowSearcher() }
        }
    }
}

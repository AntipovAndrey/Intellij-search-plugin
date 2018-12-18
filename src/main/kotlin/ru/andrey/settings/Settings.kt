package ru.andrey.settings

import ru.andrey.search.Searcher
import ru.andrey.settings.SearchEngine.GOOGLE
import javax.inject.Singleton

@Singleton
class Settings {

    val searcher: Searcher
        get() = searchEngine.searcher

    var searchEngine: SearchEngine = GOOGLE
}

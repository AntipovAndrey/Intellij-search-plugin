package ru.andrey.settings

import ru.andrey.search.Searcher
import ru.andrey.settings.SearchEngine.GOOGLE
import javax.inject.Singleton
import kotlin.properties.Delegates.observable

private typealias SearchEngineListener = (new: SearchEngine) -> Unit

@Singleton
class Settings {

    private val engineChangedListeners: MutableList<SearchEngineListener> = ArrayList()

    val searcher: Searcher
        get() = searchEngine.searcher

    var searchEngine: SearchEngine by observable(GOOGLE) { _, _, newValue ->
        engineChangedListeners.forEach { acceptor -> acceptor(newValue) }
    }

    fun onEngineChanged(listener: SearchEngineListener) = engineChangedListeners.add(listener)
}

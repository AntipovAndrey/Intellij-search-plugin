package ru.andrey.settings

import javax.inject.Singleton
import kotlin.properties.Delegates

private typealias SearchEngineListener = (new: SearchEngine) -> Unit

@Singleton
class Settings {

    private val engineChangedListeners: MutableList<SearchEngineListener> = ArrayList()

    var searchEngine: SearchEngine by Delegates.observable(SearchEngine.GOOGLE) { _, _, newValue ->
        engineChangedListeners.forEach { acceptor -> acceptor(newValue) }
    }

    fun onEngineChanged(listener: SearchEngineListener) = engineChangedListeners.add(listener)
}

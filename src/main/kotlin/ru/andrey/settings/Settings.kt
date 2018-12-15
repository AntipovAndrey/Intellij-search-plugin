package ru.andrey.settings

import javax.inject.Singleton

typealias SearchEngineListener = (new: SearchEngine) -> Unit

@Singleton
class Settings {

    private val engineChangedListeners: MutableList<SearchEngineListener> = ArrayList()

    var searchEngine: SearchEngine = SearchEngine.GOOGLE
        set(value) {
            field = value
            engineChangedListeners.forEach { acceptor -> acceptor(value) }
        }

    fun onEngineChanged(listener: SearchEngineListener) = engineChangedListeners.add(listener)
}

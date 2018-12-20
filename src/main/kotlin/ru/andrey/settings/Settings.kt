package ru.andrey.settings

import ru.andrey.settings.SearchEngine.GOOGLE
import javax.inject.Inject
import javax.inject.Singleton

private typealias SearchEngineListener = (new: SearchEngine) -> Unit

@Singleton
class Settings @Inject constructor(private val persistedConfig: SearchEngineConfig) {

    private val engineChangedListeners: MutableList<SearchEngineListener> = ArrayList()

    var searchEngine: SearchEngine = GOOGLE
        get() = persistedConfig.searchEngine ?: field
        set(value) {
            persistedConfig.searchEngine = value
            engineChangedListeners.forEach { it(value) }
        }

    fun onEngineChanged(listener: SearchEngineListener) = engineChangedListeners.add(listener)
}

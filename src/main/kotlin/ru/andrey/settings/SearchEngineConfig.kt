package ru.andrey.settings

import com.intellij.openapi.components.PersistentStateComponent
import ru.andrey.di.Di

class SearchEngineConfig : PersistentStateComponent<SearchEngine> {

    private val settings: Settings = Di[Settings::class]

    override fun getState(): SearchEngine {
        return settings.searchEngine
    }

    override fun loadState(searchEngine: SearchEngine) {
        settings.searchEngine = searchEngine
    }
}

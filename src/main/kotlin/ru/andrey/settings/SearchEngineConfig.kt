package ru.andrey.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
        name = "preferences.SearchEnginePluginConfig_search_engine",
        storages = [Storage("search_plugin.xml")]
)
class SearchEngineConfig : PersistentStateComponent<SearchEngineConfig> {

    var searchEngine: SearchEngine? = null

    override fun getState(): SearchEngineConfig {
        return this
    }

    override fun loadState(config: SearchEngineConfig) {
        XmlSerializerUtil.copyBean(config, this)
    }
}

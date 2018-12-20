package ru.andrey.di

import com.google.inject.Provider
import com.intellij.openapi.components.ServiceManager
import ru.andrey.settings.SearchEngineConfig
import javax.inject.Singleton

@Singleton
class SearchEngineConfigProvider : Provider<SearchEngineConfig> {

    override fun get() = ServiceManager.getService(SearchEngineConfig::class.java)
}

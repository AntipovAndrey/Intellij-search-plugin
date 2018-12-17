package ru.andrey.settings

import com.intellij.openapi.options.Configurable
import ru.andrey.di.Di
import ru.andrey.gui.SearchEngineSettingsGui
import javax.swing.JComponent

class SearchEngineConfigurable : Configurable {

    private val config: SearchEngineConfig = Di[SearchEngineConfig::class]

    private lateinit var settingsGui: SearchEngineSettingsGui

    override fun createComponent(): JComponent? {
        settingsGui = SearchEngineSettingsGui(config.state)
        return settingsGui.root
    }

    override fun getDisplayName() = "Change search engine"

    override fun isModified(): Boolean = settingsGui.selectedEngine() != config.state

    override fun apply() = config.loadState(settingsGui.selectedEngine())
}

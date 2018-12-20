package ru.andrey.settings

import com.intellij.openapi.options.Configurable
import ru.andrey.di.Di
import ru.andrey.gui.SearchEngineSettingsGui
import javax.swing.JComponent

class SearchEngineConfigurable : Configurable {

    private val settings: Settings = Di[Settings::class]

    private lateinit var settingsGui: SearchEngineSettingsGui

    override fun createComponent(): JComponent? {
        settingsGui = SearchEngineSettingsGui(settings.searchEngine)
        return settingsGui.root
    }

    override fun getDisplayName() = "Change search engine"

    override fun isModified(): Boolean = settingsGui.selectedEngine() != settings.searchEngine

    override fun apply() {
        settings.searchEngine = settingsGui.selectedEngine()
    }
}

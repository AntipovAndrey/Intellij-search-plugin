package ru.andrey.gui

import ru.andrey.settings.SearchEngine
import javax.swing.JPanel
import javax.swing.JRadioButton

class SearchEngineSettingsGui(engine: SearchEngine) {

    private lateinit var googleRadioButton: JRadioButton
    private lateinit var googleStackOverflowRadioButton: JRadioButton
    private lateinit var stackOverflowRadioButton: JRadioButton

    lateinit var root: JPanel

    init {
        when (engine) {
            SearchEngine.GOOGLE -> googleRadioButton.isSelected = true
            SearchEngine.GOOGLE_STACKOVERFLOW -> googleStackOverflowRadioButton.isSelected = true
            SearchEngine.STACKOVERFLOW -> stackOverflowRadioButton.isSelected = true
        }
    }

    fun selectedEngine(): SearchEngine {
        return when {
            googleRadioButton.isSelected -> SearchEngine.GOOGLE
            googleStackOverflowRadioButton.isSelected -> SearchEngine.GOOGLE_STACKOVERFLOW
            stackOverflowRadioButton.isSelected -> SearchEngine.STACKOVERFLOW
            else -> throw IllegalStateException()
        }
    }
}

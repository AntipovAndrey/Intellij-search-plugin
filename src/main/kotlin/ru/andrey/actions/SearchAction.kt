package ru.andrey.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import ru.andrey.di.Di
import ru.andrey.search.Searcher
import ru.andrey.settings.SearchEngine
import ru.andrey.settings.Settings

class SearchAction : AnAction() {

    private val settings: Settings = Di[Settings::class]

    override fun actionPerformed(e: AnActionEvent) {
        val caretModel = e.getData(LangDataKeys.EDITOR)!!.caretModel
        val term = caretModel.currentCaret.selectedText
        Di[Searcher::class].search(term)
    }

    override fun update(event: AnActionEvent) {
        updateActionAppearance(settings.searchEngine)
    }

    private fun updateActionAppearance(engine: SearchEngine) {
        with(templatePresentation) {
            text = engine.description
            icon = engine.icon
        }
    }
}

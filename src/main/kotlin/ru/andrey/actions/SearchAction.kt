package ru.andrey.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys.COPY_PROVIDER
import com.intellij.openapi.project.DumbAware
import ru.andrey.di.Di
import ru.andrey.settings.SearchEngine
import ru.andrey.settings.Settings

class SearchAction : AnAction(), DumbAware {

    private val settings: Settings = Di[Settings::class]

    init {
        updateActionAppearance(settings.searchEngine)
        settings.onEngineChanged(this::updateActionAppearance)
    }

    override fun actionPerformed(e: AnActionEvent) {
        e.getData(CommonDataKeys.EDITOR)?.let {
            val term = it.caretModel.currentCaret.selectedText
            settings.searcher.search(term)
        }
    }

    override fun update(event: AnActionEvent) {
        updateActionAppearance(settings.searchEngine)
        disableIfNothingToCopy(event)
    }

    private fun disableIfNothingToCopy(event: AnActionEvent) {
        val presentation = event.presentation
        val dataContext = event.dataContext
        val provider = COPY_PROVIDER.getData(dataContext)
        val available = provider != null &&
                provider.isCopyEnabled(dataContext) &&
                provider.isCopyVisible(dataContext)
        presentation.isEnabled = available
        presentation.isVisible = available
    }

    private fun updateActionAppearance(engine: SearchEngine) {
        with(templatePresentation) {
            text = engine.description
            icon = engine.icon
        }
    }
}

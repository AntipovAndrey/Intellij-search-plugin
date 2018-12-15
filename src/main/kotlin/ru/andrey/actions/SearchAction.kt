package ru.andrey.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.editor.Editor
import ru.andrey.di.Di
import ru.andrey.search.Searcher

class SearchAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val caretModel = e.getData<Editor>(LangDataKeys.EDITOR)!!.caretModel
        Di.getInstance(Searcher::class.java)
                .search(caretModel.currentCaret.selectedText)
    }
}

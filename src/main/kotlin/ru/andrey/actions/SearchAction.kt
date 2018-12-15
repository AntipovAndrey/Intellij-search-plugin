package ru.andrey.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.editor.Editor
import ru.andrey.search.GoogleSearcher

class SearchAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val caretModel = e.getData<Editor>(LangDataKeys.EDITOR)!!.caretModel
        GoogleSearcher().search(caretModel.currentCaret.selectedText)
    }
}

package ru.andrey.search

import com.intellij.ide.BrowserUtil
import com.intellij.util.io.URLUtil.encodeURIComponent

abstract class BrowserSearcher : Searcher {

    override fun search(term: String) {
        BrowserUtil.browse(url(term))
    }

    protected open fun url(term: String): String = "${baseUrl()}${queryUrl(encodeURIComponent(term))}"

    protected abstract fun baseUrl(): String

    protected abstract fun queryUrl(term: String): String
}
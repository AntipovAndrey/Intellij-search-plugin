package ru.andrey.search

import com.intellij.ide.BrowserUtil

abstract class BrowserSearcher : Searcher {

    override fun search(term: String?) {
        term?.let {
            BrowserUtil.browse(url(it))
        }
    }

    protected open fun url(term: String): String = "${baseUrl()}${queryUrl(term)}"

    abstract fun baseUrl(): String

    abstract fun queryUrl(term: String): String
}
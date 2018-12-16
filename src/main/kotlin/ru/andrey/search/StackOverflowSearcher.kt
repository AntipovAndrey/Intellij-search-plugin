package ru.andrey.search

class StackOverflowSearcher : BrowserSearcher() {

    override fun baseUrl() = "https://stackoverflow.com/"

    override fun queryUrl(term: String) = "search?q=$term"
}

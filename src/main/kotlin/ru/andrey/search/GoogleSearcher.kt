package ru.andrey.search

class GoogleSearcher : BrowserSearcher() {

    override fun baseUrl() = "https://www.google.com/"

    override fun queryUrl(term: String) = "?#newwindow=1&q=$term"
}

package ru.andrey.search

class StackOverflowGoogleSearcher : GoogleSearcher() {

    override fun queryUrl(term: String) = "?#newwindow=1&q=site:stackoverflow.com $term"
}

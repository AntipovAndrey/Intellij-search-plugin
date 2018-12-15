package ru.andrey.settings

import javax.inject.Singleton

@Singleton
class Settings {

    var searchEngine: SearchEngine = SearchEngine.GOOGLE
}

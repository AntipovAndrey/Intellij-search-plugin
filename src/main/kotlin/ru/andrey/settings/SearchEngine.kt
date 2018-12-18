package ru.andrey.settings

import com.intellij.openapi.util.IconLoader
import ru.andrey.search.GoogleSearcher
import ru.andrey.search.Searcher
import ru.andrey.search.StackOverflowGoogleSearcher
import ru.andrey.search.StackOverflowSearcher
import javax.swing.Icon

enum class SearchEngine(
        val description: String,
        val searcher: Searcher,
        val icon: Icon
) {

    GOOGLE(
            description = "Search with Google",
            searcher = GoogleSearcher(),
            icon = icon("google")
    ),

    GOOGLE_STACKOVERFLOW(
            description = "Search with Google on SO",
            searcher = StackOverflowGoogleSearcher(),
            icon = icon("stackoverflow")
    ),

    STACKOVERFLOW(
            description = "Search with StackOverflow",
            searcher = StackOverflowSearcher(),
            icon = icon("stackoverflow")
    )
}

private fun icon(name: String) = IconLoader.getIcon("/icon/$name.png")

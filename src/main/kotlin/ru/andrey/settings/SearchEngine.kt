package ru.andrey.settings

import ru.andrey.search.GoogleSearcher
import ru.andrey.search.Searcher
import ru.andrey.search.StackOverflowGoogleSearcher
import ru.andrey.search.StackOverflowSearcher

enum class SearchEngine {

    GOOGLE {

        override val description = "Search with Google"

        override val searcher = GoogleSearcher()
    },

    GOOGLE_STACKOVERFLOW {

        override val description = "Search with Google on SO"

        override val searcher = StackOverflowGoogleSearcher()
    },

    STACKOVERFLOW {

        override val description = "Search with StackOverflow"

        override val searcher = StackOverflowSearcher()
    };

    abstract val description: String

    abstract val searcher: Searcher
}

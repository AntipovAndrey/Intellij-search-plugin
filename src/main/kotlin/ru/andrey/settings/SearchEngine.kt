package ru.andrey.settings

enum class SearchEngine {

    GOOGLE {
        override val description = "Search with Google"
    },
    GOOGLE_STACKOVERFLOW {
        override val description = "Search with Google on SO"
    },
    STACKOVERFLOW {
        override val description = "Search with StackOverflow"
    };

    abstract val description: String
}

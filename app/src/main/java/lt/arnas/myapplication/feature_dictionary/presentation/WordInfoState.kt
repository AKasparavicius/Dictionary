package lt.arnas.myapplication.feature_dictionary.presentation

import lt.arnas.myapplication.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
    )

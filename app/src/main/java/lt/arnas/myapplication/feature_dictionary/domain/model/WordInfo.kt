package lt.arnas.myapplication.feature_dictionary.domain.model

import lt.arnas.myapplication.feature_dictionary.data.remote.dto.MeaningDto
import lt.arnas.myapplication.feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)

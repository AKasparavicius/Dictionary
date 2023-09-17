package lt.arnas.myapplication.feature_dictionary.data.remote.dto

import lt.arnas.myapplication.feature_dictionary.data.local.entity.WordInfoEntity
import lt.arnas.myapplication.feature_dictionary.domain.model.Meaning
import lt.arnas.myapplication.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity (
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
            )
    }
}
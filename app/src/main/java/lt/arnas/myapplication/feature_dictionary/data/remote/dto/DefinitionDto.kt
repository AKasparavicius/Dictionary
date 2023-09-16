package lt.arnas.myapplication.feature_dictionary.data.remote.dto

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)
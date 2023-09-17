package lt.arnas.myapplication.feature_dictionary.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import lt.arnas.myapplication.core.util.Resource
import lt.arnas.myapplication.feature_dictionary.domain.model.WordInfo
import lt.arnas.myapplication.feature_dictionary.domain.repository.WordInfoRepository

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}
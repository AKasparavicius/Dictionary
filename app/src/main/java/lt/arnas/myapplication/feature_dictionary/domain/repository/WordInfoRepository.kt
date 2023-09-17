package lt.arnas.myapplication.feature_dictionary.domain.repository

import kotlinx.coroutines.flow.Flow
import lt.arnas.myapplication.core.util.Resource
import lt.arnas.myapplication.feature_dictionary.domain.model.WordInfo

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}
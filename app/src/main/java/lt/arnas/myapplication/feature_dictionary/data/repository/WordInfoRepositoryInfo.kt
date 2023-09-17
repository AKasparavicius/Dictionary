package lt.arnas.myapplication.feature_dictionary.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import lt.arnas.myapplication.core.util.Resource
import lt.arnas.myapplication.feature_dictionary.data.local.WordInfoDao
import lt.arnas.myapplication.feature_dictionary.data.remote.DictionaryApi
import lt.arnas.myapplication.feature_dictionary.domain.model.WordInfo
import lt.arnas.myapplication.feature_dictionary.domain.repository.WordInfoRepository
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfo = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        } catch(e: HttpException) {
            emit(Resource.Error(
                "Something went wrong!",
                data = wordInfos
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                "Could not reach the server, check your internet connection!",
                data = wordInfos
            ))
        }

        val newWordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}
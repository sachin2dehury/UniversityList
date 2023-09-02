package github.sachin2dehury.universitylist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UniversityPagingSource(private val repository: UniversityRepository) :
    PagingSource<Int, UniversityResponseItem>() {
    override fun getRefreshKey(state: PagingState<Int, UniversityResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UniversityResponseItem> =
        withContext(Dispatchers.IO) {
            val offset = params.key ?: 0
            val limit = params.loadSize
            val response = repository.getUniversityList(offset, limit).body()
            val nextOffset = if (response.isNullOrEmpty()) null else offset + limit
            LoadResult.Page(response.orEmpty(), null, nextOffset)
        }
}

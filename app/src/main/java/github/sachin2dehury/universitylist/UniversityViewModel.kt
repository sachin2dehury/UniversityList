package github.sachin2dehury.universitylist

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(private val repository: UniversityRepository) :
    ViewModel() {

    private val pagingConfig = PagingConfig(10)

    fun getPager() = Pager(pagingConfig, 0) {
        UniversityPagingSource(repository)
    }
}

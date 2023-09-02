package github.sachin2dehury.universitylist

class UniversityRepository(private val apiService: ApiService) {

    suspend fun getUniversityList(offset: Int, limit: Int) =
        apiService.getUniversityList(offset, limit)
}

package github.sachin2dehury.universitylist

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search?country=india")
    suspend fun getUniversityList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<List<UniversityResponseItem>>
}

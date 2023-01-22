package ru.niisokb.makulin.sokbcats.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL_ENDPOINT_IMAGES = "images/search"
const val QUERY_IMAGE_SIZE = "size"
const val QUERY_CATS_LIMIT_PER_PAGE = "limit"
const val DEFAULT_IMAGE_SIZE = "small"
const val DEFAULT_LIMIT = 25

interface CatsApiService {

    @GET(API_URL_ENDPOINT_IMAGES)
    suspend fun getCats(
        @Query(QUERY_IMAGE_SIZE) imageSize: String = DEFAULT_IMAGE_SIZE,
        @Query(QUERY_CATS_LIMIT_PER_PAGE) limit: Int = DEFAULT_LIMIT
    ): List<CatDTO>

}
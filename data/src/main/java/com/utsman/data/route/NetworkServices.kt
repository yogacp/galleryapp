package com.utsman.data.route

import com.utsman.data.constant.RestConstant
import com.utsman.data.model.Photo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkServices {

    @GET("/photos")
    fun photos(
        @Query("page") page: Int,
        @Query("client_id") clientId: String = RestConstant.CLIENT_ID
    ): Deferred<Response<List<Photo>>>

    @GET("/photos/{id}")
    fun photo(
        @Path("id") id: String,
        @Query("client_id") clientId: String = RestConstant.CLIENT_ID
    ): Deferred<Response<Photo>>

}
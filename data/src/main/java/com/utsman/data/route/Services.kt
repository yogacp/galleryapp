package com.utsman.data.route

import com.utsman.data.ConstantValue
import com.utsman.data.model.Photo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Services {

    @GET("/photos")
    suspend fun photos(
        @Query("page") page: Int,
        @Query("client_id") clientId: String = ConstantValue.CLIENT_ID
    ): List<Photo>

    @GET("/photos/{id}")
    suspend fun photo(
        @Path("id") id: String,
        @Query("client_id") clientId: String = ConstantValue.CLIENT_ID
    ): Photo

}
package com.utsman.data.repository

import com.utsman.abstraction.state.ResultState
import com.utsman.data.model.Photo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PhotosRepository {
    suspend fun getPhoto(page: Int): List<Photo>
}
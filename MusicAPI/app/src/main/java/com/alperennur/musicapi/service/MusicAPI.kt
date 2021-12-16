package com.alperennur.musicapi.service

import com.alperennur.musicapi.model.MusicModel
import com.alperennur.musicapi.response.MusicResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAPI {

    @GET("search?")

    fun getData(@Query("term") term:String,@Query("country") country:String): Call<MusicResponse>
    //https://itunes.apple.com/search?term=sezen&country=tr
}
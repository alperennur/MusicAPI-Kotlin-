package com.alperennur.musicapi.service

class ApiUtils {

    companion object{

        private  const val BASE_URL = "https://itunes.apple.com/"

        fun getMusicInterface():MusicAPI{

            return RetrofitClient.getClient(BASE_URL).create(MusicAPI::class.java)
        }


    }
}
package com.alperennur.musicapi.response

import com.alperennur.musicapi.model.MusicModel
import com.google.gson.annotations.SerializedName

data class MusicResponse(

    @SerializedName("results")
    var results:List<MusicModel>,
    @SerializedName("resultCount")
    var resultCount:Int
)

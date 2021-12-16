package com.alperennur.musicapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MusicModel(
    @SerializedName("artistName")
    var artistName:String,
    @SerializedName("collectionName")
    var collectionName:String,
    @SerializedName("trackName")
    var trackName:String,
    @SerializedName("artworkUrl100")
    var artworkUrl100:String
    )
    :Serializable

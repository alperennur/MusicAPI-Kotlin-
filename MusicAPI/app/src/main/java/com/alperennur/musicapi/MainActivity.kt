package com.alperennur.musicapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.alperennur.musicapi.adapter.Adapter
import com.alperennur.musicapi.databinding.ActivityMainBinding
import com.alperennur.musicapi.model.MusicModel
import com.alperennur.musicapi.response.MusicResponse
import com.alperennur.musicapi.service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MainActivity : AppCompatActivity() {


private lateinit var binding: ActivityMainBinding
private lateinit var artistEdit:String

var musicList:ArrayList<MusicModel> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        artistEdit= intent.getStringExtra("artistName").toString()



        loadData(artistEdit)


    }


fun loadData(artistName:String){

    ApiUtils.getMusicInterface().getData(artistName,"tr").enqueue(

        object : Callback<MusicResponse>{
            override fun onResponse(call: Call<MusicResponse>, response: Response<MusicResponse>) {

                val templist= response.body()?.results
                templist?.let {

                    musicList= it as ArrayList<MusicModel>
                }

                val musicAdapter = Adapter(musicList)
                binding.recView.adapter=musicAdapter
                binding.recView.layoutManager= GridLayoutManager(this@MainActivity,2)
                binding.recView.setHasFixedSize(true)
             }

            override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                t.printStackTrace()

            }


        }

    )

}


}
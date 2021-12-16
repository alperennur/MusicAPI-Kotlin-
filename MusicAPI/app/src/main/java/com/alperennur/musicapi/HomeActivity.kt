package com.alperennur.musicapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alperennur.musicapi.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var artistName:String
    private var country :Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)



    }
    fun nextActivity(view: android.view.View) {

        artistName= binding.searchText.text.toString()
        val intent= Intent(this,MainActivity::class.java)
         intent.putExtra("artistName",artistName)
        startActivity(intent)
    }




}
package com.devslopes.shoeshock

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.shoeshock.databinding.ActivityDetailBinding
import com.devslopes.shoeshock.models.ShoeModel
import com.devslopes.shoeshock.repository.ShoeShockRepository

class ShoeDetailActivity : AppCompatActivity() {

    companion object {
        //const val SHOEMODEL = "SHOE_MODEL"
        const val SHOE = "SHOE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("RUN", "onCreate in ShoeDetailActivity")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val myDetailAdapter = ShoeAdapter(
            ShoeShockRepository.getShoes(),
         onItemClicked = { ShoeModel ->
            val current = Intent(this, ShoeDetailActivity::class.java).apply {
                putExtra("Shoe_Model", ShoeModel.image)
                putExtra("Shoe_Model", ShoeModel.title)
                putExtra("Shoe_Model", ShoeModel.price)
                putExtra("Shoe_Model", ShoeModel.description)
            }
            startActivity(current)
        })
    }
}

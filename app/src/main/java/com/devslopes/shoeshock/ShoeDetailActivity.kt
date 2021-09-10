package com.devslopes.shoeshock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.shoeshock.databinding.ActivityDetailBinding
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.models.ShoeModel
import com.devslopes.shoeshock.repository.ShoeShockRepository

class ShoeDetailActivity : AppCompatActivity() {

    companion object {
        const val SHOE = "SHOE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("RUN", "onCreate in ShoeDetailActivity")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val current = intent.getStringExtra(SHOE).orEmpty()
        val item = ShoeShockRepository.getItemDetail(current)
        Log.v("DETAIL", "ITEM = $item")

        binding.itemDetail.apply {
            val displayPrice = "$" + item.price.toString()
            binding.shoeName.text = item.title
            binding.shoePrice.text = displayPrice
            binding.shoeDescription.text = item.description
            binding.shoeImage.setImageResource(item.image)
        }
        startActivity(intent)
    }
}

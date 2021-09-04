package com.devslopes.shoeshock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devslopes.shoeshock.databinding.ActivityDetailBinding
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.repository.ShoeShockRepository

class ShoeDetailActivity : AppCompatActivity() {

    companion object {
        const val SHOE = "SHOE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

}
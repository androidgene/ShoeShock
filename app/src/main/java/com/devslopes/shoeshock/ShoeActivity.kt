package com.devslopes.shoeshock

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.models.ShoeModel
import com.devslopes.shoeshock.repository.ShoeShockRepository

const val SHOE_ID = "SHOE ID"

class ShoeActivity: AppCompatActivity() {

    companion object {
        const val SHOE = "SHOE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val shoe = intent.getStringExtra(SHOE).orEmpty()
        //val item = ShoeShockRepository.getItemDetail(shoe)

    }

    private fun adapterOnClick(shoe: ShoeModel) {
        val intent2 = Intent(this, ShoeDetailActivity::class.java)
        Log.v("ONCLICK", "Intent2 created")
        intent2.putExtra(SHOE_ID, shoe.title)
        Log.v("ONCLICK", "Shoe selected = ${shoe.title}")
        startActivity(intent2)
    }

}
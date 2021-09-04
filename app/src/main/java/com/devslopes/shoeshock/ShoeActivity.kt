package com.devslopes.shoeshock

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.models.ShoeModel

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


        binding.shoeList.setOnClickListener {
            val intent2 = Intent(this, ShoeDetailActivity::class.java)
            intent2.putExtra(SHOE, shoe)
            startActivity(intent2)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
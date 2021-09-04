package com.devslopes.shoeshock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.repository.ShoeShockRepository

//private val viewModel = ShoeShockViewModel()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shoeList.apply {
            adapter =  ShoeAdapter(
                ShoeShockRepository.getShoes()
            ){ shoeModel ->
                val intent = Intent(this@MainActivity, ShoeActivity::class.java)
                intent.putExtra(ShoeActivity.SHOE, shoeModel.title)
                startActivity(intent)
            }
            layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL, false)
        }

    }

}
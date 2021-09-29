package com.devslopes.shoeshock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devslopes.shoeshock.databinding.ActivityMainBinding
import com.devslopes.shoeshock.models.ShoeModel
import com.devslopes.shoeshock.repository.ShoeShockRepository

//private val viewModel = ShoeShockViewModel()

class MainActivity : AppCompatActivity() {

    companion object {
        const val SHOE = "SHOE_MODEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shoeList.apply {
            adapter =  ShoeAdapter(
                ShoeShockRepository.getShoes()
            ){ shoeModel ->
                val intent = Intent(this@MainActivity, ShoeActivity::class.java)
                intent.putExtra(MainActivity.SHOE, shoeModel.brand)
                intent.putExtra(MainActivity.SHOE, shoeModel.title)
                intent.putExtra(MainActivity.SHOE, shoeModel.price)
                intent.putExtra(MainActivity.SHOE, shoeModel.image)
                startActivity(intent)
            }
            layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL, false)
        }

    }

}
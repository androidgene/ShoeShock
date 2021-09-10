package com.devslopes.shoeshock.repository

import com.devslopes.shoeshock.R
import com.devslopes.shoeshock.databinding.ActivityCartBinding
import com.devslopes.shoeshock.models.ShoeModel

object ShoeShockRepository {

    private val shoes = listOf(
        ShoeModel(
            1,
            "Converse",
            "Chuck Taylor All Star",
            R.drawable.converse01red,
            "Converse Chuck Taylor® All Star® Core Hi",
            54.99,
            mutableListOf(7.0, 7.5, 8.0, 8.5, 10.0)
        ),
        ShoeModel(
            2,
            "Nike",
            "Nike Air Jordan 1",
            R.drawable.nike01,
            "Nike Air Jordan 1 Mid Shoes Chicago 2020 Red White Black 554724-173 Men's or GS",
            250.99,
            mutableListOf(8.0, 9.0, 11.0)
        )
    )

    fun getShoes() = shoes

    fun getItemDetail(item: String): ShoeModel {
        return when(item) {
            "Chuck Taylor All Star" -> shoes[0]
            "Nike Air Jordan 1" -> shoes[1]
            else -> ShoeModel(
                999999,
                "",
                "",
                1,
                "",
                0.00,
                mutableListOf(0.0)
            )
        }
    }
}
package com.devslopes.shoeshock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devslopes.shoeshock.databinding.ItemShoeBinding
import com.devslopes.shoeshock.models.ShoeModel

class ShoeAdapter(
    private val shoeList: List<ShoeModel>,
    private val onClick: (ShoeModel) -> Unit
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoeBinding.inflate(layoutInflater, parent, false)
        return ShoeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.bind(shoe)
        holder.binding.root.setOnClickListener(){
            onClick(shoe)
        }

    }

    override fun getItemCount(): Int = shoeList.size

    class ShoeViewHolder(
        val binding: ItemShoeBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(shoe: ShoeModel) {
            binding.apply {
                shoeBrand.text = shoe.brand
                shoeTitle.text = shoe.title
                shoePrice.text = '$' + shoe.price.toString()
                imageShoe.setImageResource(shoe.image)
            }
        }

    }
}
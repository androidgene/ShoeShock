package com.devslopes.shoeshock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devslopes.shoeshock.databinding.ItemShoeBinding
import com.devslopes.shoeshock.models.ShoeModel
import com.devslopes.shoeshock.repository.ShoeShockRepository.getItem

class ShoeAdapter(
    private val shoeList: List<ShoeModel>,
    private val onItemClicked: (ShoeModel) -> Unit
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoeBinding.inflate(layoutInflater, parent, false)
        return ShoeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(shoe)
        }
        holder.bind(shoe)
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
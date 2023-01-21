package ru.niisokb.makulin.sokbcats.featureCatsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.ItemCatslistRecyclerBinding
import ru.niisokb.makulin.sokbcats.model.Cat

class CatsListAdapter :
    PagingDataAdapter<Cat, CatsListAdapter.ViewHolder>(CatsDiffUtilsCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cat = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_catslist_recycler,
            parent,
            false
        )
        return ViewHolder(
            binding = ItemCatslistRecyclerBinding.bind(view)
        )
    }

    inner class ViewHolder(
        private val binding: ItemCatslistRecyclerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat?) {
            if (cat != null && cat.imageUrl.isNotBlank()) {
                loadImage(url = cat.imageUrl)
            }
        }

        private fun loadImage(url: String) {
            with(binding) {
                imageViewItemCatImg.load(data = url)
            }
        }

    }

}

class CatsDiffUtilsCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}
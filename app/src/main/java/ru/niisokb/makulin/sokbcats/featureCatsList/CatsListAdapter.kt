package ru.niisokb.makulin.sokbcats.featureCatsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.ItemCatslistRecyclerBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.ui.CatsDiffUtilsCallback

class CatsListAdapter(
    private val onSetFavorite: (Cat) -> Unit,
    private val navigateToDetails: (Cat) -> Unit
) :
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
            if (cat != null) {
                if (cat.imageUrl.isNotBlank()) {
                    loadImage(url = cat.imageUrl)
                }
                setupListeners(cat)
            }
        }

        private fun setupListeners(cat: Cat) {
            with(binding) {
                btnItemToFavorite.setOnClickListener {
                    onSetFavorite(cat)
                }
                root.setOnClickListener {
                    navigateToDetails(cat)
                }
            }
        }

        private fun loadImage(url: String) {
            with(binding) {
                imageViewItemCatImg.load(data = url)
            }
        }

    }

}


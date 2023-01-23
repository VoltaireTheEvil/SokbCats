package ru.niisokb.makulin.sokbcats.featureFavorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.ItemFavoriteRecyclerBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.ui.CatsDiffUtilsCallback

class FavoriteAdapter(
    private val onDeleteCat: (Cat) -> Unit,
    private val navigateToDetails: (Cat) -> Unit
) : ListAdapter<Cat, FavoriteAdapter.ViewHolder>(CatsDiffUtilsCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_favorite_recycler, parent, false)
        return ViewHolder(
            binding = ItemFavoriteRecyclerBinding.bind(view)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cat = currentList[position])
    }


    inner class ViewHolder(
        private val binding: ItemFavoriteRecyclerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat) {
            if (cat.imageUrl.isNotBlank()) {
                loadImage(url = cat.imageUrl)
            }
            setupListeners(cat)
        }

        private fun setupListeners(cat: Cat) {
            with(binding) {
                btnItemDelete.setOnClickListener {
                    onDeleteCat(cat)
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
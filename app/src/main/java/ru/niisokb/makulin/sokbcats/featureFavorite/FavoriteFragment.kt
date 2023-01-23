package ru.niisokb.makulin.sokbcats.featureFavorite

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.launch
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.FragmentFavoriteBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.di.appComponent
import ru.niisokb.makulin.sokbcats.utils.navigation.navigate
import ru.niisokb.makulin.sokbcats.utils.ui.makeSnackbar
import javax.inject.Inject

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding: FragmentFavoriteBinding by viewBinding()

    @Inject
    lateinit var favoriteViewModelFactory: dagger.Lazy<FavoriteViewModel.Factory>

    private val favoriteViewModel: FavoriteViewModel by viewModels<FavoriteViewModel> {
        favoriteViewModelFactory.get()
    }

    private val adapter: FavoriteAdapter by lazy {
        FavoriteAdapter(
            onDeleteCat = ::deleteFromFavorite,
            navigateToDetails = ::navigateToDetails
        )
    }

    companion object {
        const val ERROR_MESSAGE = "Не удалось удалить"
        const val SUCCESS_DELETE_MESSAGE = "Удалено"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFavoriteList()
        collectState()
        getFavoriteList()
    }

    private fun collectState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                favoriteViewModel.uiState.collect { state ->
                    checkState(state)
                }
            }
        }
    }

    private fun checkState(state: FavoriteUiState) {
        when (state) {
            is FavoriteUiState.Error -> binding.root.makeSnackbar(ERROR_MESSAGE)
            FavoriteUiState.Nothing -> {}
            FavoriteUiState.SuccessDelete -> {
                binding.root.makeSnackbar(SUCCESS_DELETE_MESSAGE)
                getFavoriteList()
            }
            is FavoriteUiState.SuccessLoading -> adapter.submitList(state.cats)
        }
    }

    private fun getFavoriteList() {
        favoriteViewModel.getFavoriteCats()
    }

    private fun setupFavoriteList() {
        binding.rvFavoriteList.adapter = adapter
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    private fun deleteFromFavorite(cat: Cat) {
        favoriteViewModel.deleteCat(cat)
    }

    private fun navigateToDetails(cat: Cat) {
        navigate(R.id.action_favoriteFragment_to_detailsFragment, cat)
    }

}
package ru.niisokb.makulin.sokbcats.featureCatsList

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.FragmentCatslistBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.di.appComponent
import ru.niisokb.makulin.sokbcats.utils.navigation.navigate
import ru.niisokb.makulin.sokbcats.utils.ui.makeSnackbar
import javax.inject.Inject

class CatsListFragment : Fragment(R.layout.fragment_catslist) {

    private val binding: FragmentCatslistBinding by viewBinding()

    @Inject
    lateinit var catsListViewModelFactory: dagger.Lazy<CatsListViewModel.Factory>

    private val catsListViewModel: CatsListViewModel by viewModels<CatsListViewModel> {
        catsListViewModelFactory.get()
    }

    private val adapter: CatsListAdapter by lazy {
        CatsListAdapter(
            ::addToFavorite,
            ::navigateToDetails
        )
    }

    companion object {
        const val ERROR_MESSAGE = "Не удалось добавить в избранное"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCatsList()
        collectState()
    }

    private fun collectState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                catsListViewModel.uiState.collect { state ->
                    checkState(state)
                }
            }
        }
    }

    private fun checkState(state: CatsListUiState) {
        when (state) {
            is CatsListUiState.Error -> binding.root.makeSnackbar(ERROR_MESSAGE)
            CatsListUiState.Nothing -> {}
            is CatsListUiState.Success -> binding.root.makeSnackbar(state.message)
        }
    }

    private fun setupCatsList() {
        initAdapter()
        observeCats(adapter)
    }

    private fun observeCats(adapter: CatsListAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            catsListViewModel.catsFlow.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }

    private fun initAdapter() {
        binding.rvCatsList.adapter = adapter
    }

    private fun addToFavorite(cat: Cat) {
        catsListViewModel.addToFavorite(cat)
    }

    private fun navigateToDetails(cat: Cat) {
        navigate(R.id.action_catsListFragment_to_detailsFragment, cat)
    }

}
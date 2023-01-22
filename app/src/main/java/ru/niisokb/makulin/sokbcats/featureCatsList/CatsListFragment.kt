package ru.niisokb.makulin.sokbcats.featureCatsList

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.FragmentCatslistBinding
import ru.niisokb.makulin.sokbcats.utils.di.appComponent
import javax.inject.Inject

class CatsListFragment : Fragment(R.layout.fragment_catslist) {

    private val binding: FragmentCatslistBinding by viewBinding()

    @Inject
    lateinit var catsListViewModelFactory: dagger.Lazy<CatsListViewModel.Factory>

    private val catsListViewModel: CatsListViewModel by viewModels<CatsListViewModel> {
        catsListViewModelFactory.get()
    }

    private val adapter: CatsListAdapter by lazy {
        CatsListAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCatsList()

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

}
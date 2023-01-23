package ru.niisokb.makulin.sokbcats.featureDetails

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.FragmentDetailsBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.di.appComponent
import ru.niisokb.makulin.sokbcats.utils.navigation.navigationData
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding: FragmentDetailsBinding by viewBinding()

    private var cat: Cat? = null

    @Inject
    lateinit var detailsViewModelFactory: dagger.Lazy<DetailsViewModel.Factory>

    private val detailsViewModel: DetailsViewModel by viewModels<DetailsViewModel> {
        detailsViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCatData()
        initViews()
    }

    private fun initViews() {
        with(binding) {
            if (cat != null) {
                imageViewCatImg.load(cat!!.imageUrl)
                textViewIdText.text = cat!!.id
                btnDownloadImage.setOnClickListener {
                    detailsViewModel.downloadImage(cat!!.imageUrl)
                }
            }
        }
    }

    private fun getCatData() {
        cat = navigationData as Cat?
    }


}
package ru.niisokb.makulin.sokbcats.featureDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import ru.niisokb.makulin.sokbcats.R
import ru.niisokb.makulin.sokbcats.databinding.FragmentDetailsBinding
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.navigation.navigationData

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding: FragmentDetailsBinding by viewBinding()

    private var cat: Cat? = null

    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCatData()
        initViews()
    }

    private fun initViews() {
        with(binding) {
            imageViewCatImg.load(cat?.imageUrl)
            textViewIdText.text = cat?.id
            btnDownloadImage.setOnClickListener {
                //TODO download
            }
        }
    }

    private fun getCatData() {
        cat = navigationData as Cat?
    }


}
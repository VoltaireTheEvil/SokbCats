package ru.niisokb.makulin.sokbcats.utils.navigation

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

const val NAV_BUNDLE_KEY = "nav_bundle_key"

fun Fragment.navigate(actionId: Int, data: Parcelable?) {
    val navController = findNavController()
    val bundle = Bundle().apply {
        putParcelable(NAV_BUNDLE_KEY, data)
    }
    navController.navigate(actionId, bundle)
}

val Fragment.navigationData: Parcelable?
    get() = arguments?.getParcelable(NAV_BUNDLE_KEY)
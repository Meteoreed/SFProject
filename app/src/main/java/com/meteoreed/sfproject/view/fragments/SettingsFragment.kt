package com.meteoreed.sfproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.meteoreed.sfproject.R
import com.meteoreed.sfproject.databinding.FragmentSettingsBinding
import com.meteoreed.sfproject.utils.AnimationHelper
import com.meteoreed.sfproject.viewmodel.SettingsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SettingsFragmentViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(settings_fragment_root, requireActivity(), 5)
        viewModel.categoryPropertyLifeData.observe(viewLifecycleOwner) {
            when (it) {
                POPULAR_CATEGORY -> binding.radioGroup.check(R.id.radio_popular)
                TOP_RATED_CATEGORY -> binding.radioGroup.check(R.id.radio_top_rated)
                UPCOMING_CATEGORY -> binding.radioGroup.check(R.id.radio_upcoming)
                NOW_PLAYING_CATEGORY -> binding.radioGroup.check(R.id.radio_now_playing)
            }
        }
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radio_popular -> viewModel.putCategoryPreferences(POPULAR_CATEGORY)
                R.id.radio_top_rated -> viewModel.putCategoryPreferences(TOP_RATED_CATEGORY)
                R.id.radio_upcoming -> viewModel.putCategoryPreferences(UPCOMING_CATEGORY)
                R.id.radio_now_playing -> viewModel.putCategoryPreferences(NOW_PLAYING_CATEGORY)
            }
        }
    }

    companion object{
        private const val POPULAR_CATEGORY = "popular"
        private const val TOP_RATED_CATEGORY = "top_rated"
        private const val UPCOMING_CATEGORY = "upcoming"
        private const val NOW_PLAYING_CATEGORY = "now_playing"
    }
}
package com.meteoreed.sfproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.meteoreed.sfproject.databinding.FragmentSelectionsBinding
import com.meteoreed.sfproject.utils.AnimationHelper
import kotlinx.android.synthetic.main.fragment_selections.*

class SelectionsFragment : Fragment() {
    private var binding: FragmentSelectionsBinding? = null
    private val binding1 get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        return binding1.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(fragment_selections_root, requireActivity(), 4)
    }
}
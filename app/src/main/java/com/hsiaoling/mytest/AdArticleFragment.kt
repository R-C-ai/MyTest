package com.hsiaoling.mytest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hsiaoling.mytest.databinding.FragmentAdArticleBinding


/**
 * A simple [Fragment] subclass.
 */
class AdArticleFragment : Fragment() {
    private lateinit var binding : FragmentAdArticleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAdArticleBinding.inflate(inflater)
        binding.lifecycleOwner = this


        return binding.root
    }


}

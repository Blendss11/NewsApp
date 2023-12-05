package com.idnsolo.newsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.idnsolo.newsapp.NewsViewsModel
import com.idnsolo.newsapp.adapter.NewsAdapter
import com.idnsolo.newsapp.databinding.FragmentWarningBinding


class WarningFragment : Fragment() {
    private var _binding: FragmentWarningBinding? = null
    private val binding get() = _binding!!

    private var _warningNewsViewModel: NewsViewsModel? = null
    private val warningNewsViewModel get() = _warningNewsViewModel as NewsViewsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
// Inflate the layout for this fragment
        _binding = FragmentWarningBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _warningNewsViewModel = ViewModelProvider(this)[NewsViewsModel::class.java]
        warningNewsViewModel.warningForMuslimNews()
        warningNewsViewModel.warningForMuslimNews.observe(viewLifecycleOwner)
        { val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i("AboutAlQuranFragment", "onViewCreated: ${it.articles}")
            binding.rvWarningNews.apply { adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE }}
}
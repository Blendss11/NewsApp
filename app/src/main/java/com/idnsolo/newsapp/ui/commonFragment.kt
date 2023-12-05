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
import com.idnsolo.newsapp.databinding.FragmentCommonBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class commonFragment : Fragment() {
    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding as FragmentCommonBinding

    private var _commonNewsViewModel: NewsViewsModel? = null
    private val commonNewsViewModel get() = _commonNewsViewModel as NewsViewsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCommonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _commonNewsViewModel = ViewModelProvider(this)[NewsViewsModel::class.java]
        commonNewsViewModel.commonMuslimNews()
        commonNewsViewModel.commonMuslimNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i("CommonFragment", "onViewCreated: ${it.articles}")
            binding.rvCommonNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }

}

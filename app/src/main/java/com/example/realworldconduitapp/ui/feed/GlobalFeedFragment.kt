package com.example.realworldconduitapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.models.entities.Article
import com.example.realworldconduitapp.databinding.FragmentFeedBinding

class GlobalFeedFragment: Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private lateinit var viewModel: FeedViewModel
    private lateinit var feedAdapter: ArticleFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter()

        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        _binding?.feedRecyclerView?.layoutManager = LinearLayoutManager(context)

        _binding?.feedRecyclerView?.adapter = feedAdapter

        viewModel.feed.observe({lifecycle}){
            feedAdapter.submitList(it)
        }


        viewModel.fetchGlobalFeed()

        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
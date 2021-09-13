package com.iulian.iancu.spacetracker.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iulian.iancu.spacetracker.MainViewModelFactory
import com.iulian.iancu.spacetracker.R
import com.iulian.iancu.spacetracker.SpaceTrackerService
import com.iulian.iancu.spacetracker.data.SpaceRepository
import com.iulian.iancu.spacetracker.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLatestLaunches()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val retrofitService = SpaceTrackerService.getInstance()
        val weatherRepository = SpaceRepository(retrofitService)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(weatherRepository)
        ).get(MainViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, ::onStateChange)
    }

    private fun onStateChange(state: State?) {
        //TODO use the state for something
    }
}
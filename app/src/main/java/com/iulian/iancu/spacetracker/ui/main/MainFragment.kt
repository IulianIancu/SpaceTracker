package com.iulian.iancu.spacetracker.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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

    private val adapter = LaunchAdapter()

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
        binding.launchRecycler.adapter = adapter
        binding.launchRecycler.layoutManager = LinearLayoutManager(context)

        viewModel.state.observe(viewLifecycleOwner, ::onStateChange)
    }

    private fun onStateChange(state: State?) {
        state?.apply {
            result?.let { adapter.setData(it) }
            when (error) {
                Error.Network ->
                    Toast.makeText(context, R.string.error_network, Toast.LENGTH_SHORT).show()
                Error.Unknown ->
                    Toast.makeText(context, R.string.error_unknown, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
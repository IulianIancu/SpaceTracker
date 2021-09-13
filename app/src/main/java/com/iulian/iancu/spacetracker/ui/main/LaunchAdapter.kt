package com.iulian.iancu.spacetracker.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iulian.iancu.spacetracker.R
import com.iulian.iancu.spacetracker.data.Result
import com.iulian.iancu.spacetracker.databinding.LaunchItemBinding
import com.iulian.iancu.spacetracker.getFormattedDateFromUTC

@SuppressLint("NotifyDataSetChanged")
class LaunchAdapter : RecyclerView.Adapter<LaunchViewHolder>() {
    private var result: Result? = null

    fun setData(data: Result) {
        result = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LaunchItemBinding.inflate(inflater, parent, false)
        return LaunchViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.binding.apply {
            launchTitle.text = result?.name
            launchDescription.text = "Launch date: ${getFormattedDateFromUTC(result?.date_unix)}"
            Glide.with(launchIcon).load(result?.links?.patch?.small).into(launchIcon)
            if (result?.success == true) {
                Glide.with(checkImage).load(R.drawable.ic_baseline_check_24).into(checkImage)
            } else {
                Glide.with(checkImage).load(R.drawable.ic_baseline_close_24).into(checkImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (result != null) 1 else 0
    }
}

class LaunchViewHolder(val binding: LaunchItemBinding) : RecyclerView.ViewHolder(binding.root)
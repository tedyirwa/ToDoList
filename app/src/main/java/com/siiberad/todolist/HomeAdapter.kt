package com.siiberad.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siiberad.todolist.databinding.SingleItemBinding

class HomeAdapter(private val items: List<Language>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleItemBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.tvLangName.text = name
                binding.cbList.isChecked = isDone
                binding.cbList.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        // Do something when the checkbox is checked
                    } else {
                        // Do something when the checkbox is unchecked
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
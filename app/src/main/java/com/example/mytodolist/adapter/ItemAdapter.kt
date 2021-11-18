package com.example.mytodolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.databinding.ItemListBinding


class ItemAdapter( private val dataset: List<Tasks>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var onItemClick: ((Tasks) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.bind(item)

    }

    override fun getItemCount(): Int = dataset.size

    inner class ItemViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Tasks) {
            binding.tvTask1.text = task.title
            binding.cbWork.isChecked = task.isCompleted

            binding.cardid.setOnClickListener {
                onItemClick?.invoke(task)
               // fragment.findNavController().navigate(R.id.detailsPageFragment)
            }
        }

    }

}
package com.example.mytodolist.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.R
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.databinding.ItemListBinding
import com.example.mytodolist.fragments.TaskFragmentDirections
import com.example.mytodolist.viewmodel.TaskViewModel


class ItemAdapter(
    private  val context: Context?,
    private val dataset: MutableList<Tasks>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {



    class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
            var edit: ImageButton = view.findViewById(R.id.imageEdit)
            var delete: ImageButton = view.findViewById(R.id.imagedelete)
            var title :TextView = view.findViewById(R.id.tvTask1)
            var checkBox: CheckBox = view.findViewById(R.id.cbWork)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapter = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(adapter)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.title.text = item.title
        holder.checkBox.isChecked = item.isCompleted
        holder.edit.setOnClickListener {
            val action = TaskFragmentDirections.actionTaskFragmentToDetailsPageFragment2(
                title = item.title,
                check = item.isCompleted,
                index =  position
            )
            holder.itemView.findNavController().navigate(action)
        }
        holder.delete.setOnClickListener {
            dataset.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
return dataset.size
    }

}




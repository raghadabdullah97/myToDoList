package com.example.mytodolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.R
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.databinding.ItemListBinding


class ItemAdapter(
    private  val context: Context?,
    private val dataset: List<Tasks>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
   // var onItemClick: ((Tasks) -> Unit)? = null


     class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

            var title :TextView = view.findViewById(R.id.tvTask1)
            var checkBox: CheckBox = view.findViewById(R.id.cbWork)
//        fun bind(task: Tasks) {
//            binding.tvTask1.text = task.title
//            binding.cbWork.isChecked = task.isCompleted
////
//            binding.cardid.setOnClickListener {
//                onItemClick?.invoke(task)
//                // fragment.findNavController().navigate(R.id.detailsPageFragment)
//            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapter = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.title.text = item.title
        holder.checkBox.isChecked = item.isCompleted
    }

    override fun getItemCount(): Int {
return dataset.size
    }

}



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val adapter = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
////        val binding = ItemListBinding.inflate(inflater, parent, false)
//
//        return ItemAdapter.ItemViewHolder(adapter)
//    }
//
//    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
//        val item = dataset[position]
//
//        holder.bind(item)
//
//    }


//
//
//
//    override fun getItemCount(): Int =
//        dataset.size
//
//
//
//}
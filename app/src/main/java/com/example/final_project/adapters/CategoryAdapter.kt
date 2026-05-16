package com.example.final_project.adapters


import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.R
import com.example.final_project.databinding.ViewholderCategoryBinding
import com.example.final_project.domain.CategoryModel
import kotlinx.coroutines.delay

class CategoryAdapter(val item: MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
        private lateinit var context: Context
        private var selectedPosition = -1
        private var lastSelectedPosition = -1

     class ViewHolder(val binding: ViewholderCategoryBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.ViewHolder {
        context=parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item = item[position]
        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            Handler(Looper.getMainLooper()).postDelayed({
        }, 500)
    }
    if(selectedPosition == position){
        holder.binding.titleCat.setBackgroundResource(R.drawable.brown_full_corner_bg)
    }else {
        holder.binding.titleCat.setBackgroundResource(R.drawable.brown_2_full_corner)
    }

}
    override fun getItemCount(): Int =item.size
    }

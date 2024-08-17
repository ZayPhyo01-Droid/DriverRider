package com.sci.buildtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(
    private val onClickItem: (String) -> Unit
) : RecyclerView.Adapter<ColorViewHolder>() {

    private var list: List<ColorUiModel> = emptyList()

    fun updateList(colors: List<ColorUiModel>) {
        list = colors
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_color, parent, false)
        return ColorViewHolder(view, onClickItem)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
package com.sci.buildtype

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ColorViewHolder(view: View, val onClickItem: (String) -> Unit) : ViewHolder(view) {
    val viewColor = itemView.findViewById<View>(R.id.vColor)
    val tvColorName = itemView.findViewById<TextView>(R.id.tvColorName)

    fun bind(colorUiModel: ColorUiModel) {
        tvColorName.text = colorUiModel.colorModel.colorName
        viewColor.setBackgroundColor(
            Color.parseColor(colorUiModel.colorModel.colorHax)
        )
        if (colorUiModel.isSelect) {
            itemView.setBackgroundColor(Color.GRAY)
        } else {
            itemView.setBackgroundColor(Color.WHITE)
        }
        itemView.setOnClickListener {
            onClickItem(colorUiModel.colorModel.id)
        }
    }
}
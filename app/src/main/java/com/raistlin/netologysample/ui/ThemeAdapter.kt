package com.raistlin.netologysample.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.RecyclerView
import com.raistlin.netologysample.R
import com.raistlin.netologysample.logic.Theme

class ThemeAdapter(private val themes: List<Theme>) : RecyclerView.Adapter<ThemeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent, false)
        return ThemeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.updateView(themes[position])
    }

    override fun getItemCount() = themes.size

}

class ThemeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView = view.findViewById(R.id.theme_title)
    private val description: TextView = view.findViewById(R.id.theme_description)
    private val badge: View = view.findViewById(R.id.theme_badge)

    fun updateView(theme: Theme) {
        val context = title.context
        title.text = theme.title
        description.text = context.resources.getQuantityString(R.plurals.data_courses, theme.courses, theme.courses)
        badge.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.parseColor(theme.color), BlendModeCompat.SRC_ATOP)
    }
}
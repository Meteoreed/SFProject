package com.meteoreed.sfproject

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FilmListRecyclerAdapter(private val clickListener: OnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val item = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                holder.bind(item[position])
            }
        }
    }

    override fun getItemCount() = item.size

    fun addItems(list: List<Film>) {
        item.clear()
        item.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun click(film: Film)
    }
}
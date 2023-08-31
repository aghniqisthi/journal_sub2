package com.example.news

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news.databinding.ItemJournalBinding

class JournalAdapter(private var listJournal: ArrayList<Journal>): RecyclerView.Adapter<JournalAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemJournalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemJournalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, volume, _, _, image) = listJournal[position]
        holder.binding.txtJournalTitle.text = title
        holder.binding.txtJournalVol.text = volume
        holder.binding.imgJournalCover.setImageResource(image)

        holder.binding.cardJournal.setOnClickListener {
            val moveDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            moveDetail.putExtra("data", listJournal[position])
            holder.itemView.context.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int = listJournal.size

}
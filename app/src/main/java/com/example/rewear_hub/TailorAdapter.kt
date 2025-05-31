package com.example.rewear_hub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TailorAdapter(
    private val tailorList: List<Tailor>,
    private val onItemClick: (Tailor) -> Unit
) : RecyclerView.Adapter<TailorAdapter.TailorViewHolder>() {

    class TailorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageTailor)
        val nameTextView: TextView = itemView.findViewById(R.id.textTailorName)
        val ratingTextView: TextView = itemView.findViewById(R.id.textRating)
        val locationTextView: TextView = itemView.findViewById(R.id.textCity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TailorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tailor_card, parent, false)
        return TailorViewHolder(view)
    }

    override fun onBindViewHolder(holder: TailorViewHolder, position: Int) {
        val tailor = tailorList[position]
        holder.imageView.setImageResource(tailor.imageResId)
        holder.nameTextView.text = tailor.name
        holder.ratingTextView.text = "⭐ ${tailor.rating}"
        holder.locationTextView.text = "• ${tailor.location}"

        holder.itemView.setOnClickListener {
            onItemClick(tailor)
        }
    }

    override fun getItemCount() = tailorList.size
}
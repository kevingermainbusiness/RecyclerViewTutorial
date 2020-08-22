package com.kevincodes.recyclerviewtutorial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevincodes.recyclerviewtutorial.R
import com.kevincodes.recyclerviewtutorial.models.PlacesData
import kotlinx.android.synthetic.main.places_row.view.*

class PlaceAdapter(private val mContext: Context, private val clickListener:OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItemsData: List<PlacesData> = ArrayList()

    fun submitList(list: List<PlacesData>){
        mItemsData = list
    }

    private class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(place: PlacesData, clickAction:OnItemClickListener){
            itemView.icon.setImageResource(place.icon)
            itemView.title.text = place.title
            itemView.desc.text = place.desc
            itemView.row_country.text = place.country

            itemView.setOnClickListener { clickAction.onItemClick(adapterPosition) }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlacesViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.places_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(holder){
            is PlacesViewHolder -> {
                holder.bind(mItemsData[position],clickListener)
            }
            else -> return;
        }
    }

    override fun getItemCount():Int = mItemsData.size
}
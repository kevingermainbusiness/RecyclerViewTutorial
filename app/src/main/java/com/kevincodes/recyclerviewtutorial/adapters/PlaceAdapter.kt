package com.kevincodes.recyclerviewtutorial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevincodes.recyclerviewtutorial.R
import com.kevincodes.recyclerviewtutorial.models.PlacesData
import kotlinx.android.synthetic.main.places_row.view.*

class PlaceAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItemsData:List<PlacesData> = ArrayList()

    private class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(place: PlacesData){
            itemView.icon.setImageResource(place.icon)
            itemView.title.text = place.place
            itemView.desc.text = place.desc
            itemView.row_country.text = place.country
        }
    }

    fun submitList(list: List<PlacesData>){
        mItemsData = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlacesViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.places_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(holder) {
            is PlacesViewHolder ->{
                holder.bind(mItemsData[position])
            }
            else -> return;
        }
    }

    override fun getItemCount(): Int = mItemsData.size
}
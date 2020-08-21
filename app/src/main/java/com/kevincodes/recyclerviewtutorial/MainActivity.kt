package com.kevincodes.recyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevincodes.recyclerviewtutorial.adapters.PlaceAdapter
import com.kevincodes.recyclerviewtutorial.models.PlacesData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mPlaceAdapter: PlaceAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize(){
        val mPlacesData = ArrayList<PlacesData>()
        var mDisplayedPlacesList: MutableList<PlacesData> = ArrayList()

        // list of data going in the RecyclerView Adapter
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Chicago","Cool city","U.S.A"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Toronto","The Nicest City","Canada"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Buenos Aires","Fun to be there","Argentina"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Chicago","Cool city","U.S.A"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Toronto","The Nicest City","Canada"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Buenos Aires","Fun to be there","Argentina"))

        mDisplayedPlacesList.addAll(mPlacesData)
        mPlaceAdapter = PlaceAdapter(this)
        mPlaceAdapter.submitList(mDisplayedPlacesList)

        places_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mPlaceAdapter
        }
    }
}
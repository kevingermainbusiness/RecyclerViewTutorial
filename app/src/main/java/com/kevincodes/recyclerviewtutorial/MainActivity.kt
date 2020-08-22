package com.kevincodes.recyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevincodes.recyclerviewtutorial.adapters.PlaceAdapter
import com.kevincodes.recyclerviewtutorial.models.PlacesData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PlaceAdapter.OnItemClickListener{
    private lateinit var mPlaceAdapter: PlaceAdapter
    private lateinit var mDisplayedPlacesData: MutableList<PlacesData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }
    private fun initialize(){
        val mPlacesData = ArrayList<PlacesData>()
        mDisplayedPlacesData = ArrayList()

        // list of data going in the RecyclerView Adapter
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Chicago","Cool city","U.S.A"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Toronto","The Nicest City","Canada"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Buenos Aires","Fun to be there","Argentina"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Chicago","Cool city","U.S.A"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Toronto","The Nicest City","Canada"))
        mPlacesData.add(PlacesData(R.drawable.ic_android_black_24dp,"Buenos Aires","Fun to be there","Argentina"))

        mDisplayedPlacesData.addAll(mPlacesData)
        mPlaceAdapter = PlaceAdapter(this,this)
        mPlaceAdapter.submitList(mDisplayedPlacesData)
        places_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mPlaceAdapter
        }
    }

    private fun showToast(message: String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(position: Int) {

        val title:String = mDisplayedPlacesData[position].title
        showToast(title)
    }
}
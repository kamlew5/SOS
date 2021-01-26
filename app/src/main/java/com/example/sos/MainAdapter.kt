package com.example.sos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){
//    override fun getItemCount(): Int {
//        return 3
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val cellForRow = layoutInflater.inflate(R.layout.client_row, parent, false )
//        return CustomViewHolder(cellForRow)
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//}

//class CustomAdapter(private val dataSet: Array<String>) :
class CustomAdapter(val homeFeed: Parse_Patient) :
//class CustomAdapter(val homeFeed: HomeFeed) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = "Działa"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = 5
//    override fun getItemCount() = homeFeed.videos.count()

}


//class CustomViewHolder(v: View): RecyclerView.ViewHolder(v){
//
//}
package agh.hafid.shimmerapp.adapters

import agh.hafid.shimmerapp.R
import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.json.JSONObject

class PhotosAdapter(val data:MutableList<JSONObject>,val context:Context): RecyclerView.Adapter<PhotosAdapter.mViewHolder>() {

    class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image:ImageView
        var text:TextView

        init {
            image = itemView.findViewById(R.id.image)
            text = itemView.findViewById(R.id.text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return mViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val photo = data.get(position)
        val image = photo.getString("thumbnailUrl");
        val title = photo.getString("title")

        //Glide.with(context).load(image).into(holder.image)
        Picasso.get().load(image).into(holder.image)
        holder.text.setText(title)


    }

}
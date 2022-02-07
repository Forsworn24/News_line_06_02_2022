package mudinov.ali.lenta_06_02_2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mudinov.ali.lenta_06_02_2022.R
import mudinov.ali.lenta_06_02_2022.databinding.ActivityPhotoGalleryBinding
import mudinov.ali.lenta_06_02_2022.databinding.ImageItemGalleryBinding
import mudinov.ali.lenta_06_02_2022.databinding.ItemNameDogBinding

class PhotoGalleryAdapter(private val context: Context, var gallery: ArrayList<String>): RecyclerView.Adapter<GalleryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ImageItemGalleryBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.image_item_gallery, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(gallery[position])
    }

    override fun getItemCount(): Int {
        return gallery.size
    }
}

class GalleryViewHolder(val binding: ImageItemGalleryBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(gallery: String) {
        Picasso.get().load(gallery).into(binding.imageGalleryDog)
    }

}

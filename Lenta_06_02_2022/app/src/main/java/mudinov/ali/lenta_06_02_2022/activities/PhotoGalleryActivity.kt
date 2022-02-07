package mudinov.ali.lenta_06_02_2022.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import mudinov.ali.lenta_06_02_2022.R
import mudinov.ali.lenta_06_02_2022.adapter.PhotoGalleryAdapter
import mudinov.ali.lenta_06_02_2022.common.Common
import mudinov.ali.lenta_06_02_2022.databinding.ActivityPhotoGalleryBinding
import mudinov.ali.lenta_06_02_2022.retrofit.RetrofitServices

class PhotoGalleryActivity : AppCompatActivity() {

    private var binding: ActivityPhotoGalleryBinding? = null

    private var gallery: ArrayList<String>? = null
    private var photoGalleryAdapter: PhotoGalleryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_gallery)


        val galleryImage = intent.getStringExtra("gallery_image")

        gallery = ArrayList<String>()

        if (galleryImage != null) {
            gallery?.add(galleryImage)
        }
        if (galleryImage != null) {
            gallery?.add(galleryImage)
        }
        if (galleryImage != null) {
            gallery?.add(galleryImage)
        }
        if (galleryImage != null) {
            gallery?.add(galleryImage)
        }
        if (galleryImage != null) {
            gallery?.add(galleryImage)
        }
        binding?.listPhotosDogs?.layoutManager = LinearLayoutManager(this)
        photoGalleryAdapter = PhotoGalleryAdapter(baseContext, gallery!!)
        binding?.listPhotosDogs?.adapter = photoGalleryAdapter
    }
}


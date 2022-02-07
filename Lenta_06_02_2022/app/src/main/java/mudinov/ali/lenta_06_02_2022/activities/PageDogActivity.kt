package mudinov.ali.lenta_06_02_2022.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import mudinov.ali.lenta_06_02_2022.R
import mudinov.ali.lenta_06_02_2022.adapter.NameDogsAdapter
import mudinov.ali.lenta_06_02_2022.common.Common
import mudinov.ali.lenta_06_02_2022.databinding.ItemPageDogBinding
import mudinov.ali.lenta_06_02_2022.model.Dogs
import mudinov.ali.lenta_06_02_2022.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageDogActivity : AppCompatActivity() {

    private var binding: ItemPageDogBinding? = null

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        binding = DataBindingUtil.setContentView(this, R.layout.item_page_dog)

        mService = Common.retrofitService
        layoutManager = LinearLayoutManager(this)

        var imgUrl = intent.getStringExtra("image")

        Picasso.get().load(imgUrl).into(binding?.imageDog)
        binding?.idNameDog?.text = intent.getStringExtra("name")
        binding?.temperament?.text = intent.getStringExtra("temperament")
        binding?.height?.text = intent.getStringExtra("height")

        binding?.photoGalleryButton?.setOnClickListener {
            val intent = Intent(this, PhotoGalleryActivity::class.java).apply {
                putExtra("gallery_image", imgUrl)
            }
            startActivity(intent)
        }
//        binding?.buttonId?.setOnClickListener {
//            val intent = Intent(this, Activity2::class.java)
//            startActivity(intent)
//        }
    }

}
package mudinov.ali.lenta_06_02_2022.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import mudinov.ali.lenta_06_02_2022.R
import mudinov.ali.lenta_06_02_2022.adapter.NameDogsAdapter
import mudinov.ali.lenta_06_02_2022.common.Common
import mudinov.ali.lenta_06_02_2022.databinding.ActivityMainBinding
import mudinov.ali.lenta_06_02_2022.model.Dogs
import mudinov.ali.lenta_06_02_2022.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding? = null

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: NameDogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        mService = Common.retrofitService
        binding?.listNameDogs?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding?.listNameDogs?.layoutManager = layoutManager


        getDogsNameList()


        binding?.swipeContainer?.setOnRefreshListener{
            onRefresh()
            binding?.swipeContainer?.isRefreshing = false
        }

    }

    private fun onRefresh() {
        getDogsNameList()
    }

    private fun getDogsNameList() {
        mService.getDogsList().enqueue(object : Callback<MutableList<Dogs>> {
            override fun onFailure(call: Call<MutableList<Dogs>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Dogs>>, response: Response<MutableList<Dogs>>) {
                adapter = NameDogsAdapter(baseContext, response.body() as ArrayList<Dogs>)
                adapter.notifyDataSetChanged()
                binding?.listNameDogs?.adapter = adapter
            }
        })
    }

}

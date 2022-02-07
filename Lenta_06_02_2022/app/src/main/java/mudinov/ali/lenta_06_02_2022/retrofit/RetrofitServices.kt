package mudinov.ali.lenta_06_02_2022.retrofit

import mudinov.ali.lenta_06_02_2022.model.Dogs
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("breeds")
    fun getDogsList(): Call<MutableList<Dogs>>
}
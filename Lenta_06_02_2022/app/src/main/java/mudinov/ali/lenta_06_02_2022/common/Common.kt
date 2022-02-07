package mudinov.ali.lenta_06_02_2022.common

import mudinov.ali.lenta_06_02_2022.retrofit.RetrofitClient
import mudinov.ali.lenta_06_02_2022.retrofit.RetrofitServices

object Common {
    private val BASE_URL = "https://api.thedogapi.com/v1/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}
package tranhph26979.fpoly.bai6_rettrofit.api

import retrofit2.Call
import retrofit2.http.GET
import tranhph26979.fpoly.bai6_rettrofit.model.ApiResponse

interface ApiService {
    @GET("api/?results=20")
    fun getUsers(): Call<ApiResponse>
}
package tranhph26979.fpoly.bai6_rettrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tranhph26979.fpoly.bai6_rettrofit.api.ApiService
import tranhph26979.fpoly.bai6_rettrofit.dagger.NetworkModule
import tranhph26979.fpoly.bai6_rettrofit.model.ApiResponse
import tranhph26979.fpoly.bai6_rettrofit.model.UserModel


class UserViewModel:ViewModel() {
    private val retrofit:Retrofit=NetworkModule.provideRetrofit()
    private val apiService:ApiService=NetworkModule.provideApiService(retrofit)
    private val userList:MutableLiveData<List<UserModel>> = MutableLiveData()

    fun getUsers():LiveData<List<UserModel>>{
        if (userList.value==null){
            fetvhUsers()
        }
        return userList
    }

    private fun fetvhUsers() {
        apiService.getUsers().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
              if (response.isSuccessful){
                  val users=response.body()?.results
                  userList.value=users
              }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("UserViewModel", "Error fetching users: ${t.message}")
                userList.value = emptyList()
            }

        })
    }
}
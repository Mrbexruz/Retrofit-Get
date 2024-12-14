package com.example.retrofitget.retrofit


import com.example.retrofitget.models.MyTodo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("rejalar")
    fun getAllTodo(): Call<List<MyTodo>>
}

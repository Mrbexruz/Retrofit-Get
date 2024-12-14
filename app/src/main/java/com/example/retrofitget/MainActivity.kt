package com.example.retrofitget

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitget.adapters.RvAdapter
import com.example.retrofitget.databinding.ActivityMainBinding
import com.example.retrofitget.models.MyTodo
import com.example.retrofitget.retrofit.MyAPIclient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MyAPIclient.retrofitService(this)
            .getAllTodo()
            .enqueue(object : retrofit2.Callback<List<MyTodo>>{
                override fun onResponse(
                    call: Call<List<MyTodo>>,
                    response: Response<List<MyTodo>>
                ) {
                    if(response.isSuccessful){
                        val list = response.body()
                        if (list!=null){
                            rvAdapter = RvAdapter(list!!)
                            binding.rv.adapter = rvAdapter
                        }

                    }
                }

                override fun onFailure(call: Call<List<MyTodo>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
                }
            })

    }
}
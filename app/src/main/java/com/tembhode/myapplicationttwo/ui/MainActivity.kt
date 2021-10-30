package com.tembhode.myapplicationttwo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tembhode.myapplicationttwo.R
import com.tembhode.myapplicationttwo.Utils
import com.tembhode.myapplicationttwo.data.Plant
import com.tembhode.myapplicationttwo.retrofit.RetrofitBase
import com.tembhode.myapplicationttwo.ui.adapter.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var srlMain: SwipeRefreshLayout
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        srlMain = findViewById(R.id.srlMain)

        manager = LinearLayoutManager(this)

        srlMain.setOnRefreshListener {
            callAPI()
            srlMain.isRefreshing = false
        }

        callAPI()
    }

    private fun callAPI() {
        if (Utils().isOnline(this)) {
            getData()
        } else {
            Toast.makeText(this, "Internet connection not available", Toast.LENGTH_SHORT).show()
        }
    }

    fun getData() {
        RetrofitBase.apiInterface.getAllData().enqueue(object : Callback<List<Plant>> {
            override fun onResponse(
                call: Call<List<Plant>>,
                response: Response<List<Plant>>
            ) {
                if (response.isSuccessful) {
                    recyclerView = findViewById<RecyclerView>(R.id.rvMainPage_items).apply {
                        adapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Plant>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
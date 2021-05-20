package com.frogobox.frogouikit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.frogobox.frogouikit.databinding.ActivityLayoutSamplesBinding
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.google.gson.Gson

class LayoutSamplesActivity : AppCompatActivity() {

    private lateinit var layoutSamplesBinding: ActivityLayoutSamplesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutSamplesBinding = ActivityLayoutSamplesBinding.inflate(LayoutInflater.from(this))
        setContentView(layoutSamplesBinding.root)
        setupRecyclerView()
    }

    private fun dummyData(): MutableList<String> {
        val data = mutableListOf<String>()
        data.add("")
        return data
    }

    private fun setupRecyclerView() {
        val extraData = intent.getStringExtra("EXTRA_DATA")
        val data = Gson().fromJson(extraData, Layout::class.java)

        layoutSamplesBinding.frogoRv.injector<String>()
            .addCallback(object : IFrogoViewAdapter<String>{
                override fun onItemClicked(data: String) {}
                override fun onItemLongClicked(data: String) {}
                override fun setupInitComponent(view: View, data: String) {}
            })
            .addCustomView(data.layout)
            .createLayoutLinearVertical(false)
            .addData(dummyData())
            .build()

    }


}
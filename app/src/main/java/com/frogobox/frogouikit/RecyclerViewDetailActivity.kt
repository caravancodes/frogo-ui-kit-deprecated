package com.frogobox.frogouikit

import android.os.Bundle
import android.view.View
import com.frogobox.frogouikit.core.BaseActivity
import com.frogobox.frogouikit.model.Layout
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.google.gson.Gson

class RecyclerViewDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerViewDetailBinding.root)
        setupRecyclerView()
        setupDetailActivity("")
    }

    private fun dummyData(): MutableList<String> {
        val data = mutableListOf<String>()
        data.add("")
        return data
    }

    private fun setupRecyclerView() {
        val extraData = intent.getStringExtra("EXTRA_DATA")
        val data = Gson().fromJson(extraData, Layout::class.java)

        recyclerViewBinding.frogoRv.injector<String>()
            .addCallback(object : IFrogoViewAdapter<String> {
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
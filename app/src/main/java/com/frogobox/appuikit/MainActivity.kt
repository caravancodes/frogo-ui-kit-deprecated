package com.frogobox.appuikit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.appuikit.core.BaseActivity
import com.frogobox.appuikit.model.Main
import com.frogobox.recycler.core.IFrogoViewAdapter

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        setupRecyclerView()
    }

    private fun data() : MutableList<Main> {
        val data = mutableListOf<Main>()
        data.add(Main("RecyclerView Layout", Intent(this, RecyclerViewActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        mainBinding.frogoRv.injector<Main>()
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addData(data())
            .addCallback(object : IFrogoViewAdapter<Main> {
                override fun onItemClicked(data: Main) {
                    startActivity(data.intent)
                }
                override fun onItemLongClicked(data: Main) {}
                override fun setupInitComponent(view: View, data: Main) {
                    view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}
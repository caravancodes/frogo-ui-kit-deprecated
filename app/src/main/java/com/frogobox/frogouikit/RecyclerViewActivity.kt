package com.frogobox.frogouikit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.frogouikit.core.BaseActivity
import com.frogobox.frogouikit.model.Layout
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.google.gson.Gson

class RecyclerViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerViewBinding.root)
        setupRecyclerView()
        setupDetailActivity("List UI RecyclerView")
    }

    private fun data() : MutableList<Layout> {
        val data = mutableListOf<Layout>()
        data.add(Layout("frogo_rv_list_type_1.xml","List", R.layout.frogo_rv_list_type_1))
        data.add(Layout("frogo_rv_list_type_2.xml","List", R.layout.frogo_rv_list_type_2))
        data.add(Layout("frogo_rv_list_type_3.xml","List", R.layout.frogo_rv_list_type_3))
        data.add(Layout("frogo_rv_list_type_4.xml","List", R.layout.frogo_rv_list_type_4))
        data.add(Layout("frogo_rv_list_type_5.xml","List", R.layout.frogo_rv_list_type_5))
        data.add(Layout("frogo_rv_list_type_6.xml","List", R.layout.frogo_rv_list_type_6))
        data.add(Layout("frogo_rv_list_type_7.xml","List", R.layout.frogo_rv_list_type_7))
        data.add(Layout("frogo_rv_list_type_8.xml","List", R.layout.frogo_rv_list_type_8))
        data.add(Layout("frogo_rv_list_type_9.xml","List", R.layout.frogo_rv_list_type_9))
        data.add(Layout("frogo_rv_list_type_10.xml","List", R.layout.frogo_rv_list_type_10))
        data.add(Layout("frogo_rv_list_type_11.xml","List", R.layout.frogo_rv_list_type_11))
        data.add(Layout("frogo_rv_list_type_12.xml","List", R.layout.frogo_rv_list_type_12))

        data.add(Layout("frogo_rv_grid_type_1.xml","Grid", R.layout.frogo_rv_grid_type_1))
        data.add(Layout("frogo_rv_grid_type_2.xml","Grid", R.layout.frogo_rv_grid_type_2))
        data.add(Layout("frogo_rv_grid_type_3.xml","Grid", R.layout.frogo_rv_grid_type_3))
        data.add(Layout("frogo_rv_grid_type_4.xml","Grid", R.layout.frogo_rv_grid_type_4))
        data.add(Layout("frogo_rv_grid_type_5.xml","Grid", R.layout.frogo_rv_grid_type_5))
        data.add(Layout("frogo_rv_grid_type_6.xml","Grid", R.layout.frogo_rv_grid_type_6))
        data.add(Layout("frogo_rv_grid_type_7.xml","Grid", R.layout.frogo_rv_grid_type_7))
        return data
    }

    private fun intentToLayoutSample(data: Layout) {
        val dataString = Gson().toJson(data)
        val intent = Intent(this@RecyclerViewActivity, RecyclerViewDetailActivity::class.java)
        intent.putExtra("EXTRA_DATA", dataString)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        recyclerViewBinding.frogoRv.injector<Layout>()
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addData(data())
            .addCallback(object : IFrogoViewAdapter<Layout>{
                override fun onItemClicked(data: Layout) { intentToLayoutSample(data) }
                override fun onItemLongClicked(data: Layout) {}
                override fun setupInitComponent(view: View, data: Layout) {
                    view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}
package com.frogobox.frogouikit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.frogobox.frogouikit.databinding.ActivityMainBinding
import com.frogobox.recycler.core.IFrogoViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mainBinding.root)
        setupRecyclerView()
    }

    private fun data() : MutableList<Layout> {
        val data = mutableListOf<Layout>()
        data.add(Layout("frogo_rv_list_type_1.xml","List"))
        data.add(Layout("frogo_rv_list_type_2.xml","List"))
        data.add(Layout("frogo_rv_list_type_3.xml","List"))
        data.add(Layout("frogo_rv_list_type_4.xml","List"))
        data.add(Layout("frogo_rv_list_type_5.xml","List"))
        data.add(Layout("frogo_rv_list_type_6.xml","List"))
        data.add(Layout("frogo_rv_list_type_7.xml","List"))
        data.add(Layout("frogo_rv_list_type_8.xml","List"))
        data.add(Layout("frogo_rv_list_type_9.xml","List"))
        data.add(Layout("frogo_rv_list_type_10.xml","List"))
        data.add(Layout("frogo_rv_list_type_11.xml","List"))
        data.add(Layout("frogo_rv_list_type_12.xml","List"))

        data.add(Layout("frogo_rv_grid_type_1.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_2.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_3.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_4.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_5.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_6.xml","Grid"))
        data.add(Layout("frogo_rv_grid_type_7.xml","Grid"))
        return data
    }

    private fun intentToLayoutSample(data: Layout) {
        val intent = Intent(this@MainActivity, LayoutSamplesActivity::class.java)
        intent.putExtra("EXTRA_DATA", data.name)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        mainBinding.frogoRv.injector<Layout>()
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
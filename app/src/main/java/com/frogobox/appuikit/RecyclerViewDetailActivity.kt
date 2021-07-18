package com.frogobox.appuikit

import android.os.Bundle
import com.frogobox.appuikit.Constant.TYPE_GRID
import com.frogobox.appuikit.Constant.dummyData
import com.frogobox.appuikit.FrogoRvAdapter.frogoRvAdaper
import com.frogobox.appuikit.core.BaseActivity
import com.frogobox.appuikit.model.Layout
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.google.gson.Gson

class RecyclerViewDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerViewDetailBinding.root)
        setupDetailActivity(extraData().name)
        setupRecyclerView(frogoRv())
    }

    private fun extraData() : Layout {
        val extra = intent.getStringExtra("EXTRA_DATA")
        return Gson().fromJson(extra, Layout::class.java)
    }

    private fun frogoRv() : IFrogoViewAdapter<String>{
        return frogoRvAdaper(extraData().name, this)
    }
    
    private fun setupRecyclerView(adapter: IFrogoViewAdapter<String>) {

        val scale = resources.displayMetrics.density
        val dpAsPixels = (16 * scale + 0.5f)

        if (extraData().type == TYPE_GRID) {
            recyclerViewDetailBinding.frogoRv.apply {
                injector<String>()
                    .addCustomView(extraData().layout)
                    .addCallback(adapter)
                    .addData(dummyData())
                    .createLayoutGrid(2)
                    .build()

                updatePadding(left = dpAsPixels.toInt())
            }
        } else {
            recyclerViewDetailBinding.frogoRv.injector<String>()
                .addCustomView(extraData().layout)
                .addCallback(adapter)
                .addData(dummyData())
                .createLayoutLinearVertical(false)
                .build()
        }

    }

}
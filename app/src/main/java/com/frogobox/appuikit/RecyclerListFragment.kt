package com.frogobox.appuikit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.appuikit.core.BaseFragment
import com.frogobox.appuikit.databinding.FragmentRecyclerListBinding
import com.frogobox.appuikit.model.Layout
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.google.gson.Gson


class RecyclerListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        recyclerListBinding = FragmentRecyclerListBinding.inflate(inflater, container, false)
        return recyclerListBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun intentToLayoutSample(data: Layout) {
        val dataString = Gson().toJson(data)
        val intent = Intent(mActivity, RecyclerViewDetailActivity::class.java)
        intent.putExtra("EXTRA_DATA", dataString)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        recyclerListBinding?.frogoRv?.injector<Layout>()
            ?.addCustomView(R.layout.frogo_rv_list_type_1)
            ?.addData(Constant.dataRvList())
            ?.addCallback(object : IFrogoViewAdapter<Layout> {
                override fun onItemClicked(data: Layout) { intentToLayoutSample(data) }
                override fun onItemLongClicked(data: Layout) {}
                override fun setupInitComponent(view: View, data: Layout) {
                    view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
                }
            })
            ?.createLayoutLinearVertical(false)
            ?.build()
    }

}
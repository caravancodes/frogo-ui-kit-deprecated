package com.frogobox.appuikit.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.frogobox.appuikit.databinding.FragmentRecyclerGridBinding
import com.frogobox.appuikit.databinding.FragmentRecyclerListBinding

/*
 * Created by faisalamir on 21/05/21
 * FrogoUIKit
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var mActivity: BaseActivity

    protected var recyclerGridBinding: FragmentRecyclerGridBinding? = null
    protected var recyclerListBinding: FragmentRecyclerListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = (activity as BaseActivity)
    }

    override fun onDestroy() {
        recyclerGridBinding = null
        recyclerListBinding = null
        super.onDestroy()
    }

}
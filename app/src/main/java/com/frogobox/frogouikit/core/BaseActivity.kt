package com.frogobox.frogouikit.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogouikit.databinding.ActivityMainBinding
import com.frogobox.frogouikit.databinding.ActivityRecyclerViewBinding
import com.frogobox.frogouikit.databinding.ActivityRecyclerViewDetailBinding

/*
 * Created by faisalamir on 20/05/21
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
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mainBinding: ActivityMainBinding
    protected lateinit var recyclerViewBinding: ActivityRecyclerViewBinding
    protected lateinit var recyclerViewDetailBinding: ActivityRecyclerViewDetailBinding

    protected lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        setupViewBinding()
    }

    protected fun setupDetailActivity(title: String) {
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun setupViewBinding(){
        // genereate view binding
        mainBinding = ActivityMainBinding.inflate(baseLayoutInflater())
        recyclerViewBinding = ActivityRecyclerViewBinding.inflate(baseLayoutInflater())
        recyclerViewDetailBinding = ActivityRecyclerViewDetailBinding.inflate(baseLayoutInflater())
    }

    private fun baseLayoutInflater() : LayoutInflater {
        return LayoutInflater.from(this)
    }

}